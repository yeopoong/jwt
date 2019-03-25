INSERT INTO customers(first_name, last_name) VALUES('Nobita', 'Nobi');
INSERT INTO customers(first_name, last_name) VALUES('Takeshi', 'Goda');
INSERT INTO customers(first_name, last_name) VALUES('Suneo', 'Honekawa');
INSERT INTO customers(first_name, last_name) VALUES('Shizuka', 'Minamoto');


insert into user (
    user_id,
	is_account_non_expired,
	is_account_non_locked,
	is_credentials_non_expired,
	is_enabled,
	password,
	user_name
) values ('hint', true, true, true, true, '$2a$10$Hhq501prZyR.s5aKmr0UlOkIZTAV.m.7np9whC1yt.k7SP5LRfzfe', 'YCU');
insert into user (
    user_id,
	is_account_non_expired,
	is_account_non_locked,
	is_credentials_non_expired,
	is_enabled,
	password,
	user_name
) values ('admin', true, true, true, true, '$2a$10$Hhq501prZyR.s5aKmr0UlOkIZTAV.m.7np9whC1yt.k7SP5LRfzfe', 'ABC');

insert into authority (user_id, authority) values ('admin', 'ADMIN');
insert into authority (user_id, authority) values ('admin', 'USER');
insert into authority (user_id, authority) values ('hint', 'USER');

INSERT INTO todo (id, title, completed) VALUES (default, '프로토타입', true);