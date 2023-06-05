CREATE TABLE auxilio_alimentacao
(
    id                   bigint(10)     not null AUTO_INCREMENT,
    identificador_auxilio_alimentacao varchar(36)    not null,
    dias integer(10)    not null,
    valor DECIMAL(10,2)    not null,
    id_salario BIGINT(10),

    PRIMARY KEY (id),
    FOREIGN KEY (id_salario) references salarios(id)
);