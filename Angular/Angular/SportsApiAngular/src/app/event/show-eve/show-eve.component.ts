import { Component, OnInit } from '@angular/core';
import {SharedService} from 'src/app/shared.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-eve',
  templateUrl: './show-eve.component.html',
  styleUrls: ['./show-eve.component.css']
})
export class ShowEveComponent implements OnInit {
  EventListWithoutFilter: any;

  constructor(private service:SharedService, private route:Router) { }

  EventList:any=[];

  ModalTitle!: string;
  ActivateAddEditEveComp:boolean=false;
  eve:any;

  
  EventNameFilter:string="";


  ngOnInit(): void {
    this.refreshList();
  }
  goo(){
    this.route.navigate(['/eventById']);
  }

  addClick(){
    this.eve={
      eventId:"",
      eventDate:"",
      eventName:"",
      noofSlots:"",
      sportsName:""
    }
    this.ModalTitle="Add Event";
    this.ActivateAddEditEveComp=true;
    this.refreshList();
    

  }

  editClick(item: any){
    this.eve=item;
    this.ModalTitle="Edit Event";
    this.ActivateAddEditEveComp=true;
  }

  deleteClick(item: { eventId: any; }){
    if(confirm('Are you sure??')){
      this.service.deleteEvent(item.eventId).subscribe(data=>{
        alert("Event deleted sucessfully");
        this.refreshList();
      })
    }
  }

  closeClick(){
    this.ActivateAddEditEveComp=false;
    this.refreshList();
  }
  refreshEveList() {
    throw new Error('Method not implemented.');
  }


  refreshList(){
    this.service.getEveList().subscribe(data=>{
      this.EventList=data;
    
    });
  }



  sortResult(prop: string | number,asc: any){
    this.EventList = this.EventListWithoutFilter.sort(function(a: { [x: string]: number; },b: { [x: string]: number; }){
      if(asc){
          return (a[prop]>b[prop])?1 : ((a[prop]<b[prop]) ?-1 :0);
      }else{
        return (b[prop]>a[prop])?1 : ((b[prop]<a[prop]) ?-1 :0);
      }
    })
  }

}