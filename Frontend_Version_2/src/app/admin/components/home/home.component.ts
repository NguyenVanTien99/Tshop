import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { Order } from 'src/app/shared/models/order';
import { Statistical } from 'src/app/shared/models/statistical';
import { User } from 'src/app/shared/models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  orders: Order[];
  users: User[];
  userLength: number;
  orderLength: number;
  statistical: Statistical[];

  labels: string[] = [];
  data: number[] = [];
  year: number = 2021;
  years!: number[];
  myChartBar : Chart;
  myChartDoughnut: Chart;

  image!: string;

  user!: User;

  constructor() { }

  ngOnInit(): void {
    

  }

}
