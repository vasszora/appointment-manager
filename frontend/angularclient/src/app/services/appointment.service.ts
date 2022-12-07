import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { MessageService } from './message.service';
import { Appointment } from '../appointment/model/appointment.model';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  private appointmentUrl = 'api/appointments';

  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) {}

  getAppointments(): Observable<Appointment[]> {
    const appointments = this.http.get<Appointment[]>(this.appointmentUrl);
    console.log(appointments);
    this.messageService.add('AppointmentService: fetched appointments');
    return appointments;
  }

  getTopAppointments(): Observable<Appointment[]> {
    const appointments = this.http.get<Appointment[]>(
      this.appointmentUrl + '?limit=10&sort=desc'
    );
    this.messageService.add('AppointmentService: fetched appointments');
    return appointments;
  }

  getAppointmentById(id: string): Observable<Appointment> {
    return this.http.get<Appointment>(this.appointmentUrl + '/' + id);
  }

  addAppointment(appointment: Appointment) {
    return this.http.post<Appointment>(
      this.appointmentUrl + '/' + appointment.provider,
      appointment
    );
  }

  deleteAppointment(id: number) {
    return this.http.delete(this.appointmentUrl + '/' + id);
  }
  //todo delete, update, create
}
