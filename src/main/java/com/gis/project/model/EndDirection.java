package com.gis.project.model;

import javax.persistence.*;

@Entity
@Table(name = "map_end_direction")
public class EndDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "address")
    private String address;

    public static EndDirection newInstance() {
        return new EndDirection();
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

    public EndDirection withAddress(String address) {
        this.address = address;
        return this;
    }

}
