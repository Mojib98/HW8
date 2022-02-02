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
    adminId integer,
    categoryId integer,
    nameProduct varchar(20),
    numberProduct integer,
    price float
);

