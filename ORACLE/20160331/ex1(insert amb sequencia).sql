CREATE SEQUENCE seq_product
INCREMENT BY 1
START WITH 1;
commit;
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);

select * from product
