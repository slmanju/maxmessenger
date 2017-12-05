import { Component, OnInit } from '@angular/core';
import { Message } from './message.model';
import {MessagesService} from "./messages.service";
import {NgForm} from "@angular/forms";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-messages-input',
  templateUrl: './messages-input.component.html'
})
export class MessagesInputComponent implements OnInit {
  message: Message;
  modalRef: BsModalRef;

  constructor(private messageService: MessagesService, private modalService: BsModalService) {}

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    const message = new Message(form.value.content, 'Manjula');
    this.messageService.addMessage(message);
    form.resetForm();
  }

}
