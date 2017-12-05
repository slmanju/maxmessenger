import {Component, OnInit, TemplateRef} from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';

import { Message } from './message.model';
import { MessagesService } from './messages.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: [ './messages.component.css' ]
})
export class MessagesComponent implements OnInit {
  modalRef: BsModalRef;
  messages: Message[] = [];

  constructor(private messageService: MessagesService, private modalService: BsModalService) {}

  ngOnInit() {
      this.messages = this.messageService.getMessages();
  }

  onAddMessage(message: Message) {
    message.author = 'Manjula';
    this.messages.push(message);
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

}
