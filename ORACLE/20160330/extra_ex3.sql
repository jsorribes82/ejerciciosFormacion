--nombre del treballador i el numero de clients que te asociat el que en te més

select e.name, count(c.employee_id) as "núm. clientes"  
from employee e left outer join customer c 
on c.employee_id=e.id 
group by e.id, e.name 
having (select max(count(c.employee_id))  from employee e left outer join customer c on (c.employee_id=e.id) group by e.id, e.name)=count(c.employee_id);
