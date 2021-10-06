import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/shared/models/product';
import { ProductCategory } from 'src/app/shared/models/product-category';
import { ProductCategoryService } from 'src/app/shared/services/product-category.service';
import { ProductService } from 'src/app/shared/services/product.service';
import { DialogRedirectComponent } from 'src/app/shared/components/dialog-redirect/dialog-redirect.component';
import { FormValidator } from 'src/app/admin/validator/form-validator';
import { DialogComponent } from 'src/app/shared/components/dialog/dialog.component';
import { Location } from '@angular/common';

@Component({ 
  selector: 'app-admin-products-update',
  templateUrl: './admin-products-update.component.html',
  styleUrls: ['./admin-products-update.component.css']
})
export class AdminProductsUpdateComponent implements OnInit {

  product: Product;

  @ViewChild("myinputFirst") myinputFirst: ElementRef;

  @ViewChild("myinputLast") myinputLast: ElementRef;

  submitted = true;

  url: string;

  addProductFormGroup: FormGroup;

  productCategory: ProductCategory[] = [];

  constructor(private formBuilder: FormBuilder, private routerActive: ActivatedRoute, private productCategoryService: ProductCategoryService,public dialog: MatDialog, private route: Router,
              private productService: ProductService, private _location: Location  ) { }



  ngOnInit(): void {

    this.addProductFormGroup = this.formBuilder.group(
      {
        sku: new FormControl('', [Validators.required, Validators.pattern('([A-Za-z]+-)+[0-9]+'), FormValidator.notOnlyWhitespace]),
        name: new FormControl('', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace] ),
        description: new FormControl('', [Validators.maxLength(255)]),
        unitPrice: new FormControl('', [Validators.required, Validators.min(0)]),
        active: new FormControl(true),
        unitInStock: new FormControl('', [Validators.required, Validators.min(0)]),
        category: new FormControl('', FormValidator.DefaultOption),
      },
    )


      this.routerActive.paramMap.subscribe(() => {
        this.getProduct();
      });

  }

  getProduct(){

    const productId: number = +this.routerActive.snapshot.paramMap.get('id');

    this.productService.getProductById(productId).subscribe({
      next: response => {
        this.product = response

        this.setFormValue()

      },
      error: err => {
        alert(`There was an error: ${err.message}`);
      }
    });
  }

  setFormValue(){
    console.log(this.unitPrice) ;
    
    this.addProductFormGroup.setValue({
      sku: this.product.sku,
      name: this.product.name,
      description: this.product.description,
      unitPrice: this.product.unitPrice,
      active: this.product.active,
      unitInStock: this.product.unitInStock,
      category: this.product.category

    });

    this.url = this.product.imageUrl

    this.productCategoryService.getAllProductCategory().subscribe(
      data => {
        this.productCategory = data;
        console.log(this.productCategory);
        
        this.addProductFormGroup.get('category').setValue(this.productCategory[0])
      }
    )
    
  }

  onShiftKey(event: KeyboardEvent) {

    event.preventDefault();
    if (event.shiftKey && event.key === "Tab") {
      this.myinputLast.nativeElement.focus();

    }
  }

  onKey(event: KeyboardEvent) {

    event.preventDefault();
    if (event.key === "Tab") {
      this.myinputFirst.nativeElement.focus();
    }
  }

  ngOnDestroy() {

  }

  ngAfterViewInit() {
  
    this.myinputFirst.nativeElement.focus();

    
  }

  get sku() { return this.addProductFormGroup.get('sku'); }
  get name() { return this.addProductFormGroup.get('name'); }
  get description() { return this.addProductFormGroup.get('description'); }
  get active() { return this.addProductFormGroup.get('active'); }
  get unitPrice() { return this.addProductFormGroup.get('unitPrice'); }
  get unitInStock() { return this.addProductFormGroup.get('unitInStock'); }
  get category() { return this.addProductFormGroup.get('category'); }

  
    

  onSubmit() {
    console.log("Handle Form Submit");

    this.submitted = true;

    if (this.addProductFormGroup.invalid) {
      return;
    }

    console.log(this.addProductFormGroup.value)

    this.openDialog1("Do you want to update product?", "Yes", "No");
    
  }


  openDialog1(message: string, textConfirm: string, textCancel: string) {
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
        this.saveProduct()
      }
    });

  }

  saveProduct(){
      let product = new Product();

      console.log(product);
      

      product.sku = this.addProductFormGroup.get('sku').value;
      product.name = this.addProductFormGroup.get('name').value;
      product.description = this.addProductFormGroup.get('description').value;
      product.active = true;
      product.unitPrice = this.addProductFormGroup.get('unitPrice').value;
      product.unitInStock = this.addProductFormGroup.get('unitInStock').value;  

      product.imageUrl = this.url;


      let productCategory = new ProductCategory();

      productCategory.id = this.addProductFormGroup.get('category').value.id;

      product.category = productCategory;
      

      this.productService.updateProduct(product, +this.product.id).subscribe(
        {
          next: response => {
            this.openDialog2("Updated successfully ", "Back to list");  
  
          },
          error: err => {
            alert(`There was an error: ${err.message}`);
          }
        }
      );
      
  }

  openDialog2(message: string, textConfirm: string) {
    const dialogRef = this.dialog.open(DialogRedirectComponent,{
      data:{
        message: message,
        buttonText: {
          ok: textConfirm,
        }
      }
    });
    

    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.route.navigateByUrl('admin/products');
      }else{
        this.addProductFormGroup.reset();

         this.addProductFormGroup.get('category').setValue('Default')
      }
    });

  }


  readUrl(event: any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      reader.onload = (event: any) => {
        this.url = event.target.result;
        console.log(this.url);
      }
      reader.readAsDataURL(event.target.files[0]);
    }
  }


  reset(event: KeyboardEvent){

    event.preventDefault();

    this.addProductFormGroup.reset();

    this.addProductFormGroup.get('category').setValue('Default')

  }

  backClicked() {
    this._location.back();
  }

  enableSubmited(){
    this.submitted = true;
  }

}
