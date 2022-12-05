package org.ppke.itk.appointmentmanager.controller.dto;

import org.ppke.itk.appointmentmanager.domain.Appointment;
import org.ppke.itk.appointmentmanager.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Integer id;
    private String start_time;
    private Integer duration;
    private Integer price;
    private String description;
    private String username;

    public static AppointmentDto fromAppointment(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getStart_time().toString(),
                appointment.getDuration(),
                appointment.getPrice(),
                appointment.getDescription(),
                appointment.getUser_id().getUsername());
    }

}
