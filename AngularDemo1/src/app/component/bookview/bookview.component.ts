import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';
import {ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bookview',
  templateUrl: './bookview.component.html',
  styleUrls: ['./bookview.component.scss']
})
export class BookviewComponent implements OnInit {
book:any;
id:any;
  constructor( private active : ActivatedRoute,private bookService :BookService) { }

  ngOnInit() {
    this.id = this.active.snapshot.paramMap.get('id');
    this.bookService.getBookById(this.id).subscribe((response)=>{
      console.log(response);

        this.book=response;

    });
  }

}
