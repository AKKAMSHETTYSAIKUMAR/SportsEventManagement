import { Component, Input, OnInit } from '@angular/core';
import {SharedService} from 'src/app/shared.service';

@Component({
  selector: 'app-add-edit-parti',
  templateUrl: './add-edit-parti.component.html',
  styleUrls: ['./add-edit-parti.component.css']
})
export class AddEditPartiComponent implements OnInit {
  [x: string]: any;

  constructor(private service:SharedService) { }

  @Input() parti:any;
  participationId!: string;
  playerId!: string;
  playerName!: string;
  eventId!: string;
  eventName!: string;
  sportsId!: string;
  sportsName!: string;
  status!: string;
  

 

  ngOnInit(): void {
    this.participationId=this.parti.participationId;
    this.status=this.parti.status;
    
   
 
  }
  
  


  addParticipation(){
    var val = {participationId:this.participationId,
      playerId:this.playerId,
      playerName:this.playerName,
      eventId:this.eventId,
      eventName:this.eventName,
      sportsId:this.sportsId,
      sportsName:this.sportsName,
      status:this.status,};
    this.service.addParticipation(val).subscribe(res=>{
      alert("Player with Id"+this.playerId+" added successfully");
      
    });
  }
 

  updateParticipation(){
    var val = {ParticipationId:this.participationId,
      playerId:this.playerId,
      slayerName:this.playerName,
      eventId:this.eventId,
      eventName:this.eventName,
      sportsId:this.sportsId,
      sportsName:this.sportsName,
      status:this.status,};
    this.service.updateParticipation(val).subscribe(res=>{
    alert("Player with Id"+this.playerId+" updated successfully");
   
    });
  }

  

}
