import { Component, OnInit } from '@angular/core';
import { User } from './user.model';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[] = [];

  constructor() { }

  ngOnInit() {
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '1'));
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '2'));
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '3'));
    this.users.push(new User('Manjula', 'Jayawardana', 'manjula@seebo.com', '1983-10-13', '4'));
  }

}
