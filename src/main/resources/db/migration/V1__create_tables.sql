create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha_creacion datetime not null,
    estado varchar(100) not null,
    autor_id bigint not null,
    curso_id varchar(100) not null,
    respuestas varchar(100) not null,

    primary key(id)

);
create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    correo_electronico varchar(100) not null,
    contrasena varchar(6) not null,
    perfiles varchar(100) not null,

    primary key(id)

);
create table cursos(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    categoria varchar(100) not null,

    primary key(id)

);
create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(100) not null,
    topico_id bigint not null,
    fecha_creacion varchar(6) not null,
    autor_id bigint not null,
    solucion varchar(100) not null,

    primary key(id)

);