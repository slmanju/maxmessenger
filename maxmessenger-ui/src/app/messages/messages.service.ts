import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Message } from './message.model';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class MessagesService {
  messages: Message[] = [];

  messagesUrl = 'http://localhost:8080/messages';

  constructor(private http: HttpClient) { }

  addMessage(message: Message) {
    this.http.post(this.messagesUrl + '/user/1', message).subscribe(value => {
      this.messages.push(new Message(value.text, value.id, value.date));
    });
  }

  getMessages(): Observable<Message[]> {
    return this.http.get(this.messagesUrl);
  }

}
