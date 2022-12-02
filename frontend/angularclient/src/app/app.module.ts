import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AppointmentComponent } from './appointment/appointment.component';
import { AppointmentDetailComponent } from './appointment-detail/appointment-detail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MessagesComponent } from './messages/messages.component';
import { AppointmentService } from './services/appointment.service';
import { AppointmentButtonDirective } from './directives/appointment-button.directive';
import { AppointmentModule } from './appointment/appointment.module';

@NgModule({
  declarations: [AppComponent, MessagesComponent, AppointmentButtonDirective],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [AppointmentService],
  bootstrap: [AppComponent],
})
export class AppModule {}
