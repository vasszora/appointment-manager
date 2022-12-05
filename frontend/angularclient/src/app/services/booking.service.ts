import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../booking/model/bookings.model';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root',
})
export class BookingService {
  private bookingUrl = 'api/bookings';

  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) {}

  getBookings(): Observable<Booking[]> {
    const bookings = this.http.get<Booking[]>(this.bookingUrl);
    this.messageService.add('BookingService: fetched bookings');
    return bookings;
  }

  getTopBookings(): Observable<Booking[]> {
    const bookings = this.http.get<Booking[]>(
      this.bookingUrl + '?limit=10&sort=desc'
    );
    this.messageService.add('BookingService: fetched bookings');
    return bookings;
  }

  getBookingById(id: string): Observable<Booking> {
    return this.http.get<Booking>(this.bookingUrl + '/' + id);
  }

  getBookingsByUsername(username: string): Observable<Booking[]> {
    return this.http.get<Booking[]>(this.bookingUrl + '/' + username);
  }

  addBooking(booking: Booking) {
    return this.http.post<Booking>(
      this.bookingUrl +
        '/' +
        booking.appointment.id +
        '/' +
        booking.client_username,
      booking
    );
  }
  //todo delete, update, create
}
