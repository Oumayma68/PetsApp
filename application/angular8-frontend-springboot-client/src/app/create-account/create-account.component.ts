import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from '../Account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  account :Account =new Account();
  submitted=false;

  constructor(private accountService:AccountService,private router:Router) { }

  ngOnInit(): void {
  }

  newAccount():void
  {
    this.submitted=false;
    this.account=new Account();
  }

  save()
  {
    this.accountService.createAccount(this.account)
    .subscribe(res=>{
      this.account=new Account();
      this.goToList();
    })
  }

  onSubmit()
  {
    this.submitted=true;
    this.save();
  }

  goToList()
  {
    this.router.navigate['/accounts']
  }
}
