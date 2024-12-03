package com.concretepage;

import com.concretepage.candidate.model.CandidateActivity;
import com.concretepage.candidate.repository.CandidateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class HibernateJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(HibernateJpaApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CandidateRepository repository) {
        return (args) -> {
            var candidate = repository.findByIdWithActivities(1L).orElse(null);

            CandidateActivity activity = new CandidateActivity(
                    null, "", Instant.now(), true, candidate);
            candidate.add(activity);
            repository.saveAndFlush(candidate);
            log.info("activity id={} is null", activity.getId());
        };
    }
}
