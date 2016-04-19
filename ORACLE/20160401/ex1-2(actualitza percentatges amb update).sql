--no funciona quan cridem a la funció percent_cliente
create or replace procedure ACTUALIZA_PORCE_prod as
		cursor clients_cur is 
            select *  
              from customer; 
    vari22 number(8,2);          
		clients_cur_aux clients_cur%rowtype;
		begin
			
			open clients_cur;
			loop
				fetch clients_cur into clients_cur_aux;
				exit when  (clients_cur%notfound);
        vari22:=Percent_cliente(clients_cur_aux.ID);
				dbms_output.put_line('empleat'||clients_cur_aux.ID||'tant per cent: '||vari22||'%');
				--UPDATE employee SET PERCENT_CUSTOMER=resultado ,clien_data=sysdate where id=Empleado_id_cur_aux.id; 
			end loop;
			commit;
			close clients_cur;
		end;
    
create or replace function PRECENT_cliente(id_cliente in number) return number is
      
	  Tproduct number(8);
	  TproductporClient number(8);
	  resultado number(8);
	  begin
      select count(product_id) into TproductporClient
        from product_customer where id_cliente=customer_id;
      select count(id) into Tproduct
        from product;
      resultado:=(TproductporClient/Tproduct)*100;
      return resultado;
	  end;
    