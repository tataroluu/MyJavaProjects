insert into public.role (name) VALUES ('ROLE_ADMIN');
insert into public.role (name) VALUES ('ROLE_USER');

insert into public.system_user (email, name, password) VALUES ( '1@1.com', 'hamit', '$2a$10$WDtUVEjZuuQ7YNOfweEOu.5BxWq/yRH/LIyU9jv0g.TYjP8DfiMfC');
insert into public.system_user (email, name, password) VALUES ( '2@2.com', 'muhammed', '$2a$10$WDtUVEjZuuQ7YNOfweEOu.5BxWq/yRH/LIyU9jv0g.TYjP8DfiMfC');

insert into public.system_user_roles (system_user_id, roles_id)VALUES (1, 1);
insert into public.system_user_roles (system_user_id, roles_id)VALUES (2, 2);

insert into public.service(desktop, laptop, mac, name, "time")    VALUES (50,50,200,'FORMATLAMA',2);
insert into public.service(desktop, laptop, mac, name, "time")    VALUES (100,100,100,'VİRÜS TEMİZLİĞİ',4);
insert into public.service(desktop, laptop, mac, name, "time")    VALUES (200,200,400,'DİSKTEN VERİ KURTARMA',10);
insert into public.service(desktop, laptop, mac, name, "time")    VALUES (30,100,200,'FAN VE TERMAL MACUN TEMİZLİĞİ',1);

insert into public.product(name)VALUES ('CPU');
insert into public.product(name)VALUES ('GPU');
insert into public.product(name)VALUES ('RAM');
insert into public.product(name)VALUES ('Motherboard');

INSERT INTO public.sale(note, price, productid_id)	VALUES ( 'CPU', 100, 1);
INSERT INTO public.sale(note, price, productid_id)	VALUES ( 'motherboard', 1000, 4);