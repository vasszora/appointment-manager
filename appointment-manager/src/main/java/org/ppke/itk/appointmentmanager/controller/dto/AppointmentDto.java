package org.ppke.itk.appointmentmanager.controller.dto;

import org.ppke.itk.appointmentmanager.domain.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Integer id;
    private String startTime;
    private Integer duration;
    private Integer price;
    private String description;
    private String username;

    public static AppointmentDto fromAppointment(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getStartTime().toString(),
                appointment.getDuration(),
                appointment.getPrice(),
                appointment.getDescription(),
                appointment.getProvider().getUsername());
    }

}
