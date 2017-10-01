package com.gis.project.model;

import javax.persistence.*;

@Entity
@Table(name = "map_start_direction")
public class StartDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "address")
    private String address;

    public static StartDirection newInstance() {
        return new StartDirection();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StartDirection withAddress(String address) {
        this.address = address;
        return this;
    }

}
