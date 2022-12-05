package org.ppke.itk.appointmentmanager.repository;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.ppke.itk.appointmentmanager.domain.Appointment;
import org.ppke.itk.appointmentmanager.domain.Booking;
import org.ppke.itk.appointmentmanager.domain.User;

public class CustomBookingRepositoryImpl implements CustomBookingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Booking saveBooking(Integer appointmentId, String username) {
        Booking booking;
        Appointment appointment = entityManager.find(Appointment.class, appointmentId);
        if (appointment == null) {
            throw new NoSuchElementException(String.format("No match found for id %s", appointmentId));
        }
        Optional<Booking> existingBooking = entityManager
                .createQuery(
                        "SELECT b FROM Booking b WHERE b.client.username = :username and b.appointmentOfBooking.id = :appointmentId",
                        Booking.class)
                .setParameter("username", username).setParameter("appointmentId", appointmentId)
                .setMaxResults(1).getResultStream().findFirst();

        Optional<User> existingUser = entityManager
                .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .setMaxResults(1).getResultStream().findFirst();
        if (existingUser.isEmpty()) {
            throw new NoSuchElementException(String.format("No user found for username %s", username));
        }

        if (existingBooking.isPresent()) {
            booking = existingBooking.get();
            booking.setClient(existingUser.get());
            booking.setAppointmentOfBooking(appointment);
        } else {
            booking = new Booking();
            booking.setClient(existingUser.get());
            booking.setAppointmentOfBooking(appointment);
            entityManager.persist(booking);
        }
        return booking;
    }
}
