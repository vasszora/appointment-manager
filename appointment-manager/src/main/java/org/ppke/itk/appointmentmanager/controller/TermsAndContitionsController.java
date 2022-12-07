package org.ppke.itk.appointmentmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/terms-and-conditions")
public class TermsAndContitionsController {

    @GetMapping(produces = APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getTermsAndConditionsAsTxt() throws IOException {
        byte[] binaryData = FileCopyUtils
                .copyToByteArray((new ClassPathResource("static/terms.txt")).getInputStream());
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=terms.txt");

        ByteArrayResource resource = new ByteArrayResource(binaryData);

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(resource.contentLength())
                .contentType(APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
