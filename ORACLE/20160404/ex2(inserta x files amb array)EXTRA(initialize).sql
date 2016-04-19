	create or replace procedure INITIALIZE(num_empleats number, client_Array varray, producte_array varray) as
        id_cust number(8);
        id_empl number(8);
        id_prod number(8);
	begin
         for conta in 1..num_empleats   
         loop
            id_cust:=seq_customer.nextval;
            id_empl:=seq_employee.nextval;
            id_prod:=seq_product.nextval;
            insert into EMPLOYEE(id, name, date_of_birth) values (id_empl, 'empleado ' ||conta, TO_DATE('01/07/1996','DD/MM/YYYY'));
            insert into customer(id, name, employee_id) values (id_cust, 'cliente '||conta, id_empl);
            insert into PRODUCT(id,name,description) values (id_prod,'name '||id_prod, 'description ' ||id_prod);
            insert into product_customer(product_id, customer_id, creation_date) values (id_prod, id_empl, TO_DATE('01/07/1996','DD/MM/YYYY'));
            --dbms_output.put_line(conta||'   '||id_empl||'   '||id_cust||'   '||id_prod);
          end loop;
        
      end;
