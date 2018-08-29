package com.crystal.School.uberjava;

public enum LocationEnum {

    SACRAMENTO("Sacramento"), REDDING("Redding"), SAN_FRANCISCO("San+Francisco"), SAN_JOSE("San+Jose"), FRESNO("Fresno"), LOS_ANGELES("Los+Angeles"), SAN_DIEGO("San+Diego"), SAN_BERNADINO("San+Bernadino"), YOSEMITE("Yosemite"), DEATH_VALLEY("Death+Valley");

    private String location;

    LocationEnum(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

}
