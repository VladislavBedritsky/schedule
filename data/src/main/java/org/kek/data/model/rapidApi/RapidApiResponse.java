package org.kek.data.model.rapidApi;

import java.util.List;
import java.util.Objects;

public class RapidApiResponse {

    private List<CityResponse> response;
    private String terms;

    public List<CityResponse> getResponse() {
        return response;
    }

    public void setResponse(List<CityResponse> response) {
        this.response = response;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RapidApiResponse that = (RapidApiResponse) o;
        return Objects.equals(response, that.response) &&
                Objects.equals(terms, that.terms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, terms);
    }

    @Override
    public String toString() {
        return "RapidApiResponse{" +
                "response=" + response +
                ", terms='" + terms + '\'' +
                '}';
    }
}
