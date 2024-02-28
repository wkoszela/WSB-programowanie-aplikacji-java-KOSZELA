CREATE TABLE Studenci
(
    id       SERIAL PRIMARY KEY,
    imie     VARCHAR(50),
    nazwisko VARCHAR(50),
    wiek     INT
);


SELECT * FROM Studenci WHERE imie='Wojtek'