* SQL 설정(오라클)

create SEQUENCE seq_board;

create table tbl_board(
    bno number(10,0),
    title VARCHAR2(200) not null,
    content VARCHAR2(2000) not null,
    writer VARCHAR2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate
);

alter table tbl_board add CONSTRAINT pk_board
PRIMARY key(bno);

desc tbl_board;

insert into tbl_board(bno, title, content, writer)
values(seq_board.nextval, '홍길동전' , '도둑이야기', '허균');