# Assignment1
## Create an angular app
Create 3 components(home,about,contact,header,footer)
Create navigation for 3 pages from header component
### My Angular Components in the header
```js
<nav>
  <ul>
    <li><a routerLink="/home">Home</a></li>
    <li><a routerLink="/about">About</a></li>
    <li><a routerLink="/contact">Contact</a></li>
  </ul>
</nav>
```

## Create and spring boot app
Create 4 rest api for curd operations(create ,read, update ,delete)
### My test paths
use JSON format to post or update dates
```text
GET/words

GET/words/{id}

GET/words/search?word=&frequency=&mastered=
eg:
localhost:8080/words/search?word=affront
localhost:8080/words/search?frequency=1
localhost:8080/words/search?word=affront&frequency=1

POST/words

PUT/words/{id}

DELETE/words/{id}
```
# words
This is a newborn template about angular and spring boot applications.
## Features will be added

Connect front-end to back-end

Handle wrong inputs

Handle user authentication

# Test cases
## FrontEnd
### Correct paths
localhost:4200/home

localhost:4200/about

localhost:4200/contact

### Wrong path
localhost:4200/homedd redirect to localhost:4200/home

## BackEnd
replace correct passwords and databse, in my case:

spring.datasource.url=jdbc:mysql://localhost:3306/glintAssignment1

spring.datasource.username=root

spring.datasource.password=mysql

### SQL
data.sql: Inital dabase 

INSERT INTO WORDS(WORD, INTERPRETATION, FREQUENCY, MASTERED) VALUES('demanding', 'needing a lot of ability, effort, or skill', 1, true);

INSERT INTO WORDS(WORD, INTERPRETATION, FREQUENCY, MASTERED) VALUES('treacherous', 'someone who is treacherous cannot be trusted because they are not loyal and secretly intend to harm you', 0, false);

### CRUD
GET/words

GET/words/{id}

GET/words/search

POST/words

PUT/words/{id}

DELET/words/{id}

### DATA FORMAT
@Column(name = "WORD")
private String word;

@Column(name = "INTERPRETATION")
private String interpretation;

@Column(name = "FREQUENCY")
private Integer frequency;

@Column(name = "MASTERED")
private boolean mastered;
