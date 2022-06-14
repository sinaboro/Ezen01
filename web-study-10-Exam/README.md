* 환경

* DBbase
create table movie(
    code number(4) primary key,
    Title varchar2(50) not null,
    price number(10) ,
    director varchar2(20),
    actor varchar2(20),
    poster varchar2(100),
    synopsis varchar2(3000)
);

create SEQUENCE movie_seq start with 1 INCREMENT by 1;

insert into movie values(movie_seq.nextval, '베를린', 10000, '하정우', '류승환', '1','2012년 제작, 2013년에 개봉한 한국 영화. 류승완 감독의 작품. 베를린에서 남·북간 첩보전을 소재로 했다.' );
insert into movie values(movie_seq.nextval, '마녀', 11000, '김다미', '박훈정', '1','10년 전 의문의 사고가 일어난 시설에서 홀로 탈출한 후 모든 기억을 잃은 자윤' );
insert into movie values(movie_seq.nextval, '백수건달', 12000, '김다미', '박훈정', '1','10년 전 의문의 사고가 일어난 시설에서 홀로 탈출한 후 모든 기억을 잃은 자윤' );
insert into movie values(movie_seq.nextval, '레미제라블', 13000, '김다미', '박훈정', '1','10년 전 의문의 사고가 일어난 시설에서 홀로 탈출한 후 모든 기억을 잃은 자윤' );
insert into movie values(movie_seq.nextval, '7번방선물', 14000, '김다미', '박훈정', '1','10년 전 의문의 사고가 일어난 시설에서 홀로 탈출한 후 모든 기억을 잃은 자윤' );
commit;

select * from movie;
