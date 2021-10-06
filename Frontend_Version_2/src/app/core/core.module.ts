import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './components/register/register.component';
import { SharedModule } from '../shared/shared.module';
import { LoginComponent } from './components/login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { LoginAdminComponent } from './components/login-admin/login-admin.component';

 

@NgModule({
  declarations: [RegisterComponent, LoginComponent, LoginAdminComponent],
  imports: [
    BrowserModule,
    CommonModule,
    SharedModule
  ]
})
export class CoreModule { }
