package org.ppke.itk.appointmentmanager.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.ppke.itk.appointmentmanager.controller.dto.AppointmentDto;
import org.ppke.itk.appointmentmanager.domain.Appointment;
import org.ppke.itk.appointmentmanager.domain.User;

public class CustomAppointmentRepositoryImpl implements CustomAppointmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Appointment saveAppointment(AppointmentDto appointment, String username) throws ParseException {
        Appointment new_appointment;
        // search for user
        Optional<User> existingUser = entityManager
                .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .setMaxResults(1).getResultStream().findFirst();
        // if user is not found, throw exception
        if (existingUser.isEmpty()) {
            throw new NoSuchElementException(String.format("No user found for username %s", username));
        }

        // check for already existing appointment
        // Optional<Appointment> existingAppointment = entityManager
        // .createQuery("SELECT a FROM Appointment a WHERE a.user_id.username =
        // :username ", Appointment.class)
        // .setParameter("username", username)
        // .setMaxResults(1).getResultStream().findFirst();

        // if appointment is found, update it
        // if (existingAppointment.isPresent()) {
        // new_appointment = existingAppointment.get();
        // new_appointment.setUser_id(existingUser.get());
        // } else {
        // if appointment is not found, create a new one
        new_appointment = new Appointment();
        new_appointment.setProvider(existingUser.get());
        new_appointment.setStartTime(new SimpleDateFormat("YYYY-MM-DD'T'HH:mm").parse(appointment.getStartTime()));
        new_appointment.setDuration(appointment.getDuration());
        new_appointment.setPrice(appointment.getPrice());
        new_appointment.setDescription(appointment.getDescription());
        new_appointment.setBookings(null);
        entityManager.persist(new_appointment);
        // }
        return new_appointment;
    }

}
