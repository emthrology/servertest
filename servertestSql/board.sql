drop table board cascade constraints;

create table board(
board_no        number          primary key,
category        varchar2(30)    not null,
board_author    varchar2(15)    not null,
board_title     varchar2(100)   not null,
board_content   varchar2(4000)  not null,
filepath        varchar2(100),
viewcount       number          not null,
board_date      date            default sysdate,
constraint fk_board_author foreign key (board_author) references member1 (member_id) on delete set null
);

drop sequence seq_board_no;
create sequence seq_board_no;

insert into board values(seq_board_no.nextval, '뻘글', 'user01', '게시판 테스트1', '게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 ', null, 0, sysdate);
insert into board values(seq_board_no.nextval, '유머', 'user02', '유머글 테스트2', '게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 ', null, 0, sysdate);
insert into board values(seq_board_no.nextval, '진지', 'user03', '게시판 테스트3', '게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 게시판 테스트 내용 ', null, 0, sysdate);

select * from board;


rollback;
commit;