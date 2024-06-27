package com.example.tpot6web.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Race_Racer")
public class RaceRacer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Race_id", nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "Racer_Id", nullable = false)
    private Racer racer;

    @Column(name = "place")
    private int position;


    public RaceRacer() {}

    public RaceRacer(Race race, Racer racer, int position) {
        this.race = race;
        this.racer = racer;
        this.position = position;
    }





}
