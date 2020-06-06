create table vendedor
(
	 idvendedor varchar(50) not null,
	 contrasenya varchar(50) not null, 
	 nombre varchar(50) not null,
	 apellido varchar(50) not null,
	 direccion varchar(100) not null,
	 telefono varchar(15) not null,
	 primary key(idvendedor)
);
CREATE TABLE orden_compra_encabezado (
  OrdenID integer not null,
  idvendedor varchar(4) not null,
  Company varchar(20) not null,
  FechaOrden varchar(10) not null,
  primary key(OrdenID),
  UNIQUE(OrdenID, idvendedor, FechaOrden)
);
alter  table orden_compra_encabezado add constraint orden_compra_encabezadoConstraint1 FOREIGN KEY (idvendedor) references vendedor(idvendedor);

CREATE TABLE Productos(
   Codigo varchar(10) not null,
   Nombre VARCHAR(50) not null,
   Precio decimal(10,2), 
   Stock int not null,
   primary key(Codigo)
);
CREATE TABLE orden_compra_detalle (
  OrdenID integer not null,
  Codigo varchar(10) not null,
  ValorUnit decimal(10,2) not null,
  Cantidad int not null,
  primary key(OrdenID),
  UNIQUE(OrdenID, Codigo)
);
alter  table orden_compra_detalle add constraint orden_compra_detalleConstraint1 FOREIGN KEY (Codigo) references Productos(Codigo);
alter  table orden_compra_detalle add constraint orden_compra_detalleConstraint2 FOREIGN KEY (OrdenID) references orden_compra_encabezado(OrdenID);



create table empleados
(
	 idempleado varchar(50) not null,
	 contrasenya varchar(50) not null, 
	 nombre varchar(50) not null,
	 apellido varchar(50) not null,
	 direccion varchar(100),
	 telefono varchar(15) not null,
	 primary key(idempleado)
);
CREATE TABLE orden_venta_encabezado (
  OrdenID integer not null,
  idempleado varchar(50) not null,
  Company varchar(20) not null,
  FechaOrden varchar(10) not null,
  primary key(OrdenID),
  UNIQUE(OrdenID, idempleado, FechaOrden)
);
alter  table orden_venta_encabezado add constraint orden_venta_encabezadoConstraint1 FOREIGN KEY (idempleado) references empleados(idempleado);
CREATE TABLE orden_venta_detalle (
  OrdenID integer not null,
  Codigo varchar(10) not null,
  ValorUnit decimal(10,2) not null,
  Cantidad int not null,
  primary key(OrdenID),
  UNIQUE(OrdenID, Codigo)
);
alter  table orden_venta_detalle add constraint orden_venta_detalleConstraint1 FOREIGN KEY (Codigo) references productos(Codigo);
alter  table orden_venta_detalle add constraint orden_venta_detalleConstraint2 FOREIGN KEY (OrdenID) references orden_venta_encabezado(OrdenID);






