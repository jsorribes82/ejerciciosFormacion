-- Mostrar, para cada trabajador:
			-- Nombre del trabajador: <NOMBRE>
			-- Apellido del trabajador: <APELLIDO>
			-- -Lista de clientes:
				-- <cliente1>
				-- <cliente2>
SET SERVEROUTPUT ON;
commit;

declare
  cursor clientes_cur is select * from CUSTOMER ;
  cursor empleat_cur is select * from employee;
  client_aux customer%rowtype;
  empleat_aux employee%rowtype;
  num_temp number(8);
  
begin
  open clientes_cur;
  open empleat_cur;
  
  
  loop
    fetch empleat_cur into empleat_aux;
    exit when empleat_cur%notfound;
    dbms_output.put_line('nom empleat: '||empleat_aux.name ||'     cognom empleat: '||empleat_aux.surname );
    dbms_output.put_line('nom clients: ');
    loop
        fetch clientes_cur into client_aux;
        exit when (empleat_aux.id<>client_aux.employee_id)or(clientes_cur%notfound);
        dbms_output.put_line(client_aux.name);
        end loop;
      
  end loop;
  close empleat_cur;
  close clientes_cur;

end;

