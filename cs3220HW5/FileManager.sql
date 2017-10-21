drop table if exists account;
drop table if exists file1;

create table account (
    name    	varchar(255),
    password	varchar(255),
	accId		integer
);

create table file1 (
    id			integer,
	name		varchar(255),
	type		varchar(255),
	size		integer,
	date		varchar(255),
	parentId	integer,
	isFolder	boolean,
	accId		integer
);