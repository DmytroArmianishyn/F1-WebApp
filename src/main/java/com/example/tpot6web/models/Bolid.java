package com.example.tpot6web.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Bolid")
@Getter
@Setter
public class Bolid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Bottom")
    String bottom;

    @Column(name = "Gearbox")
    String gearbox;

    @Column(name = "Telemetry_equipment")
    String telemetry_equipment;

    @Column(name = "Engine")
    String engine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Team_id")
    TeamF1 teamF1;

    public Bolid() {
    }
}
