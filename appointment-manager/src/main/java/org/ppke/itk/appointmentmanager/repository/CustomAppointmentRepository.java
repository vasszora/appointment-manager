package org.ppke.itk.appointmentmanager.repository;

import java.text.ParseException;

import org.ppke.itk.appointmentmanager.controller.dto.AppointmentDto;
import org.ppke.itk.appointmentmanager.domain.Appointment;

public interface CustomAppointmentRepository {
    Appointment saveAppointment(AppointmentDto appointment, String username) throws ParseException;
}
