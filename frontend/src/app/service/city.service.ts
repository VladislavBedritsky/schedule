import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { City } from 'src/app/common/city'

@Injectable({
  providedIn: 'root'
})
export class CityService {

  private findAllCitiesUrl = "http://localhost:8080/api/cities";

  constructor(private _httpClient: HttpClient) { }

  getCities(): Observable<City[]> {
    return this._httpClient.get<City[]>(this.findAllCitiesUrl);
  }

}
