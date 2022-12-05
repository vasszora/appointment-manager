package org.ppke.itk.appointmentmanager.repository;

import org.ppke.itk.appointmentmanager.domain.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomBookingRepository {
    Booking saveBooking(Integer appointmentId, String username);
}
