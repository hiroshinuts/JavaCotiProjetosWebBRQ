drop database if exists aula08;
create database aula08;
use aula08;

create table cliente(
	idcliente		integer			auto_increment,
	nome			varchar(50)		not null,
	email			varchar(50)		not null unique,
	sexo			enum('Masculino', 'Feminino') not null,
	estadocivil		enum('Solteiro', 'Casado', 'Divorciado', 'Viuvo') not null,
	primary key(idcliente));
	
desc cliente;