package org.ppke.itk.appointmentmanager.repository;

import java.util.List;
import java.util.Optional;

import org.ppke.itk.appointmentmanager.domain.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>, CustomAppointmentRepository {
    List<Appointment> findAll();

    Page<Appointment> findAll(Pageable page);

    Optional<Appointment> findById(Integer id);

    List<Appointment> findByPriceLessThan(Double limit); // TODO what?

    void deleteById(Integer id);
}
