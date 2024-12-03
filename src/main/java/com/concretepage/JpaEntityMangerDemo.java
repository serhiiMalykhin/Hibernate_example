package com.concretepage;

import com.concretepage.entity.candidate.Candidate;
import com.concretepage.entity.candidate.CandidateActivity;

import javax.persistence.EntityManager;
import java.time.Instant;

public class JpaEntityMangerDemo {
    public static void main(String[] args) {
        createCandidate();
    }

    private static void createCandidate() {
        EntityManager entityManager = JPAUtility.getEntityManager();

        Candidate candidate = entityManager.find(Candidate.class, 1L);

        CandidateActivity activity = new CandidateActivity(null, "",
                Instant.now(), true, candidate);
        candidate.add(activity);
        save(entityManager, candidate);
        assert activity.getId() != null;
        System.out.println("activity index should not be null: "+ activity.getId());
        System.out.println("activities: "+ candidate.getActivities());
        entityManager.close();
        JPAUtility.close();
    }

    private static void save(EntityManager entityManager, Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }
}
