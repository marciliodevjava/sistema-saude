CREATE TABLE formulario_paciente
(
    id bigint(10) not null AUTO_INCREMENT,
    id_formulario varchar(36)    not null,
    data DATE not null,
    hora TIME not null,
    PRIMARY KEY (id)
);