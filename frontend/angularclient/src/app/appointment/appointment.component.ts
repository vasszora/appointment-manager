import {
  Component,
  ElementRef,
  Input,
  OnInit,
  QueryList,
  ViewChild,
  ViewChildren,
} from '@angular/core';

import { Appointment } from './model/appointment.model';
import { AppointmentDetailComponent } from '../appointment-detail/appointment-detail.component';
import { AppointmentService } from '../services/appointment.service';
import { BookingService } from '../services/booking.service';
import { Booking } from '../booking/model/bookings.model';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css'],
})
export class AppointmentComponent implements OnInit {
  appointment: Appointment | undefined;

  appointments: Appointment[] = [];

  @ViewChild(AppointmentDetailComponent)
  appointmentDetailComponent!: AppointmentDetailComponent;
  @ViewChildren('appointmentDiv') appointmentDivs!: QueryList<ElementRef>;

  constructor(
    private appointmentService: AppointmentService,
    private bookingService: BookingService
  ) {}

  ngOnInit(): void {
    this.initAppointments();
  }

  private initAppointments() {
    this.appointmentService.getAppointments().subscribe((appointments) => {
      this.appointments = appointments;
    });
  }

  onSubmit() {
    if (this.appointment) {
      this.appointmentService
        .addAppointment(this.appointment)
        .subscribe((appointment) => {
          this.appointments.push(appointment);
        });
      console.log(this.appointment);
      this.appointment = undefined;
    }
  }

  addNewAppointment() {
    this.appointment = new Appointment(
      this.appointments.length + 1,
      '',
      '',
      0,
      0,
      ''
    );
  }

  deleteAppointment(appointment: Appointment) {
    this.appointmentService
      .deleteAppointment(appointment.id)
      .subscribe((app) => {
        //TODOD
      });
  }

  addBooking(appointment: Appointment, client_username: string) {
    this.bookingService
      .addBooking(
        new Booking(
          this.bookingService.getBookings.length + 1,
          appointment,
          client_username
        )
      )
      .subscribe();
  }
}
