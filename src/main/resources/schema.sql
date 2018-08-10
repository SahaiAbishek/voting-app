create table candidate
(
   id integer ,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table Votes
(
   id integer not null auto_increment ,
   user_name varchar(255) not null,
   user_email varchar(255) not null,
   candidate_name varchar(255),
   primary key(id)
);