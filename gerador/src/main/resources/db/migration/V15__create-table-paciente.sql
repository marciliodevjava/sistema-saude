CREATE TABLE pacientes
(
    id              bigint(20)   not null AUTO_INCREMENT,
    id_paciente     varchar(36)  not null,
    nome            varchar(150) not null,
    rg              varchar(150) not null,
    cpf             varchar(150) not null,
    email           varchar(150) not null,
    data_nascimento DATE         not null,
    ativo           BIT          not null,
    id_formulario   bigint(20),
    PRIMARY KEY (id),
    FOREIGN KEY (id_formulario) references formulario_paciente (id)
);