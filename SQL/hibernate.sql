#User hibernate
#Passwd hibernate

CREATE TABLE AUTHOR (
	id INT(11) NOT NULL AUTO_INCREMENT, 
    name VARCHAR(32) NOT NULL, 
    PRIMARY KEY(id)
);

CREATE TABLE BOOK (
	id int(11) not null auto_increment, 
    title varchar(32) not null, 
    author int(11) not null, 
    
    PRIMARY KEY(id),
    foreign key (author) references AUTHOR(id)
);

select * from AUTHOR; 
select * from BOOK; 

select * from AUTHOR left join BOOK on AUTHOR.id = BOOK.author;

# MANY TO MANY
create table ACTOR (
	ACTOR_ID INT AUTO_INCREMENT PRIMARY KEY, 
    NAME VARCHAR(32) NOT NULL
);

create table MOVIE (
	MOVIE_ID INT AUTO_INCREMENT PRIMARY KEY, 
    TITLE VARCHAR(32) NOT NULL
);

# tabla de relación 

create table MOVIE_ACTOR (
	MOVIE_ID INT NOT NULL, 
    ACTOR_ID INT NOT NULL,
    PRIMARY KEY(MOVIE_ID, ACTOR_ID),
    FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(MOVIE_ID),
    FOREIGN KEY (ACTOR_ID) REFERENCES ACTOR(ACTOR_ID)
);


select * from MOVIE_ACTOR;

drop table BOOK; 

# Nueva tabla book para el webservice
create table `BOOK` (
	`isbn` varchar(32) not null primary key,
    `title` varchar(32) not null,
    `author` varchar(32) not null
);


INSERT INTO BOOK() VALUES('1', 'LIBRO1', 'AUTOR1'),('2','LIBRO2', 'AUTOR2');
SELECT * FROM BOOK; 



