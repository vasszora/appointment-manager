import { Injectable, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
  HttpClientModule,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { MessagesComponent } from './messages/messages.component';
import { AppointmentService } from './services/appointment.service';
import { AppointmentButtonDirective } from './directives/appointment-button.directive';
import { AppointmentModule } from './appointment/appointment.module';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { BookingService } from './services/booking.service';
import { LoginModule } from './auth/login/login.module';
import { CalendarComponent } from './calendar/calendar.component';
import { AuthService } from './auth/auth.service';
import { LoginComponent } from './auth/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    MessagesComponent,
    AppointmentButtonDirective,
    CalendarComponent,
    LoginComponent,
    //LoginComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
    LoginModule,
  ],
  providers: [AppointmentService, BookingService, AuthService],
  bootstrap: [AppComponent],
})
export class AppModule {}
