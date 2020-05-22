import { Component, OnInit } from '@angular/core';

import { City } from 'src/app/common/city';
import { CityService } from 'src/app/service/city.service'
import { Point } from 'src/app/dto/point';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  cities: City[] = [];
  selectedCity: string;
  filteredPoints = [];

  points: Point[] = [];

  constructor(private _cityService: CityService) { }

  ngOnInit(): void {
    this.getCities();

  }

  getCities() {
    this._cityService.getCities().subscribe(
      data => {
        this.cities = data

        for(let i=0; i < this.cities.length; i++) {
          var point = new Point()

          point.cityName = this.cities[i]['cityName']
          point.pointIataCode = this.cities[i]['iataCode']
          point.pointName = this.cities[i]['cityName']
          point.countryIataCode = this.cities[i]['countryCode']
          point.typeOfPoint = 'city'

          this.points.push(point)
        }
      }
    )

  }

  filterPoints() {
    this.filteredPoints = this.points.filter(
      item => item.cityName.toLowerCase().includes(this.selectedCity.toLowerCase())
    )
  }

}
