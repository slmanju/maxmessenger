import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppBootstrapModule } from './app-bootstrapcss.module';
import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { AppComponent } from './app.component';
import { HeaderComponent } from './app.header';
import { HomeComponent } from './home/home.component';
import { UsersComponent } from './users/users.component';
import { UsersEditComponent } from './users/users-edit/users-edit.component';
import { MessagesComponent } from './messages/messages.component';
import { MessagesInputComponent } from './messages/messages-input.component';
import { FieldErrorComponent } from './field-error/field-error.component';

@NgModule({
  declarations: [
      AppComponent,
      HeaderComponent,
      MessagesComponent,
      MessagesInputComponent,
      UsersComponent,
      HomeComponent,
      UsersEditComponent,
      FieldErrorComponent
  ],
  imports: [
    [ BrowserModule,
      FormsModule,
      AppBootstrapModule,
      AngularFontAwesomeModule,
      AppRoutingModule,
      ReactiveFormsModule,
      HttpClientModule
    ]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

