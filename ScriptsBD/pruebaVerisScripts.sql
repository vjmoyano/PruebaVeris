
insert into edificio(codigo_edificio, nombre_edificio, codigo_ciudad, usuario_registro, fecha_registro) values (10, 'Hotel Hilton', 1, (select user from dual), SYSDATE)
insert into edificio(codigo_edificio, nombre_edificio, codigo_ciudad, usuario_registro, fecha_registro) values (9, 'Las Torres', 4, (select user from dual), SYSDATE)
insert into edificio(codigo_edificio, nombre_edificio, codigo_ciudad, usuario_registro, fecha_registro) values (8, 'Municipio', 3, (select user from dual), SYSDATE)
insert into edificio(codigo_edificio, nombre_edificio, codigo_ciudad, usuario_registro, fecha_registro) values (7, 'Gobernacion', 5, (select user from dual), SYSDATE)
insert into edificio(codigo_edificio, nombre_edificio, codigo_ciudad, usuario_registro, fecha_registro) values (6, 'Hotel', 6, (select user from dual), SYSDATE)

INSERT INTO ciudad (codigo_ciudad, nombre_ciudad, USUARIO_REGISTRO, FECHA_REGISTRO) VALUES (4,'Machala', 'VECSUS', SYSDATE );
INSERT INTO ciudad (codigo_ciudad, nombre_ciudad, USUARIO_REGISTRO, FECHA_REGISTRO) VALUES (5,'Pedro Carbo', 'VECSUS', SYSDATE );
INSERT INTO ciudad (codigo_ciudad, nombre_ciudad, USUARIO_REGISTRO, FECHA_REGISTRO) VALUES (6,'Nobol', 'VECSUS', SYSDATE );
commit;

Select m.fecha_marcacion, ed.nombre_edificio, e.nombre_completo, m.tipo_marcacion, m.hora_marcacion
from empleado e join marcacion m on e.codigo_empleado = m.codigo_empleado join edificio ed on e.codigo_edificio = ed.codigo_edificio
where m.hora_marcacion between '08:00' and '16:00' order by m.fecha_marcacion, ed.nombre_edificio, e.nombre_completo


select * from empleado e join edificio ed on e.codigo_edificio = ed.codigo_edificio 
join ciudad c on c.codigo_ciudad = ed.codigo_ciudad where e.estado ='ACT' and c.codigo_ciudad = 1

select * from empleado e where e.NOMBRE_COMPLETO like '%Tomas%' and e.estado = 'ACT'
