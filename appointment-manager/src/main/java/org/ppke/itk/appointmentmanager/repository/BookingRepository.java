package org.ppke.itk.appointmentmanager.repository;

import java.util.List;
import java.util.Optional;

import org.ppke.itk.appointmentmanager.domain.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findAll();

    Page<Booking> findAll(Pageable page);

    Optional<Booking> findById(Integer id);

    // List<Booking> findByPriceLessThan(Double limit); // TODO what?
}
