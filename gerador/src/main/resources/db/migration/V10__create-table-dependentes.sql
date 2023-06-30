CREATE TABLE depedentes
(
    id                       bigint(10)   not null AUTO_INCREMENT,
    identificador_dependente varchar(36)  not null,
    nome                     varchar(150) not null,
    cpf                      varchar(11)  not null,
    rg                       varchar(10)  not null,
    data_nascimento          DATE         not null,
    grau_parentesco          varchar(10)  not null,
    id_funcionario_clt       BIGINT(10),
    id_funcionario_cnpj      BIGINT(10),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario_clt) references funcionarios_clt (id),
    FOREIGN KEY (id_funcionario_cnpj) references funcionarios_cnpj (id)
);