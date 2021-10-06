import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LoginAdminComponent } from "../core/components/login-admin/login-admin.component";
import { CategoryFormComponent } from "./components/categories/category-form/category-form.component";
import { CategoryListComponent } from "./components/categories/category-list/category-list.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { HomeComponent } from "./components/home/home.component";
import { OrderListComponent } from "./components/order/order-list/order-list.component";
import { AdminProductsAddComponent } from "./components/products/admin-products-add/admin-products-add.component";
import { AdminProductsDetailComponent } from "./components/products/admin-products-detail/admin-products-detail.component";
import { AdminProductsListComponent } from "./components/products/admin-products-list/admin-products-list.component";
import { AdminProductsUpdateComponent } from "./components/products/admin-products-update/admin-products-update.component";




const routes: Routes = [

    {   
        path: 'admin', component: DashboardComponent,
        children: [
          {path: 'home', component: HomeComponent},
          {path: 'products', children : [
            {path: '', component: AdminProductsListComponent},
            {path: 'create', component: AdminProductsAddComponent},
            {path: 'detail/:id', component: AdminProductsDetailComponent},
            {path: 'update/:id', component: AdminProductsUpdateComponent},
            {path: 'delete/:id', component: AdminProductsListComponent},
            {path: 'search', component: AdminProductsListComponent},
            {path: 'sort/:sortBy', component: AdminProductsListComponent},
          ]},

          {
            path: 'product-category',children : [
              {path: '', component: CategoryListComponent},
              {path: 'create', component: CategoryFormComponent},
              {path: 'update/:id', component: CategoryFormComponent},
              {path: 'detail/:id', component: CategoryFormComponent},
            ]
          },

          {
            path: 'order',children : [
              {path: '', component: OrderListComponent},
            ]
          },

        
        ]
    },
  ];

@NgModule({

    imports: [
        RouterModule.forChild(routes)
    ],

    exports: [RouterModule]
    
  })
  export class AdminRoutingModule { }