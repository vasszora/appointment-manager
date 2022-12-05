import { Appointment } from 'src/app/appointment/model/appointment.model';

export class Booking {
  constructor(
    public id: number,
    public appointment: Appointment,
    public client_username: string
  ) {}
}
