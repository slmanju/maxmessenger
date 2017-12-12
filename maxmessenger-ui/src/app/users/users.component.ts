import { Component, OnInit } from '@angular/core';

import { User } from './user.model';
import { UsersService } from './users-service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UsersService) { }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.userService.getUsers().subscribe(users => {
      this.users = users.map(user => {
        return new User(user.firstName, user.lastName, user.email, user.birthDate, user.id);
      });
    });
  }

}
