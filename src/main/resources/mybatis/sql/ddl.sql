-- 1. oracle db인 경우
-- sys 에서 권한 부여
CREATE USER POP IDENTIFIED BY pop;
GRANT CONNECT, RESOURCE TO POP;

-- POP/pop@XE로 로그인한 후,
-- 회원정보 테이블 생성

-- 게시판 테이블 생성

-- 게시판 댓글 테이블 생성

-- 팝업스토어 테이블 생성

-- 굿즈스토어 테이블 생성

-- 굿즈 테이블 생성

-- 각 테이블 시퀀스 생성
CREATE SEQUENCE mno_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 99999999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE SEQUENCE bno_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE SEQUENCE cno_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE SEQUENCE sno_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE SEQUENCE pno_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE SEQUENCE rno_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

-- 임시로 팝업, 굿즈 테이블 데이터 생성(관리자 모드로 추후에 구현)
insert into pop (sno, sname, scon, simg, splc, sdate, scell, smedia, smap, sgimg)
values(sno_seq.nextval, '망그러진 곰과 비밀의 다락방','영등포 더현대에 있는 망그러진곰과 비밀의 다락방의 팝업을 즐겨보세요',
'/img/mango-2.png','영등포 더 현대','2024.07.25(목)~2024.08.07(수)','02-1010-1010',
'https://www.youtube.com/embed/P24x81R2xfA?si=hKLoWeiiSNEpedeU',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3164.237538564367!2d126.92585117568048!3d37.52589747204912!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b45c3d89d7801%3A0x7883571cabf15b8b!2z642U7ZiE64yAIOyEnOyauA!5e0!3m2!1sko!2skr!4v1721704219173!5m2!1sko!2skr', 'manggom-goods');

insert into pop (sno, sname, scon, simg, splc, sdate, scell, smedia, smap, sgimg)
values(sno_seq.nextval, '데드풀과 울버린','잠실 롯데월드몰에 있는 데드풀과울버린의 팝업을 즐겨보세요',
'/img/deadpool-2.png','잠실 롯데월드몰','2024.07.10(수)~2024.08.07(수)','02-1010-1010',
'https://www.youtube.com/embed/QB0sxysgMNA?si=uXITQxCtdhLmZKy9',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3164.758101226225!2d127.10153917567999!3d37.51362307205223!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca5a6567d2211%3A0x3f2975ea3640d4f4!2z66Gv642w7JuU65Oc66qw!5e0!3m2!1sko!2skr!4v1721704129908!5m2!1sko!2skr', 'deadfwolv-goods');

insert into pop (sno, sname, scon, simg, splc, sdate, scell, smedia, smap, sgimg)
values(sno_seq.nextval, '이토준지','홍대 LC타워몰에 있는 이토준지의 팝업을 즐겨보세요',
'/img/junji-2.png','잠실 롯데월드몰','2024.06.15(토)~2024.09.08(일)','02-0101-1212',
'https://www.youtube.com/embed/hIzY0njqNzI?si=FopZt6yCoGmOsA31',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3162.8869608583236!2d126.92358675579808!3d37.557726930229954!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c99f9b5a23bfd%3A0x3fc0a700f86f63b5!2zTEPtg4Dsm4w!5e0!3m2!1sko!2skr!4v1721704878275!5m2!1sko!2skr', 'ito-junji-goods');

insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-3 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '망곰키링1', 15000, '2024.07.25 ~ 2024.08.07', 10, 'mang-keyring1', '귀염뽀짝한 망곰키링을 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-3 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '망곰키링2', 13000, '2024.07.25 ~ 2024.08.07', 10, 'mang-keyring1', '귀염뽀짝한 망곰키링을 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-3 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '망곰키링3', 13000, '2024.07.25 ~ 2024.08.07', 10, 'mang-keyring1', '귀염뽀짝한 망곰키링을 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-3 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '망곰키링4', 15000, '2024.07.25 ~ 2024.08.07', 10, 'mang-keyring1', '귀염뽀짝한 망곰키링을 언능 사가세요 얼마안남았어요..!');

insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-2 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '데드풀 피규어', 30000, '2024.07.10 ~ 2024.08.07', 13, 'deadwolv-figure1', '섹시한 데드풀 피규어를 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-2 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '울버린 피규어', 30000, '2024.07.10 ~ 2024.08.07', 12, 'deadwolv-figure2', '섹시한 울버린 피규어를 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-2 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '데드풀과 울버린 목걸이', 20000, '2024.07.10 ~ 2024.08.07', 5, 'deadwolv-necklace', '데드풀과 울버린 목걸이를 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-2 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '데드풀과 울버린 티셔츠', 20000, '2024.07.10 ~ 2024.08.07', 3, 'deadwolv-tshirts', '데드풀과 울버린 티셔츠를 언능 사가세요 얼마안남았어요..!');

insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-1 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '이토준지 책상 매트', 20000, '2024.06.15 ~ 2024.09.08', 5, 'Itojunji-Desk-Matte-Lug', '오싹한 이토준지 책상 매트를 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-1 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '이토준지 아이폰 케이스', 15000, '2024.06.15 ~ 2024.09.08', 6, 'itojunji-iphone-case', '오싹한 이토준지 아이폰 케이스를 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-1 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '이토준지 머그컵', 25000, '2024.06.15 ~ 2024.09.08', 4, 'itojunji-mugcub', '오싹한 이토준지 머그컵을 언능 사가세요 얼마안남았어요..!');
insert into product(pno, sno, pname, pprice, pdate, pquan, pimg, pcon) values(pno_seq.nextval, (SELECT last_number-1 sno FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SNO_SEQ'), '이토준지 티셔츠', 30000, '2024.06.15 ~ 2024.09.08', 2, 'itojunji-tshirts', '오싹한 이토준지 티셔츠를 언능 사가세요 얼마안남았어요..!');