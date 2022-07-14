package com.cognizant.participation.controller;

import com.cognizant.participation.entity.Participation;
import com.cognizant.participation.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/v1/participation")
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @GetMapping("/getParticipants")
    public ResponseEntity<List<Participation>> getParticipants()
    {
        List<Participation> participations = participationService.findAllParticipations();
        return new ResponseEntity<>(participations, HttpStatus.OK);
    }

    @GetMapping("/getApprovedParticipants")
    public ResponseEntity<Optional<List<Participation>>> getApprovedParticipants()
    {
        Optional<List<Participation>> participations = participationService.getApprovedParticipations();
        return new ResponseEntity<>(participations, HttpStatus.OK);
    }

    @GetMapping("/getDeclinedParticipants")
    public ResponseEntity<Optional<List<Participation>>> getDeclinedParticipants()
    {
        Optional<List<Participation>> participations = participationService.getDeclinedParticipants();
        return new ResponseEntity<>(participations, HttpStatus.OK);
    }

    @GetMapping("/getPendingParticipants")
    public ResponseEntity<Optional<List<Participation>>> getPendingParticipants()
    {
        Optional<List<Participation>> participations = participationService.getPendingParticipations();
        return new ResponseEntity<>(participations, HttpStatus.OK);
    }

    @PostMapping("/addParticipation")
    public ResponseEntity<Participation> addParticipation(@RequestBody Participation newparticipation)
    {
		/*
		 * String playerId = (String) map.get("playerId"); String playerName = (String)
		 * map.get("playerName"); String eventId = (String) map.get("eventId"); String
		 * eventName = (String) map.get("eventName"); String sportsId = (String)
		 * map.get("sportsId"); String sportsName = (String) map.get("sportsName");
		 */

        Participation participation = participationService.addParticipation(newparticipation);
        return new ResponseEntity<>(newparticipation, HttpStatus.OK);
    }

    @PutMapping("/updateParticipant")
    public ResponseEntity<Participation> updateParticipation(@RequestBody Participation participation)
    {
        Participation participate = participationService.updateParticipation(participation);
        return new ResponseEntity<>(participate, HttpStatus.OK);
    }

    private Map<String, String> participationAddedSuccessfully(Participation participation) {

        Map<String, String> map = new HashMap<>();

        map.put("message", "Participation added successfully!!");
        map.put("participationId", participation.getParticipationId().toString());
        map.put("playerName", participation.getPlayerName());
        map.put("eventName", participation.getEventName());
        map.put("sportName", participation.getSportsName());
        map.put("status", participation.getStatus());

        return map;
    }


}
