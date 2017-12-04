import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MessagesComponent } from './messages/messages.component';
import { UsersComponent } from './users/users.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  /*{ path: '', redirectTo: '/', pathMatch: 'full' },*/
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'messages', component: MessagesComponent },
  { path: 'users', component: UsersComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
