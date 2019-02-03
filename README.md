Representing actual news from the specific country about specific category.

# How to build Server
1. You need to git clone repository.
2. After clone go to created folder
3. Go to /backend and from command line type mvn package (https://spring.io/guides/gs/maven/). 
   It will create target folder.Go to target directory where you can open command line and type java -jar
   {name_of_the_builded_jar}
   
Note: server must be deployed on 127.0.0.1:8080
  
# How to build Angular
1. Go to /frontend/regionalnews and from cmd type 'npm update' then type 'ng serve'.

# REST API:
GET /news/{country}/{category} example /news/us/technology

{<br />
    country: string?, <br />
    category: string?, <br />
    articles: { <br />
    author: string, <br />
    title: string, <br />
    description: string, <br />
    date: string(yyyy-MM-dd), <br />
    sourceName: string, <br />
    articleUrl: string, <br />
    imageUrl: string <br />
 }[] <br />
}
