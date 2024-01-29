create table cep(

    id bigint not null auto_increment,
    cep  varchar(8) not null unique,
    logradouro varchar(100) not null,
    complemento varchar(100) not null,
    bairro varchar(100) not null,
    localidade varchar(100) not null,
    uf varchar(2) not null,
    ibge varchar(7) not null,
    gia varchar(4) not null,
    ddd varchar (2) not null,
    siafi varchar (4) not null,

    primary key(id)
);