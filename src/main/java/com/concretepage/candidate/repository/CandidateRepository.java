package com.concretepage.candidate.repository;

import com.concretepage.candidate.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c JOIN FETCH c.activities WHERE c.id = :id")
    Optional<Candidate> findByIdWithActivities(@Param("id") Long id);
}