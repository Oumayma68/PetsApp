import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from "@angular/router"
import { UserInfo } from 'src/app/_auth/UserRegisterModel';
import { UserService } from 'src/app/_services/user.service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  logInForm: FormGroup;
  erroeMessage: string;
  password: string;
  email: string;
  userService: UserService;
  user:UserInfo;

  constructor(private test: UserService, private router: Router) {
    this.userService = test;
  }

  ngOnInit() {
    this.logInForm = new FormGroup({
      'email': new FormControl(),
      'password': new FormControl(),

    });
  }
  onSubmit() {

    this.email = (this.logInForm.get('email') as FormControl).value;
    this.password = (this.logInForm.get('password') as FormControl).value;
    this.userService.loginUser_(this.logInForm.get('email').value,this.logInForm.get('password').value).subscribe(res=>{
      console.log(res)
      if(res=='false')
      alert("bad credentials");
      else
      this.router.navigate(['/Home']);
    },err=>{
      console.log(err);
    })

  }

}
