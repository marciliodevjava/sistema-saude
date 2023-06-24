CREATE USER 'funcionario'@'localhost' IDENTIFIED BY '123456789';
GRANT INSERT, DELETE, SELECT, UPDATE ON sistema_saude.* TO 'funcionario'@'localhost';
