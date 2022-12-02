package org.ppke.itk.appointmentmanager.domain;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Provider{ //TODO get data from a data class for user and provider, and provider extends that
    private String companyName;
    private String companyAddress;
}
