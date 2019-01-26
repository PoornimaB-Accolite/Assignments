export class Book {
    id:String;
    name:String;
    author:String;
    price:number;
    description:String;

    constructor(name,id,author,price,description)
    {
        this.id=id;
        this.name=name;
        this.author=author;
        this.price=price;
        this.description=description;
    }
}
