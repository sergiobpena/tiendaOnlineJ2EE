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
    cantidad INT ,
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
-- LIBROS
INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('O extranxeiro','10.3',1942,'Terror');
INSERT INTO Libro VALUES (1,'Albert Camus','ABCDEF');
INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('A Esmorga',11.8,1970,'Novela');
INSERT INTO Libro VALUES (2,'E.Blanco Amor','XX1XX');

INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('El señor de las moscas',29.30,1954,'Ficcion');
INSERT INTO Libro VALUES (3,'William Golding','PPPTTTT');

INSERT INTO Producto (titulo, precio, anho , genero) VALUES ('La conjura de los necios',40.10,1980,'Ficcion');
INSERT INTO Libro VALUES (4,'John Kennedy Toole','KKKKKKKK');
-- PELICULAS

INSERT INTO Producto(titulo, precio, anho, genero) VALUES ('Apocalypse Now',25.30,1969,'Belica');
INSERT INTO Pelicula(idProducto, directo, reparto) VALUES (5,'Francis Coppola','Martin Sheen , Marlon Brando');

INSERT INTO Producto(titulo, precio, anho, genero) VALUES ('El discreto encanto de la burguesía',19.90,1972,'Surrealismo');
INSERT INTO Pelicula(idProducto, directo, reparto) VALUES (6,'Luis Buñuel','Fernando Rey, Paul Frankeur');

INSERT INTO Producto(titulo, precio, anho, genero) VALUES ('Lock & Stock',25.30,1998,'Comedia');
INSERT INTO Pelicula(idProducto, directo, reparto) VALUES (7,'Guy Ritchie','Nick Moran, Jason Flemyng, Jason Statham');

INSERT INTO Producto(titulo, precio, anho, genero) VALUES ('Los santos inocentes',30.01,1984,'Drama');
INSERT INTO Pelicula(idProducto, directo, reparto) VALUES (8,'Mario Camus','Alfredo Landa, Francisco Rabal');

