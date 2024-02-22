
Portuguese:
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
________________________________________________________________________________________________________________________________

English:
# JEE5 Application Example

1 - A JEE 5 standard Eclipse Maven project was created, just import a Maven project into Eclipse.

2 - The first application must be run locally to create and populate the tables, with persistence-des.xml.

3 - You must rename the persistence-des.xml file to persistence.xml.

4 - You must rename the persistence.xml file to persistence-des.xml.

5 - You must rename the persistence-prod.xml file to persistence.xml.

6 - You must map the Jboss api's compatible with the JEE 5 standard, in Eclipse to use the version of Hibernate that is inside it, you must download the latest version of the Mysql jdbc driver, and install it on Jboss.

7 - A datasource must be created in Jboss with the name java:jboss/mysqlds.

8 - The TesteCrud.java class must be executed.

9 - Check whether the application tables were created and populated.

10 - Compile the application and deploy it to Jboss.
