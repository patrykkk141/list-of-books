INSERT INTO user(user_name, password, role, enabled)
values("patryk", "$2a$04$/L1ZpSHdbOa4H/B6dgvFHu5J17tYMft4tSl1IrDCY80pdHPXFwOqi", "ROLE_ADMIN", true);



INSERT INTO publisher(name, address,email)
values
("MEDIA RODZINA Sp. z o.o.", "ul. Pasieka 24 61-657 Poznań", "mediarodzina@mediarodzina.pl"),
("Helion SA", "ul. Kościuszki 1c 44-100 Gliwice", "sekretariat@helion.pl"),
("Wydawnictwo GREG","ul. Klasztorna 2B 31-979 Kraków", "greg@greg.pl");



INSERT INTO book(title, author, release_date, publisher_id)
values
("Harry Potter i Czara Ognia", "J.K. Rowling", "2012-11-07", 1),
("Harry Potter i Więzień Azkabanu", "J.K. Rownling", "2012-11-07", 1),
("Java. Kompendium programisty. Wydanie IX", "Herbert Schildt", "2015-09-10", 2),
("Czysty kod. Podręcznik dobrego programisty", "Robert C. Martin", "2015-03-25", 2),
("Python. Uczenie maszynowe", "Sebastian Raschka", "2017-11-24", 2),
("W pustyni i w puszczy", "Sienkiewicz Henryk", "2002-01-01", 3);
