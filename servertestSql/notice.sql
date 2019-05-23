select * from member1;
create table notice(
notice_no       number primary key,
notice_title    varchar2(100) not null,
notice_author   varchar2(15) not null,
notice_content  varchar2(4000) not null,
notice_date     date default sysdate,
filename        varchar2(300),
filepath        varchar2(300), 
--파일이름과 파일 경로를 동시에 입력하는 이유 : 여러 명이 쓰는 경우, 오버라이팅 되는걸 방지하기 위해--
constraint      fk_notice_author foreign key (notice_author) references member1 (member_id)
);
create sequence seq_notice_no;

insert into notice values (seq_notice_no.nextval,'NOTICE TEST','admin','test notice content',sysdate,null,null);
insert into notice values (seq_notice_no.nextval,'회식 공지','admin','test notice contentㅁㄴㅇ러ㅣㅁ닝ㄹㅁㅈㄷ',sysdate,null,null);
commit;
rollback;
select * from notice;
delete from notice where notice_no=1;

select * from(select rownum as rnum, n.* from(select * from notice order by notice_no desc) n) where rnum between 6 and 10; 