# Exemplo de aplica��o JEE5

1 - Foi criado um projeto Maven do Eclipse padr�o JEE 5, � s� importar um projeto Maven no Eclipse.

2 - A aplica��o primeior tem de ser executada localmente para criar e popular as tabelas, com o persistence-des.xml. 

3 - Deve-se renomear o arquivo persistence-des.xml para persistence.xml.

4 - Deve-se renomear o arquivo persistence.xml para persistence-des.xml.

5 - Deve-se renomear o arquivo persistence-prod.xml para persistence.xml.

6 - Deve-se mapear as api's do Jboss compat�vel com o padr�o JEE 5, no Eclipse para se utilizar da vers�o do hibernate que est� dentro dele, deve-se fazer o download da �litma vers�o do driver jdbc do Mysql, e instal�-lo no Jboss.

7 - Deve-se criar no Jboss, um datasource com o nome java:jboss/mysqlds.

8 - Deve-se executar a classe TesteCrud.java.

9 - Verificar se as tabelas da aplica��o foram criadas e populadas. 

10 - Compilar a aplica��o e fazer o deploy no Jboss.