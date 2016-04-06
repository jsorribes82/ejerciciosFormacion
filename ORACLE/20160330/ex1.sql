select name from employee;
select id from employee;
select name from employee order by name;

select name from employee order by date_of_birth;

select name from customer;

select e.name, c.name from employee e, customer c where e.id=c.employee_id;
select e.name, c.name from employee e inner join customer c on e.id=c.employee_id;