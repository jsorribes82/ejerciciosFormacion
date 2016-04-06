-- Buscar el trabajador con más clientes
-- Buscar el cliente de ese trabajador con más productos relacionados
-- Mostrar el nombre del cliente

declare
treballador_mes_clients varchar2(50);
client_mes_productes varchar2(50);

BEGIN
--treballador amb _mes_clients  
select c.employee_id --into treballador_mes_clients
    from employee e left outer join customer c 
      on c.employee_id=e.id 
    group by e.id,c.employee_id 
    having (select max(count(c.employee_id))  
      from employee e left outer join customer c 
        on (c.employee_id=e.id) 
        group by e.id, e.name)=count(c.employee_id);
        
--client amb mes productes
select  c.NAME --into client_mes_productes
  from PRODUCT_CUSTOMER pd left outer join CUSTOMER c
    on c.ID=pd.CUSTOMER_ID
  group by c.ID,c.NAME
  having count(c.id) = (select max(count(c.id))  
      from PRODUCT_CUSTOMER pd left outer join CUSTOMER c
        on c.ID=pd.CUSTOMER_ID
      group by c.ID);
dbms_output.put_line('el client amb mes productes es el: '||client_mes_productes);
end;
