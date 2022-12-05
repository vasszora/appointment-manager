import {
  Component,
  ElementRef,
  OnInit,
  QueryList,
  ViewChildren,
} from '@angular/core';
import { Appointment } from '../appointment/model/appointment.model';
import { BookingService } from '../services/booking.service';
import { Booking } from './model/bookings.model';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],
})
export class BookingComponent implements OnInit {
  booking: Booking | undefined;

  bookings: Booking[] = [];

  @ViewChildren('bookingDiv') bookingDivs!: QueryList<ElementRef>;

  constructor(private bookingService: BookingService) {}

  ngOnInit(): void {
    this.initBookings();
  }

  private initBookings() {
    this.bookingService.getBookings().subscribe((bookings) => {
      this.bookings = bookings;
    });
  }

  onSubmit() {
    if (this.booking) {
      this.bookingService.addBooking(this.booking).subscribe((booking) => {
        this.bookings.push(booking);
      });
      console.log(this.booking);
      this.booking = undefined;
    }
  }

  addNewBooking() {
    this.booking = new Booking(
      this.bookings.length + 1,
      new Appointment(0, '', new Date(), 0, 0, ''),
      ''
    );
  }
}
