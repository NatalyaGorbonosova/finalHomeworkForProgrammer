CREATE DATABASE PeopleFriends; #Создание базы данных
USE PeopleFriends;
CREATE TABLE HomeAnimals		#Создание таблиц
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NameHomeAnimal VARCHAR(20)
    );
CREATE TABLE PackAnimals
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NamePackAnimal VARCHAR(20)
    );
CREATE TABLE Dogs
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NameDog VARCHAR(20) NOT NULL,
    Commands VARCHAR(20),
    DateBirth DATE NOT NULL
    );
CREATE TABLE Cats
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NameCat VARCHAR(20) NOT NULL,
    Commands VARCHAR(20),
    DateBirth DATE NOT NULL
    );
CREATE TABLE Hamsters
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NameHamster VARCHAR(20) NOT NULL,
    Commands VARCHAR(20),
    DateBirth DATE NOT NULL
    );    
CREATE TABLE Horses
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NameHorse VARCHAR(20) NOT NULL,
    Commands VARCHAR(20),
    DateBirth DATE NOT NULL
    );
CREATE TABLE Camels
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NameCamel VARCHAR(20) NOT NULL,
    Commands VARCHAR(20),
    DateBirth DATE NOT NULL
    );
CREATE TABLE Donkeys
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NameDonkey VARCHAR(20) NOT NULL,
    Commands VARCHAR(20),
    DateBirth DATE NOT NULL
    );
INSERT INTO HomeAnimals(NameHomeAnimal)  #Добавление данных в таблицу
	VALUES
    ('Dogs'),
    ('Cats'),
    ('Hamsters');
INSERT INTO PackAnimals(NamePackAnimal)
	VALUES
    ('Horses'),
    ('Camels'),
    ('Donkeys');
INSERT INTO Dogs(NameDog, Commands, DateBirth)
	VALUES
    ('Bobik', 'Sit down', '2020-03-05'),
    ('July', 'Voice', '2022-08-15'),
    ('Roby', 'Voice', '2014-02-14');
INSERT INTO Cats(NameCat, Commands, DateBirth)
	VALUES
    ('Felix', 'Voice', '2022-06-06'),
    ('Tima', 'Voice', '2018-12-20'),
    ('Masy', 'Voice', '2023-05-23');
INSERT INTO Hamsters(NameHamster, Commands, DateBirth)
	VALUES
    ('Chik', 'Run', '2021-03-17'),
    ('Kuzy', 'Run', '2022-08-17'),
    ('Phil', 'Run', '2023-04-15');
INSERT INTO Horses(NameHorse, Commands, DateBirth)
	VALUES
    ('Luna', 'Stop', '2019-02-15'),
    ('White', 'Run', '2020-05-07'),
    ('Hurry', 'Run', '2017-11-25');
INSERT INTO Camels(NameCamel, Commands, DateBirth)
	VALUES
    ('Pot', 'Stop', '2021-12-26'),
    ('Sam', 'Run', '2015-03-18'),
    ('Sunny', 'Run', '2022-04-15');
INSERT INTO Donkeys(NameDonkey, Commands, DateBirth)
	VALUES
    ('Soon', 'Stop', '2023-04-25'),
    ('Flopy', 'Run', '2020-05-07'),
    ('Henry', 'Run', '2022-07-21');
DELETE FROM PackAnimals  				#Удаление верблюдов из таблицы
WHERE NamePackAnimal = 'Camels'
LIMIT 10;								#Чтобы не было ошибки 1175, ограничиваем удаление 10-ю позицями
#Объединяем лошадей и ослов в одну таблицу, создаем новую, добавляем столбец индекса, удаляем отдельные таблицы

CREATE TABLE HorsesAndDonkeys AS 
SELECT NameHorse AS NameAnimal, Commands, DateBirth FROM Horses
UNION
SELECT NameDonkey AS NameAnimal, Commands, DateBirth FROM Donkeys;
ALTER TABLE HorsesAndDonkeys
ADD Id INT PRIMARY KEY AUTO_INCREMENT FIRST;
DROP TABLE Horses;
DROP TABLE Donkeys;
# 11 Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет 
# и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
DROP FUNCTION IF EXISTS get_age; # Функция для подсчета возраста
DELIMITER //
CREATE FUNCTION get_age(months INT)
RETURNS VARCHAR(50) DETERMINISTIC
BEGIN
DECLARE mon INT;
DECLARE years INT;
SET mon = MOD(months, 12);
SET years = FLOOR(months/12);
RETURN CONCAT(years, ' years ', mon, ' months ');
END//
DELIMITER ;

CREATE TABLE YoungAnimals AS
SELECT 'Dog' AS Animal, NameDog, Commands, DateBirth, get_age(timestampdiff(month, datebirth, CURRENT_TIMESTAMP))
 AS Age FROM Dogs 
	WHERE  timestampdiff(year, datebirth, CURRENT_TIMESTAMP) BETWEEN 1 AND 2
UNION
SELECT 'Cat' AS Animal, NameCat, Commands, DateBirth, get_age(timestampdiff(month, datebirth, CURRENT_TIMESTAMP))
 AS Age FROM Cats 
	WHERE  timestampdiff(year, datebirth, CURRENT_TIMESTAMP) BETWEEN 1 AND 2
UNION
SELECT 'Hamster' AS Animal, NameHamster, Commands, DateBirth, get_age(timestampdiff(month, datebirth, CURRENT_TIMESTAMP))
 AS Age FROM Hamsters 
	WHERE  timestampdiff(year, datebirth, CURRENT_TIMESTAMP) BETWEEN 1 AND 2
UNION
SELECT 'PackAnimal' AS Animal, NameAnimal, Commands, DateBirth, get_age(timestampdiff(month, datebirth, CURRENT_TIMESTAMP))
 AS Age FROM HorsesAndDonkeys 
	WHERE  timestampdiff(year, datebirth, CURRENT_TIMESTAMP) BETWEEN 1 AND 2;
# Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
CREATE TABLE AllAnimals AS
SELECT  'Dog' AS Animal, NameDog AS NameAnimal, Commands, DateBirth FROM Dogs
UNION
SELECT 'Cat' AS Animal, NameCat AS NameAnimal, Commands, DateBirth FROM Cats
UNION
SELECT 'Hamster' AS Animal, NameHamster AS NameAnimal, Commands, DateBirth FROM Hamsters
UNION 
SELECT 'Pack Animal' AS Animal, NameAnimal, Commands, DateBirth FROM HorsesAndDonkeys;

