----------- User Schema
create table users(
	username NVARCHAR2(64) not null primary key,
	password NVARCHAR2(256) not null,
	enabled number(1,0) not null check(enabled in (0,1))
);

--drop table users;

create table authorities (
    
	username NVARCHAR2(64) not null,
	authority NVARCHAR2(128) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

--drop table authorities;

-------- Group Authorities

create table groups (
	id number(38)  primary key,
	group_name NVARCHAR2(64) not null
);

--drop table groups;

create sequence groups_sequence start with 1 INCREMENT by 1 NOMAXVALUE;

--drop sequence groups_sequence;
---

create table group_authorities (
	group_id number(38) not null,
	authority NVARCHAR2(64) not null,
	constraint fk_group_authorities_group foreign key(group_id) references groups(id)
);

--drop table group_authorities;

---

create table group_members (
	id number(38)  primary key,
	username varchar(64) not null,
	group_id number(38) not null,
	constraint fk_group_members_group foreign key(group_id) references groups(id)
);

--drop table group_members;

create sequence group_members_sequence start with 1 INCREMENT by 1 NOMAXVALUE;
--drop sequence group_members_sequence;

------------- Persistent Login (Remember-Me) Schema

create table persistent_logins (
	username varchar(64) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
);

--drop table persistent_logins;