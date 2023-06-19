CREATE TABLE uuid(
                        id bigint not null AUTO_INCREMENT,
                        uuid_gerado varchar(36) not null ,
                        projeto varchar(20),
                        data DATE not null,
                        hora TIME not null,

                        PRIMARY KEY (id)
);