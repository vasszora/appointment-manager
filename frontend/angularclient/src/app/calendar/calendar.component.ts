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
  view: CalendarView = CalendarView.Week;
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
      console.log('appointments', appointments);
      this.events = this.convertAppointmentsToEvents(appointments);
    });
    this.refresh.next();
  }

  setView(view: CalendarView) {
    this.view = view;
  }

  setEvents(events: CalendarEvent[]) {
    this.events = events;
    this.refresh.next();
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

    console.log('events', events);
    return events;
  }

  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    console.log(date);
    //this.openAppointmentList(date)
  }
}
