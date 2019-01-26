import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  list : [];
  constructor(private bookservice : BookService) { }
  ngOnInit() {

    this.bookservice.getCartItems().subscribe((response)=>{
       if(response && response.length > 0){
         this.list = response;
       }
    });
  }

}
