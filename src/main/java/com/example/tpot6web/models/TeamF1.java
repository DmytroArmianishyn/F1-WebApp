package com.example.tpot6web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TeamF1")
@AllArgsConstructor
@NoArgsConstructor
public class TeamF1 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "country")
    private String country;


    public TeamF1(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Team_Racer",
            joinColumns = @JoinColumn(name = "Team_id"),
            inverseJoinColumns = @JoinColumn(name = "Racer_Id")
    )
    private List<Racer> racers;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamF1")
    private List<Bolid> bolids;





    @Override
    public String toString() {
        return name;
    }

    public TeamF1(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void addRacer(Racer racer){
        if (racers==null){
            racers= new ArrayList<>();
        }
        racers.add(racer);
    }
    public void addBolid(Bolid bolid){
        if (bolids==null){
            bolids= new ArrayList<>();
        }
        bolids.add(bolid);
        bolid.setTeamF1(this);
    }


}
