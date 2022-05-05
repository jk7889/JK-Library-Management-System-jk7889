create database library;
use library;

-- This library not only rents but also sells books
-- Creating sys_admin table which contains admin_login information 
-- Sys_admin can access JK library Management System via Administrator Login and can add users
-- Only the useres added by the sys_admin can acess the software
create table sys_admin(
id int not null auto_increment,
username varchar(50) not null,
email varchar(50) not null,
password varchar(50) not null,
primary key(id)
);

alter table sys_admin auto_increment=137691;

insert into sys_admin(username, email, password) values("root136", "root136@jklib.ca", "password");

select * from sys_admin;
select id, password from sys_admin where id = '137691' and password = 'password';
-- drop table sys_admin;
 
 -- Creating system_users table which contains user_login information 
 -- Only sys_admin can add users to this table and only the users added to this table can access jk library management system via User Login
create table system_users(
id int not null auto_increment,
username varchar(50) not null,
library_name varchar(50) not null,
email varchar(50) not null,
password varchar(50) not null,
primary key(id)
);

alter table system_users auto_increment=137168;
insert into system_users values(137168,	'mitch jones', 'willow creek regional library',	'mjones@wcrlib.co.uk', 'mitch');
insert into system_users values(137169,	'marcy peterson', 'hope community library',	'marcy217@hopelib.ca', 'marcy');
insert into system_users values(137170,	'natasha kapoor', 'chandigarh regional library', 'nkapoor97@chdlib.in', 'natasha');
insert into system_users values(137171,	'vikram nanda', 'mumbai state library', 'vicky47@mslib.in', 'vikram');
select * from system_users;
-- drop table system_users;

-- Creating table record which contains library records information
create table record(
s_no int not null auto_increment,
customer_id int not null,
name varchar(100) not null,
type varchar(10) not null default 'Rent',
charge int not null default '10',
book_name varchar(500) not null,
date_of_issue datetime not null default (CURRENT_DATE),
date_of_return datetime null default (DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)), 
primary key(s_no)
);

select * from record;
-- select date_of_issue from record where s_no in (select s_no order by s_no desc) limit 5;  
select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue ,date(date_of_return) as date_of_return from record;
show index from record;
-- drop table record;
 
SELECT CURRENT_DATE, DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY);
SELECT DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY);

-- Creating table customer_info which contains library customers information
create table customer_info(
id int not null auto_increment,
name character(50) not null unique,
address varchar(100) default '-',
city character(20) not null default'-',
phone_number decimal(10,0) not null default '0',
primary key(id)
);

select * from customer_info;
-- drop table customer_info

-- Creating table books which contains information regarding books available in the library
create table books(
id int not null auto_increment,
title character(1000) not null,
author varchar(1000) not null,
publisher character(100) not null default '-',
publishing_year int not null,
pages int not null,
primary key(id) 
);

insert into books(title, author, publisher, publishing_year, pages) values ("Python Developer's Handbook", "Andre Lessa", "Sams", "2001", 1481);
select * from books;
-- drop table books;


-- Views
create view number_of_books_rented_bought_each_customer as select customer_id, name, count(book_name) as number_of_books from record group by name order by count(book_name) desc, name asc;

create view number_of_books_rented_each_customer as select customer_id, name, count(book_name) as number_of_books from record where type = "Rent" group by name order by count(book_name) desc, name asc;

create view number_of_books_bought_each_customer as select customer_id, name, count(book_name) as number_of_books from record where type = "Purchase" group by name order by count(book_name) desc, name asc;

create view number_of_books_by_each_author as select author, count(title) as number_of_books from books group by author order by count(title) desc, author asc;

/*
drop view number_of_books_rented_bought_each_customer;
drop view number_of_books_rented_each_customer;
drop view number_of_books_bought_each_customer;
drop view number_of_books_by_each_author;
 */
