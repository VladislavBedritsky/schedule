import { Component, OnInit } from '@angular/core';

import { City } from 'src/app/common/city';
import { CityService } from 'src/app/service/city.service'

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  cities: City[];

  constructor(private _cityService: CityService) { }

  ngOnInit(): void {
  }

  getCities() {
    this._cityService.getCities().subscribe(
      data => console.log(data)
    )
  }
}
