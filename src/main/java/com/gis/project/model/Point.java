package com.gis.project.model;

import javax.persistence.*;

@Entity
@Table(name = "map_points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    public static Point newInstance() {
        return new Point();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Point withId(long id) {
        this.id = id;
        return this;
    }

    public Point withAddress(String address) {
        this.address = address;
        return this;
    }

    public Point withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Point withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

}
