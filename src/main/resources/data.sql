insert into TB_STATE (NAME) values ('SP');
insert into TB_STATE (NAME) values ('MG');

insert into TB_CITY (NAME, STATE_ID) values ('São Paulo', 1);
insert into TB_CITY (NAME, STATE_ID) values ('Guarulhos', 1);
insert into TB_CITY (NAME, STATE_ID) values ('Franca', 1);

insert into TB_USER (CPF, CITY_ID, ADDRESS, NAME) values ('11122233344', 1, 'Rua 1', 'Pessoa 1');
insert into TB_USER (CPF, CITY_ID, ADDRESS, NAME) values ('11122233355', 1, 'Rua 2', 'Pessoa 2');
insert into TB_USER (CPF, CITY_ID, ADDRESS, NAME) values ('11122233366', 2, 'Rua 3', 'Pessoa 3');

insert into TB_PRODUCT (NAME) values ('Teclado');
insert into TB_PRODUCT (NAME) values ('Mouse');

insert into TB_SALE (PRODUCT_ID, QUANTITY, SALE_VALUE, PAYMENT_METHOD, USER_ID, SALE_DATE_TIME) values (1, 2, 100.5, 'DEBIT', 1, '2022-11-17 12:30:00.0');
insert into TB_SALE (PRODUCT_ID, QUANTITY, SALE_VALUE, PAYMENT_METHOD, USER_ID, SALE_DATE_TIME) values (2, 4, 50.5, 'PIX', 1, '2022-11-17 15:30:00.0');
insert into TB_SALE (PRODUCT_ID, QUANTITY, SALE_VALUE, PAYMENT_METHOD, USER_ID, SALE_DATE_TIME) values (1, 3, 100.5, 'CREDIT', 2, '2022-11-17 12:30:00.0');
insert into TB_SALE (PRODUCT_ID, QUANTITY, SALE_VALUE, PAYMENT_METHOD, USER_ID, SALE_DATE_TIME) values (1, 10, 100.5, 'DEBIT', 3, '2022-11-17 12:30:00.0');
