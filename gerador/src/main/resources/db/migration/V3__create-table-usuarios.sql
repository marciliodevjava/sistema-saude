CREATE TABLE usuarios(
    id    bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(100) not null,
    data DATE,
    hora TIME,
    primary key (id)
);