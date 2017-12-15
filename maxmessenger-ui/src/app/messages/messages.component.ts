import {Component, OnInit} from "@angular/core";

import {Message} from "./message.model";
import {MessagesService} from "./messages.service";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  messages: Message[] = [];

  constructor(private messageService: MessagesService) {
  }

  ngOnInit() {
    this.messageService.getMessages().subscribe(
      messages => {
        this.messages = messages;
      });
  }

}
