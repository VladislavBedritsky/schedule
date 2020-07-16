import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './module/app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppMaterialModule } from './module/app-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { MainComponent } from './component/main/main.component';
import { SearchFromToComponent } from './component/search-from-to/search-from-to.component';
import { TruncateTextPipe } from './pipe/truncate-text.pipe';
import { NavbarComponent } from './component/navbar/navbar.component';
import { FooterComponent } from './component/footer/footer.component';
import { MapComponent } from './component/map/map.component';
import { ProposalsComponent } from './component/proposals/proposals.component';


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    SearchFromToComponent,
    TruncateTextPipe,
    NavbarComponent,
    FooterComponent,
    MapComponent,
    ProposalsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AppMaterialModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
