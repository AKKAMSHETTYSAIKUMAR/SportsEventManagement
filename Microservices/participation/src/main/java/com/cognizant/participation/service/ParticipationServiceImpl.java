package com.cognizant.participation.service;

import com.cognizant.participation.entity.Participation;
import com.cognizant.participation.exception.ParticipantionCreationException;
import com.cognizant.participation.exception.ParticipationUpdationException;
import com.cognizant.participation.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationServiceImpl implements ParticipationService {

    @Autowired
    private ParticipationRepository participationRepository;

   
	@Override
	public Participation addParticipation(Participation newparticipation)
    {
        if(newparticipation.getPlayerId() == null || newparticipation.getPlayerName() == null || newparticipation.getEventId() == null || newparticipation.getEventName() == null || newparticipation.getSportsId() == null || newparticipation.getSportsName() == null)
            throw new ParticipantionCreationException("Fields can't be empty!");

        String status = "pending";

       // Participation participation = new Participation(playerId, playerName, eventId, eventName, sportsId, sportsName, status);
        return participationRepository.save(newparticipation);
    }

   
	@Override
	public List<Participation> findAllParticipations()
    {
        return participationRepository.findAll();
    }

  
	@Override
	public Participation updateParticipation(Participation participation)
    {
        if(participation.getParticipationId() == null)
            throw new ParticipationUpdationException("participationId cannot be empty!");

        if(participation.getStatus().equalsIgnoreCase("approved") || participation.getStatus().equalsIgnoreCase("declined"))
            return participationRepository.save(participation);

        else
            throw new ParticipationUpdationException("status can only be updated to either 'Approved' or 'Declined', but not "+participation.getStatus());
    }

   
	@Override
	public Optional<List<Participation>> getApprovedParticipations()
    {
        return participationRepository.findParticipationByStatus("approved");
    }

    
	@Override
	public Optional<List<Participation>> getDeclinedParticipants()
    {
        return participationRepository.findParticipationByStatus("declined");
    }

   
	@Override
	public Optional<List<Participation>> getPendingParticipations()
    {
        return participationRepository.findParticipationByStatus("pending");
    }

    
}
