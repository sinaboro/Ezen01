create user book IDENTIFIED by book
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp;

grant CONNECT, dba to book;