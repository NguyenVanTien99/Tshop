import { ProductCategory } from "./product-category";
import { Rate } from "./rate";

export class Product {
    id: number
    sku: string;
    name: string;
    description: string;
    unitPrice: number;
    imageUrl: string;
    imageStore: string;
    active: boolean;
    unitInStock: number;
    dateCreated: Date;
    lastUpdate: Date;
    category : ProductCategory
    rates: Rate[]

}
