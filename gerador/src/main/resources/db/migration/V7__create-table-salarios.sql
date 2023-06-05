CREATE TABLE salarios
(
    id                   bigint(10)     not null AUTO_INCREMENT,
    identificador_salario varchar(36)    not null,
    salario              DECIMAL(10, 2) not null,
    valor_alimentacao DECIMAL(10, 2) not null,
    transporte           DECIMAL(10, 2) not null,
    id_funcionarioClt BIGINT(10),
    id_funcionarioCnpj BIGINT(10),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionarioClt) references funcionarios_clt (id),
    FOREIGN KEY (id_funcionarioCnpj) references funcionarios_cnpj (id)
);