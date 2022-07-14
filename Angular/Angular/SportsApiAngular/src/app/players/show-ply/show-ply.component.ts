import { Component, OnInit } from '@angular/core';
import {SharedService} from 'src/app/shared.service';

@Component({
  selector: 'app-show-ply',
  templateUrl: './show-ply.component.html',
  styleUrls: ['./show-ply.component.css']
})
export class ShowPlyComponent implements OnInit {

  constructor(private service:SharedService) { }

  PlayersList:any=[];
  
  ModalTitle!: string;
  ActivateAddEditPlyComp:boolean=false;
  ply:any;

  ngOnInit(): void {
    this.refreshList();
  }


  addClick(){
    this.ply={
      playerId:"",
      playerName:""
    }
    this.ModalTitle="Add Players";
    this.ActivateAddEditPlyComp=true;
    this.refreshList();
  }

  editClick(item: any){
    this.ply=item;
    this.ModalTitle="Edit Players";
    this.ActivateAddEditPlyComp=true;
  }

  closeClick(){
    this.ActivateAddEditPlyComp=false;
    this.refreshList();
  }
  refreshPlyList() {
    throw new Error('Method not implemented.');
  }





  deleteClick(item: { playerId: any; }){
    if(confirm('Are you sure??')){
      this.service.deletePlayers(item.playerId).subscribe(data=>{
        alert("Player deleted successfully");
        this.refreshList();
      })
    }
  }

  refreshList(){
    this.service.getPlyList().subscribe(data=>{
      this.PlayersList=data;
    
    });
  }

}
