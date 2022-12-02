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

@Component({
  selector: 'app-appointments',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css'],
})
export class AppointmentComponent implements OnInit {
  @Input() appointments: Appointment[] = [];

  @ViewChild(AppointmentDetailComponent)
  appointmentDetailComponent!: AppointmentDetailComponent;
  @ViewChildren('appointmentDiv') appointmentDivs!: QueryList<ElementRef>;

  constructor() {}

  ngOnInit(): void {}

  ngAfterViewInit(): void {
    //ViewChildren example
    // this.teamDivs.get(2)?.nativeElement.setAttribute('style', 'border-left: solid black 5px');
  }
}
