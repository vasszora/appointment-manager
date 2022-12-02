export class Appointment {
  constructor(
    public id: number,
    public description: string,
    public start_time: string,
    public end_time: string,
    public price: number,
    public provider: number
  ) {}
}
