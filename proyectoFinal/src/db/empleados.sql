drop database if exists empleados;
create database empleados;

use empleados;
CREATE TABLE generos (
    id_generos INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20)
);

CREATE TABLE login (
    id_login INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) NOT NULL,
    usuario VARCHAR(100) NOT NULL,
    contrasenia VARCHAR(100) NOT NULL
);


CREATE TABLE empleados (
    id_login INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    domicilio VARCHAR(100) NOT NULL,
    telefono VARCHAR(12) NOT NULL,
    email VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    id_generos INT,
    CONSTRAINT empleados_tiene_llave_generos_fk FOREIGN KEY (id_generos)
        REFERENCES generos (id_generos)
);


