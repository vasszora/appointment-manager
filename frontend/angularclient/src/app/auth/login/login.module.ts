import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login.component';

const routes = [{ path: '', component: LoginComponent }];

@NgModule({
  declarations: [],
  exports: [RouterModule],
  imports: [FormsModule, CommonModule, RouterModule.forChild(routes)],
})
export class LoginModule {}
