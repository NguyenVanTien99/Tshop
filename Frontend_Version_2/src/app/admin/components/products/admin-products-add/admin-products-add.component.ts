import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Product } from 'src/app/shared/models/product';
import { ProductCategory } from 'src/app/shared/models/product-category';
import { ProductCategoryService } from 'src/app/shared/services/product-category.service';
import { ProductService } from 'src/app/shared/services/product.service';
import { FormValidator } from 'src/app/admin/validator/form-validator';
import { DialogComponent } from 'src/app/shared/components/dialog/dialog.component';
import { Location } from '@angular/common';

@Component({ 
  selector: 'app-admin-products-add',
  templateUrl: './admin-products-add.component.html',
  styleUrls: ['./admin-products-add.component.css']
})
export class AdminProductsAddComponent implements OnInit {

  @ViewChild("myinputFirst") myinputFirst: ElementRef;

  @ViewChild("myinputLast") myinputLast: ElementRef;

  submitted = false;

  addProductFormGroup: FormGroup;

  productCategory: ProductCategory[] = [];

  url: string = "";

  constructor(private renderer: Renderer2,private formBuilder: FormBuilder, private productCategoryService: ProductCategoryService,public dialog: MatDialog, private route: Router,
              private productService: ProductService, private _location: Location ) { }

  ngOnInit(): void {

    this.addProductFormGroup = this.formBuilder.group(
      {
        sku: new FormControl('', [Validators.pattern('([A-Za-z]+-)+[0-9]+'), FormValidator.notOnlyWhitespace, Validators.maxLength(255)]),
        name: new FormControl('', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace, Validators.maxLength(255)] ),
        description: new FormControl('', [Validators.maxLength(255)]),
        unitPrice: new FormControl('', [Validators.required, Validators.min(0)]),
        active: new FormControl(true), 
        unitInStock: new FormControl('', [Validators.required, Validators.min(0)]),
        category: new FormControl('', FormValidator.DefaultOption),
      },
    )

  this.addProductFormGroup.get('category').setValue('Default')

  this.productCategoryService.getAllProductCategory().subscribe(
    data => {
      this.productCategory = data;
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


  ngAfterViewInit() {
    this.myinputFirst.nativeElement.focus();
    // this.renderer.removeClass( this.myinputFirst, 'ng-invalid');
  }

  get sku() { return this.addProductFormGroup.get('sku'); }
  get name() { return this.addProductFormGroup.get('name'); }
  get description() { return this.addProductFormGroup.get('description'); }
  get active() { return this.addProductFormGroup.get('active'); }
  get unitPrice() { return this.addProductFormGroup.get('unitPrice'); }
  get unitInStock() { return this.addProductFormGroup.get('unitInStock'); }
  get category() { return this.addProductFormGroup.get('category'); }
  get form() { return this.addProductFormGroup.controls; }

  
    
  onSubmit() {

    this.submitted = true;

    console.log("Handle Form Submit");

    if (this.addProductFormGroup.invalid) {

      this.addProductFormGroup.markAllAsTouched();
    
      return;
    }

    console.log(this.addProductFormGroup.value)
 
    this.openDialog1("Do you want to add product?", "Yes", "No");
    
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

      console.log("asd-345",product);
      
      

      this.productService.saveProduct(product).subscribe(
        {
          next: response => {
            this.openDialog("Added successfully", "Back to list", "Continue");  
  
          },
          error: err => {
            alert(`There was an error: ${err.message}`);
          }
        }
      );
      
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
  

  openDialog(message: string, textConfirm: string, textCancel: string) {
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
        //this.route.navigateByUrl('admin/products');

        this.route.navigate(['admin/products'], { queryParams: { new: 1 } });
      }else{

        this.submitted = false

        this.addProductFormGroup.reset();

         this.addProductFormGroup.get('category').setValue('Default')
      }
    });

  }


  reset(event: KeyboardEvent){

    event.preventDefault();

    this.addProductFormGroup.reset();

    this.addProductFormGroup.get('category').setValue('Default')

  }


  enableSubmited(){
    this.submitted = true;
  }


  backClicked() {
    this._location.back();
  }

}
