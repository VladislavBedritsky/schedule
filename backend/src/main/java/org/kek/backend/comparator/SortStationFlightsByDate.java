package org.kek.backend.comparator;

import org.kek.data.dto.StationFlight;

import java.util.Comparator;

public class SortStationFlightsByDate implements Comparator<StationFlight> {
    @Override
    public int compare(StationFlight x, StationFlight y) {
        return x.getDate().compareTo(y.getDate());
    }
}
