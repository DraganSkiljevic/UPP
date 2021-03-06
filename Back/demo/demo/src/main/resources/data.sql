insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (100, "Olga", "Savic", "admin",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "admin@admin.com", "Srbija", "Novi Sad", "student", false, true, "ADMIN", false);
	
insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (200, "Nemanja", "Vujovic", "urednik1",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "jasamdragan@gmail.com", "Srbija", "Novi Sad", "student", false, true, "UREDNIK", false);
insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (300, "Pavle", "Trifkovic", "urednik2",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "jasamdragan@gmail.com", "Srbija", "Novi Sad", "student", false, true, "UREDNIK", false);
insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (400, "Nikola", "Pavlovic", "urednik3",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "jasamdragan@gmail.com", "Srbija", "Novi Sad", "student", false, true, "UREDNIK", false);

insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (500, "Marina", "Gavric", "maki",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "maki@rec.com", "Srbija", "Novi Sad", "student", true, true, "RECENZENT", true);
insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (600, "Dragan", "Borkovac", "borkovac1996",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "borkovac@rec.com", "Srbija", "Novi Sad", "student", true, true, "RECENZENT", true);
insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (700, "Nikola", "Mandic", "manda1996",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "manda@rec.com", "Srbija", "Novi Sad", "student", true, true, "RECENZENT", true);

insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (800, "Lola", "Savi4", "autor1",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "jasamdragan@gmail.com", "Srbija", "Novi Sad", "student", false, true, "AUTOR", false);
insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (900, "Gandri", "Borkovac", "autor2",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "jasamdragan@gmail.com", "Srbija", "Novi Sad", "student", false, true, "AUTOR", false);
insert into db_new.korisnik (id, ime, prezime, username, password, email, drzava, grad, titula, recenzent, aktivan, tip, odobren_recenzent) 
	values (1000, "Petar", "Savic", "autor3",  "$2a$10$bFoT0UWjOFAIQoFRYCIicO2hwNwZy6qhWYq4eXmWqJevf7b2TWpae", "jasamdragan@gmail.com", "Srbija", "Novi Sad", "student", false, true, "AUTOR", false);

	
insert into db_new.casopis(id, naziv, issn, open_access, aktivan, izabran, glavni_urednik_id)
	values(100, "magazin1", "100", false, true, false, 200);
insert into db_new.casopis(id, naziv, issn, open_access, aktivan, izabran, glavni_urednik_id)
	values(200, "magazin2", "200", true, true, false, 200);
insert into db_new.casopis(id, naziv, issn, open_access, aktivan, izabran, glavni_urednik_id)
	values(300, "magazin3", "300", true, true, false, 200);	
	

insert into db_new.naucna_oblast_casopis(id, nazivNO)
	values(100, "Geografija");
insert into db_new.naucna_oblast_casopis(id, nazivNO)
	values(200, "Istorija");
insert into db_new.naucna_oblast_casopis(id, nazivNO)
	values(300, "Biologija");
insert into db_new.naucna_oblast_casopis(id, nazivNO)
	values(400, "Ekologija");
insert into db_new.naucna_oblast_casopis(id, nazivNO)
	values(500, "Knjizevnost");
insert into db_new.naucna_oblast_casopis(id, nazivNO)
	values(600, "Umetnost");	
	
	
INSERT INTO db_new.casopis_recenzent VALUES (100, 500), (100, 600), (100, 700);	
INSERT INTO db_new.casopis_urednik VALUES (100, 300), (100, 400);

INSERT INTO db_new.casopis_no VALUES (100, 100), (100, 300), (200, 200), (200, 400), (300, 500), (300, 600);	
	
INSERT INTO db_new.nocas_recenzent VALUES (100, 500), (100, 600), (300, 700);	
INSERT INTO db_new.nocas_urednik VALUES (100, 300), (300, 400);	

insert into db_new.clanarina(id, aktivna, korisnik_id, casopis_id)
	values(100, true, 900, 300);
insert into db_new.clanarina(id, aktivna, korisnik_id, casopis_id)
	values(200, true, 1000, 200);
