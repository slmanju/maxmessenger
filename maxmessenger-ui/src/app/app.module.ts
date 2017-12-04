import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppBootstrapModule } from './app-bootstrapcss.module';
import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { AppComponent } from './app.component';
import { HeaderComponent } from './app.header';
import { MessagesComponent } from './messages/messages.component';
import { UsersComponent } from './users/users.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    [ AppComponent, HeaderComponent, MessagesComponent, UsersComponent, HomeComponent]
  ],
  imports: [
    [ BrowserModule, AppBootstrapModule, AngularFontAwesomeModule, AppRoutingModule ]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
