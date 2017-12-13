import { Component, OnInit } from '@angular/core';

import { User } from './user.model';
import { UsersService } from './users-service';
import { Role } from './role.model';

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
        const role = new Role(user.role.code, user.role.name, user.role.id);
        return new User(user.firstName, user.lastName, user.email, user.birthDate, role, user.id);
      });
    });
  }

}
