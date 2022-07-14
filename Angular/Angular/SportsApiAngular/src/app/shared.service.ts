import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { LoginCredintials } from './login/logincredintials';
import { JwtTokenresponse } from './login/jwtTokenresponse';


@Injectable({
  providedIn: 'root'
})

export class SharedService {
  [x: string]: any;
 
  constructor(private http:HttpClient) { }

  deleteDepartment(DepartmentId: any) {
    throw new Error('Method not implemented.');
  }

  getAllSportsNames() {
    throw new Error('Method not implemented.');
  }
  updateSport(val: { sportsId: string; sportsName: string; }) {
    throw new Error('Method not implemented.');
  }
   readonly APIUrl="http://localhost:8080/api/v1/sportsEvent";
  readonly APIIUrl="http://localhost:8080/api/v1/sportsEvent";
  readonly APIIIUrl="http://localhost:52560/api";
  
 
  // getLogin(body:any):Observable<any[]>{
  //   return this.http.post<any>('http://localhost:8080/api/auth/login',body);
  // }
  

  getSpoList():Observable<any[]>{
    return this.http.get<any>('http://localhost:8081/api/v1/sportsEvent/viewAllSports');
  }
  
  getPartiList():Observable<any[]>{
    return this.http.get<any>('http://localhost:8083/api/v1/participation/getParticipants');
  }

  getPlyList():Observable<any[]>{
    return this.http.get<any>('http://localhost:8082/api/v1/Player/viewAllPlayers');
  }

  addSports(val:any){
    return this.http.post('http://localhost:8081/api/v1/sportsEvent/addSport',val);
  }
  addParticipation(val:any){
    return this.http.post('http://localhost:8083/api/v1/participation/addParticipation',val);
  }
  addPlayers(val:any){
    return this.http.post('http://localhost:8082/api/v1/Player/addPlayer',val);
  }

  updateSports(val:any){
    return this.http.put(this.APIIUrl+'/Sports',val);
  }
  updateParticipation(val:any){
    return this.http.put('http://localhost:8083/api/v1/participation/updateParticipant',val);
  }
  updatePlayers(val:any){
    return this.http.put(this.APIUrl+'/Player',val);
  }

  deleteSports(val:any){
    return this.http.delete(this.APIIUrl+'/Sports/'+val);
  }
  deleteParticipation(val:any){
    return this.http.delete(this.APIIIUrl+'/Participation/'+val);
  }
  deletePlayers(val:any){
    return this.http.delete('http://localhost:8082/api/v1/Player/deleteplayer/'+val);
  }


  getEveList():Observable<any[]>{
    return this.http.get<any>('http://localhost:8081/api/v1/sportsEvent/viewAllEvents');
  }


  addEvent(val:any){
    return this.http.post('http://localhost:8081/api/v1/sportsEvent/addEvent',val);
  }

  updateEvent(val:any){
    return this.http.put(this.APIIUrl+'/Event',val);
  }

  deleteEvent(val:any){
    return this.http.delete('http://localhost:8081/api/v1/sportsEvent/cancelEvent/'+val);
  }
  getToken(login:LoginCredintials):Observable<JwtTokenresponse> {
    return this.http.post<JwtTokenresponse>("http://localhost:8080/api/auth/login",login);
  }
}
