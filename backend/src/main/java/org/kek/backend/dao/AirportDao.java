package org.kek.backend.dao;

import org.kek.data.dto.Airport;

import java.util.List;

public interface AirportDao {
    void saveAirport(Airport airport);
    List<Airport> findAll();
}
