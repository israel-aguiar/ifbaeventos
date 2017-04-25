-- -----------------------------------------------------
-- Table ORGANIZADOR
-- -----------------------------------------------------
CREATE TABLE ORGANIZADOR (
  id BIGINT NOT NULL,
  nome VARCHAR(100),
  data_criacao TIMESTAMP,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table EVENTO
-- -----------------------------------------------------
CREATE TABLE EVENTO (
  id BIGINT NOT NULL,
  nome VARCHAR(100),
  descricao VARCHAR(255),
  ativo BOOLEAN,
  ORGANIZADOR_id BIGINT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table PESSOA
-- -----------------------------------------------------
CREATE TABLE PESSOA (
  id BIGINT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cpf CHAR(11) NOT NULL,
  email VARCHAR(100) NULL,
  senha VARCHAR(8) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table TIPO_ATIVIDADE
-- -----------------------------------------------------
CREATE TABLE TIPO_ATIVIDADE (
  id BIGINT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(255) NULL,
  codigo VARCHAR(10) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table MINISTRANTE
-- -----------------------------------------------------
CREATE TABLE MINISTRANTE (
  id BIGINT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefone VARCHAR(15) NULL,
  formacao VARCHAR(50) NULL,
  cpf CHAR(11) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table ATIVIDADE
-- -----------------------------------------------------
CREATE TABLE ATIVIDADE (
  id BIGINT NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  codigo VARCHAR(10) NOT NULL,
  area_atividade VARCHAR(30),
  requisito_atividade TEXT NULL,
  ch INT(11) NULL,
  vagas_total INT(11) NULL,
  vagas_disponiveis INT(11) NULL,
  data DATE NULL,
  turno VARCHAR(10) NULL,
  descricao TEXT NULL,
  TIPO_ATIVIDADE_id BIGINT NOT NULL,
  EVENTO_id BIGINT NOT NULL,
  MINISTRANTE_id BIGINT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table MATRICULA
-- -----------------------------------------------------
CREATE TABLE MATRICULA (
  id BIGINT NOT NULL,
  data_criacao TIMESTAMP NULL,
  efetivado BOOLEAN NULL,
  observacao TEXT NULL,
  PESSOA_id BIGINT NOT NULL,
  ATIVIDADE_id BIGINT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table USUARIO
-- -----------------------------------------------------
CREATE TABLE USUARIO (
  id BIGINT NOT NULL,
  nome_completo VARCHAR(100) NOT NULL,
  username VARCHAR(20) NOT NULL,
  passoword VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table HORARIO
-- -----------------------------------------------------
CREATE TABLE HORARIO (
  id BIGINT NOT NULL,
  data DATE NOT NULL,
  hora_inicio TIMESTAMP NULL,
  hora_fim TIMESTAMP NULL,
  ATIVIDADE_id BIGINT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table FREQUENCIA
-- -----------------------------------------------------
CREATE TABLE FREQUENCIA (
  id BIGINT NOT NULL,
  presente BOOLEAN NULL,
  MATRICULA_id BIGINT NOT NULL,
  HORARIO_id BIGINT NOT NULL,
  PRIMARY KEY (id))
;
