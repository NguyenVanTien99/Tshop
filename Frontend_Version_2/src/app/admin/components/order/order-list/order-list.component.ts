import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Order } from 'src/app/shared/models/order';
import { ProductCategory } from 'src/app/shared/models/product-category';
import { User } from 'src/app/shared/models/user';
import { CartServiceService } from 'src/app/shared/services/cart-service.service';
import { OrderService } from 'src/app/shared/services/order.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  index: number = 1


  thePageNumber: number = 1;
  thePageSize: number = 10;
  theTotalElements: number = 0;
  itemPerPage: number = 1;

  currentCategoryId: number = 1;
  previousCategoryId: number


  productCategory: ProductCategory[] = [];

  previousKeyword: string = null

  user: User;

  orders: Order[];

  order: Order;

  constructor(private router: Router, private tokenStorageService: TokenStorageService,private orderService: OrderService
    , private toastr: ToastrService, private cartService: CartServiceService) { }

  ngOnInit(): void {
    this.checkLogin();
  }

  checkLogin(){
    this.user = this.tokenStorageService.getUser();

    if (this.user != null) {
      this.getOrder();
      
    }else{
      this.router.navigate(['/login']);
    }
  }

  getOrder(){

    this.orderService.getAllOrder(0, 20).subscribe(data => { 

      this.orders = data.content

      console.log(this.order);
      
      
    }, error => {
      this.toastr.error('Lỗi! ' + error.status, 'Hệ thống');
    })

    
  }

  finish() {
    this.ngOnInit();
  }




}
