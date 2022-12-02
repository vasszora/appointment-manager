import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AppointmentDetailRoutingModule } from './appointment-detail-routing.module';
import { AppointmentDetailComponent } from './appointment-detail.component';

@NgModule({
  declarations: [AppointmentDetailComponent],
  imports: [FormsModule, CommonModule, AppointmentDetailRoutingModule],
})
export class AppointmentDetailModule {}
