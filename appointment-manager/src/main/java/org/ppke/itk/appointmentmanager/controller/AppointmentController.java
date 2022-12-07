package org.ppke.itk.appointmentmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.ppke.itk.appointmentmanager.controller.dto.AppointmentDto;
import org.ppke.itk.appointmentmanager.domain.Appointment;
import org.ppke.itk.appointmentmanager.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Appointment")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;

    @Operation(summary = "Retrieve list of appointments")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of appointments retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid url params supplied")
    })
    public List<Appointment> getAppointments(@RequestParam(required = false, defaultValue = "100") Integer limit,
            @RequestParam(required = false, defaultValue = "desc") String sort) {
        log.info("Calling GET /appointment endpoint.");

        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")) {
            throw new IllegalArgumentException("Invalid sorting param!!!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, "price")
                : Sort.by(Sort.Direction.DESC, "price");

        Page<Appointment> appointments = appointmentRepository.findAll(PageRequest.of(0, limit, sortParam));

        return appointments.toList();
    }

    @GetMapping(produces = APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getAppointmentsAsTxt() throws IOException {

        byte[] binaryData = FileCopyUtils
                .copyToByteArray((new ClassPathResource("static/appointments.txt")).getInputStream());
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appointments.txt");

        ByteArrayResource resource = new ByteArrayResource(binaryData);

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(resource.contentLength())
                .contentType(APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Appointment getAppointmentById(@PathVariable("id") Integer id) {
        return appointmentRepository.findById(id).get();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAppointmentById(@PathVariable("id") Integer id) {
        appointmentRepository.deleteById(id);
    }

    @PostMapping(value = "/{username}", produces = APPLICATION_JSON_VALUE, consumes = {
            "application/json;charset=UTF-8" })
    public Appointment saveAppointment(@RequestBody AppointmentDto appointment,
            @PathVariable String username) throws ParseException {
        return appointmentRepository.saveAppointment(appointment, username);
    }

    @GetMapping(value = "/{username}/appointments", produces = APPLICATION_JSON_VALUE)
    public List<Appointment> getAppointmentsByUsername(@PathVariable String username) {
        return appointmentRepository.findByProviderUsername(username);
    }

    @GetMapping(value = "/current", produces = APPLICATION_JSON_VALUE)
    public List<Appointment> getCurrentAppointments() throws ParseException {
        return appointmentRepository
                .findByStartTimeAfter(Date.from(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC)));
    }
}
