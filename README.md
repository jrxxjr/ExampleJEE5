# Exemplo de aplicação JEE5

1 - Foi criado um projeto Maven do Eclipse padrão JEE 5, é só importar um projeto Maven no Eclipse.

2 - A aplicação primeior tem de ser executada localmente para criar e popular as tabelas, com o persistence-des.xml. 

3 - Deve-se renomear o arquivo persistence-des.xml para persistence.xml.

4 - Deve-se renomear o arquivo persistence.xml para persistence-des.xml.

5 - Deve-se renomear o arquivo persistence-prod.xml para persistence.xml.

6 - Deve-se mapear as api's do Jboss compatível com o padrão JEE 5, no Eclipse para se utilizar da versão do hibernate que está dentro dele, deve-se fazer o download da úlitma versão do driver jdbc do Mysql, e instalá-lo no Jboss.

7 - Deve-se criar no Jboss, um datasource com o nome java:jboss/mysqlds.

8 - Deve-se executar a classe TesteCrud.java.

9 - Verificar se as tabelas da aplicação foram criadas e populadas. 

10 - Compilar a aplicação e fazer o deploy no Jboss.