create database dbsisfuncionario;
use dbsisfuncionario;

create table setor(
	id int primary key not null auto_increment,
	descricao varchar(30)

);

create table funcionario(
	id bigint auto_increment not null,
	nome varchar(255),
	profissao varchar(255),
	idSetor int,
	primary key (id),
	foreign key (idSetor) references setor (id)
);

create table cliente(
	id int primary key auto_increment,
    	nome varchar(40),
    	endereco varchar(100),
    	pass varchar(20),
    	login varchar(20)
);

insert cliente(nome, endereco, login, pass)values ("sergio","RJ - BR","sergio@gmail.com","123456");
