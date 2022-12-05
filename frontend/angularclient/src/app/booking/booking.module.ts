import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BookingComponent } from './booking.component';

const routes = [{ path: '', component: BookingComponent }];

@NgModule({
  declarations: [BookingComponent],
  exports: [BookingComponent, RouterModule],
  imports: [FormsModule, CommonModule, RouterModule.forChild(routes)],
})
export class BookingModule {}
