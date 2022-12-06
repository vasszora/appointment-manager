package org.ppke.itk.appointmentmanager.repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.ppke.itk.appointmentmanager.controller.dto.AppointmentDto;
import org.ppke.itk.appointmentmanager.domain.Appointment;

public interface CustomAppointmentRepository {
    Appointment saveAppointment(AppointmentDto appointment, String username) throws ParseException;

    // List<Appointment> getAppointmentsByDateGreaterThen(Date today);
}
