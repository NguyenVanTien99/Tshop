import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/shared/models/cart';
import { CartDetail } from 'src/app/shared/models/cart-detail';
import { User } from 'src/app/shared/models/user';
import { CartServiceService } from 'src/app/shared/services/cart-service.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  totalCartItem: number;

  isLoggedIn: boolean = false;

  cartDetail: CartDetail[];

  cart: Cart; 

  user: User;

  constructor(private cartService: CartServiceService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.cartService.data.subscribe(data => {
      this.totalCartItem = data;
    })
    this.getUser();
  }

  getUser(){
    this.user = this.tokenStorageService.getUser();

    if (this.user == null) {
      this.cartService.setData(0)
    }else{
      this.getTotalCartItem();
    }
  }

  getTotalCartItem(){
    this.cartService.getAllCartByUserId(this.user.id).subscribe(data=>{
      this.cart = data[0];
      this.cartDetail = this.cart.cartDetails;
      this.cartService.setData(this.cartDetail.length)
    }, error => {
      alert('handle error')
    })
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

}
