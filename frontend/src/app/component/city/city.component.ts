import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

import { City } from 'src/app/common/city';
import { CityService } from 'src/app/service/city.service'

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  cities: City[];
  selectedCity: string;
  filteredCities = [];

  myControl = new FormControl();
  options: string[] = ['One', 'Two', 'Three'];
  filteredOptions: Observable<string[]>;

  constructor(private _cityService: CityService) { }

  ngOnInit(): void {
    this.getCities()

    this.filteredOptions = this.myControl.valueChanges.pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

  getCities() {
    this._cityService.getCities().subscribe(
      data => {
        this.cities = data
      }
    )
  }

  filterCities() {
    this.filteredCities = this.cities.filter(
      item => item.cityName.toLowerCase().includes(this.selectedCity.toLowerCase())
    );
    console.log(this.filteredCities)
  }
}
