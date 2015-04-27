INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES ('Houdeeh', 'How', '1980-04-19');
INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES ('Samurai', 'Jhon', '1970-04-11');
INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES ('Samuel L', 'Jackson', '1968-01-11');
INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES ('Alex', 'Monson', '1968-01-21');
INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES ('Joshua', 'Jackson', '1911-11-11');

----------------------------------------------------------------------------------------------------------------
insert into contact_tel_detail (contact_id, tel_type, tel_number) values (1, 'Mobile', '1234567890');
insert into contact_tel_detail (contact_id, tel_type, tel_number) values (1, 'Home', '1234567890');
insert into contact_tel_detail (contact_id, tel_type, tel_number) values (2, 'Home', '1234567890');
commit;
