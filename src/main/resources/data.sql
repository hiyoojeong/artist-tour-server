insert into "user" (username, password, email, name, nickname) values ('admin', '$2a$10$e4AJU2Rt9X71sOoM2HIfdevDDhhyqpxBQBk38rVm57nklqqif1fkW', 'hiyoojeong@gmail.com', '조유정', '조머정');

-- user
insert into "user" (username, password, email, name, nickname) values ('1', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '1', '사용자1', '사용자1');
insert into "user" (username, password, email, name, nickname) values ('2', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '2', '사용자2', '사용자2');
insert into "user" (username, password, email, name, nickname) values ('3', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '3', '사용자3', '사용자3');
insert into "user" (username, password, email, name, nickname) values ('4', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '4', '사용자4', '사용자4');
insert into "user" (username, password, email, name, nickname) values ('5', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '5', '사용자5', '사용자5');
insert into "user" (username, password, email, name, nickname) values ('6', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '6', '사용자6', '사용자6');
insert into "user" (username, password, email, name, nickname) values ('7', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '7', '사용자7', '사용자7');
insert into "user" (username, password, email, name, nickname) values ('8', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '8', '사용자8', '사용자8');
insert into "user" (username, password, email, name, nickname) values ('9', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '9', '사용자9', '사용자9');
insert into "user" (username, password, email, name, nickname) values ('10', '$2a$10$FmNjOy.hhrCpdXGRItCn4etLPYo/ndBid1WoOIALBy6UnlOoZ0LMa', '10', '사용자10', '사용자10');

-- artist
insert into artist (name, maker_id) values ('BTS', 1);
insert into artist (name, maker_id) values ('블랙핑크', 1);
insert into artist (name, maker_id) values ('아이유', 1);
insert into artist (name, maker_id) values ('에스파', 1);

-- place
insert into place (artist_id, maker_id, name, address, latitude, longitude, date, content) values (1, 1, '부산 수영구 광안해변로 219', '2022년 10월 15일 21:00', 37.532600, 127.024612, '2023-10-15 21:00:00', 'BTS의 2030 부산세계박람회 유치 기원 콘서트를 축하하는 [광안리 M 드론라이트쇼]가 개최된다.
매주 토요일마다 오후 7시, 9시에 진행되는 드론 행사이며 주제는 매번 바뀐다고 한다.
BTS의 부산 콘서트를 축하하기 위해 15일 9시 드론쇼 주제가 BTS로 선정되었다.');
insert into place (artist_id, maker_id, name, address, latitude, longitude, date, content) values (1, 1, '서울시청 옆', '서울시 어쩌구 어쩐동 2', 37.532700, 127.024712, '2023-10-15 21:00:00', '서울에서 BTS의 첫 번째 콘서트가 개최된다.');
insert into place (artist_id, maker_id, name, address, latitude, longitude, date, content) values (1, 1, '서울시청 뒤', '서울시 어쩌구 어쩐동 3', 37.532800, 127.024812, '2023-10-16 21:00:00', '서울에서 BTS의 두 번째 콘서트가 개최된다.');
insert into place (artist_id, maker_id, name, address, latitude, longitude, date, content) values (2, 1, '서울시청 앞', '서울시 어쩌구 어쩐동 4', 37.532900, 127.024912, '2023-10-17 21:00:00', '드디어 돌아온 블랙핑크 한국 콘서트!!');

-- subscribe
insert into subscribe (artist_id, user_id) values (1, 1);
insert into subscribe (artist_id, user_id) values (2, 1);
insert into subscribe (artist_id, user_id) values (3, 2);
insert into subscribe (artist_id, user_id) values (4, 3);

-- report
insert into report (reported, reporter, flag, place_id) values ('1', '1', 1, 1);