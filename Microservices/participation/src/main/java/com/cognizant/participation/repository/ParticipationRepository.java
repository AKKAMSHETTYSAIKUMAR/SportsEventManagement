package com.cognizant.participation.repository;

import com.cognizant.participation.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

        Optional<Participation> findParticipationByParticipationId(Long participationId);
        Optional<List<Participation>> findParticipationByStatus(String status);


}
