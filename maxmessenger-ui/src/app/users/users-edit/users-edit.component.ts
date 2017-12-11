import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import FormUtils from '../../field-error/FormUtil';

@Component({
  selector: 'app-users-edit',
  templateUrl: './users-edit.component.html',
  styleUrls: ['./users-edit.component.css']
})
export class UsersEditComponent implements OnInit {
  userForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.createForm();
  }

  private createForm() {
    const id = this.route.snapshot.paramMap.get('id');
    console.log('id ', id);
    this.userForm = this.formBuilder.group({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }

  save() {
    console.log(this.userForm.value);
    if (this.userForm.valid) {
      console.log('form submitted');
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

}
