import { Component, OnInit } from '@angular/core';

import { City } from 'src/app/common/city';
import { CityService } from 'src/app/service/city.service'
import { Point } from 'src/app/dto/point';
import { Airport } from 'src/app/common/airport';
import { AirportService } from 'src/app/service/airport.service'


@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  cities: City[] = [];
  airports: Airport[] = [];
  points: Point[] = [];

  filteredPoints = [];
  selectedPoint: string;
  selectedPointIataCode: string;

  constructor(private _cityService: CityService,
              private _airportService: AirportService) { }

  ngOnInit(): void {
    this.getCitiesAndSetPoints();
    this.getAirportsAndSetPoints();
  }

  getIataCodeFromSelectedPoint(event, point) {
    if (event.source.selected) {
       this.selectedPointIataCode = point.pointIataCode;
       console.log(this.selectedPointIataCode)
    }
  }

  getCitiesAndSetPoints() {
    this._cityService.getCities().subscribe(
      data => {
        this.cities = data

        for(let i=0; i < this.cities.length; i++) {
          var point = new Point()

          point.cityName = this.cities[i]['cityName']
          point.pointIataCode = this.cities[i]['iataCode']
          point.pointName = this.cities[i]['cityName']
          point.countryCode = this.cities[i]['countryCode']
          point.typeOfPoint = 'city'

          this.points.push(point)
        }
      }
    )
  }

  getAirportsAndSetPoints() {
    this._airportService.getAirports().subscribe(
      data => {
        this.airports = data

        for(let i=0; i < this.airports.length; i++) {
          var point = new Point()

          point.cityName = this.airports[i]['cityName']
          point.pointIataCode = this.airports[i]['iataCode']
          point.pointName = this.airports[i]['airportName']
          point.countryCode = this.airports[i]['countryIso2']
          point.typeOfPoint = 'airport'

          this.points.push(point)
        }
      }
    )
  }

  filterPoints() {
    this.filteredPoints = this.points.filter(
      item => item.cityName.toLowerCase().includes(this.selectedPoint.toLowerCase())
    )
  }


}
