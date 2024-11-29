package com.example.DoctorDistrtrict;

public class Doctor {
    private int id;
    private String name;
    private String fio;
    private String region;

    public Doctor(int id, String name, String fio, String region) {
        this.id = id;
        this.name = name;
        this.fio = fio;
        this.region = region;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFio() {
        return fio;
    }

    public String getRegion() {
        return region;
    }
}
