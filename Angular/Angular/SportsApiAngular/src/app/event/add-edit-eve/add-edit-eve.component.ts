import { Component, Input, OnInit } from '@angular/core';
import {SharedService} from 'src/app/shared.service';

@Component({
  selector: 'app-add-edit-eve',
  templateUrl: './add-edit-eve.component.html',
  styleUrls: ['./add-edit-eve.component.css']
})
export class AddEditEveComponent implements OnInit {
  [x: string]: any;

  constructor(private service:SharedService) { }

  @Input() eve:any;
  eventId!: string;
  eventDate!: string;
  eventName!: string;
  noofSlots!: string;
  sportsName!: string;
  

 

  ngOnInit(): void {
    this.eventId=this.eve.eventId;
    this.eventName=this.eve.eventName;
    
   
 
  }
  
  


  addEvent(){
    var val = {eventId:this.eventId,
                eventDate:this.eventDate,
                eventName:this.eventName,
                noofSlots:this.noofSlots,
                sportsName:this.sportsName};
    this.service.addEvent(val).subscribe(res=>{
      alert("Event Added Sucessfully");
      
    });
  }
 

  updateEvent(){
    var val = {eventId:this.eventId,
              eventDate:this.eventDate,
              eventName:this.eventName,
              noofSlots:this.noofSlots,
              sportsName:this.sportsName};
    this.service.updateEvent(val).subscribe(res=>{
    alert(res.toString());
   
    });
  }

  

}
