create database spitter;
use database spitter;

drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id int not null auto_increment primary key,
  username varchar(25) not null,
  password varchar(25) not null,
  fullname varchar(100),
  email varchar(50),
  update_by_email boolean
);

create table spittle (
  id int not null auto_increment primary key,
  spitter_id int not null,
  spittleText varchar(2000) not null,
  postedTime date not null,
  foreign key (spitter_id) references spitter(id)
);



insert into spitter (username, password, fullname, email, update_by_email) values ('habuma', 'password', 'Craig Walls', 'craig@habuma.com', false);
insert into spitter (username, password, fullname, email, update_by_email) values ('artnames', 'password', 'Art Names', 'artnames@habuma.com', false);

insert into spittle (spitter_id, spittleText, postedTime) values (1, 'Have you read Spring in Action 3? I hear it is awesome!', '2010-06-09');
insert into spittle (spitter_id, spittleText, postedTime) values (2, 'Trying out Spring''s new expression language.', '2010-06-11');
insert into spittle (spitter_id, spittleText, postedTime) values (1, 'Who''s going to SpringOne/2GX this year?', '2010-06-19');