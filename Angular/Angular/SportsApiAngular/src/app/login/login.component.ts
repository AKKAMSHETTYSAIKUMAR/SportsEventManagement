import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SharedService } from '../shared.service';
import { LoginCredintials } from './logincredintials';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user='1'
  error:boolean=false;
  constructor(public sharedservice:SharedService,public router:Router) { }

  ngOnInit() {

    
  }
  onSubmit(logincredintials:LoginCredintials){
    this.sharedservice.getToken(logincredintials).subscribe(data=>{
      if(data!=null){
      console.log(data);
      localStorage.setItem("jwt",data.authToken);
      localStorage.setItem("userid",data.userid);
      this.router.navigate(["/home"]);
      }
    },error => {
      this.error=true;
    },
    () => {
      // 'onCompleted' callback.
      // No errors, route to new page here
      alert("Successfull");
    }
    );
  }

  onCancel(){
    this.router.navigate(["/main"])
  }

}
