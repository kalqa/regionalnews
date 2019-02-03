import {Component, OnInit} from '@angular/core';
import {DataService} from "../service/data.service";
import {News} from "../model/article.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  news$: News;

  constructor(private dataService: DataService) {

  }

  ngOnInit() {
    return this.dataService.getArticles().subscribe(data => this.news$ = data)
  }
}
