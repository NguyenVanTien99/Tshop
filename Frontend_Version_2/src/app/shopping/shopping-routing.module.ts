import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { BoardUserComponent } from "./components/board-user/board-user.component";
import { CartComponent } from "./components/cart/cart.component";
import { HomeComponent } from "./components/home/home.component";
import { ItemDetailComponent } from "./components/item-detail/item-detail.component";
import { OrderHistoryComponent } from "./components/order-history/order-history.component";
import { ProductsComponent } from "./components/products/products.component";
import { ProfileComponent } from "./components/profile/profile.component";
import { UserProfileComponent } from "./components/user-profile/user-profile.component";


const routes: Routes = [

    {
        path: '', component: HomeComponent,
        children: [
            {path: '', component: ProductsComponent},
            {path: 'profilez', component: ProfileComponent},
            {path: 'user', component: BoardUserComponent},
            {path: 'carts', component: CartComponent },
            {path: 'item-detail/:id', component: ItemDetailComponent },
            {path: 'order-history', component: OrderHistoryComponent },
            {path: 'profile', component: UserProfileComponent },
          ]},

  ];

@NgModule({

    imports: [
        RouterModule.forChild(routes)
    ],

    exports: [RouterModule]
    
  })
  export class shoppingRoutingModule { }