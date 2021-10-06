import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DialogRedirectComponent } from 'src/app/shared/components/dialog-redirect/dialog-redirect.component';
import { DialogComponent } from 'src/app/shared/components/dialog/dialog.component';
import { Product } from 'src/app/shared/models/product';
import { ProductService } from 'src/app/shared/services/product.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-products-detail',
  templateUrl: './admin-products-detail.component.html',
  styleUrls: ['./admin-products-detail.component.css']
})
export class AdminProductsDetailComponent implements OnInit {

 

  product: Product;

  constructor(public dialog: MatDialog,private routeActive: ActivatedRoute, private productService: ProductService, private route : Router, private _location: Location) { }
  
  ngOnInit(): void {

    this.routeActive.paramMap.subscribe(() => {
      this.getProduct();
    });
    
  }

  getProduct(){

    const productId: number = +this.routeActive.snapshot.paramMap.get('id');

    this.productService.getProductById(productId).subscribe({
      next: response => {
        this.product = response

      },
      error: err => {
        this.openDialogError("Error! Not found product", "go to list", "cancel");  
      }
    });

   
  }


  Delete() {
    this.openDialog("Do you want to Delete product?", "Yes", "No", this.product.id);
  }


  openDialog(message: string, textConfirm: string, textCancel: string, id: number) {
    const dialogRef = this.dialog.open(DialogComponent, {
      data: {
        message: message,
        buttonText: {
          ok: textConfirm,
          cancel: textCancel
        }
      }
    });


    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.deleteProduct(id);
      }
    });

  }

  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe(
      (data) => {
        this.openDialogBack("Deleted successfully", "Back to list");  
      },(error) => {
        console.log(error);
        this.openDialogError("Error! Not found product", "go to list", "cancel");  
        }
      );
  }


  openDialogBack(message: string, textConfirm: string) {
    const dialogRef = this.dialog.open(DialogRedirectComponent,{
      data:{
        message: message,
        buttonText: {
          ok: textConfirm
        }
      }
    });
    

    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.route.navigateByUrl("admin/products");
      }
    });

  }


  openDialogError(message: string, textConfirm: string, textCancel: string) {
    const dialogRef = this.dialog.open(DialogComponent,{
      data:{
        message: message,
        buttonText: {
          ok: textConfirm,
          cancel: textCancel
        }
      }
    });
    

    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.route.navigateByUrl("admin/products");
      }
    });

  }

  backClicked() {
    this._location.back();
  }
 
}
