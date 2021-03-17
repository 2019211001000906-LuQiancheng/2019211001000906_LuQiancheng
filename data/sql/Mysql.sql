create DATABASE userdb;
use userdb;
CREATE TABLE usertable(
  id int(10) auto_increment PRIMARY KEY,
  username varchar(50) not null,
  password varchar(20) not null,
  email varchar(20)not NULL,
  gender varchar(10),
  birthdate date
);