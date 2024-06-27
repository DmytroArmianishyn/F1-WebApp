package com.example.tpot6web.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    String city;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private Set<RaceRacer> raceRacers;



    public Race() {}

    public Race(String name, String city) {
        this.name = name;
        this.city=city;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void addRaceRacer(Racer racer, int position) {
        RaceRacer raceRacer = new RaceRacer(this, racer, position);
        raceRacers.add(raceRacer);
        racer.getRaceRacers().add(raceRacer);
    }

    @Override
    public String toString() {
        return "Name-" + name + " City-"+ city;
    }
}
