import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { User } from '../user.model';

@Component({
  selector: 'app-users-edit',
  templateUrl: './users-edit.component.html',
  styleUrls: ['./users-edit.component.css']
})
export class UsersEditComponent implements OnInit {
  @Input() user: User;

  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    console.log('id ', id);
    if (id) {
      console.log('edit user');
    } else {
      console.log('new user');
    }
    this.user = new User('a', 'b', 'c', 'd', id);
  }

  goBack(): void {
    this.location.back();
  }

}
