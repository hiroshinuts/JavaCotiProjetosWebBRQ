drop database if exists aula22;
create database aula22;
use aula22;

create table cliente(
	idcliente		integer			auto_increment,
	nome			varchar(50)		not null,
	email			varchar(50)		not null,
	primary key(idcliente));
	
desc cliente;