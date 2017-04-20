# ifbaeventos
Sistema para gerenciamentos de cursos oferecidos em enventos do IFBA - Brumado


## Tecnologias utilizadas

* Tecnologias Web

	Java 1.8
	Servlet 3.1
	Java Server Faces 2.1
	JPA 2.1
	Apache Tomcat 8.x	

* Banco de dados

	MySQL 5.7.17
	
* IDE para desenvolvimento

	Eclipse Java EE IDE for Web Developers.
	Version: Neon Release (4.6.0)


## Instruções para desenvolvimento

### Configurar banco de dados

1. Acessar mysql através do shell

	mysql -u root -p mysql

2. Criar banco de dados

	create database ifbabru_ifbaeventos;

3. Criar usuário para o banco de dados

	 grant all privileges on ifbabru_ifbaeventos.* to ifba@'%' identified by '123';