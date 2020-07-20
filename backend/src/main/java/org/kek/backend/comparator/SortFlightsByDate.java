package org.kek.backend.comparator;

import org.kek.data.dto.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * Comparator which compares class Flight by startDate property
 *
 * @version 1.01 20 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public class SortFlightsByDate implements Comparator<Flight> {
    @Override
    public int compare(Flight x, Flight y) {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date();
        Date d2 = new Date();

        try {
            d1 = sdformat.parse(x.getStartDate());
            d2 = sdformat.parse(y.getStartDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return d1.compareTo(d2);
    }
}
