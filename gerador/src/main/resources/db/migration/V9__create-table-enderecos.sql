CREATE TABLE enderecos
(
    id                   bigint(10)     not null AUTO_INCREMENT,
    identificador_endereco varchar(36)    not null,
    cep varchar(9)    not null,
    logradouro varchar(50)    not null,
    numero varchar(10)    not null,
    bairro varchar(50)    not null,
    cidade varchar(50)    not null,
    uf varchar(32)    not null,
    ativo bit(1)    not null,
    id_funcionarioClt BIGINT(10),
    id_funcionarioCnpj BIGINT(10),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionarioClt) references funcionarios_clt(id),
    FOREIGN KEY (id_funcionarioCnpj) references funcionarios_cnpj(id)
);