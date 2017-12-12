import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

import { User } from './user.model';
import {Role} from './role.model';

@Injectable()
export class UsersService {
  users: User[] = [];

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.http.get('http://localhost:8080/users').map(this.extractData).catch(this.handleError);
  }

  getUserById(id: string): Observable<User> {
    return this.http.get('http://localhost:8080/users/' + id).map(this.extractData).catch(this.handleError);
  }

  getAllRoles(): Observable<Role[]> {
    return this.http.get('http://localhost:8080/users/roles').map(this.extractData).catch(this.handleError);
  }

  private extractData(res: Response) {
        return res || [];
    }

    private handleError(error: any) {
        // In a real world app, we might use a remote logging infrastructure
        // We'd also dig deeper into the error to get a better message
        const errMsg = (error.message) ? error.message : error.status ? `${error.status} - ${error.statusText}` : 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }

}
