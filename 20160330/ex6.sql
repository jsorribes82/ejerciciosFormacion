--6. Cread los scripts para actualizar la información 
--necesaria de los empleados y clientes, para que los campos no tengan valor nulo

UPDATE Customer
SET surname='surname1.1' where name='Client 1.1';
UPDATE Customer
SET surname='surname1.2' where name='Client 1.2';
UPDATE Customer
SET surname='surname1.3' where name='Client 1.3';
UPDATE Customer
SET surname='surname2.1' where name='Client 2.1';
UPDATE Customer
SET surname='surname2.2' where name='Client 2.2';
UPDATE Customer
SET surname='surname2.3' where name='Client 2.3';

commit;
UPDATE EMPLOYEE
SET surname='surname1' where name='Treballador 1';
UPDATE EMPLOYEE
SET surname='surname2' where name='Treballador 2';
UPDATE EMPLOYEE
SET surname='surname3' where name='Treballador 3';
commit;