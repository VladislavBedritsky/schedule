import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { City } from 'src/app/common/city';
import { CityService } from 'src/app/service/city.service'
import { Point } from 'src/app/dto/point';
import { Airport } from 'src/app/common/airport';
import { AirportService } from 'src/app/service/airport.service'
import { InputErrorStateMatcher } from 'src/app/error/input-error-state-matcher'

@Component({
  selector: 'app-search-from-to',
  templateUrl: './search-from-to.component.html',
  styleUrls: ['./search-from-to.component.css']
})
export class SearchFromToComponent implements OnInit {

  matcher = new InputErrorStateMatcher();
  minDate: Date = new Date();
  date = new FormControl(new Date(), [
     Validators.required
  ]);

  cities: City[] = [];
  airports: Airport[] = [];
  points: Point[] = [];

  departureForm = new FormControl('', [
      Validators.required
  ])
  filteredPointsFrom = [];
  selectedPointFromIataCode: string;

  arrivalForm = new FormControl('', [
      Validators.required
  ])
  filteredPointsTo = [];
  selectedPointToIataCode: string;

  constructor(private _cityService: CityService,
              private _airportService: AirportService,
              private _router: Router) { }

  ngOnInit(): void {
    this.getCitiesAndSetPoints();
    this.getAirportsAndSetPoints();

    this.departureForm.setValue('Warsaw')
    this.selectedPointFromIataCode = 'WAW'

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
      item => item.cityName.toLowerCase().includes(this.departureForm.value.toLowerCase())
    )

    if (this.filteredPointsFrom.length === 0) {
      this.filteredPointsFrom = this.points.filter(
        item => item.pointName.toLowerCase().includes(this.departureForm.value.toLowerCase())
      )
    }
  }

  getIataCodeFromSelectedPointFrom(event, point) {
    if (event.source.selected) {
       this.selectedPointFromIataCode = point.pointIataCode;
    }
  }

  filterPointsTo() {
    this.filteredPointsTo = this.points.filter(
      item => item.cityName.toLowerCase().includes(this.arrivalForm.value.toLowerCase())
    )

    if (this.filteredPointsTo.length === 0) {
      this.filteredPointsTo = this.points.filter(
        item => item.pointName.toLowerCase().includes(this.arrivalForm.value.toLowerCase())
      )
    }
  }

  getIataCodeFromSelectedPointTo(event, point) {
    if (event.source.selected) {
       this.selectedPointToIataCode = point.pointIataCode;
    }
  }

  doPointsReverse() {
    const from = this.departureForm.value;
    const iataCodefrom = this.selectedPointFromIataCode;

    const to = this.arrivalForm.value;
    const iataCodeTo = this.selectedPointToIataCode;

    this.departureForm.setValue(to)
    this.selectedPointFromIataCode = iataCodeTo

    this.arrivalForm.setValue(from)
    this.selectedPointToIataCode = iataCodefrom

  }

  navigateToFlights() {
    this._router.navigateByUrl('/flights')
  }
}
