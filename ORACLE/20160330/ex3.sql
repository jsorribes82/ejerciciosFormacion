--3. Escribid en una sola query el sql necesario para despedir a los trabajadores que no tienen ningún cliente:
--	- Calcular qué trabajadores no tienen clientes
--	- Borrarlos de la BD


delete from employee 
where NAME=(select e.name as empleado  
	from employee e left outer join customer c on c.employee_id=e.id 
	group by e.id, e.name having count(c.employee_id)=0);

select * from employee;