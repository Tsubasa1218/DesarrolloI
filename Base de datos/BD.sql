/*
#Base de datos: Proyecto de desarrollo de software 1
#Version: 5.0
#Integrantes:
#	Juan Suaza
#	Mauricio Ceron
#	Jose Salazar
#	Alejandro Martinez
*/
DROP TABLE if exists sedes CASCADE;
DROP TABLE if exists vehiculos CASCADE;
DROP TABLE if exists partes CASCADE;
DROP TABLE if exists usuarios CASCADE;
DROP TABLE if exists comprador CASCADE;
DROP TABLE if exists ordenes CASCADE;
DROP TABLE if exists ordenes_emitidas CASCADE;
DROP TABLE if exists ventas_vehiculos CASCADE;
DROP TABLE if exists cotizaciones_realizadas CASCADE;

CREATE TABLE sedes(
	id_sede SERIAL PRIMARY KEY,
	nombre_sede VARCHAR(20) UNIQUE NOT NULL,
	direccion_sede VARCHAR(50) NOT NULL,
	telefono_sede CHAR(7) NOT NULL,
	email_sede VARCHAR(50) NOT NULL UNIQUE);

CREATE TABLE vehiculos(
	id_vehiculo SERIAL PRIMARY KEY,
	marca_vehiculo VARCHAR(20) NOT NULL,
	modelo_vehiculo CHAR(4) NOT NULL,
	color_vehiculo VARCHAR(20) NOT NULL,
	nuevo_vehiculo BOOLEAN NOT NULL,
	cantidad_disponible_vehiculo INTEGER DEFAULT 0,
	valor_vehiculo FLOAT NOT NULL,
	fecha_adicion_vehiculo DATE NOT NULL,
	id_sede SERIAL REFERENCES sedes(id_sede));
	
CREATE TABLE usuarios(
	id_usuario CHAR(10) PRIMARY KEY,
	password_usuario VARCHAR(15) NOT NULL,
	nombre_usuario VARCHAR(50) NOT NULL,
	estado_usuario BOOLEAN NOT NULL,
	email_usuario VARCHAR(50) NOT NULL UNIQUE,
	telefono_usuario CHAR(7) NOT NULL,
	tipo_usuario VARCHAR(15) NOT NULL,
	fecha_ingreso_usuario DATE NOT NULL,
	activo_usuario BOOLEAN DEFAULT FALSE,
	id_sede SERIAL REFERENCES sedes(id_sede));

CREATE TABLE partes(
	id_parte SERIAL PRIMARY KEY,
	nombre_parte VARCHAR(20) NOT NULL,
	cantidad_parte INTEGER DEFAULT 0,
	valor_parte FLOAT NOT NULL,
	id_sede SERIAL REFERENCES sedes(id_sede));

CREATE TABLE comprador(
	id_comprador CHAR(10) PRIMARY KEY,
	nombre_comprador VARCHAR(30) NOT NULL,
	direccion_comprador VARCHAR(50) NOT NULL,
	telefono_comprador CHAR(7) NOT NULL,
	email_comprador VARCHAR(50) NOT NULL UNIQUE);

CREATE TABLE cotizaciones_realizadas(
	id_cotizaciones SERIAL,
	id_usuario CHAR(10)  REFERENCES usuarios(id_usuario),
	id_vehiculo SERIAL  REFERENCES vehiculos(id_vehiculo),
	id_comprador CHAR(10)  REFERENCES comprador(id_comprador),
	fecha_cotizacion DATE NOT NULL,
	CONSTRAINT pk_cotizaciones_realizadas PRIMARY KEY(id_cotizaciones),
	CONSTRAINT unique_cotizaciones UNIQUE(fecha_cotizacion, id_usuario, id_vehiculo, id_comprador));

CREATE TABLE ordenes_emitidas(
	id_usuario CHAR(10)  REFERENCES usuarios(id_usuario),
	id_orden SERIAL,
	id_vehiculo SERIAL REFERENCES vehiculos(id_vehiculo),
	id_parte SERIAL REFERENCES partes(id_parte),
	fecha_emision DATE NOT NULL,
	resumen_orden VARCHAR(250) NOT NULL,
	cantidad INTEGER NOT NULL,
	CONSTRAINT pk_ordenes_emitidas PRIMARY KEY (id_orden)
	);

CREATE TABLE ventas_vehiculos(
	id_venta SERIAL,
	id_usuario CHAR(10)  REFERENCES usuarios(id_usuario),
	id_vehiculo SERIAL  REFERENCES vehiculos(id_vehiculo),
	id_comprador CHAR(10) REFERENCES comprador(id_comprador),
	fecha_venta DATE NOT NULL,
	CONSTRAINT pk_ventas_vehiculos PRIMARY KEY (id_venta),
	CONSTRAINT unique_ventas UNIQUE (id_usuario, id_vehiculo, id_comprador, fecha_venta));

INSERT INTO sedes(nombre_sede, direccion_sede, telefono_sede, email_sede) VALUES('Londres', 'Calle 4D','1234567', 'sede01@abc.com');
INSERT INTO usuarios(id_usuario, password_usuario, nombre_usuario, estado_usuario, email_usuario, telefono_usuario, tipo_usuario, fecha_ingreso_usuario, id_sede) VALUES ('114408514', '12345', 'Juan Suaza', TRUE, 'xd@xd.com', '1234567', 'Gerente', '2016-12-12', 1);
