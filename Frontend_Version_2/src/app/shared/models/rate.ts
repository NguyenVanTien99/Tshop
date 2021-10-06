import { Product } from "./product";
import { User } from "./user";

export class Rate {

    id: number;

	start: number;

	comment: string;

	dateRate: Date;

	product: Product;

    productId: number;

	user: User


	constructor(id:number, star:number, comment:string, product:number, user: User) {
        this.id = id;
        this.start = star;
        this.comment = comment;
        this.productId = product;
        this.user = user;
    }
}
