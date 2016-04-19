select * from employee e, customer c where e.id=c.employee_id(+);
select * from employee e left outer join customer c on c.employee_id=e.id;

select e.name emleado, case when c.name is null then 'no tiene clientes' else c.name end cliente from employee e left outer join customer c on c.employee_id=e.id;
select e.name emleado, nvl(c.name, 'no tieneee clientes') cliente from employee e left outer join customer c on c.employee_id=e.id;
select e.name emleado, nvl2(c.name, 'tiene','no tieneee clientes') cliente from employee e left outer join customer c on c.employee_id=e.id;
select e.name emleado, decode (e.name, 'x', 'si','y',e.name) cliente from employee e left outer join customer c on c.employee_id=e.id;

select e.name as empleado, count(c.employee_id) as "núm. clientes"  from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name;

select e.name as empleado, case when count(c.employee_id)=0 then 'no tiene clientes' else  tochar(count(c.employee_id))end as "núm. clientes"  from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name;

select e.name as empleado,  decode(count(c.employee_id), '0', 'no tiene clientes', count(c.employee_id)) as "núm. clientes"  from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name;

select * from customer;

insert into customer (ID, NAME,EMPLOYEE_ID ) values( 7,'pepito', 2);commit;

select max(count(c.employee_id)) as "núm. clientes" from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name;
select max("núm. clientes") from  ( select count(c.employee_id) as "núm. clientes" from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name);

select  e.name, count(c.employee_id) as "núm. clientes" from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name having count(c.employee_id)= max(count(c.employee_id)) ;


select e.name as empleado  from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name having ()select max(count(c.employee_id)) as "núm. clientes" from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name);



delete from employee where NAME=(select e.name as empleado  from employee e left outer join customer c on c.employee_id=e.id group by e.id, e.name having count(c.employee_id)=0);
select * from employee;