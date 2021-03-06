import { Component, OnInit } from '@angular/core';

import { Point } from 'src/app/dto/point';
import { Route } from 'src/app/common/route';

@Component({
  selector: 'app-proposals',
  templateUrl: './proposals.component.html',
  styleUrls: ['./proposals.component.css']
})
export class ProposalsComponent implements OnInit {

  popularDestinations: Point[] = [
    {cityName: 'Singapore',pointName: 'Singapore', pointIataCode: 'SIN', countryCode: 'SG', typeOfPoint: 'city'},
    {cityName: 'Hong Kong',pointName: 'Hong Kong', pointIataCode: 'HKG', countryCode: 'HK', typeOfPoint: 'city'},
    {cityName: 'Aruba',pointName: 'Aruba', pointIataCode: 'AUA', countryCode: 'AW', typeOfPoint: 'city'},
    {cityName: 'Rome',pointName: 'Rome', pointIataCode: 'ROM', countryCode: 'IT', typeOfPoint: 'city'},
    {cityName: 'Dublin',pointName: 'Dublin', pointIataCode: 'DUB', countryCode: 'IE', typeOfPoint: 'city'},
    {cityName: 'Shannon',pointName: 'Shannon', pointIataCode: 'SNN', countryCode: 'IE', typeOfPoint: 'city'},
    {cityName: 'Los Angeles',pointName: 'Los Angeles', pointIataCode: 'LAX', countryCode: 'US', typeOfPoint: 'city'},
    {cityName: 'New York',pointName: 'New York', pointIataCode: 'NYC', countryCode: 'US', typeOfPoint: 'city'},
    {cityName: 'San Francisco',pointName: 'San Francisco', pointIataCode: 'SFO', countryCode: 'US', typeOfPoint: 'city'},
    {cityName: 'Madrid',pointName: 'Madrid', pointIataCode: 'MAD', countryCode: 'ES', typeOfPoint: 'city'},
    {cityName: 'Barcelona',pointName: 'Barcelona', pointIataCode: 'BCN', countryCode: 'ES', typeOfPoint: 'city'},
    {cityName: 'London',pointName: 'London', pointIataCode: 'LON', countryCode: 'GB', typeOfPoint: 'city'},
    {cityName: 'Bangkok',pointName: 'Bangkok', pointIataCode: 'BKK', countryCode: 'TH', typeOfPoint: 'city'},
    {cityName: 'Tokyo',pointName: 'Tokyo', pointIataCode: 'TYO', countryCode: 'JP', typeOfPoint: 'city'},
    {cityName: 'Melbourne',pointName: 'Melbourne', pointIataCode: 'MEL', countryCode: 'AU', typeOfPoint: 'city'},
    {cityName: 'Sydney',pointName: 'Sydney', pointIataCode: 'SYD', countryCode: 'AU', typeOfPoint: 'city'},
    {cityName: 'Osaka',pointName: 'Osaka', pointIataCode: 'OSA', countryCode: 'JP', typeOfPoint: 'city'},
    {cityName: 'Ho Chi Minh City',pointName: 'Ho Chi Minh City', pointIataCode: 'SGN', countryCode: 'VN', typeOfPoint: 'city'},
    {cityName: 'Amsterdam',pointName: 'Amsterdam', pointIataCode: 'AMS', countryCode: 'NL', typeOfPoint: 'city'},
    {cityName: 'Milan',pointName: 'Milan', pointIataCode: 'MIL', countryCode: 'IT', typeOfPoint: 'city'},
    {cityName: 'Paris',pointName: 'Paris', pointIataCode: 'PAR', countryCode: 'FR', typeOfPoint: 'city'},
    {cityName: 'Berlin',pointName: 'Berlin', pointIataCode: 'BER', countryCode: 'DE', typeOfPoint: 'city'},
    {cityName: 'Warsaw',pointName: 'Warsaw', pointIataCode: 'WAW', countryCode: 'PL', typeOfPoint: 'city'},
    {cityName: 'Prague',pointName: 'Prague', pointIataCode: 'PRG', countryCode: 'CZ', typeOfPoint: 'city'},
    {cityName: 'Moscow',pointName: 'Moscow', pointIataCode: 'MOW', countryCode: 'RU', typeOfPoint: 'city'},
    {cityName: 'Saint Petersburg',pointName: 'Saint Petersburg', pointIataCode: 'LED', countryCode: 'RU', typeOfPoint: 'city'},
    {cityName: 'Rio de Janeiro',pointName: 'Rio de Janeiro', pointIataCode: 'RIO', countryCode: 'BR', typeOfPoint: 'city'},
    {cityName: 'New Delhi',pointName: 'New Delhi', pointIataCode: 'DEL', countryCode: 'IN', typeOfPoint: 'city'},
    {cityName: 'Manchester',pointName: 'Manchester', pointIataCode: 'MAN', countryCode: 'GB', typeOfPoint: 'city'},
    {cityName: 'Dubai',pointName: 'Dubai', pointIataCode: 'DXB', countryCode: 'AE', typeOfPoint: 'city'},
    {cityName: 'Istanbul',pointName: 'Istanbul', pointIataCode: 'IST', countryCode: 'TR', typeOfPoint: 'city'},
    {cityName: 'Ibiza',pointName: 'Ibiza', pointIataCode: 'IBZ', countryCode: 'ES', typeOfPoint: 'city'}
  ];

  popularRoutes: Route[] = [
    { routeName: 'Kuala Lumpur – Singapore', fromIataCode: 'KUL', toIataCode: 'SIN'},
    { routeName: 'Hong Kong – Taipei', fromIataCode: 'HKG', toIataCode: 'TPE'},
    { routeName: 'Jakarta – Singapore', fromIataCode: 'CGK', toIataCode: 'SIN'},
    { routeName: 'Hong Kong – Shanghai', fromIataCode: 'HKG', toIataCode: 'SHA'},
    { routeName: 'Jakarta – Kuala Lumpur', fromIataCode: 'CGK', toIataCode: 'KUL'},
    { routeName: 'Seoul Incheon – Osaka', fromIataCode: 'ICN', toIataCode: 'ITM'},
    { routeName: 'New York LaGuardia – Toronto', fromIataCode: 'LGA', toIataCode: 'YYZ'},
    { routeName: 'Hong Kong – Seoul Incheon', fromIataCode: 'HKG', toIataCode: 'ICN'},
    { routeName: 'Bangkok – Singapore', fromIataCode: 'BKK', toIataCode: 'SIN'},
    { routeName: 'Dubai – Kuwait', fromIataCode: 'DXB', toIataCode: 'KWI'},
    { routeName: 'Bangkok – Hong Kong', fromIataCode: 'BKK', toIataCode: 'HKG'},
    { routeName: 'Hong Kong – Beijing', fromIataCode: 'HKG', toIataCode: 'PEK'},
    { routeName: 'New York JFK – London Heathrow', fromIataCode: 'JFK', toIataCode: 'LHR'},
    { routeName: 'Tokyo Narita – Taipei', fromIataCode: 'NRT', toIataCode: 'TPE'},
    { routeName: 'Dublin – London Heathrow', fromIataCode: 'DUB', toIataCode: 'LHR'},
    { routeName: 'Osaka – Shanghai', fromIataCode: 'ITM', toIataCode: 'SHA'}
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
