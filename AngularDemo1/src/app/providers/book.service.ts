import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from, Observable } from 'rxjs';
import { Cart } from '../model/cart';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http:HttpClient) { }

  getAllBooks() : Observable<any>
  {
    return this.http.get('/JustBooks/books');
  }
  getBookById(id :any) :Observable<any>
  {
    return this.http.get('JustBooks/books/get/'+ id);
  }
  addBook(book: any): Observable<any>{
    return this.http.post('JustBooks/booksinsert',book);
  }
  addBookToCart(bookcart :any): Observable<any>
  {
    return this.http.post('JustBooks/addtocart',bookcart);
  }
 getCartItems():Observable<any>
 {
   return this.http.get('/JustBooks/cartbooks');
 }

}
