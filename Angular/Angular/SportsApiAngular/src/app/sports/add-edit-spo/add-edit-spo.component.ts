import { Component, Input, OnInit } from '@angular/core';
import {SharedService} from 'src/app/shared.service';

@Component({
  selector: 'app-add-edit-spo',
  templateUrl: './add-edit-spo.component.html',
  styleUrls: ['./add-edit-spo.component.css']
})
export class AddEditSpoComponent implements OnInit {
  [x: string]: any;

  constructor(private service:SharedService) { }

  @Input() spo:any;
  sportsId!: string;
  sportsName!: string;
  sportsType!: string;
  noOfPlayers!: string;
  

 

  ngOnInit(): void {
    this.sportsId=this.spo.sportsId;
    this.sportsName=this.spo.sportsName;
    
   
 
  }
  
  


  addSports(){
    var val = {sportsId:this.sportsId,
                sportsName:this.sportsName,
                sportsType:this.sportsType,
                noOfPlayers:this.noOfPlayers};
    this.service.addSports(val).subscribe(res=>{
      alert("Sports with Id"+this.sportsId+" added successfully");
      
    });
  }
 

  updateSports(){
    var val = {sportsId:this.sportsId,
      sportsName:this.sportsName,
      sportsType:this.sportsType,
      noOfPlayers:this.noOfPlayers};
    this.service.updateSports(val).subscribe(res=>{
    alert(res.toString());
   
    });
  }

  

}
