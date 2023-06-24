CREATE USER IF NOT EXISTS 'funcionario'@'localhost' IDENTIFIED BY '123456789';
GRANT INSERT, DELETE, SELECT, UPDATE ON sistema_saude.* TO 'funcionario'@'localhost';

CREATE USER IF NOT EXISTS 'gerador-user'@'localhost' IDENTIFIED BY '123456789';
GRANT INSERT, DELETE, SELECT, UPDATE, CREATE, DROP, ALTER, GRANT OPTION ON sistema_saude.* TO 'gerador-user'@'localhost';

CREATE USER IF NOT EXISTS 'exame'@'localhost' IDENTIFIED BY '123456789';
GRANT INSERT, DELETE, SELECT, UPDATE ON sistema_saude.* TO 'exame'@'localhost';

CREATE USER IF NOT EXISTS 'governancia-user'@'localhost' IDENTIFIED BY '123456789';
GRANT INSERT, DELETE, SELECT, UPDATE ON sistema_saude.* TO 'governancia-user'@'localhost';