import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators ,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { UserInfo } from 'src/app/_auth/UserRegisterModel';

import { User } from 'src/app/_model/User';
import { UserService } from 'src/app/_services/user.service.service';

import {PasswordValidator} from './register.form.validation';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  user:UserInfo;
  submitted = false;
  genders=['Male','Female'];
  newUser:User;

  constructor(private formBuilder:FormBuilder, private router:Router, private insertData:UserService) {
    this.newUser={ id: this.insertData.data.length, firstName: "", lastName: "", email: "", password: "", userGroupId: 2, image: "../../../../assets/images/comments/John-Amaechi-OBE_portraitfeatured.jpg" }

   }

  ngOnInit() {
    this.registerForm=this.formBuilder.group({
      firstName:[null, Validators.required],
      lastName:[null, Validators.required],
      email:[null, [Validators.required,Validators.email]],
      birthDate:[null],
      gender:['Male'],  
      password:['', [Validators.required, Validators.minLength(6)] ],
      confirmPassword:['', [Validators.required]]},
      {
        validator:PasswordValidator('password','confirmPassword')

      });

  }

  onSubmit(){
  
    this.user = new UserInfo(this.registerForm.get('firstName').value,this.registerForm.get('lastName').value,this.registerForm.get('email').value,this.registerForm.get('password').value)
   
  this.insertData.registerUser(this.user).subscribe(res=>{

    this.router.navigate(['/Login'])

  },err=>{
    console.log(err);
  })
    // console.log( this.insertData.data)
// this.router.navigate(['/Login'])

  }
  Cancel(){
    return 0;
  }
}

