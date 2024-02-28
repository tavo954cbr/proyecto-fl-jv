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
    id_empleados INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    domicilio VARCHAR(100) NOT NULL,
    telefono VARCHAR(12) NOT NULL,
    email VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    id_generos INT,
    CONSTRAINT empleados_tiene_llave_generos_fk FOREIGN KEY (id_generos)
        REFERENCES generos (id_generos)
);

INSERT INTO generos VALUES
	(null,'Femenino'),
	(null,'Masculino'),
	(null,'Otro');

INSERT INTO login VALUES 
	(null,'GUSTAVO','tavogmail.com','tavocbr','diablo1212'),
	(null,'DANIEL','danielgmail.com','danielcbr','daniel1212'),
	(null,'CLAUDIA','claudiagmail.com','claudiacbr','claudia1212'),
	(null,'NANCY','nancygmail.com','nancycbr','nancy1212');

INSERT INTO empleados VALUES
	(null, 'Juan Pérez', 'Calle Principal 123', '5551234567', 'juan@example.com', '1990-05-15',2),
    (null, 'María López', 'Avenida Central 456', '555-987-6543', 'maria@example.com', '1988-09-20',1),
	(null, 'Carlos Rodríguez', 'Calle Secundaria 789', '555-555-5555', 'carlos@example.com', '1995-03-10',2),
	(null, 'Ana García', 'Boulevard Norte 321', '555-111-2222', 'ana@example.com', '1992-11-05',1),
	(null, 'Pedro Martínez', 'Calle Sur 567', '555-444-3333', 'pedro@example.com', '1985-07-30',3),
	(null, 'Laura Sánchez', 'Avenida Oeste 987', '555-888-9999', 'laura@example.com', '1998-02-18',1),
	(null, 'José Ramírez', 'Calle Este 654', '555-777-8888', 'jose@example.com', '1993-12-25',2),
	(null, 'Sofía Torres', 'Boulevard Central 789', '555-222-1111', 'sofia@example.com', '1997-06-05',3),
	(null, 'Diego Vargas', 'Avenida Principal 234', '555-666-7777', 'diego@example.com', '1991-04-12',3),
	(null, 'Elena Fernández', 'Calle Norte 876', '555-333-4444', 'elena@example.com', '1987-08-22',1),
	(null, 'Andrés López', 'Boulevard Sur 543', '555-999-0000', 'andres@example.com', '1994-10-15',2),
	(null, 'Isabel Martínez', 'Avenida Este 210', '555-444-5555', 'isabel@example.com', '1996-01-08',3),
	(null, 'Ricardo Soto', 'Calle Oeste 765', '555-777-6666', 'ricardo@example.com', '1989-03-28',2),
	(null, 'Carmen Ramírez', 'Boulevard Norte 123', '555-555-4444', 'carmen@example.com', '1999-07-01',2),
	(null, 'Fernando González', 'Avenida Sur 432', '555-888-7777', 'fernando@example.com', '1994-09-10',3);

