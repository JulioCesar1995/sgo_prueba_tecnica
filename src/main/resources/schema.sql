create table pais(
    id varchar(2),
    nombre varchar(50),
    primary key (id)
);

create table persona(
    id bigint auto_increment,
    nombres varchar(100),
    apellidos varchar(100),
    idPais varchar(2)
)