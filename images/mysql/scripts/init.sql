CREATE DATABASE curso;

GRANT ALL PRIVILEGES ON `curso`.* TO 'user'@'%';

USE curso;

DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS DetallesCarrito;
DROP TABLE IF EXISTS Libro;
DROP TABLE IF EXISTS Pelicula;
DROP TABLE IF EXISTS Producto;
DROP TABLE IF EXISTS Carrito;





CREATE TABLE Carrito(
	idCarrito INT AUTO_INCREMENT ,
	CONSTRAINT PK_CARRITO PRIMARY KEY (idCarrito)
);

CREATE TABLE Producto (
	idProducto INT AUTO_INCREMENT,
	titulo VARCHAR(50) NOT NULL ,
	precio DECIMAL (6,2),
	anho INT , 
	genero VARCHAR (20),
	CONSTRAINT PK_PRODUCTO PRIMARY KEY (idProducto)

)engine=InnoDB;

CREATE TABLE Cliente(
	numDni INT ,
	letraDni CHAR (1),
	login VARCHAR (20) UNIQUE ,
	clave VARCHAR (20),
	nombre VARCHAR(25),
	apellidos VARCHAR(50),
	direccion VARCHAR (100),
	fechaNacimiento DATE ,
	idCarrito INT ,
	CONSTRAINT PK_CLIENTE PRIMARY KEY (numDni),
	CONSTRAINT FK_CLIENTE_CARRITO FOREIGN KEY (idCarrito) REFERENCES Carrito (idCarrito)
		ON DELETE SET NULL ON UPDATE CASCADE
)engine=InnoDB;

CREATE TABLE DetallesCarrito(
	idDetalle INT AUTO_INCREMENT,
	idCarrito INT,
	idProducto INT,
	CONSTRAINT PK_DETALLESCARRITO PRIMARY KEY (idDetalle),
	CONSTRAINT FK_DETALLES_CARRITO FOREIGN KEY (idCarrito) REFERENCES Carrito (idCarrito)
		ON DELETE SET NULL ON UPDATE CASCADE, 
		
	CONSTRAINT FK_DETALLES_PRODUCTO FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)
		ON DELETE CASCADE 	ON UPDATE CASCADE
	
)engine=InnoDB;

CREATE TABLE Libro(
	idProducto INT,
	autor VARCHAR(150),
	ISBN CHAR(10),
	CONSTRAINT PK_LIBRO PRIMARY KEY (idProducto),
	CONSTRAINT FK_LIBRO_PRODUCTO FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)
		ON DELETE CASCADE ON UPDATE CASCADE
		
)engine=InnoDB;

CREATE TABLE Pelicula(
	idProducto INT,
	directo VARCHAR(150),
	reparto VARCHAR(200),
	CONSTRAINT PK_PELICULA PRIMARY KEY (idProducto),
	CONSTRAINT FK_PELICULA_PRODUCTO FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)
		ON DELETE CASCADE ON UPDATE CASCADE
		
)engine=InnoDB;
-- ALTER TABLE DetallesCarrito ADD COLUMN cantidad INT;

INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('Titulo 1','10.3','1980','Terror');
INSERT INTO Libro VALUES (1,'Autor 1','ABCDEF');
INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('Titulo 2',11.8,1970,NULL);
INSERT INTO Libro VALUES (2,'Autor 2','ABCDEG');

INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('Titulo 3',29.30,2013,NULL);
INSERT INTO Libro VALUES (3,'Director 1','Actriz 1');

INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('Titulo 4',40.10,2017,'Belica');
INSERT INTO Libro VALUES (4,'Director 2','Actor 1');

UPDATE Producto SET titulo = 'Libro 1'
WHERE idProducto= 1 ;

UPDATE Producto SET titulo = 'Libro 2'
WHERE idProducto= 2;

UPDATE Producto SET titulo = 'Pelicula 1'
WHERE idProducto= 3;

UPDATE Producto SET titulo = 'Pelicula 2'
WHERE idProducto = 4;



