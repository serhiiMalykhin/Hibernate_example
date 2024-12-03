package com.concretepage.candidate.model;

//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<CandidateActivity> activities = new ArrayList<>();

    public Candidate(Long id, List<CandidateActivity> activities) {
        this.id = id;
        this.activities = activities;
    }

    public Candidate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CandidateActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<CandidateActivity> activities) {
        this.activities = activities;
    }

    public void add(CandidateActivity activity) {
        activities.add(activity);
    }
}