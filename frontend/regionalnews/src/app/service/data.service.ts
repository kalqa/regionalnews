import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {News} from "../model/article.model";

@Injectable({providedIn: 'root'})

export class DataService {

  apiUrl = 'http://127.0.0.1:8080/news/pl/technology';

  constructor(private _http: HttpClient) {
  }

  getArticles() {
    // @ts-ignore
    return this._http.get(<News>(this.apiUrl))
  }

}
