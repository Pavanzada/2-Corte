drop schema preguntas;
CREATE SCHEMA preguntas;
USE preguntas ;

CREATE  TABLE tema (
  idtema INT NOT NULL AUTO_INCREMENT ,
  nombreTema VARCHAR(45) NOT NULL ,
  PRIMARY KEY (idtema ) );

CREATE  TABLE materia (
  idmateria INT NOT NULL AUTO_INCREMENT ,
  nombreMateria VARCHAR(45) NOT NULL ,
  idtema int not null, 
  PRIMARY KEY (idmateria),
	foreign key(idtema) references tema (idtema) on delete no action on update no action );

CREATE  TABLE pregunta (
  idpregunta INT NOT NULL AUTO_INCREMENT,
  porcentaje float NOT NULL ,
  complejidad varchar(50) not null,
  tipopregunta varchar(50) not null,
  descripcion varchar(100) not null,
  nombre varchar(50) not null,
  respuesta varchar(100) null,
  PRIMARY KEY (idpregunta)
  );

create table pregunta_respuesta(
	idprres int not null auto_increment,
	idpregunta int not null,	
	respuesta varchar(50),
	foreign key(idpregunta) references pregunta (idpregunta) on delete no action on update no action ,	
	PRIMARY KEY (idprres)
);

create table pregunta_temas(
	idtemapreg int not null AUTO_INCREMENT, 
	idtema int not null,
	idpregunta int not null, 	
	foreign key(idtema) references tema (idtema) on delete no action on update no action,
	foreign key(idpregunta) references pregunta (idpregunta) on delete no action on update no action,
	PRIMARY KEY (idtemapreg)
);

create table examen(
	idexamen int not null auto_increment, 
	nombre varchar(50) not null,
	PRIMARY KEY (idexamen));
	
create table examen_preguntas(
	idexampreg int not null auto_increment, 
	idpregunta int not null, 
	idexamen int not null,
	foreign key(idpregunta) references pregunta (idpregunta) on delete no action on update no action ,
	foreign key(idexamen) references examen (idexamen) on delete no action on update no action ,
	PRIMARY KEY (idexampreg)
);

create table examen_temas(
	idexatem int not null auto_increment,
	idtema int not null,
	idexamen int not null, 	
	foreign key(idtema) references tema (idtema) on delete no action on update no action ,
	foreign key(idexamen) references examen (idexamen) on delete no action on update no action ,
	PRIMARY KEY (idexatem)
);
