import { Component, Input, OnInit } from '@angular/core';
import {SharedService} from 'src/app/shared.service';

@Component({
  selector: 'app-add-edit-ply',
  templateUrl: './add-edit-ply.component.html',
  styleUrls: ['./add-edit-ply.component.css']
})
export class AddEditPlyComponent implements OnInit {
  string: any;

  constructor(private service:SharedService) { }

  @Input() ply:any;
  playerId!: string;
  playerName!: string;
  age!: string;
  contactNumber!: string;
  email!: string;
  gender!: string;
  sportsName!: string;
  

 

  ngOnInit(): void {
    this.playerId=this.ply.playerId;
    this.playerName=this.ply.playerName;
    
   
 
  }
  addPlayers(){
    var val = {playerId:this.playerId,
                playerName:this.playerName,
                age:this.age,
                contactNumber:this.contactNumber,
                email:this.email,
                gender:this.gender,
                sportsName:this.sportsName,};
    this.service.addPlayers(val).subscribe(res=>{
      alert("Player  added successfully");
      
    });
  }
 

  updatePlayers(){
    var val = {playerId:this.playerId,
      playerName:this.playerName,
      age:this.age,
      contactNumber:this.contactNumber,
      email:this.email,
      gender:this.gender,
      sportsName:this.sportsName};
    this.service.updatePlayers(val).subscribe(res=>{
    alert(res.toString());
   
    });
  }

  

}
