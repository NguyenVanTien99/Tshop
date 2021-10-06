import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { BoardUserComponent } from './components/board-user/board-user.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { shoppingRoutingModule } from './shopping-routing.module';
import { ProductsComponent } from './components/products/products.component';
import { HeaderComponent } from './components/header/header.component';
import { ToastrModule } from 'ngx-toastr';
import { CartComponent } from './components/cart/cart.component';
import { OrderHistoryComponent } from './components/order-history/order-history.component';
import { OrderDetailComponent } from './components/order-detail/order-detail.component';
import { RateComponent } from './components/rate/rate.component';
import { ItemDetailComponent } from './components/item-detail/item-detail.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';



@NgModule({
  declarations: [HomeComponent, ProfileComponent, BoardUserComponent, ProductsComponent, HeaderComponent, CartComponent, OrderHistoryComponent, OrderDetailComponent, RateComponent, ItemDetailComponent, UserProfileComponent],
  imports: [
    CommonModule,
    ToastrModule.forRoot({
      timeOut: 2500,
      // progressBar: true,
      progressAnimation: 'increasing',
      // preventDuplicates: true,
      closeButton: true,
      // newestOnTop: false,
    }),
    SharedModule,
    shoppingRoutingModule,
    
  ]
})
export class ShoppingModule { }
