delete from product_customer;
delete from product;
commit;

--or

alter table product_customer remove constraint pk_product;
	--or
alter table product_customer disable constraint pk_product;
	
	
