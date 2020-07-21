package org.kek.data.model.aviasales;

import java.util.Map;

/**
 *
 * Response from api.travelpayouts.com REST API about cheap flights
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class CheapFlightsResponse {

    /**
     *  Request result
     */
    private Boolean success;
    private String error;
    private String currency;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CheapFlightsResponse{" +
                "success=" + success +
                ", error='" + error + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
