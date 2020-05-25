import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

import { City } from 'src/app/common/city';
import { CityService } from 'src/app/service/city.service'
import { Point } from 'src/app/dto/point';
import { Airport } from 'src/app/common/airport';
import { AirportService } from 'src/app/service/airport.service'


@Component({
  selector: 'app-search-from-to',
  templateUrl: './search-from-to.component.html',
  styleUrls: ['./search-from-to.component.css']
})
export class SearchFromToComponent implements OnInit {

  colorControl = new FormControl('warn');

  cities: City[] = [];
  airports: Airport[] = [];
  points: Point[] = [];

  filteredPointsFrom = [];
  selectedPointFrom: string;
  selectedPointFromIataCode: string;

  filteredPointsTo = [];
  selectedPointTo: string;
  selectedPointToIataCode: string;

  constructor(private _cityService: CityService,
              private _airportService: AirportService) { }

  ngOnInit(): void {
    this.getCitiesAndSetPoints();
    this.getAirportsAndSetPoints();
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

  filterPointsFrom() {
    this.filteredPointsFrom = this.points.filter(
      item => item.cityName.toLowerCase().includes(this.selectedPointFrom.toLowerCase())
    )

    if (this.filteredPointsFrom.length === 0) {
      this.filteredPointsFrom = this.points.filter(
        item => item.pointName.toLowerCase().includes(this.selectedPointFrom.toLowerCase())
      )
    }
  }

  getIataCodeFromSelectedPointFrom(event, point) {
    if (event.source.selected) {
       this.selectedPointFromIataCode = point.pointIataCode;
       console.log(this.selectedPointFromIataCode)
    }
  }

  filterPointsTo() {
    this.filteredPointsTo = this.points.filter(
      item => item.cityName.toLowerCase().includes(this.selectedPointTo.toLowerCase())
    )

    if (this.filteredPointsTo.length === 0) {
      this.filteredPointsTo = this.points.filter(
        item => item.pointName.toLowerCase().includes(this.selectedPointTo.toLowerCase())
      )
    }
  }

  getIataCodeFromSelectedPointTo(event, point) {
    if (event.source.selected) {
       this.selectedPointToIataCode = point.pointIataCode;
       console.log(this.selectedPointToIataCode)
    }
  }
}
