export class Appointment {
  constructor(
    public id: number,
    public description: string,
    public startTime: Date,
    public duration: number,
    public price: number,
    public provider: string
  ) {}
}
