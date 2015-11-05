create user app IDENTITY  by 'app_password';
create database sca;
grant all PRIVILEGES on sca_db.* to app;
CREATE TABLE sca_db.Student
(
  id char(255) PRIMARY KEY NOT NULL,
  GivenName CHAR(255) NOT NULL,
  LastName CHAR(255) NOT NULL
);

insert into sca_db.Student(id, GivenName, LastName) VALUES ('abekeb1', 'abebe', 'kebede');

