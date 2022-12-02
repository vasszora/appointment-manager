package org.ppke.itk.appointmentmanager.controller;

import java.util.List;

import org.ppke.itk.appointmentmanager.domain.Booking;
import org.ppke.itk.appointmentmanager.repository.BookingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Booking")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingRepository bookingRepository;

    @Operation(summary = "Retrieve list of bookings")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of bookings retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid url params supplied")
    })
    public List<Booking> getBookings(@RequestParam(required = false, defaultValue = "100") Integer limit,
            @RequestParam(required = false, defaultValue = "desc") String sort) {
        log.info("Calling GET /bookings endpoint.");

        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")) {
            throw new IllegalArgumentException("Invalid sorting param!!!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, "client_id")
                : Sort.by(Sort.Direction.DESC, "client_id");

        Page<Booking> bookings = bookingRepository.findAll(PageRequest.of(0, limit, sortParam));
        log.info("Returning {} bookings.", bookings.toString());
        return bookings.toList();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Booking getBookingById(@PathVariable("id") Integer id) {
        log.info("returning booking: {}", bookingRepository.findById(id).get().toString());
        return bookingRepository.findById(id).get();
    }
}
