CREATE TABLE numeros(
    id bigint not null AUTO_INCREMENT,
    id_funcionario bigint,
    identificador_numero bigint,
    matricula bigint not null,
    data DATETIME not null,
    ativo bit,

    PRIMARY KEY (id)
);