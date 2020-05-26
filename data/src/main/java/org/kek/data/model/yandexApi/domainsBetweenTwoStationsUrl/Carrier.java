package org.kek.data.model.yandexApi.domainsBetweenTwoStationsUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kek.data.model.yandexApi.Codes;

import java.util.Objects;

/**
 *
 * Information about the carrier.
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public class Carrier {

    /**
     * Flight number.
     */
    private Integer code;
    private String contacts;
    private String url;
    /**
     * Link to the carrier’s logo used by Yandex in SVG format.
     */
    @JsonProperty("logo_svg")
    private String logoSvg;
    private String title;
    private String phone;
    private Codes codes;
    private String address;
    /**
     * Link to the carrier’s logo used by Yandex in raster format.
     */
    private String logo;
    private String email;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogoSvg() {
        return logoSvg;
    }

    public void setLogoSvg(String logoSvg) {
        this.logoSvg = logoSvg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Codes getCodes() {
        return codes;
    }

    public void setCodes(Codes codes) {
        this.codes = codes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrier carrier = (Carrier) o;
        return Objects.equals(code, carrier.code) &&
                Objects.equals(contacts, carrier.contacts) &&
                Objects.equals(url, carrier.url) &&
                Objects.equals(logoSvg, carrier.logoSvg) &&
                Objects.equals(title, carrier.title) &&
                Objects.equals(phone, carrier.phone) &&
                Objects.equals(address, carrier.address) &&
                Objects.equals(logo, carrier.logo) &&
                Objects.equals(email, carrier.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, contacts, url, logoSvg, title, phone, address, logo, email);
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "code=" + code +
                ", contacts='" + contacts + '\'' +
                ", url='" + url + '\'' +
                ", logoSvg='" + logoSvg + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", codes=" + codes +
                ", address='" + address + '\'' +
                ", logo='" + logo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
