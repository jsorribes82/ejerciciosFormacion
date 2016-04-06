--no funciona el package... per separat si que funciona
create or replace package PACK_EMPLOYEE as
	procedure ACTUALIZA_PORCENTAJES_empleat();
	function TOTAL_clientes(id_empleado number(8));
end PACK_EMPLOYEE;


/
create or replace package body PACK_EMPLOYEE as

create or replace function TOTAL_clientes(id_empleado in number) return number is
			 Tclient_por_empl number(8,2);
			  											
			begin
				select count(id) into Tclient_por_empl 
					from customer where employee_id=id_empleado;
				return Tclient_por_empl;
			end;
      

	create or replace procedure ACTUALIZA_PORCENTAJES_empleat as
		cursor Empleado_id_cur(id_empleado number) is 
            select count(id) total 
              from customer 
              where employee_id=id_empleado;
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
				Tclient_empl:=TOTAL_clientes(Empleado_id_cur_aux.id);
				resultado:=(Tclient_empl/Tclient)*100;
				dbms_output.put_line('empleat'||Empleado_id_cur_aux.ID||'tant per cent: '||resultado||'%');
				UPDATE employee SET PERCENT_CUSTOMER=resultado ,clien_data=sysdate where id=Empleado_id_cur_aux.id; 
			end loop;
			commit;
			close Empleado_id_cur;
		end;
      
end PACK_EMPLOYEE;
