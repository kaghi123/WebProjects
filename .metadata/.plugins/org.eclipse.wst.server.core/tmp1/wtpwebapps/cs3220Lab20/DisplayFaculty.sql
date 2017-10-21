drop table if exists department;
drop table if exists faculty;

create table department (
    name    varchar(255)
);

create table faculty (
    name    varchar(255),
    isChair boolean
);