drop table member1 cascade constraints;

CREATE TABLE MEMBER1(
MEMBER_ID   VARCHAR2(15)    PRIMARY KEY,
MEMBER_PW   VARCHAR2(15)    NOT NULL,
MEMBER_NAME VARCHAR2(21)    NOT NULL,
AGE         NUMBER          NOT NULL,
EMAIL       VARCHAR2(30)    NOT NULL,
PHONE       CHAR(11)        NOT NULL,
ADDRESS     VARCHAR2(100)   NOT NULL,
ENROLL_DATE DATE            DEFAULT SYSDATE
);

INSERT INTO MEMBER1 VALUES ('admin','1234','관리자',20,'admin@kh.or.kr','01011112220','서울',default);
INSERT INTO MEMBER1 VALUES ('user01','1234','유저1',20,'user1@kh.or.kr','01011112221','서울',default);
INSERT INTO MEMBER1 VALUES ('user02','1234','유저2',20,'user2@kh.or.kr','01011112222','대전',default);
INSERT INTO MEMBER1 VALUES ('user03','1234','유저3',20,'user3@kh.or.kr','01011112223','대구',default);
INSERT INTO MEMBER1 VALUES ('user04','1234','유저4',20,'user4@kh.or.kr','01011112224','부산',default);
INSERT INTO MEMBER1 VALUES ('user05','1234','유저5',20,'user5@kh.or.kr','01011112225','찍고',default);
INSERT INTO MEMBER1 VALUES ('user06','1234','유저6',20,'user6@kh.or.kr','01011112226','찍고',default);
INSERT INTO MEMBER1 VALUES ('user07','1234','유저7',20,'user7@kh.or.kr','01011112227','찍고',default);
INSERT INTO MEMBER1 VALUES ('user08','1234','유저8',20,'user8@kh.or.kr','01011112228','찍고',default);
INSERT INTO MEMBER1 VALUES ('user09','1234','유저9',20,'user9@kh.or.kr','01011112229','찍고',default);
INSERT INTO MEMBER1 VALUES ('user10','1234','유저10',20,'user10@kh.or.kr','01011112230','아하',default);
INSERT INTO MEMBER1 VALUES ('user11','1234','유저11',20,'user11@kh.or.kr','01011112231','아하',default);
INSERT INTO MEMBER1 VALUES ('user12','1234','유저12',20,'user12@kh.or.kr','01011112232','대전',default);
INSERT INTO MEMBER1 VALUES ('user13','1234','유저13',20,'user13@kh.or.kr','01011112233','대구',default);
INSERT INTO MEMBER1 VALUES ('user14','1234','유저14',20,'user14@kh.or.kr','01011112234','부산',default);
INSERT INTO MEMBER1 VALUES ('user15','1234','유저15',20,'user15@kh.or.kr','01011112235','찍고',default);
INSERT INTO MEMBER1 VALUES ('user16','1234','유저16',20,'user16@kh.or.kr','01011112236','찍고',default);
INSERT INTO MEMBER1 VALUES ('user17','1234','유저17',20,'user17@kh.or.kr','01011112237','아하',default);
INSERT INTO MEMBER1 VALUES ('user18','1234','유저18',20,'user18@kh.or.kr','01011112238','아하',default);
INSERT INTO MEMBER1 VALUES ('user19','1234','유저19',20,'user19@kh.or.kr','01011112239','아하',default);
INSERT INTO MEMBER1 VALUES ('user20','1234','유저20',20,'user20@kh.or.kr','01011112240','아하',default);
INSERT INTO MEMBER1 VALUES ('user21','1234','유저21',20,'user21@kh.or.kr','01011112241','아하',default);
INSERT INTO MEMBER1 VALUES ('user22','1234','유저22',20,'user22@kh.or.kr','01011112242','대전',default);
INSERT INTO MEMBER1 VALUES ('user23','1234','유저23',20,'user23@kh.or.kr','01011112243','대구',default);
INSERT INTO MEMBER1 VALUES ('user24','1234','유저24',20,'user24@kh.or.kr','01011112244','부산',default);
INSERT INTO MEMBER1 VALUES ('user25','1234','유저25',20,'user25@kh.or.kr','01011112245','찍고',default);
INSERT INTO MEMBER1 VALUES ('user26','1234','유저26',20,'user26@kh.or.kr','01011112246','찍고',default);
INSERT INTO MEMBER1 VALUES ('user27','1234','유저27',20,'user27@kh.or.kr','01011112247','아하',default);
INSERT INTO MEMBER1 VALUES ('user28','1234','유저28',20,'user28@kh.or.kr','01011112248','아하',default);
INSERT INTO MEMBER1 VALUES ('user29','1234','유저29',20,'user29@kh.or.kr','01011112249','아하',default);
INSERT INTO MEMBER1 VALUES ('user30','1234','유저30',20,'user30@kh.or.kr','01011112250','아하',default);
INSERT INTO MEMBER1 VALUES ('user31','1234','유저31',20,'user31@kh.or.kr','01011112251','아하',default);
INSERT INTO MEMBER1 VALUES ('user32','1234','유저32',20,'user32@kh.or.kr','01011112252','대전',default);
INSERT INTO MEMBER1 VALUES ('user33','1234','유저33',20,'user33@kh.or.kr','01011112253','대구',default);
INSERT INTO MEMBER1 VALUES ('user34','1234','유저34',20,'user34@kh.or.kr','01011112254','부산',default);
INSERT INTO MEMBER1 VALUES ('user35','1234','유저35',20,'user35@kh.or.kr','01011112255','찍고',default);
INSERT INTO MEMBER1 VALUES ('user36','1234','유저36',20,'user36@kh.or.kr','01011112256','찍고',default);
INSERT INTO MEMBER1 VALUES ('user37','1234','유저37',20,'user37@kh.or.kr','01011112257','아하',default);
INSERT INTO MEMBER1 VALUES ('user38','1234','유저38',20,'user38@kh.or.kr','01011112258','아하',default);
INSERT INTO MEMBER1 VALUES ('user39','1234','유저39',20,'user39@kh.or.kr','01011112259','아하',default);
INSERT INTO MEMBER1 VALUES ('user40','1234','유저40',20,'user40@kh.or.kr','01011112260','아하',default);

commit;

select * from member1;
select count(*) cnt from member1 where member_name like ('%유저%');

-- 1.MEMBER_ID를 기준으로 정렬하여 전부 나오는 Query--
select * from member1 order by member_id;
-- 1에 ROWNUM 붙여줌(index 붙이기 위해)--
select rownum as rnum, m1.* from (select * from member1 order by member_id) m1;
-- rnum을 기준으로 원하는 페이지의 시작과 끝까지의 tuple를 조회
select * from(select rownum as rnum, m1.* from(select * from member1 order by member_id) m1) where rnum between 11 and 15;

select * from(select rownum as rnum, m.* from(select * from member1 where member_name like '%유저%' order by member_id) m) where (rnum between 6 and 10);
