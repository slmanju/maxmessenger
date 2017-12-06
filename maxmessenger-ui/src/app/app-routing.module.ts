import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MessagesComponent } from './messages/messages.component';
import { UsersComponent } from './users/users.component';
import { HomeComponent } from './home/home.component';
import { UsersEditComponent } from './users/users-edit/users-edit.component';

const routes: Routes = [
  /*{ path: '', redirectTo: '/', pathMatch: 'full' },*/
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'messages', component: MessagesComponent },
  { path: 'users', component: UsersComponent, },
  { path: 'user/edit/:id', component: UsersEditComponent },
  { path: 'user/new', component: UsersEditComponent }

  /*{ path: 'users', component: UsersComponent,
    children: [
      { path: 'edit/:id', component: UsersEditComponent },
      { path: '', component: UsersComponent, pathMatch: 'full' }
    ]
  }*/
  /*{ path: '**', component: PageNotFoundComponent }*/
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
