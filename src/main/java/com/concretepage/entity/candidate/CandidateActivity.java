package com.concretepage.entity.candidate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "candidates_activities")
public class CandidateActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    private Instant appointedTime;

    @Column(nullable = false)
    private boolean processed;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    public CandidateActivity() {
    }

    public CandidateActivity(Long id, String text,
                             Instant appointedTime, boolean processed, Candidate candidate) {
        this.id = id;
        this.text = text;
        this.appointedTime = appointedTime;
        this.processed = processed;
        this.candidate = candidate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getAppointedTime() {
        return appointedTime;
    }

    public void setAppointedTime(Instant appointedTime) {
        this.appointedTime = appointedTime;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
