drop table notice_comment cascade constraints;
create table notice_comment(
notice_comment_no       number primary key, -- 댓글 번호,primary key --
notice_comment_level    number default 1,   -- 댓글인지 대댓글인지 구분 --
notice_comment_author   varchar2(15),       -- 댓글 쓴 사람(외래키 : member_id) --
notice_comment_content  varchar2(2000),     -- 댓글 내용 --
notice_ref              number,             -- 댓글을 단 글의 번호(외래키 : notice_no) --
notice_comment_ref      number,             -- 대댓글을 단 댓글의 번호(외래키 : notice_comment_ref) --
notice_comment_date     date default sysdate,-- 댓글을 단 날짜 --
constraint              fk_notice_ref foreign key (notice_ref) references notice(notice_no) on delete cascade,--부모글이 지워지면 댓글도 지워짐--
constraint              fk_notice_comment_author FOREIGN key (notice_comment_author) references member1 (member_id) on delete set null, --댓글지워지면 댓글 작성자를 null로--
constraint              fk_notice_comment_ref foreign key (notice_comment_ref) references notice_comment(notice_comment_no) on delete cascade -- 댓글 지워지면 대댓글도 같이 지워짐 --
);
create sequence seq_notice_comment_no;
insert into notice_comment values(seq_notice_comment_no.nextval, 2,'admin','대댓글 테스트','48',1,default);
drop sequence seq_notice_comment_no;


select * from notice_comment;
commit;