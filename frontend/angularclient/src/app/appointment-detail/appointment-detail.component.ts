import {
  AfterContentChecked,
  AfterContentInit,
  AfterViewChecked,
  AfterViewInit,
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Appointment } from '../appointment/model/appointment.model';
import { MessageService } from '../services/message.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-appointment-detail',
  templateUrl: './appointment-detail.component.html',
  styleUrls: ['./appointment-detail.component.css'],
})
export class AppointmentDetailComponent implements OnInit {
  appointment: Appointment | undefined;

  constructor(
    private messageService: MessageService,
    private route: ActivatedRoute,
    private appointmentService: AppointmentService,
    private location: Location
  ) {}

  ngOnInit() {
    this.initAppointment();
  }
  initAppointment() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.appointmentService
      .getAppointmentById(id.toString())
      .subscribe((appointment) => {
        this.appointment = this.appointment;
      });
  }

  goBack() {
    this.location.back();
  }
}
