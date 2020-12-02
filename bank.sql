create or replace type address as Object(
  address varchar(50),
  nationality varchar(50),
  district varchar(50),
  branch varchar(50)
);

create or replace type userinfo as Object(
  firstname varchar(50),
  middlename varchar(50),
  lastname varchar(50),
  gender varchar(50),
  phone_no varchar(50),
  occupation varchar(50),
  photo varchar(50)
);

create table account(
  account_no number primary key,
  userinfo userinfo,
  addressinfo address,
  account_type varchar(50),
  balance number,
  empid int,
  dates varchar(50),
  status int
);

create table employee(
  id number generated by default on null as IDENTITY,
  userinfo userinfo,
  addressinfo address,
  dates varchar(50),
  status int
);

create table login(
account_no number not null primary key,
username varchar(50) not null,
password varchar(20) not null,
role varchar(20) not null);

create or replace TYPE withdraw AS OBJECT(
	account_no int,
  amount int,
	dates varchar(50),
	emp_id int,
	amount2 varchar(50)
);

create table withdraw_info(
  info withdraw
);

create or replace TYPE deposite AS OBJECT(
	amount int,
	amount2 varchar(50),
	r_account_no number,
	s_account_no number,
	branch varchar(50),
	s_phone_no varchar(50),
	dates varchar(50),
	role varchar(50)
)

create table deposite_info (
  info deposite
);

INSERT INTO deposite_info (INFO) VALUES (DEPOSITE(1001, "two hundred", 1225, 1125, "bole", "09586874", "12.2568", "advicer"));

create table transfer (
  id number not null primary key,
	s_branch varchar(50),
	s_firstname varchar(50),
	s_middlename varchar(50),
	s_lastname varchar(50),
	s_address varchar(50),
	amount int,
	amount2 varchar(50),
	dates varchar(50),
	r_firstname varchar(50),
	r_middlename varchar(50),
	r_lastname varchar(50),
	r_address varchar(50),
	r_phone varchar(50),
	r_branch varchar(50),
	emp_id int,
	status int
);


create or replace procedure accdeposite(vamount int, vamount2 varchar, vraccount number,
vsaccount number, vbranch varchar, vsphone varchar, vdates varchar, 
vemp varchar) AS 
BEGIN
INSERT INTO DEPOSITE_INFO (INFO) VALUES (DEPOSITE(vamount, vamount2, vraccount, vsaccount, vbranch, vsphone, vdates, vemp));
UPDATE baccount SET balance = balance + vamount WHERE account_no=vraccount;
UPDATE baccount SET balance = balance - vamount WHERE account_no=vsaccount;
COMMIT;
END;


create or replace procedure selfdeposite(vamount int, vamount2 varchar, vraccount number,
vsaccount number, vbranch varchar, vsphone varchar, vdates varchar, 
vemp varchar) AS 
BEGIN
INSERT INTO DEPOSITE_INFO (INFO) VALUES (DEPOSITE(vamount, vamount2, vraccount, vsaccount, vbranch, vsphone, vdates, vemp));
UPDATE baccount SET balance = balance + vamount WHERE account_no=vraccount;
COMMIT;
END;

create or replace procedure withdrawadd(vaccount number, vamount int, vdates varchar, vemp varchar, vamount2 varchar) AS 
BEGIN
INSERT INTO WITHDRAW_INFO (INFO) VALUES (WITHDRAW(vaccount, vamount, vdates, vemp, vamount2));
UPDATE baccount SET balance = balance - vamount WHERE account_no=vaccount;
COMMIT;
END;

create or replace procedure transferconfirm(cnumber number, empId number, vdates varchar) AS
BEGIN
INSERT INTO transfered (select * from transfer where id=cnumber);
UPDATE transfered SET emp_id = empId, dates = vdates,status=1 where id=cnumber;
delete from transfer where id = cnumber;
COMMIT;
END;

create or replace procedure createaccount(vaccount_no number, vuser userinfo, vaddress address,
vaccount_type varchar, vbalance number, vempid number, vdates varchar, vstatus varchar) AS
BEGIN
INSERT INTO laccount (account_no, userinfo, addressinfo, account_type) values (vaccount_no, vuser, vaddress, vaccount_type);
INSERT INTO baccount (account_no, balance, empid, dates, status) values (vaccount_no, vbalance, vempid, vdates, vstatus);
COMMIT;
END;

create or replace procedure createemployee(vid number, vuser userinfo, vaddress address, vdates varchar, vstatus number) AS
BEGIN
INSERT INTO lemployee (id, userinfo, addressinfo) values (vid, vuser, vaddress);
INSERT INTO bemployee (id, dates, status) values (vid, vdates, vstatus);
COMMIT;
END;

show error;
exec createemployee(userinfo('Mohammed','Ousman', 'Abdu','M','0925687495','Ass Manager',''), address('LA','USA','fjalfja','fjalfjal'),'12/56/2005',1);

exec depositeadd(400, 'Four hundered birr', 1001, 2571, '4 killo', '0985698745', '2/26/2020', 'teller');


CREATE PUBLIC DATABASE LINK Link2Server CONNECT TO bankdb2 Identified by bank2 using 'CN2SERVER';

select * from bankdb2.login@link2server;

create or replace view normal_account as (select * from account where account_type='N');
create or replace view free_account as (select * from account where account_type='F');

show error;

select e.info.firstname from employee_info@link2server e;

select * from all_users@link2server;

--Horizontal fragmentation

create synonym client_login for bankdb2.login@link2server;

select * from client_login;

insert into client_login (account_no, username, password, role) values (1361, 'mawlid', '123456', 'client');

create view login_info as select * from login union select * from client_login;

select * from login_info;

select * from transfer@link2server;

create synonym transfered for transfer@link2server;

create view all_transaction as select * from transfer union select * from transfered;

select * from all_transaction;

select * from transfered;
select * from transfer;
delete from transfered;

insert into transfer (select * from transfered);

select * from employee@link2server;
select * from account@link2server;

--Horizontal fragmentation

create synonym baccount for account@link2server;

insert into baccount (select account_no, balance, empid, dates, status from laccount);

select * from baccount;

select * from laccount;

alter table laccount drop column status;

create view account as select la.account_no as account_no, la.userinfo as userinfo, la.addressinfo as addressinfo, la.account_type as account_type,
ba.balance as balance, ba.empid as empid, ba.dates as dates, ba.status as status from laccount la, baccount ba where la.account_no = ba.account_no; 

select * from account;

--Horizontal fragmentation
select * from employee@link2server;

create synonym bemployee for employee@link2server;

create view employee as select le.id as id, le.userinfo as userinfo, le.addressinfo as addressinfo, be.dates as dates, be.status as status
from lemployee le, bemployee be where le.id = be.id;

select * from bemployee;
delete from bemployee;
alter table lemployee modify (id number  primary key);

select * from login;

select * from lemployee;