import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { UsersService } from '../users-service';
import { Role } from '../role.model';
import FormUtils from '../../field-error/FormUtil';
import { User } from '../user.model';

@Component({
  selector: 'app-users-edit',
  templateUrl: './users-edit.component.html',
  styleUrls: ['./users-edit.component.css']
})
export class UsersEditComponent implements OnInit {
  userForm: FormGroup;
  roles: Role[] = [];
  newUser = true;
  userId = '';
  minDate = new Date(2017, 5, 10);
  maxDate = new Date(2018, 9, 15);

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private formBuilder: FormBuilder,
    private userService: UsersService
  ) {}

  ngOnInit() {
    this.createForm();
    // this.userService.getAllRoles().subscribe(roles => {
    //   this.roles = roles.map(role => {
    //     return new Role(role.code, role.name, role.id);
    //   });
    // });
  }

  private createForm() {
    const id = this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.userForm = this.formBuilder.group({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      email: new FormControl('', [ Validators.required, Validators.email ]),
      password: new FormControl('', Validators.required),
      birthDate: new FormControl(new Date()),
      role: new FormControl('', Validators.required)
    });
    if (id) {
      this.newUser = false;
      this.userId = id;
      this.userService.getUserById(id).subscribe(user => {
        const role = new Role(user.role.code, user.role.name, user.role.id);
        this.userForm = this.formBuilder.group({
          firstName: new FormControl(user.firstName, Validators.required),
          lastName: new FormControl(user.lastName, Validators.required),
          email: new FormControl(user.email, [ Validators.required, Validators.email ]),
          birthDate: new FormControl(user.birthDate),
          role: new FormControl(role, Validators.required)
        });
      },
       error => console.log(<any>error));
    }
    console.log(this.userId);
  }

  save() {
    console.log(this.userForm.value);
    if (this.userForm.valid) {
      console.log('form submitted');
      const value = this.userForm.value;
      const roleString = value.role;
      const role = new Role(roleString.code, roleString.name, roleString.id);
      const user = new User(value.firstName, value.lastName, value.email, value.birthDate, role, this.userId);
      this.userService.save(user);
    } else {
      FormUtils.validateAllFormFields(this.userForm);
    }
  }

  goBack(): void {
    this.location.back();
  }

  isInvalid(field: string) {
    return FormUtils.isFieldInvalid(this.userForm, field);
  }

  displayFieldCss(field: string) {
    return FormUtils.displayFieldCss(this.userForm, field);
  }

  reset() {
    this.userForm.reset();
  }

  compare(val1, val2) {
    return val1.id === val2.id;
  }

}

