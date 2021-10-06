import { NgModule } from "@angular/core";

import { SharedModule } from "../shared/shared.module";
import { BrowserModule } from "@angular/platform-browser";
import { AdminRoutingModule } from "./admin-routing.module";
import { FormDirective } from "./directive/form.directive";

import { AdminProductsAddComponent } from "./components/products/admin-products-add/admin-products-add.component";
import { AdminProductsDetailComponent } from "./components/products/admin-products-detail/admin-products-detail.component";
import { AdminProductsListComponent } from "./components/products/admin-products-list/admin-products-list.component";
import { AdminProductsUpdateComponent } from "./components/products/admin-products-update/admin-products-update.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { SidebarComponent } from "./components/sidebar/sidebar.component";
import { CategoryListComponent } from './components/categories/category-list/category-list.component';
import { CategoryFormComponent } from './components/categories/category-form/category-form.component';
import { CategoryDetailComponent } from './components/categories/category-detail/category-detail.component';
import { OrderListComponent } from './components/order/order-list/order-list.component';
import { OrderActionComponent } from './components/order/order-action/order-action.component';
import { HomeComponent } from './components/home/home.component';
 



@NgModule({
    declarations: [
        AdminProductsListComponent,
        DashboardComponent,
        AdminProductsAddComponent,
        AdminProductsUpdateComponent,
        AdminProductsDetailComponent,
        FormDirective,
        SidebarComponent,
        NavbarComponent,
        CategoryListComponent,
        CategoryFormComponent,
        CategoryDetailComponent,
        OrderListComponent,
        OrderActionComponent,
        HomeComponent,
    ],
    imports: [
        BrowserModule,
        SharedModule,
        AdminRoutingModule
    ]
  })
  export class AdminModule { }