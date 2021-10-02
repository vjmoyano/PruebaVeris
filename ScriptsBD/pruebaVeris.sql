CREATE SEQUENCE seq_marcacion
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 1000;
    
CREATE TABLE ciudad (
    codigo_ciudad NUMBER,
    nombre_ciudad VARCHAR2(50) NOT NULL,
    usuario_registro VARCHAR2(50) NOT NULL,
    fecha_registro DATE NOT NULL,
    CONSTRAINT pk_ciudad PRIMARY KEY (codigo_ciudad)
    )

CREATE TABLE edificio (
    codigo_edificio NUMBER,
    nombre_edificio VARCHAR2(100) NOT NULL,
    codigo_ciudad NUMBER NOT NULL,
    usuario_registro VARCHAR2(50) NOT NULL,
    fecha_registro DATE NOT NULL,
    CONSTRAINT pk_edificio PRIMARY KEY (codigo_edificio),
    CONSTRAINT fk_ciudad FOREIGN KEY (codigo_ciudad) REFERENCES ciudad(codigo_ciudad)
)
    
CREATE TABLE empleado (
    codigo_empleado NUMBER,
    tipo_identificacion VARCHAR2(3) CONSTRAINT check_tipo_identificacion CHECK (tipo_identificacion in ('CED','RUC','PAS') ) NOT NULL,
    numero_identificacion VARCHAR2(20) NOT NULL,
    primer_nombre VARCHAR2(25) NOT NULL,
    segundo_nombre VARCHAR2(25),
    primer_apellido VARCHAR2(25) NOT NULL,
    segundo_apellido VARCHAR2(25) NOT NULL,
    nombre_completo VARCHAR2(100) NOT NULL,
    mail VARCHAR2(50) NOT NULL,
    sexo VARCHAR2(1) CONSTRAINT check_sexo CHECK (sexo in ('F','M')) NOT NULL,
    fecha_nacimiento DATE,
    codigo_edificio NUMBER NOT NULL,
    estado VARCHAR2(3) CONSTRAINT check_estado CHECK (estado in ('ACT','INA')) NOT NULL,
    usuario_registro VARCHAR2(50) NOT NULL,
    fecha_registro DATE NOT NULL,
    CONSTRAINT pk_empleado PRIMARY KEY (codigo_empleado),
    CONSTRAINT fk_edificio FOREIGN KEY (codigo_edificio) REFERENCES edificio(codigo_edificio)
)


CREATE TABLE marcacion (
    secuencia NUMBER DEFAULT SEQ_MARCACION.nextval,
    codigo_empleado NUMBER NOT NULL,
    codigo_edificio NUMBER NOT NULL,
    fecha_marcacion DATE,
    hora_marcacion VARCHAR2(25),
    tipo_marcacion VARCHAR2(3) CONSTRAINT check_tipo_marcacion CHECK (tipo_marcacion in ('ENT','SAL')) NOT NULL,
    usuario_registro VARCHAR2(50) NOT NULL,
    fecha_registro DATE NOT NULL,
    CONSTRAINT pk_marcacion PRIMARY KEY (secuencia),
    CONSTRAINT fk_empleado FOREIGN KEY (codigo_empleado) REFERENCES empleado(codigo_empleado),
    CONSTRAINT fk_edificioM FOREIGN KEY (codigo_edificio) REFERENCES edificio(codigo_edificio)
)
