import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';
import { Cart } from 'src/app/model/cart';
import { Book } from 'src/app/model/book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
book:any;
  constructor( private bookService :BookService) { }

  ngOnInit() {

     this.bookService.getAllBooks().subscribe((response)=>{
      if(response &&response.length>0){
        this.book=response;
     }
    });
  }
CartBook :Cart;
name:any;
id:any;
author:any;
price:any;
description:any;

 /* AddToCartData(book:Book){
  
   // this.CartBook =new Cart(book.name,book.id,book.author,book.price,book.description);
   this.bookService.addBookToCart(this.CartBook).subscribe((response)=>{
     console.log(response);
   });
  
  }*/
cart:any;
  PostDataCart()
  {
    this.cart=new Cart(this.id);
    this.bookService.addBookToCart(this.cart).subscribe((response)=>{
      console.log(response);
    });
  }

/*checkOut(id : any){

    this.bookService.addBookToCart(new Cart(id)).subscribe();

  }*/
}
