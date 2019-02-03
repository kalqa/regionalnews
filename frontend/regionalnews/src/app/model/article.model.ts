export class News {
  country: string;
  category: string;
  articles: {
    author: string;
    title: string;
    description: string;
    date: string;
    sourceName: string;
    articleUrl: string;
    imageUrl: string;
  }[];

}
