create table photo(
photo_no        number primary key,
photo_author    varchar2(15) not null,
photo_content   varchar2(2000),
filename        varchar2(100),
photo_date      date default sysdate,
constraint fk_photo_author foreign key (photo_author) references member1 (member_id) on delete set null
);

create sequence seq_photo_no;
commit;
select * from photo;