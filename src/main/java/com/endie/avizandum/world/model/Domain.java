package com.endie.avizandum.world.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domain")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domainId;

    private String name;

    public Domain() {
    }

    public Domain( String name) {
        this.name = name;
    }

    public Long getDomainId() {
        return domainId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

}
