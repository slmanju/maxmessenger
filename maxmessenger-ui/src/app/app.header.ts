import { Component, TemplateRef } from '@angular/core';

import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-header',
  templateUrl: './app.header.html'
})
export class HeaderComponent {
  public modalRef: BsModalRef; // {1}
  constructor(private modalService: BsModalService) {} // {2}

  public openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template); // {3}
  }
}
