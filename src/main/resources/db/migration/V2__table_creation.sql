CREATE TABLE Empleado (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  cedula VARCHAR(20) NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);

CREATE TABLE Salario (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(200),
  monto DOUBLE NOT NULL,
  fecha TIMESTAMP NOT NULL,
  PRIMARY KEY (id, fecha)
);

CREATE TABLE TipoGasto (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(200) NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);

CREATE TABLE EmpleadoXSalario (
  id INT NOT NULL AUTO_INCREMENT,
  idTipoGasto INT NOT NULL,
  idEmpleado INT NOT NULL,
  idSalario INT NOT NULL,
  cantidadDias INT NOT NULL,
  fechaCalculo TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (idTipoGasto) REFERENCES TipoGasto(id),
  CONSTRAINT FOREIGN KEY (idEmpleado) REFERENCES Empleado(id),
  CONSTRAINT FOREIGN KEY (idSalario) REFERENCES Salario(id)
);

CREATE TABLE Gasto (
  id INT NOT NULL AUTO_INCREMENT,
  fecha TIMESTAMP NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  monto DOUBLE NOT NULL,
  status ENUM('Pendiente', 'Pagado') NOT NULL,
  idTipoGasto INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (idTipoGasto) REFERENCES TipoGasto(id)
);

CREATE TABLE Prestamo (
  id INT NOT NULL AUTO_INCREMENT,
  idEmpleado INT NOT NULL,
  montoTotal DOUBLE NOT NULL,
  saldo DOUBLE NOT NULL,
  status ENUM('Pendiente', 'Pagado') NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (idEmpleado) REFERENCES Empleado(id)
);

CREATE TABLE Ingreso (
  id INT NOT NULL AUTO_INCREMENT,
  idPrestamo INT NOT NULL,
  montoIngreso DOUBLE NOT NULL,
  fecha TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (idPrestamo) REFERENCES Prestamo(id)
);