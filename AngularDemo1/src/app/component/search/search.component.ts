import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
book:any;
id :any;
  constructor(private bookService :BookService) { }

  ngOnInit() { }
  searchBookById(){

    this.bookService.getBookById(this.id).subscribe((response)=>{
      console.log(response);
        this.book=response;
    });

  }
  

}
