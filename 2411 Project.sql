DROP TABLE  userinf;
DROP TABLE orderinf;
DROP TABLE object;
DROP TABLE receiver;
DROP TABLE place;
create table userinf
(
    user_id number(6) primary key ,
    phone_number number(13) not null,
    password varchar(15) not null,
    u_name varchar(15),
    place_id number(6)
);

create table orderinf
(
    user_id number(6) not null ,
    r_phone number(13) not null ,
    order_id number(8) primary key ,
    number_of_object number(5) not null ,
    total_weight number(*,2) not null ,
    price number(*,2) not null
);

create table object
(
    order_id number(8) ,
    name varchar(30),
    size_ number(*,2) not null,
    weight number(*,2) not null
);

create table receiver
(
    order_id number(8) not null ,
    phone_number number(13) primary key ,
    r_name varchar(15) not null,
    place_id number(6)
);

create table place
(
    place_id number(6) primary key ,
    place_name varchar(15) not null,
    x number(*,2) not null ,
    y number(*,2) not null
);

INSERT INTO place values(1,'1 place',10,10);
INSERT INTO place values(2,'2 place',60,90);
INSERT INTO userinf values(1,13510719357,'1 de pasw','xiongyifan',1);
INSERT INTO userinf values(2,15626595226,'2 de pasw','zhuguanyu',2);
INSERT INTO orderinf values(1,15626595226,1,2,5.00,150);
INSERT INTO orderinf values(1,15626595226,2,1,1.26,1000);
INSERT INTO object values(1,'mangguo',3.00,2.20);
INSERT INTO object values(1,'xigua',4.00,2.80);
INSERT INTO object values(2,'huolongguo',3.00,1.26);
INSERT INTO receiver values(1,15626595226,'zhuguanyu',2);

/*
 find the user name and the receiver name in one order
 */
select u_name , r_name from userinf,receiver
    where userinf.user_id=(select user_id from orderinf
where order_id=1)
AND receiver.phone_number=(select r_phone from orderinf
where order_id=1);

/*
 list all the objects and its weight in one order
 */
select name,weight from object
where order_id=1;

/*
 figure out the sending place and the receive place(user to receiver)
 */
select p1.place_name, p2.place_name from place p1,place p2
where p1.place_id=(select place_id from userinf where userinf.user_id=(select user_id from orderinf where order_id=1))
and p2.place_id=(select place_id from receiver where receiver.phone_number=(select r_phone from orderinf where order_id=1))
and p1.place_id!=p2.place_id;