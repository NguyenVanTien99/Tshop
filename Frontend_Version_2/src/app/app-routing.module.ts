import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './core/components/login/login.component';
import { RegisterComponent } from './core/components/register/register.component';
import { ErrorPageComponent } from './shared/components/error-page/error-page.component';

const routes: Routes = [

  {path: 'login', component: LoginComponent},

  {path: 'register', component: RegisterComponent},

  {path: '', redirectTo: 'home-page', pathMatch: 'full'},

  {
    path: '**',
    component: ErrorPageComponent
    
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
