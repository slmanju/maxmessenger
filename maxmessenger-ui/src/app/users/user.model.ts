export class User {
  firstName: string;
  lastName: string;
  email: string;
  birthDate: string;

  constructor(firstName: string,
              lastName: string,
              email: string,
              birthDate: string) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.birthDate = birthDate;
  }

}
