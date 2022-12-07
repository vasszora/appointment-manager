import { Component, OnInit } from '@angular/core';
import { CalendarEvent, CalendarView } from 'angular-calendar';
import { startOfDay } from 'date-fns';
import { Subject } from 'rxjs';
import { Appointment } from '../appointment/model/appointment.model';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css'],
})
export class CalendarComponent implements OnInit {
  viewDate: Date = new Date();
  view: CalendarView = CalendarView.Month;
  CalendarView = CalendarView;

  events: CalendarEvent[] = [];

  refresh = new Subject<void>();

  constructor(private appointmentService: AppointmentService) {}

  ngOnInit(): void {
    this.initEvents();
  }

  private initEvents() {
    console.log('initEvents');
    this.appointmentService.getAppointments().subscribe((appointments) => {
      this.convertAppointmentsToEvents(appointments);
    });
  }

  setView(view: CalendarView) {
    this.view = view;
  }

  setEvents(events: CalendarEvent[]) {
    this.events = events;
  }

  private convertAppointmentsToEvents(appointments: Appointment[]) {
    let events: CalendarEvent[] = [];
    appointments.forEach((appointment) => {
      const end_time = new Date(appointment.startTime);
      end_time.setHours(end_time.getHours() + appointment.duration / 60);
      end_time.setMinutes(end_time.getMinutes() + (appointment.duration % 60));
      events.push({
        start: new Date(appointment.startTime),
        title: appointment.description,
        end: end_time,
      });
    });

    this.refresh.next();
    this.events = events;
  }

  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    console.log(date);
  }
}
