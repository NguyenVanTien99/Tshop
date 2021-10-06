import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DialogRedirectComponent } from 'src/app/shared/components/dialog-redirect/dialog-redirect.component';
import { DialogComponent } from 'src/app/shared/components/dialog/dialog.component';
import { ProductCategory } from 'src/app/shared/models/product-category';
import { ProductCategoryService } from 'src/app/shared/services/product-category.service';
import { ProductService } from 'src/app/shared/services/product.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {


  index: number = 1

  productCategory: ProductCategory;


  thePageNumber: number = 1;
  thePageSize: number = 10;
  theTotalElements: number = 0;
  itemPerPage: number = 1;

  currentCategoryId: number = 1;
  previousCategoryId: number


  productCategorys: ProductCategory[] = [];

  previousKeyword: string = null


  constructor( 
    private routerActive: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog,
    private productCategoryService: ProductCategoryService,
    private productService: ProductService) { }

  ngOnInit(): void {

    this.routerActive.paramMap.subscribe(() => {
      this.listCategories();
    });

  }

  listCategories(){

    this.productCategoryService.getAllProductCategoryPaginate(this.thePageNumber -1, this.thePageSize).subscribe(this.processResult());

  }


  processResult() {
    console.log("processResult");

    return data => {
      console.log(data);
      
      this.productCategorys = data.content;
      this.thePageNumber = data.number + 1;
      this.thePageSize = data.size;
      this.theTotalElements = data.totalElements;
      this.processItemPerPage();
    }
  }


  processItemPerPage() {
      if (this.thePageNumber * this.thePageSize > this.theTotalElements) {
        this.itemPerPage = this.theTotalElements;
      } else {
        this.itemPerPage = this.thePageNumber * this.thePageSize;
      }
  }

  updatePageSize(pageSize) {
    this.thePageSize = pageSize;
    this.thePageNumber = 1;
    this.listCategories();
  }


  delete(id: number) {
    this.openDialog("Do you want to Delete product?", "Yes", "No", id);
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
        this.deleteCate(id);
      }
    });

  }


  deleteCate(value){

    console.log("ádasd");
    
    
    this.productService.getProductByCategoryId(value).subscribe(
      {
        next: response => {
                  

         if (response.length > 0) {
          this.openDialogError("Không Thể xoá vì vẫn còn sản phẩm thuộc thể loại này", "go to list", "cancel");
         }else{
            this.productCategoryService.getProductCategoryById(value).subscribe(data => {

              console.log(data);

              this.productCategoryService.deleteProduct(value).subscribe(
                (data) => {
                  this.openDialogBack("Deleted successfully", "Back to list");
                }, (error) => {
                  console.log(error);
                  this.openDialogError("Error! Not found product", "go to list", "cancel");
                }
              );
                


            }, error => {
              this.openDialogError("Không tìm thấy thể loại", "go to list", "cancel");
            }) 


         }
          

        },
        error: err => {
          this.openDialogError("Error", "go to list", "cancel");
        }
      }
    );


  }


  openDialogBack(message: string, textConfirm: string) {
    const dialogRef = this.dialog.open(DialogRedirectComponent, {
      data: {
        message: message,
        buttonText: {
          ok: textConfirm
        }
      }
    });


    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.listCategories();
      }
    });

  }


  openDialogError(message: string, textConfirm: string, textCancel: string) {
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
        this.listCategories();
      }
    });
  }

}
