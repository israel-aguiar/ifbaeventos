ALTER TABLE ATIVIDADE MODIFY turno VARCHAR(11);

ALTER TABLE FREQUENCIA DROP COLUMN id;
ALTER TABLE FREQUENCIA ADD PRIMARY KEY (horario_id, matricula_id);


ALTER TABLE EVENTO MODIFY descricao TEXT;
ALTER TABLE EVENTO ADD COLUMN ch INTEGER;
ALTER TABLE EVENTO ADD COLUMN data_inicio DATE;
ALTER TABLE EVENTO ADD COLUMN data_fim DATE;

ALTER TABLE MATRICULA CHANGE data_criacao data_matricula TIMESTAMP;
ALTER TABLE MATRICULA ADD COLUMN certificado CHAR(1);
ALTER TABLE MATRICULA ADD COLUMN certificado_emissao TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE MATRICULA ALTER COLUMN certificado_emissao DROP DEFAULT;

ALTER TABLE PESSOA RENAME TO PARTICIPANTE;
