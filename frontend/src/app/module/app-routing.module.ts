import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from 'src/app/component/main/main.component';
import { FlightsComponent } from 'src/app/component//flight/flights/flights.component';

const routes: Routes = [
  {path: 'main', component: MainComponent },
  {path: 'flights', component: FlightsComponent },
  {path: '', redirectTo: '/main', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
