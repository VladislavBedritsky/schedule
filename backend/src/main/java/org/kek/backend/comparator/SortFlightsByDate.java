package org.kek.backend.comparator;

import org.kek.data.dto.Flight;

import java.util.Comparator;

public class SortFlightsByDate implements Comparator<Flight> {
    @Override
    public int compare(Flight x, Flight y) {
        return x.getStartDate().compareTo(y.getStartDate());
    }
}
