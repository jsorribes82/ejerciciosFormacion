--8. Inicializad las dos tablas con al menos 10 registros cada una.
--	- TIP: Se pueden utilizar secuencias


CREATE SEQUENCE incremento_id_producto
INCREMENT BY 1
START WITH 1;

--crear sequencia anterior que empiece en 300
drop incremento_id_producto
CREATE SEQUENCE incremento_id_producto
INCREMENT BY 300
START WITH 1;

CREATE SEQUENCE incremento_id_customer
INCREMENT BY 1
START WITH 1;
CREATE SEQUENCE quesos
INCREMENT BY 1
START WITH 1;
commit;
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
insert into product(id, name, description) values (incremento_id_producto.NEXTVAL, concat('queso', TO_CHAR(quesos.NEXTVAL)), concat('queso de la valle de aran', TO_CHAR(quesos.NEXTVAL)));
select * from product
select * from customer
insert into product_customer(product_id, customer_id, creation_date) values (61, 24, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (62, 24, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (62, 24, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (61, 24, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (63, 24, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (64, 25, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (65, 25, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (66, 25, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (67, 25, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (68, 25, TO_DATE('01/07/1996','DD/MM/YYYY'));
insert into product_customer(product_id, customer_id, creation_date) values (69, 25, TO_DATE('01/07/1996','DD/MM/YYYY'));