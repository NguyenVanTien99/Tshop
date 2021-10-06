import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Order } from 'src/app/shared/models/order';
import { User } from 'src/app/shared/models/user';
import { CartServiceService } from 'src/app/shared/services/cart-service.service';
import { OrderService } from 'src/app/shared/services/order.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit { 

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

    this.orderService.getOrdersByUserId(this.user.id, 0, 10).subscribe(data => {

      this.orders = data.content

      console.log(this.order);
      
      
    }, error => {
      this.toastr.error('Lỗi! ' + error.status, 'Hệ thống');
    })

    
  }


  cancel(id){

    Swal.fire({
      title: 'Bạn có muốn huỷ đơn hàng này?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonText: 'Không',
      confirmButtonText: 'Huỷ'
    }).then((result) => {
      if (result.isConfirmed) {
        this.orderService.getOrdersById(id).subscribe(data => {
          this.order = data;
          this.order.status = 0

          console.log("ádasdasd", this.order);
          

          this.orderService.updateOrder(this.order).subscribe(data => {
            this.toastr.success('Huỷ thành công !', 'Hệ thống');
            this.ngOnInit();
          }, error => {
            this.toastr.error('Lỗi! ' + error.status, 'Hệ thống');
        }
        )

        }, error => {
            this.toastr.error('Lỗi! ' + error.status, 'Hệ thống');
        })
      }
    })

  }

}
 