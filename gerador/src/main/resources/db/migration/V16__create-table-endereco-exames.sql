CREATE TABLE enderecos_exames
(
    id          bigint(10)  not null AUTO_INCREMENT,
    id_endereco varchar(36) not null,
    cep         varchar(9)  not null,
    endereco    varchar(50) not null,
    numero      varchar(10) not null,
    bairro      varchar(50) not null,
    cidade      varchar(50) not null,
    uf          varchar(32) not null,
    complemento varchar(32) not null,
    ativo       bit(1)      not null,
    id_paciente BIGINT(10),
    id_medico   BIGINT(10),

    PRIMARY KEY (id),
    FOREIGN KEY (id_paciente) references pacientes (id),
    FOREIGN KEY (id_medico) references medicos (id)
);