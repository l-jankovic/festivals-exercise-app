INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
              
              
              
-- Ubaci festivale
INSERT INTO Festival (naziv) VALUES ('Wacken Open Air');
INSERT INTO Festival (naziv) VALUES ('Hellfest');
INSERT INTO Festival (naziv) VALUES ( 'Download Festival');

-- Ubaci izvođače
INSERT INTO Izvodjac (ime, zanr, drzava_porekla, br_clanova) VALUES ( 'Metallica', 'Metal', 'United States', 4);
INSERT INTO Izvodjac (ime, zanr, drzava_porekla, br_clanova) VALUES ( 'Iron Maiden', 'Metal', 'United Kingdom', 6);
INSERT INTO Izvodjac (ime, zanr, drzava_porekla, br_clanova) VALUES ( 'Slayer', 'Thrash Metal', 'United States', 4);
INSERT INTO Izvodjac (ime, zanr, drzava_porekla, br_clanova) VALUES ('Nightwish', 'Symphonic Metal', 'Finland', 6);
INSERT INTO Izvodjac (ime, zanr, drzava_porekla, br_clanova) VALUES ( 'Sabaton', 'Power Metal', 'Sweden', 5);

-- Ubaci nastupe
INSERT INTO Nastup (festival_id, izvodjac_id) VALUES (1, 1); -- Metallica na Wacken Open Air
INSERT INTO Nastup (festival_id, izvodjac_id) VALUES (1, 2); -- Iron Maiden na Wacken Open Air
INSERT INTO Nastup (festival_id, izvodjac_id) VALUES (2, 1); -- Metallica na Wacken Open Air
INSERT INTO Nastup (festival_id, izvodjac_id) VALUES (3, 4); -- Nightwish na Download Festival
INSERT INTO Nastup (festival_id, izvodjac_id) VALUES (3, 5); -- Sabaton na Download Festival