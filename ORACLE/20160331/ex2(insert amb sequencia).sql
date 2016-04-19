drop sequence incremento_id_producto
CREATE SEQUENCE incremento_id_producto
INCREMENT BY 1
START WITH 1;
commit;
CREATE SEQUENCE seq_product
INCREMENT BY 1
START WITH 1;

insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, 'producto' ||seq_product.nextval,'descripcion' ||seq_product.nextval);
