import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CalendarComponent } from './calendar.component';

const routes = [{ path: '', component: CalendarComponent }];

@NgModule({
  declarations: [],
  exports: [RouterModule],
  imports: [FormsModule, CommonModule, RouterModule.forChild(routes)],
})
export class CalendarModule {}
