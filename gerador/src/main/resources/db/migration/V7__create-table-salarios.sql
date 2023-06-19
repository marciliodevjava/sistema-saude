CREATE TABLE salarios
(
    id                   bigint(10)     not null AUTO_INCREMENT,
    identificador_salario varchar(36)    not null,
    salario              DECIMAL(10, 2) not null,
    valor_alimentacao DECIMAL(10, 2) not null,
    transporte           DECIMAL(10, 2) not null,
    id_funcionario_clt bigint(10),
    id_funcionario_cnpj bigint(10),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario_clt) references funcionarios_clt(id),
    FOREIGN KEY (id_funcionario_cnpj) references funcionarios_cnpj(id)
);