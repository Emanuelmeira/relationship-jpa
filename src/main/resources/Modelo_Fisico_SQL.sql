CREATE TABLE IF NOT EXISTS DEPARTAMENTO (
   cod_departamento SERIAL PRIMARY KEY,
	nome_departamento VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS CURSO (
    cod_curso SERIAL PRIMARY KEY,
	nome_curso VARCHAR(30) NOT NULL,
	cod_departamento INT NOT NULL,
	CONSTRAINT fk01_departamento FOREIGN KEY (cod_departamento) REFERENCES DEPARTAMENTO (cod_departamento)
);

CREATE TABLE IF NOT EXISTS TURMA (
    cod_turma SERIAL PRIMARY KEY,
	cod_curso INT NOT NULL,
	num_alunos_sala SMALLINT NOT NULL,
	periodo varchar(20) NOT NULL,
	data_inicio Date NOT NULL,
	data_fim Date NOT NULL,
		
	CONSTRAINT fk01_curso FOREIGN KEY (cod_curso) REFERENCES CURSO (cod_curso)
);


CREATE TABLE IF NOT EXISTS ARMARIO (
	cod_armario SERIAL PRIMARY KEY,
	num_armario int NOT NULL
);

--- Estrutura Aluno
CREATE TABLE IF NOT EXISTS ALUNO (
    ra SERIAL PRIMARY KEY,
	cod_turma int NOT NULL,
	cod_curso int NOT NULL,
	cod_armario int NOT NULL UNIQUE,
	nome_mae varchar(50) NOT NULL,
	nome_pai varchar(50) NULL,
	nome_aluno varchar(20) NOT NULL,
	sobrenome_aluno varchar(30) NOT NULL,
	cpf varchar(11) NOT NULL,
	status boolean NOT NULL,
	sexo char NOT NULL,
	whatsapp varchar(20) NULL,
	email varchar(30) NULL,
			
	CONSTRAINT fk01_turma FOREIGN KEY (cod_turma) REFERENCES TURMA (cod_turma),
	CONSTRAINT fk02_curso FOREIGN KEY (cod_curso) REFERENCES CURSO (cod_curso),
	CONSTRAINT fk03_armario FOREIGN KEY (cod_armario) REFERENCES ARMARIO (cod_armario)
);


CREATE TABLE IF NOT EXISTS TIPO_LOGRADOURO (
    cod_tipo_logradouro SERIAL PRIMARY KEY,	
	tipo_logradouro VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS ENDERECO_ALUNO (
    cod_endereco_aluno SERIAL PRIMARY KEY,
	ra INT NOT NULL,
	cod_tipo_logradouro INT NOT NULL,	
	nome_rua VARCHAR(50) NOT NULL,
	complemento VARCHAR(30) NULL,
	cep VARCHAR(8) NOT NULL,
	CONSTRAINT fk01_aluno FOREIGN KEY (ra) REFERENCES ALUNO (ra),
	CONSTRAINT fk02_tipo_logradouro FOREIGN KEY (cod_tipo_logradouro) REFERENCES TIPO_LOGRADOURO (cod_tipo_logradouro)
);


CREATE TABLE IF NOT EXISTS TIPO_TELEFONE (
    cod_tipo_tel SERIAL PRIMARY KEY,	
	tipo_telefone VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS TELEFONE_ALUNO (
    cod_tel_aluno SERIAL PRIMARY KEY,	
	ra INT NOT NULL,
	cod_tipo_tel INT NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	
	CONSTRAINT fk01_aluno FOREIGN KEY (ra) REFERENCES ALUNO (ra),
	CONSTRAINT fk02_tipo_telefone FOREIGN KEY (cod_tipo_tel) REFERENCES TIPO_TELEFONE (cod_tipo_tel)
);


CREATE TABLE IF NOT EXISTS HISTORICO (
    cod_historico SERIAL PRIMARY KEY,
	ra INT NOT NULL,
	data_inicio Date NOT NULL,
	data_fim Date NOT NULL,
	FOREIGN KEY (ra) REFERENCES ALUNO (ra)
);

CREATE TABLE IF NOT EXISTS DISCIPLINA (
	cod_disciplina SERIAL PRIMARY KEY,
	cod_departamento int NOT NULL,
	cod_disciplina_depende int NULL,
	num_alunos smallint NOT NULL,
	nome_disciplina varchar(30) NOT NULL,
	carga_horaria smallint NOT NULL,
	descricao varchar(100) NULL,
	
	CONSTRAINT fk01_departamento FOREIGN KEY (cod_departamento) REFERENCES DEPARTAMENTO (cod_departamento)	,
	CONSTRAINT fk02_disciplina_depende FOREIGN KEY (cod_disciplina_depende) REFERENCES DISCIPLINA (cod_disciplina)	
);

CREATE TABLE IF NOT EXISTS PROFESSOR (
	cod_professor SERIAL PRIMARY KEY,	
	cod_departamento int NOT NULL,	
	nome_professor varchar(20) NOT NULL,
	sobrenome_professor varchar(20) NOT NULL,
	status boolean NOT NULL	,
	CONSTRAINT fk01_departamento FOREIGN KEY (cod_departamento) REFERENCES DEPARTAMENTO (cod_departamento)	
);

-- Tabelas associativas

CREATE TABLE IF NOT EXISTS CURSO_DISCIPLINA (
	cod_curso int NOT NULL,	
	cod_disciplina int NOT NULL,	
	PRIMARY KEY(cod_curso, cod_disciplina),
	CONSTRAINT fk01_curso FOREIGN KEY (cod_curso) REFERENCES CURSO (cod_curso),
	CONSTRAINT fk02_disciplina FOREIGN KEY (cod_disciplina) REFERENCES DISCIPLINA (cod_disciplina)
);

CREATE TABLE IF NOT EXISTS ALUNO_DISCIPLINA (
	ra int NOT NULL,	
	cod_disciplina int NOT NULL,	
	PRIMARY KEY(ra, cod_disciplina),
	CONSTRAINT fk01_aluno FOREIGN KEY (ra) REFERENCES ALUNO (ra),
	CONSTRAINT fk02_disciplina FOREIGN KEY (cod_disciplina) REFERENCES DISCIPLINA (cod_disciplina)
);


CREATE TABLE IF NOT EXISTS HISTORICO_DISCIPLINA (
	cod_historico int NOT NULL,
	cod_disciplina int NOT NULL,	
	PRIMARY KEY(cod_historico, cod_disciplina),
	CONSTRAINT fk01_historico FOREIGN KEY (cod_historico) REFERENCES HISTORICO (cod_historico),
	CONSTRAINT fk02_disciplina FOREIGN KEY (cod_disciplina) REFERENCES DISCIPLINA (cod_disciplina)
);


CREATE TABLE IF NOT EXISTS PROFESSOR_DISCIPLINA (
	cod_professor int NOT NULL,
	cod_disciplina int NOT NULL,	
	PRIMARY KEY(cod_professor, cod_disciplina),
	CONSTRAINT fk01_professor FOREIGN KEY (cod_professor) REFERENCES PROFESSOR (cod_professor),
	CONSTRAINT fk02_disciplina FOREIGN KEY (cod_disciplina) REFERENCES DISCIPLINA (cod_disciplina)
);

-----------------------------------------
-- Inserts 
-----------------------------------------

insert into DEPARTAMENTO (nome_departamento) values 
('Departamento de Saude'),
('Departamento de Dados'),
('Departamento de Literatura'),
('Departamento de Exatas');

--select * from DEPARTAMENTO;
-------------------

insert into CURSO (nome_curso, cod_departamento) values 
('Ciencia da computação', 4 ),
('Literatura', 3),
('Emfermagem', 1),
('Mineração de dados', 2),
('Medicina', 1);

--select * from CURSO;
-------------------

insert into TURMA (cod_curso, num_alunos_sala, periodo, data_inicio, data_fim) values 
(1, 30, 'Manhã', '2020-01-01', '2020-12-01' ),
(2, 25, 'Tarde', '2020-01-01', '2021-12-01' ),
(3, 40, 'Noite', '2020-06-01', '2022-12-01' ),
(4, 30, 'Manhã', '2020-01-01', '2022-12-01' ),
(5, 30, 'Integral', '2020-06-01', '2025-12-01'),
(1, 25, 'Tarde', '2020-01-01', '2020-12-01' ),
(1, 25, 'Noite', '2020-01-01', '2020-12-01' );

--select * from TURMA;
-------------------

INSERT INTO ARMARIO (num_armario) VALUES (1),
(2),
(3),
(4),
(5);

insert into ALUNO (cod_turma, cod_curso, cod_armario, nome_mae, nome_pai, nome_aluno,sobrenome_aluno, cpf, status, sexo,  whatsapp, email) values
(1, 1, 1, 'Carol village', 'Muhad Muhami', 'Pedro', 'da Costa', '89282309624', true, 'M', '11935120487', 'pedro@gmail.com'),
(1, 1, 2, 'Anesio Meira', 'Rosa Meira', 'Emanuel ', 'Meira', '95263015487', true, 'M', '11974521036', 'emanuel@gmail.com'),
(2, 2, 3, 'Carla Castro', 'Bia doria', 'Maria', 'Pereira', '89282301598', true, 'F', '11936251487', 'carla@gmail.com'),
(5, 5, 4, 'Anesio Meira', 'Rosa Meira', 'Vagnerl ', 'Lisboa', '95263011592', true, 'M', '11974523214', 'vagner@gmail.com'),
(5, 5, 5, 'Jessica Oliveira', 'Juca chaves', 'Juliana', 'Jakcs', '89282308880', true, 'F', '11936250000', 'juliana@gmail.com');

--select * from ALUNO;
-------------------

insert into TIPO_LOGRADOURO (tipo_logradouro) values 
('Avenida'),
('Rua'),
('Travessa'),
('Praça');

--select * from tipo_logradouro;
-------------------

insert into endereco_aluno (ra, cod_tipo_logradouro,nome_rua,  complemento, cep ) values 
(1, 1, 'Serafim Gonçalves', 'ap 32 bl 2', '0279000'),
(2, 3, 'beco 51', null, '5214000'),
(3, 4, '14 bis', null, '56984257');

--select * from endereco_aluno;
---------------------

insert into tipo_telefone (tipo_telefone) values 
('residencial'),
('celular');


--select * from tipo_telefone;
---------------------

insert into telefone_aluno (cod_tipo_tel, ra, telefone) values
(2, 1, '71965425745'),
(1, 1, '7133652148'),
(2, 2, '71965425000'),
(1, 3, '7133692852');

--select * from telefone_aluno;
-----------

insert into historico (ra, data_inicio, data_fim) values 
(1, '2020-01-01', '2023-12-01'),
(2, '2010-01-01', '2019-12-01'),
(3, '2017-01-01', '2022-06-01');

--select * from historico;
-----------

insert into disciplina (cod_departamento, cod_disciplina_depende, num_alunos, nome_disciplina, carga_horaria, descricao) values
(1, null, 30, 'Anatomia', 100, 'Descrição da disciplina blablablabla .. blabla'),
(1, null, 40, 'Citologia Histologia', 60, 'Descrição da disciplina blablablabla .. blabla'),
(4, null, 20, 'Matematica', 75, 'Descrição da disciplina blablablabla .. blabla'),
(4, 3, 10, 'Matematica 2', 60, 'Descrição da disciplina blablablabla .. blabla'),
(3, null, 40, 'Machado de assis', 120, 'Descrição da disciplina blablablabla .. blabla');


--delete from disciplina where disciplina.cod_disciplina = 6;
--select * from disciplina;
-----------

insert into professor (cod_departamento, nome_professor, sobrenome_professor, status ) values 
(1, 'Carlos', 'silva', true),
(4, 'Eliana', 'rocha', true),
(3, 'Brusqueta', 'bilispe', true);

--select * from professor;
-----------------

insert into aluno_disciplina (ra, cod_disciplina) values 
(1, 1),
(1, 2),
(2, 3),
(3, 5);

--select * from aluno_disciplina;
------------------

insert into curso_disciplina (cod_curso, cod_disciplina) values 
(1, 3),
(1, 4),
(3, 1),
(3, 2),
(2, 5);

--select * from curso_disciplina;
------------------

insert into professor_disciplina (cod_professor, cod_disciplina) values 
(1, 3),
(1, 4),
(2, 3),
(3, 5);

-----------------------------------------
-- Consultas
-----------------------------------------

-- ra, nome do aluno, seu curso, e o periodo do curso
select A.ra, A.nome_aluno, C.nome_curso, T.periodo from Aluno A
inner join Turma T on A.cod_turma = T.cod_turma
inner join Curso C on A.cod_curso = C.cod_curso
order by A.nome_aluno, A.ra;

-- nome do aluno e a disciplina que ele cursa no nomento
select A.nome_aluno, D.nome_disciplina from Aluno A
inner join aluno_disciplina AD on A.ra = AD.ra
inner join disciplina D on AD.cod_disciplina = D.cod_disciplina
where A.ra = 1;


-- nome do professor+sobrenome, curso q eles ministram e a carga horaria da disciplina
select P.nome_professor, P.sobrenome_professor, D.nome_disciplina, D.carga_horaria from professor P
inner join professor_disciplina PD on P.cod_professor = PD.cod_professor
inner join disciplina D on PD.cod_disciplina = D.cod_disciplina
order by P.nome_professor;

-- nome, cpf, tel e endereço dos alunos
select A.nome_aluno, A.cpf, TA.telefone,TL.tipo_logradouro, EA.nome_rua, EA.complemento from Aluno A
inner join telefone_aluno TA ON A.ra = TA.ra 
inner join endereco_aluno EA ON A.ra = EA.ra
inner join tipo_logradouro TL ON EA.cod_tipo_logradouro = TL.cod_tipo_logradouro;

-- nome da disciplina, nome do curso, nome do professor e nome do departamento
select D.nome_disciplina, C.nome_curso, P.nome_professor, DE.nome_departamento from disciplina D
inner join departamento DE ON D.cod_departamento = DE.cod_departamento
inner join professor_disciplina PD ON D.cod_disciplina = PD.cod_disciplina
inner join professor P ON PD.cod_professor = P.cod_professor
inner join curso_disciplina CD ON D.cod_disciplina = CD.cod_disciplina
inner join curso C ON CD.cod_curso = C.cod_curso
order by D.nome_disciplina;

