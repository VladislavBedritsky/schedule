import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Airport } from 'src/app/common/airport'

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  private findAllAirports = "http://localhost:8080/api/airports"

  constructor(private _httpClient: HttpClient) { }

  getAirports(): Observable<Airport[]> {
    return this._httpClient.get<Airport[]>(this.findAllAirports);
  }
}
