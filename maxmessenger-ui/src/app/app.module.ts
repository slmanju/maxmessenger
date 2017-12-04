import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppBootstrapModule } from './app-bootstrapcss.module';
import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { AppComponent } from './app.component';
import { HeaderComponent } from './app.header';

@NgModule({
  declarations: [
    [AppComponent, HeaderComponent]
  ],
  imports: [
    [BrowserModule, AppBootstrapModule, AngularFontAwesomeModule]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
