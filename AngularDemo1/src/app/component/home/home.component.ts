import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';
import { Book } from 'src/app/model/book';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

//books:any=[];

name:String;
id:String;
author:String;
price:number;
description:String;


book :Book ;
  constructor( private bookService : BookService) { }
  ngOnInit() {
    this.bookService.getAllBooks().subscribe((response)=>{
      if(response&&response.length>0){
        this.book=response;
     }
    });
   
  }

    //let book = new Book(this.name,this.id,this.author,this.price,this.desc);

    postData(){
       this.book=new Book(this.name,this.id,this.author,this.price,this.description);
      this.bookService.addBook(this.book).subscribe((response)=>{
        console.log(response);
      });
  
  }

}
