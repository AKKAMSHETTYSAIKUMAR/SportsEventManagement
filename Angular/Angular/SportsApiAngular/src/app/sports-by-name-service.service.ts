import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SportsByNameServiceService {

  constructor(private http:HttpClient) { }

  getAllSportsNames(name:string) {
    return this.http.get<any>('http://localhost:8081/api/v1/sportsEvent/viewSportBySportName/'+name);
  }

}
