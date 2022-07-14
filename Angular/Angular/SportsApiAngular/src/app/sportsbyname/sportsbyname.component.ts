import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SportsByNameServiceService } from '../sports-by-name-service.service';
import { sports } from './sports';

@Component({
  selector: 'app-sportsbyname',
  templateUrl: './sportsbyname.component.html',
  styleUrls: ['./sportsbyname.component.css']
})
export class SportsbynameComponent implements OnInit {

  sports!:sports;
  constructor(private sportsService:SportsByNameServiceService,public router:Router) { }

 id!:string;

  ngOnInit(): void {
    
  }

  onCancel(){
    this.router.navigate(["home/sports"])
  }

  onClick(){
    this.sportsService.getAllSportsNames(this.id).subscribe((data:sports)=>{this.sports=data;
    console.log(data);});
    this.router.navigate(["home/sports/sportsbyId"]);
  }

}
