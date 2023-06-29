CREATE TABLE funcionarios
(
    id    bigint(16)      not null auto_increment,
    identificador_funcionario varchar(36) not null,
    numero_funcionario integer(20) not null,
    estado_funcionario varchar(15) not null,
    in_principal_funcionario_clt BOOLEAN not null ,
    in_principal_funcionario_cnpj BOOLEAN not null,

    primary key (id)
);