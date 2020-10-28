package com.endie.avizandum.world.model;

import javax.persistence.*;

@Entity
@Table(name="terrain")
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long terrainId;

    private String name;

    public Terrain() {
    }

    public Terrain( String name ) {
        this.name = name;
    }


    public Long getTerrainId() {
        return terrainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
