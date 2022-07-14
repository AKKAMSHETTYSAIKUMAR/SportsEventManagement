import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventbynameServiceService } from '../eventbyname.service';
import { event } from './event';
@Component({
  selector: 'app-eventbyname',
  templateUrl: './eventbyname.component.html',
  styleUrls: ['./eventbyname.component.css']
})
export class EventbynameComponent implements OnInit {

  event!:event;
  constructor(private eventService:EventbynameServiceService,public router:Router) { }

 id!:string;

  ngOnInit(): void {
  }
    onCancel(){

      this.router.navigate(["home/event"])
    }
  
    onClick(){
      this.eventService.getAllEventsNames(this.id).subscribe((data:event)=>{this.event=data;
      console.log(data);});
      this.router.navigate(["home/event/eventById"]);
    }
  

}
