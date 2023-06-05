CREATE TABLE funcionarios
(
    id    bigint(16)      not null auto_increment,
    identificador_funcionario varchar(36) not null,
    numero_funcionario integer(20) not null,
    estado_funcionario varchar(15) not null,

    primary key (id)
);