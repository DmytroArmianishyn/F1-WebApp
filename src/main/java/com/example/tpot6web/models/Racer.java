package com.example.tpot6web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Racer")
@AllArgsConstructor
@NoArgsConstructor
public class Racer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Racer(int id, String fullname, int age, int points) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.points = points;
    }

    @OneToMany(mappedBy = "racer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RaceRacer> raceRacers = new HashSet<>();

    @Column(name = "fullname")
    String fullname;
    int age;
    int points;

    public Racer(String fullname, int age, int points) {
        this.fullname = fullname;
        this.age = age;
        this.points = points;
        this.teams = teams;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Team_Racer",
            joinColumns = @JoinColumn(name = "Racer_Id"),
            inverseJoinColumns = @JoinColumn(name = "Team_id")
    )
    private List<TeamF1> teams;



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "fullName='" + fullname + '\'' +
                ", age=" + age +
                ", points=" + points +
                ", id=" + id +
                '}';
    }

    public void addTeam(TeamF1 teamF1){
        if (teams==null){
            teams= new ArrayList<>();
        }
        teams.add(teamF1);
    }
}
