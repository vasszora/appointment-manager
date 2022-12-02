import { NgModule } from '@angular/core';
import { AppointmentComponent } from './appointment.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AppointmentDetailRoutingModule } from '../appointment-detail/appointment-detail-routing.module';

const routes = [{ path: '', component: AppointmentComponent }];

@NgModule({
  declarations: [AppointmentComponent],
  exports: [AppointmentComponent, RouterModule],
  imports: [FormsModule, CommonModule, RouterModule.forChild(routes)],
})
export class AppointmentModule {}
