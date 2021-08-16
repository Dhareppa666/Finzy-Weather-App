package com.finzy.utils;

public enum ResponseDataTypes {

    WEATHER("weather"),
    FORECAST("forecast");

    private final String value;

    public String getValue() {
        return this.value;
    }

    ResponseDataTypes(String value) {
        this.value = value;
    }

    public static ResponseDataTypes value(String label) {
        for (ResponseDataTypes e : values()) {
            if (e.value.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
