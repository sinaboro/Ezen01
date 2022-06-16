***********환경
1. windows10
2. sts(Version: 3.9.17.RELEASE)
3. tomcat9.0
4. oracle11g
5. lombok(lombok-1.18.24.jar)
6. jstl.jar
7. standard.jar
8. ojdbc6.jar



***********DB
select * from board;
delete board where num=26;
commit;
delete from board where num=23;
desc board;

create table employees(
    id varchar2(10) not null PRIMARY key,
    pass varchar2(10) not null,
    name varchar2(20),
    lev char(1) default 'A',
    enter date DEFAULT sysdate,
    gender char(1) DEFAULT 1,
    phone varchar2(30)    
);

insert into employees values('pingsunk', '1234', '성윤정','A', sysdate,'2','010-2222-3333');
insert into employees values('subin', '1234', '박윤정','B', sysdate,'1','010-2222-3333');
insert into employees values('hong', '1234', '엄윤정','C', sysdate,'1','010-2222-3333');
insert into employees values('park', '1234', '윤윤정','A', sysdate,'2','010-2222-3333');
commit;
select * from EMPLOYEES;

**********특징
dbcp : 
<Resource auth="Container"
						driverClassName="oracle.jdbc.OracleDriver" maxIdle="10"
						maxTotal="20" maxWaitMillis="-1" name="jdbc/myoracle"
						password="tiger" type="javax.sql.DataSource"
						url="jdbc:oracle:thin:@127.0.0.1:1521:xe" username="scott" />
