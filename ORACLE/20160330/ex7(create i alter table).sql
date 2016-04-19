--7. Cread los scripts necesarios para añadir 
--las dos tablas que faltan al schema para igualarlo con el modelo de la imagen

create table product_customer
  (product_id int not null,
  customer_id int not null,
  creation_date date not null,
  primary key (product_id, customer_id),
  foreign key (customer_id) references customer(id),
  foreign key (product_id) references product(id));
drop table product_customer;
drop  table product;
--corregit
create table product(
	id number(8),
	name varchar2(50) not null,
	description varchar2(500)
	);
alter table product add constraint pk_product
	primary key(id)
	using index;
  
create table product(
  id int,
  name varchar2(50),
  description varchar2(500),
  primary key (id)
   );
   
--corregit  
 create table product_customer
  (product_id number(8) not null,
  customer_id number(8) not null,
  creation_date date not null,
  );  
  alter table product_customer add constraint pk_product_customer
	primary key(product_id, customer_id)
	using index;