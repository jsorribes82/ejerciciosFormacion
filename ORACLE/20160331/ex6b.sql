SET SERVEROUTPUT ON;
commit;

declare
  cursor Tprod_client_cur(id_cliente number) is select count(product_id) total from product_customer where customer_id=id_cliente;
  cursor vendedor_id_cur is select id from customer ;
  Tprod_client_cur_aux Tprod_client_cur%rowtype;
  vendedor_id_cur_aux vendedor_id_cur%rowtype;
  resultado number(5,2);
  Tprod number(8,2);
  Tprod_client number(8,2);
begin
   select count(product_id) into Tprod
   from product_customer ;
   open vendedor_id_cur;
    loop
      fetch vendedor_id_cur into vendedor_id_cur_aux.ID;
      
      exit when  (vendedor_id_cur%notfound);
      
      open Tprod_client_cur(vendedor_id_cur_aux.id);
        loop
          fetch Tprod_client_cur into Tprod_client_cur_aux.total;
          resultado:=0;
          Tprod_client:=Tprod_client_cur_aux.total;
          resultado:=(Tprod_client/Tprod)*100;
          --dbms_output.put_line('client'||vendedor_id_cur_aux.ID||'tant per cent: '||resultado||'%');
          UPDATE customer SET PRECENT_PRODUCT=resultado ,empleat_data=sysdate where id=vendedor_id_cur_aux.id;    
          exit when (Tprod_client_cur%notfound);
        end loop;
		close Tprod_client_cur;
	end loop;
	commit;
	 close vendedor_id_cur;
end;
     