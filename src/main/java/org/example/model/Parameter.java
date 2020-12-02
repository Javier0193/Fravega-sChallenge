package org.example.model;

public class Parameter {
    String ppa_name;
    String ppa_value;

    public Parameter(String ppa_name, String ppa_value) {
        this.ppa_name = ppa_name;
        this.ppa_value = ppa_value;
    }

    public Parameter() {
    }

    public String getPpa_name() {
        return ppa_name;
    }

    public void setPpa_name(String ppa_name) {
        this.ppa_name = ppa_name;
    }

    public String getPpa_value() {
        return ppa_value;
    }

    public void setPpa_value(String ppa_value) {
        this.ppa_value = ppa_value;
    }
}
