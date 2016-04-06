--La empresa quiere tener disponibles como datos de empleado, el porcentaje de clientes que gestiona ese empleado del total de la compañía, 
 --y como dato de cliente el porcentaje de productos que compra del total que ofrece la compañía.

--Quieren una validez de datos diaria y quieren actualizar los datos con un bloque PLSQL.
	-- Necesitan un campo PERCENT_CUSTOMER en la tabla EMPLOYEE
	-- Necesitan un campo PRECENT_PRODUCT en la tabla CUSTOMER
	-- Necesitan un bloque PLSQL que calcule y actualice los datos diariamente
  
alter table employee
drop Column clien_data ;

alter table employee
drop Column PERCENT_CUSTOMER;

alter table CUSTOMER
drop Column PRECENT_PRODUCT;

alter table CUSTOMER
drop Column empleat_data;

alter table employee
add (PERCENT_CUSTOMER number(5,2),clien_data date);

alter table CUSTOMER
add (PRECENT_PRODUCT number(5,2), empleat_data date);

SET SERVEROUTPUT ON;
commit;

declare
  cursor Tclient_empl_cur(id_empleado number) is select count(id) total from customer where employee_id=id_empleado;
  cursor Empleado_id_cur is select id from employee ;
  Tclient_empl_cur_aux Tclient_empl_cur%rowtype;
  Empleado_id_cur_aux Empleado_id_cur%rowtype;
  resultado number(5,2);
  Tclient number(8,2);
  Tclient_empl number(8,2);
begin
   select count(id) into Tclient
  from customer ;
  open Empleado_id_cur;
    loop
      fetch Empleado_id_cur into Empleado_id_cur_aux.ID;
      
      exit when  (Empleado_id_cur%notfound);
      
      open Tclient_empl_cur(Empleado_id_cur_aux.id);
        loop
          fetch Tclient_empl_cur into Tclient_empl_cur_aux.total;
          Tclient_empl:=Tclient_empl_cur_aux.total;
          resultado:=(Tclient_empl/Tclient)*100;
          dbms_output.put_line('empleat'||Empleado_id_cur_aux.ID||'tant per cent: '||resultado||'%');
          UPDATE employee SET PERCENT_CUSTOMER=resultado ,clien_data=sysdate where id=Empleado_id_cur_aux.id;    
          exit when (Tclient_empl_cur%notfound);
          --dbms_output.put_line('empleat'||Empleado_id_cur_aux.ID||'tant per cent: '||resultado||'%');
        end loop;
        close Tclient_empl_cur;
     end loop;
  close Empleado_id_cur;
end;