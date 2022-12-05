package org.ppke.itk.appointmentmanager.controller.dto;

import org.ppke.itk.appointmentmanager.domain.Appointment;
import org.ppke.itk.appointmentmanager.domain.Booking;
import org.ppke.itk.appointmentmanager.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Integer id;
    private Appointment appointment;
    private User userOfBooking;

    public static BookingDto fromBooking(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getAppointmentOfBooking(),
                booking.getClient());
    }
}
