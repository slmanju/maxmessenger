import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient } from '@angular/common/http';

import { User } from './user.model';

@Injectable()
export class UsersService {
  users: User[] = [];

  constructor(private http: HttpClient) {
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '1'));
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '2'));
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '3'));
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '4'));
  }

  getUsers(): Observable<User[]> {
    this.http.get('https://api.github.com/users/seeschweiler').subscribe(data => {
      console.log(data);
    });
    return of(this.users);
  }

}
