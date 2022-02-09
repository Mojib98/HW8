CREATE TABLE IF NOT EXISTS userstore
(
    Id         serial,
    IdUser     integer,
    fullName   varchar(50),
    nationalId char(5),
    password   integer,
    kind       varchar(8),
    address    varchar(50),
    budget     float
);
CREATE TABLE IF NOT EXISTS Product(
    id serial,
    idProduct integer unique ,
    adminId integer,
    categoryId integer references category(barndid)  ,
    nameProduct varchar(20) unique ,
    numberProduct integer,
    price float
);
CREATE TABLE IF NOT EXISTS customerBasket(
    id serial,
    customerId integer ,
    productId integer ,
    numberProduct integer ,
    price float,
    name varchar(20)
);
CREATE TABLE IF NOT EXISTS saleProduct(
    id serial,
    customerId integer,
    productId integer,
    numberProduct integer,
    price float,
    datesell date
);
create table if not exists category(
    id serial,
    barndid integer primary key ,
    name varchar(20) unique
);
delete from userstore;
delete from customerBasket;
delete from product;
delete from saleproduct;