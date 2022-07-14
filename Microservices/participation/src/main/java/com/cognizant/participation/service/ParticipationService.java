package com.cognizant.participation.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.participation.entity.Participation;

public interface ParticipationService {

	Participation addParticipation(Participation newparticipation);

	List<Participation> findAllParticipations();

	Participation updateParticipation(Participation participation);

	Optional<List<Participation>> getApprovedParticipations();

	Optional<List<Participation>> getDeclinedParticipants();

	Optional<List<Participation>> getPendingParticipations();

}