import { Cart } from "./cart";
import { Rate } from "./rate";

export class User {

    id: number;
    username: String;
    email: String;

    password: String;

    name: String;

    address: String;

    gender: String;

    phone: String;

    active: boolean;


    //	orders;


    carts: Cart[];


    rates: Rate[];


    dateCreated: Date;

    lastUpdated: Date;
}
