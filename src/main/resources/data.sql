
-- USERS init
-- pw must be a hash
insert into users (username, password, is_account_non_locked, is_account_non_expired, enabled, is_credentials_non_expired)
values ('tom', '$2a$10$ZS54pBP1HnDK2g.sVCtXXu0aylcoZsjeSca./wvhFtjfrRObvZRVm', 'TRUE', 'TRUE', 'TRUE', 'TRUE');



-- TODO move it to schema.sql
DROP TABLE authorities;
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);



-- AUTHORITIES init
insert into authorities (username, authority) values ('tom', 'ROLE_STUDENT');
insert into authorities (username, authority) values ('tom', 'student:read');


-- TRACKS init
insert into track (duration_ms, href, name, uri) values (  '180000', 'www.somehref.com', 't.A.T.u. - All The Things She Said','https://www.youtube.com/watch?v=8mGBaXPlri8');
insert into track (duration_ms, href, name, uri) values (  '163210', 'somehr.com', 'Crazy Town - Butterfly (Official Video)','https://www.youtube.com/watch?v=6FEDrU85FLE');
insert into track (duration_ms, href, name, uri) values (  '174210', 'some href for details.com' , 'Bloodhound Gang - The Bad Touch (Official Video)', 'https://www.youtube.com/watch?v=xat1GVnl8-k');
insert into track (duration_ms, href, name, uri) values (  '174845', 'href for details.com' , 't.A.T.u. - Nas Ne Dogonyat (Not Gonna Get Us - Russian Version) #SD', 'https://www.youtube.com/watch?v=sZV9A_gJzQI');


-- Playlist init - track_id must match with foreign key in table TRACKS
insert into playlist (name, track_id) values ('honduras after scraping', '4');
insert into playlist (name, track_id) values ('honduras after scraping', '1');


-- Artist init
insert into artist (name, href, spotify_id, uri) values ('Kaz Bałagane', 'https://pl.wikipedia.org/wiki/Kaz_Ba%C5%82agane','1980', 'https://www.youtube.com/watch?v=SwOXYIEVf0w');
insert into artist (name, href, spotify_id, uri) values ('DDB', 'https://en.wikipedia.org/wiki/IAMDDB','1410', 'https://www.youtube.com/watch?v=pDgoDQn-6cs');



-- Check if it will drop record from playlist table also, it should
delete from track where track_id = 4;


