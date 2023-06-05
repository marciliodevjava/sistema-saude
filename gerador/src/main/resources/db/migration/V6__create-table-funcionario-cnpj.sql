CREATE TABLE funcionarios_cnpj
(
    id bigint(10) not null AUTO_INCREMENT,
    identificador_funcionario_cnpj varchar(36) not null,
    funcao_funcionario varchar(25) not null,
    estado_civil varchar(10) not null,
    nome varchar(150) not null,
    data_nascimento date not null,
    cpf varchar(11) not null,
    cnpj varchar(14) not null,
    rg varchar(10) not null,
    ddd varchar(9) not null,
    telefone varchar(9) not null,
    email varchar(150) not null,
    data_admissao date not null,
    hora_inicial time not null,
    hora_final time not null,
    ativo bit(1) not null,
    id_funcionario bigint(10),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) references funcionarios(id)
);