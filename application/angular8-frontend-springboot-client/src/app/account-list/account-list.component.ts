import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Account } from '../Account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  accounts:Observable<Account[]>

  constructor(private accountService:AccountService,private router:Router) { }

  ngOnInit(): void {

    this.reloadData()
  }

reloadData()
{
  this.accounts=this.accountService.getAccountList()
}

deleteAccount(id:number)
{
  this.accountService.deleteAccount(id).subscribe(data=>{
    console.log(data)
    this.reloadData()
  },err=>{
    console.log(err)
  })
}

accountDetails(id:number)
{
  this.router.navigate(['details',id])
}

updateAccount(id: number){
  this.router.navigate(['update', id]);
}
}
