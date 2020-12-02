package org.example.model;

public class Cerveceria {
    private int id;
    private String name;
    private String brewery_type;
    private String street;
    private String address_2;
    private String address_3;
    private String city;
    private String state;
    private String county_province;
    private String postal_code;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    private String website_url;
    private String updated_at;
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery_type() {
        return brewery_type;
    }

    public void setBrewery_type(String brewery_type) {
        this.brewery_type = brewery_type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getAddress_3() {
        return address_3;
    }

    public void setAddress_3(String address_3) {
        this.address_3 = address_3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty_province() {
        return county_province;
    }

    public void setCounty_province(String county_province) {
        this.county_province = county_province;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Cerveceria{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brewery_type='" + brewery_type + '\'' +
                ", street='" + street + '\'' +
                ", address_2='" + address_2 + '\'' +
                ", address_3='" + address_3 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", county_province='" + county_province + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", phone='" + phone + '\'' +
                ", website_url='" + website_url + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
