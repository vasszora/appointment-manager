package org.ppke.itk.appointmentmanager.repository;

import java.util.List;
import java.util.Optional;

import org.ppke.itk.appointmentmanager.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>, CustomBookingRepository {
    Optional<Booking> findFirstByClientUsernameAndAppointmentOfBookingId(String username, Integer appointmentId);

    List<Booking> findByAppointmentOfBookingId(Integer appointmentId);

    void deleteById(Integer id);

    List<Booking> findByClientUsername(String username);
}
