import { Role } from './role.model';

export class User {
  firstName: string;
  lastName: string;
  email: string;
  birthDate: string;
  id?: string;
  role: Role;

  constructor(firstName: string,
              lastName: string,
              email: string,
              birthDate: string,
              id?: string) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.birthDate = birthDate;
      this.id = id;
  }

}
