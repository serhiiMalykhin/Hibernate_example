package com.concretepage.candidate.repository;

import com.concretepage.candidate.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateActivityRepository extends JpaRepository<Candidate, Long> {
}