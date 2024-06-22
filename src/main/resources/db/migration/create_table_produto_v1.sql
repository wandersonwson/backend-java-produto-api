create schema if not exists produtos;

create table produtos.categoria (
    id bigserial primary key,
    nome varchar(100) not null
);

create table produtos.produto (
    id bigserial primary key,
    produto_id varchar(100) not null,
    nome varchar(100) not null,
    descricao varchar(100) not null,
    preco float not null,
    categoria_id bigint references produtos.categoria(id)
);

insert into produtos.categoria(id, nome) values(1, 'Eletrônico');
insert into produtos.categoria(id, nome) values(2, 'Móveis');
insert into produtos.categoria(id, nome) values(3, 'Brinquedos');