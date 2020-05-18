package org.kek.backend.service.impl;

import org.kek.backend.dao.AirportDao;
import org.kek.backend.service.AirportService;
import org.kek.data.dto.Airport;
import org.kek.data.service.AviationstackApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * AirportService implementation
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDao airportDao;
    @Autowired
    private AviationstackApiService aviationstackApiService;

    @Override
    public void saveAllAirportsFromAviationstackApi() {
        for(Airport airport : aviationstackApiService.getAllAirports()) {
            airportDao.saveAirport(airport);
        }
    }
}
