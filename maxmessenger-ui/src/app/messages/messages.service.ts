import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Message } from './message.model';

@Injectable()
export class MessagesService {
  messages: Message[] = [];

  constructor() {
    this.messages.push(new Message('Hello World', 'Manjula Jayawardana'));
    this.messages.push(new Message('Hello Seebo', 'Manjula Jayawardana'));
    this.messages.push(new Message('Hello Manjula', 'Manjula Jayawardana'));
  }

  addMessage(message: Message) {
    this.messages.push(message);
  }

  getMessages(): Observable<Message[]> {
    return of(this.messages);
  }

}
