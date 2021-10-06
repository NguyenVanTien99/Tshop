import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { ProductCategory } from '../models/product-category';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {

  private baseUrl = 'http://localhost:8080/api/';

  private categoryUrl = 'http://localhost:8080/api/product-category';

  constructor(private httpClient: HttpClient) { }

  getAllProductCategory(): Observable<ProductCategory[]>{

    return this.httpClient.get<ProductCategory[]>(this.categoryUrl)
    
  }

  getAllProductCategoryPaginate(thePage: number, thePageSize: number,): Observable<GetResponseProductsCategory>{
    let url = `${this.categoryUrl}/all?` + `&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseProductsCategory>(url);
  }

  getProductCategoryById(id: number): Observable<ProductCategory>{
    let url = `${this.categoryUrl}/${id}`;
    return this.httpClient.get<ProductCategory>(url);
  }

  getByName(name: string): Observable<ProductCategory>{
    let url = `${this.categoryUrl}/search?` + `&name=${name}`;
    return this.httpClient.get<ProductCategory>(url);
  }

  saveProduct(product: ProductCategory): Observable<any>{
    return this.httpClient.post<ProductCategory>(this.categoryUrl, product).pipe(catchError(this.handleError));
  }

  // updateProduct(product: Product, id: number): Observable<any>{
  //   let url = `${this.productUrl}/${id}`;
  //   return this.httpClient.put<Product>(url, product).pipe(catchError(this.handleError));
  // }


  deleteProduct(id: number){
    let url = `${this.categoryUrl}/${id}`;
    return this.httpClient.delete(url).pipe(catchError(this.handleError));
  }
  
  handleError(err){
    return throwError(err.message || 'serve error')
  }

}


interface GetResponseProductsCategory {
  content: ProductCategory[],

  totalElements: number,
  totalPages: number,
  size: number,
  number: number

}

