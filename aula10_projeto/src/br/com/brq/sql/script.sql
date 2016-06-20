drop database if exists aula09;
create database aula09;
use aula09;

create table fornecedor(
	idfornecedor		integer			auto_increment,
	nome				varchar(50)		not null,
	descricao			varchar(250)	not null,
	primary key(idfornecedor));
	
create table produto(
	idproduto			integer			auto_increment,
	nome				varchar(50)		not null,
	preco				double			not null,
	quantidade			integer			not null,
	datacadastro		date			not null,
	idfornecedor		integer			not null,
	primary key(idproduto),
	foreign key(idfornecedor) references fornecedor(idfornecedor));
	
	
--view para obter dados de produtos e fornecedor
create view vwprodutofornecedor
as
	select 
		p.idproduto,
		p.nome as nomeproduto,
		p.preco,
		p.quantidade,
		f.idfornecedor,
		f.nome as nomefornecedor,
		f.descricao
	from produto as p
	inner join fornecedor as f
	on f.idfornecedor = p.idfornecedor;
	
desc vwprodutofornecedor;
	
	
	
	
	
	
	
	
	