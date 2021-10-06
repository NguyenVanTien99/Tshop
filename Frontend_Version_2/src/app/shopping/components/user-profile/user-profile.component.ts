import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  customer: User;

  constructor() { } 

  ngOnInit(): void {
  }

}
