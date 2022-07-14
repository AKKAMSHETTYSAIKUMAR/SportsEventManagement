import { Component,Input, OnInit } from '@angular/core';

import {SharedService} from 'src/app/shared.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-show-spo',
  templateUrl: './show-spo.component.html',
  styleUrls: ['./show-spo.component.css']
})
export class ShowSpoComponent implements OnInit {
  SportsListWithoutFilter: any;

  constructor(private service:SharedService,private route:Router) { }

  SportsList:any=[];

  ModalTitle!: string;
  ActivateAddEditSpoComp:boolean=false;
  spo:any;

  
  SportsNameFilter:string="";


  ngOnInit(): void {
    this.refreshList();
  }
  go(){
    this.route.navigate(['/sportsById']);
  }

  addClick(){
    this.spo={
      sportsId:"",
      sportsName:""
    }
    this.ModalTitle="Add Sports";
    this.ActivateAddEditSpoComp=true;
    this.refreshList();
    

  }

  editClick(item: any){
    this.spo=item;
    this.ModalTitle="Edit Sports";
    this.ActivateAddEditSpoComp=true;
  }

  deleteClick(item: { sportsId: any; }){
    if(confirm('Are you sure??')){
      this.service.deleteSports(item.sportsId).subscribe(data=>{
        alert(data.toString());
        this.refreshList();
      })
    }
  }

  closeClick(){
    this.ActivateAddEditSpoComp=false;
    this.refreshList();
  }
  refreshSpoList() {
    throw new Error('Method not implemented.');
  }


  refreshList(){
    this.service.getSpoList().subscribe(data=>{
      this.SportsList=data;
    
    });
  }



  sortResult(prop: string | number,asc: any){
    this.SportsList = this.SportsListWithoutFilter.sort(function(a: { [x: string]: number; },b: { [x: string]: number; }){
      if(asc){
          return (a[prop]>b[prop])?1 : ((a[prop]<b[prop]) ?-1 :0);
      }else{
        return (b[prop]>a[prop])?1 : ((b[prop]<a[prop]) ?-1 :0);
      }
    })
  }

}