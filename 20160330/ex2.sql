--2. Escribid las sentencias SQL que os permitan recuperar:
--	- Los trabajadores y qué clientes tienen cada uno
--		- Con un literal de 'No tiene clientes' en caso que no tenga
--	- Los trabajadores y cuántos clientes tiene cada uno
--		- Con un literal de 'No tiene clientes' en caso que no tenga
--	- Cuál es el máximo de clientes que tiene un trabajador

select * from employee e, customer c where e.id=c.employee_id(+);
select * from employee e left outer join customer c on c.employee_id=e.id;


select e.name emleado, case when c.name is null then 'no tiene clientes' else c.name end cliente from employee e left outer join customer c on c.employee_id=e.id;
select e.name emleado, nvl(c.name, 'no tieneee clientes') cliente from employee e left outer join customer c on c.employee_id=e.id;
select e.name emleado, nvl2(c.name, 'tiene','no tieneee clientes') cliente from employee e left outer join customer c on c.employee_id=e.id;
select e.name emleado, decode (e.name, 'x', 'si','y') cliente from employee e left outer join customer c on c.employee_id=e.id;

select max(count(c.employee_id)) as "núm. clientes" from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name;
select max("núm. clientes") from  ( select count(c.employee_id) as "núm. clientes" from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name);
