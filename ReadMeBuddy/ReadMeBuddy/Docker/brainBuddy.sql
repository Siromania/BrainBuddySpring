BEGIN;
    CREATE TABLE users(
        user_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        username varchar(40) NOT NULL UNIQUE,
        email varchar(40) UNIQUE,
        password varchar(500) NOT NULL
    );

    CREATE TABLE sessions(
        session_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        token varchar(40) NOT NULL UNIQUE,
        expiration date NOT NULL,
        user_id int NOT NULL,
        FOREIGN KEY(user_id) REFERENCES users(user_id)
    );

    CREATE TABLE games(
        game_id int NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        name varchar(30) NOT NULL,
        description varchar(100) NOT NULL,
        instructions varchar(250)
    );

    CREATE TABLE difficulty(
        difficulty_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        point int,
        nb_mistake int,
        nb_lifes int,
        timer int,
        game_id int NOT NULL,
        FOREIGN KEY(game_id) REFERENCES games(game_id)
    );

    CREATE TABLE scores(
        score_id int NOT NULL GENERATED ALWAYS AS IDENTITY,
        timestamp timestamp NOT NULL,
        level int NOT NULL,
        timer int,
        nb_mistake int,
        user_id int NOT NULL,
        game_id int NOT NULL,
        FOREIGN KEY(user_id) REFERENCES users(user_id),
        FOREIGN KEY(game_id) REFERENCES games(game_id),
        PRIMARY KEY(score_id,timestamp)
    );

    CREATE TABLE saison(
        saison_id int NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        dateDebut date NOT NULL,
        dateFin date NOT NULL,
        name varchar(40) NOT NULL,
        game_id int NOT NULL,
        FOREIGN KEY(game_id) REFERENCES games(game_id)
    );

    CREATE TABLE saisonUser(
        saisonuser_id int NOT NULL  GENERATED ALWAYS AS IDENTITY,
        placement int NOT NULL,
        dateTime date NOT NULL,
        user_id int NOT NULL,
        saison_id int NOT NULL,
        FOREIGN KEY(user_id) REFERENCES users(user_id),
        FOREIGN KEY(saison_id) REFERENCES saison(saison_id)
    );

    CREATE TABLE trophees(
        trophee_id int NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        name varchar(40) NOT NULL,
        description varchar(250) NOT NULL,
        image varchar(250) NOT NULL,
        game_id int NOT NULL,
        FOREIGN KEY(game_id) REFERENCES games(game_id)
    );

    CREATE TABLE usertrophees(
        trophee_id int NOT NULL,
        user_id int NOT NULL,
        FOREIGN KEY(trophee_id) REFERENCES trophees(trophee_id),
        FOREIGN KEY(user_id) REFERENCES users(user_id),
        PRIMARY KEY(trophee_id,user_id)
    );

    INSERT INTO users(username, email, password) 
    VALUES 
       ('Adrien', null ,'1234'),
       ('Hamza',  null , '1234'),
       ('Theo',  null , '1234'),
       ('Karim', null ,  '1234'),
       ('Melanie',  null ,'1234'),
       ('Sebastien',  null ,'1234'),
       ('Huan',  null ,'1234'),
       ('Etienne', null , '1234'),
       ('Loic', null , '1234'),
       ('Jerome', null , '1234');

    INSERT INTO games(name, description, instructions)
    VALUES
       ('MonkeyTest', 'a good game', 'this is how you play'),
       ('Memory', 'a good game', 'this is how you play'),
       ('Quiz', 'a good game', 'this is how you play'),
       ('AimTrainer', 'a good game', 'this is how you play'),
	   ('Typing', 'a good game', 'this is how you play'),
       ('Concentration', 'a good game', 'this is how you play');

    INSERT INTO scores (timestamp,level,timer,nb_mistake,user_id,game_id)
    VALUES
        ('2024-4-12 20:51:16',3,29,14,9,4),
		('2048-3-23 11:49:12',14,11,1,4,4),
		('2025-6-5 7:35:35',15,29,10,7,4),
		('2028-2-13 19:55:36',19,52,15,4,4),
		('2030-6-14 14:24:23',20,112,4,4,3),
		('2030-4-18 1:31:33',7,110,7,4,1),
		('2035-8-28 16:28:2',1,43,9,1,1),
		('2031-5-24 1:56:5',12,110,9,10,5),
		('2047-4-2 8:37:25',2,44,17,7,1),
		('2030-9-28 4:36:22',12,83,11,10,4),
		('2044-9-21 3:33:36',6,117,14,5,3),
		('2047-8-2 22:58:56',3,11,15,10,1),
		('2044-1-7 5:47:36',9,8,18,1,5),
		('2037-12-9 3:32:2',9,88,10,3,5),
		('2033-12-11 0:35:3',18,89,3,10,2),
		('2025-8-15 17:51:53',8,26,7,5,4),
		('2044-8-15 16:34:18',18,71,14,9,4),
		('2029-2-3 7:21:37',2,55,3,6,4),
		('2039-2-16 16:48:41',11,114,20,6,5),
		('2050-1-30 2:24:55',17,87,6,2,5),
		('2045-3-4 20:17:19',7,101,10,8,5),
		('2036-7-18 1:7:22',19,104,0,3,3),
		('2043-5-17 10:20:5',12,94,15,7,4),
		('2030-5-17 20:48:36',17,100,6,6,4),
		('2048-1-9 18:55:37',2,9,8,7,5),
		('2042-5-1 11:39:0',7,39,6,1,2),
		('2041-8-8 13:12:50',12,57,19,7,5),
		('2035-7-6 21:20:52',19,86,1,9,4),
		('2025-7-26 22:38:46',4,25,4,9,4),
		('2023-9-3 16:25:6',19,37,2,10,1),
		('2032-1-5 13:43:23',2,72,18,5,1),
		('2044-3-6 12:28:40',11,72,5,3,1),
		('2027-3-24 2:16:7',3,89,12,4,2),
		('2041-5-26 1:54:48',14,92,18,8,5),
		('2041-2-14 23:53:14',3,76,0,1,1),
		('2048-10-16 19:49:10',19,71,19,1,3),
		('2038-2-18 11:8:31',12,5,16,10,4),
		('2028-9-11 3:11:23',19,24,16,3,1),
		('2030-8-25 15:16:21',4,24,5,5,5),
		('2042-7-3 6:39:52',17,38,2,3,5),
		('2037-4-8 2:21:0',13,67,13,3,2),
		('2043-11-11 13:19:26',6,77,20,2,3),
		('2036-9-10 2:32:18',7,64,9,3,3),
		('2047-6-5 20:21:16',14,95,3,4,3),
		('2039-9-24 2:58:37',17,45,2,6,5),
		('2043-4-2 12:4:26',17,73,16,4,5),
		('2024-4-26 7:10:44',11,56,4,5,4),
		('2023-9-14 4:47:41',5,51,9,9,4),
		('2043-4-28 20:7:36',17,112,6,10,2),
		('2036-4-4 7:35:32',6,91,11,9,2),
		('2024-12-3 12:24:22',20,105,13,6,4),
		('2026-4-27 14:49:58',5,37,16,6,2),
		('2024-2-3 7:50:40',9,97,11,6,3),
		('2028-1-21 4:52:5',16,82,8,4,1),
		('2044-12-8 22:37:15',10,83,1,9,5),
		('2043-9-20 10:36:28',10,58,3,7,5),
		('2050-4-4 6:33:35',14,78,15,9,3),
		('2030-9-3 4:0:7',1,69,6,6,5),
		('2026-2-20 0:30:54',11,47,15,3,4),
		('2027-4-3 17:33:8',3,82,4,6,4),
		('2029-10-27 11:15:32',17,112,18,2,3),
		('2035-6-26 19:58:42',13,27,20,5,3),
		('2045-12-6 10:48:16',3,114,17,3,1),
		('2030-2-26 20:52:5',20,105,9,7,4),
		('2029-7-11 22:1:1',17,33,12,3,1),
		('2049-9-3 10:40:23',2,99,9,10,5),
		('2030-7-10 5:56:52',2,112,19,2,5),
		('2029-12-27 1:45:3',6,63,17,8,5),
		('2036-4-4 15:39:18',6,26,6,4,1),
		('2047-1-12 4:37:2',3,100,3,10,5),
		('2035-8-19 21:38:1',6,116,12,1,4),
		('2045-2-7 2:9:7',15,14,1,1,1),
		('2049-11-10 23:14:3',20,60,4,5,5),
		('2040-4-29 4:47:4',13,56,1,7,1),
		('2041-6-5 17:7:56',11,94,6,9,2),
		('2039-5-22 11:33:41',9,73,12,10,2),
		('2024-11-2 1:53:9',6,44,11,4,5),
		('2039-7-19 11:34:55',2,55,7,10,1),
		('2043-5-25 9:8:16',18,34,13,6,3),
		('2049-8-24 8:54:38',8,80,11,10,5),
		('2040-7-17 4:5:54',12,38,7,8,2),
		('2049-8-11 6:45:20',13,99,16,3,1),
		('2023-1-17 20:59:55',8,81,13,3,4),
		('2044-7-19 20:27:18',4,116,1,10,5),
		('2050-8-16 23:25:18',5,16,17,7,5),
		('2038-7-25 22:20:35',11,66,9,7,2),
		('2048-1-9 18:10:20',8,56,20,9,2),
		('2032-1-10 21:51:36',19,106,5,1,1),
		('2032-8-7 14:8:11',4,94,5,10,2),
		('2023-11-23 11:23:14',6,116,15,4,3),
		('2039-12-5 2:56:16',4,12,17,9,2),
		('2029-4-11 21:1:24',10,92,2,4,4),
		('2033-1-26 12:40:22',3,100,14,1,1),
		('2047-7-26 8:37:58',15,115,20,6,5),
		('2041-5-11 4:38:19',9,91,8,4,1),
		('2030-1-2 7:57:28',10,115,5,7,4),
		('2030-12-5 17:0:39',17,112,20,5,1),
		('2032-2-11 20:10:19',19,115,12,4,1),
		('2041-8-18 18:0:51',5,103,20,1,5),
		('2028-9-24 20:14:5',13,38,10,4,3),
		('2025-8-2 21:48:42',13,41,3,7,3),
		('2038-7-13 3:16:49',2,29,5,7,2),
		('2044-7-30 22:12:28',7,17,5,2,5),
		('2031-8-16 3:29:31',14,35,14,2,2),
		('2045-8-3 7:51:23',15,69,0,3,2),
		('2023-8-25 10:26:46',17,67,1,3,5),
		('2041-2-17 23:40:3',7,102,9,1,1),
		('2041-4-15 4:1:13',7,11,18,9,4),
		('2029-12-6 1:30:24',7,12,1,1,5),
		('2027-1-18 11:9:19',7,38,7,9,3),
		('2029-5-4 13:47:19',4,67,12,3,2),
		('2030-3-29 23:32:52',10,120,2,2,4),
		('2050-6-16 3:11:5',17,25,9,4,1),
		('2043-9-22 13:9:15',3,83,15,7,4),
		('2046-7-19 20:25:27',19,37,0,8,3),
		('2031-6-14 13:53:26',2,12,5,3,2),
		('2046-7-28 9:44:43',6,118,13,4,3),
		('2024-8-26 20:53:9',2,105,20,3,4),
		('2040-9-24 6:8:12',11,102,3,9,1),
		('2033-8-12 17:11:11',14,116,14,5,5),
		('2041-1-14 20:37:20',10,48,16,6,4),
		('2034-9-14 10:29:43',17,15,7,3,1),
		('2032-5-2 0:25:58',15,42,17,9,5),
		('2033-12-5 23:57:18',9,11,9,1,1),
		('2035-6-27 15:35:13',8,57,0,6,5),
		('2028-5-30 23:49:30',5,63,4,10,1),
		('2035-6-15 5:12:40',7,27,1,6,3),
		('2041-1-23 21:55:29',6,23,14,7,1),
		('2035-4-8 6:34:27',12,115,15,6,5),
		('2035-8-17 4:41:14',9,32,11,1,1),
		('2043-7-4 18:51:7',4,18,4,8,5),
		('2029-10-6 2:7:51',17,71,15,5,4),
		('2045-9-23 7:21:9',14,49,16,7,1),
		('2039-12-24 2:38:2',12,43,3,1,1),
		('2042-5-4 7:53:45',8,10,17,7,3),
		('2028-11-1 16:9:5',10,97,5,5,3),
		('2040-9-25 14:6:31',12,108,13,6,3),
		('2037-6-21 9:13:29',14,106,8,7,3),
		('2043-3-27 20:20:37',20,9,18,2,2),
		('2039-10-27 3:18:38',15,40,2,9,4),
		('2029-9-4 0:28:44',7,91,13,9,4),
		('2025-10-28 8:45:45',3,19,10,7,2),
		('2033-9-18 10:23:38',17,34,4,9,2),
		('2031-8-16 7:24:7',9,51,20,10,5),
		('2031-5-8 16:2:18',13,98,2,5,3),
		('2047-7-11 13:32:55',20,97,12,3,5),
		('2029-9-21 8:25:18',6,108,9,8,1),
		('2038-5-27 4:0:21',6,32,1,6,1),
		('2042-8-24 8:12:4',18,16,1,3,1),
		('2035-3-29 0:41:46',7,16,19,4,3),
		('2031-11-16 4:47:38',4,12,15,2,1),
		('2037-8-16 5:42:56',1,103,1,9,4),
		('2049-11-26 12:7:49',1,20,1,2,3),
		('2044-5-30 2:51:3',10,9,18,4,2),
		('2029-9-12 8:8:44',5,102,13,8,2),
		('2030-2-17 1:55:51',13,70,3,4,4),
		('2036-2-13 20:53:19',15,13,3,9,2),
		('2024-6-15 1:47:49',9,114,1,8,2),
		('2023-8-13 23:6:40',5,26,10,3,4),
		('2033-4-3 2:53:20',9,109,5,4,5),
		('2047-7-3 10:58:3',18,95,13,2,4),
		('2027-8-18 16:8:13',11,109,13,10,2),
		('2047-11-25 5:38:10',5,97,18,6,3),
		('2030-7-10 9:19:34',11,60,11,9,5),
		('2037-6-13 1:28:10',16,95,10,7,1),
		('2023-8-21 3:40:50',14,24,19,4,3),
		('2043-9-30 21:5:46',10,13,3,8,2),
		('2028-3-17 5:15:59',1,119,12,10,3),
		('2033-5-23 17:12:35',17,111,5,6,5),
		('2030-9-29 1:44:10',10,90,9,6,2),
		('2039-10-30 20:44:18',15,63,7,4,2),
		('2040-1-12 6:46:16',16,6,0,3,2),
		('2033-9-23 11:25:33',1,30,2,9,1),
		('2048-2-14 16:0:15',10,40,9,5,3),
		('2050-11-13 13:4:32',5,72,7,3,3);

    INSERT INTO saison(dateDebut, dateFin, name, game_id)
    VALUES 
       (CURRENT_DATE, CURRENT_DATE+10,'Ete',1),
       ('2023-03-24','2023-06-24','Printemps',2),
       ('2022-09-24', '2022-12-24','Automne',2),
       ('2023-12-24', '2023-03-24','Hiver',2),
       ('2023-06-24', '2023-09-24','Ete',2),
       ('2022-09-24', '2023-05-24','HotDogParty',3),
       (CURRENT_DATE, '2023-09-24','ButterFlys',3),
       ('2023-09-24', '2023-12-24','ChristmasSoup',3),
       ('2022-10-12', CURRENT_DATE,'HiddedSweetInSnow',4),
       (CURRENT_DATE, '2023-12-24','BrainBuddyStar',4),
       (CURRENT_DATE, CURRENT_DATE+10,'OnePiece',4),
       ('2022-10-12', CURRENT_DATE,'GoT',5),
       (CURRENT_DATE, '2023-12-24','DownTownAbbay',5),
       (CURRENT_DATE, CURRENT_DATE+10,'GodSaveTheQueen',5);

    INSERT INTO saisonUser(placement, dateTime, user_id, saison_id)
    VALUES
       (6,'2021-09-16',8,1),
       (65,'2021-10-09',4,8),
       (62,'2023-04-12',3,5),
       (56,'2022-03-25',4,2),
       (15,'2022-12-26',8,8),
       (73,'2021-09-05',2,7),
       (5,'2020-04-24',10,11),
       (97,'2021-01-20',2,1),
       (70,'2022-08-16',3,7),
       (46,'2022-07-30',6,6),
       (28,'2020-03-08',9,4),
       (9,'2021-02-08',10,13),
       (63,'2023-03-05',10,11),
       (49,'2023-02-21',10,9),
       (76,'2023-05-24',4,13),
       (68,'2023-04-15',10,14),
       (94,'2021-12-01',6,14),
       (96,'2021-09-08',3,3),
       (96,'2020-04-28',7,5),
       (38,'2021-07-12',6,1),
       (27,'2021-05-27',6,10),
       (81,'2023-07-02',7,6),
       (45,'2022-01-20',9,6),
       (98,'2020-12-25',7,9),
       (74,'2020-06-02',10,9),
       (36,'2023-07-22',6,8),
       (7,'2021-02-15',8,10),
       (74,'2022-07-04',9,5),
       (58,'2020-04-02',4,11),
       (97,'2021-05-13',10,9),
       (73,'2020-07-15',2,1),
       (8,'2020-11-10',1,2),
       (23,'2020-06-01',9,7),
       (47,'2021-03-12',3,2),
       (78,'2021-04-29',4,8),
       (31,'2020-02-22',5,11),
       (33,'2022-10-03',8,12),
       (38,'2023-11-30',2,5),
       (26,'2022-02-13',9,4),
       (94,'2020-06-10',2,5);

	INSERT INTO trophees(name, description, image,game_id)
    VALUES
		('Platinum Trophy','obtaining all other trophies in a game','http',3),
		('Gold Trophy','completing a major objective in a game','http',4),
		('Silver Trophy','completing a minor objective in a game','http',4),
		('Bronze Trophy','completing a basic objective in a game','http',5),
		('First Blood','getting the first kill in a multiplayer match','http',2),
		('Survivor','surviving a certain amount of time in a game mode or map','http',3),
		('Speed Run','completing the game or a level within a specific time limit','http',5),
		('Puzzle Master','completing all puzzles in a game or level','http',5),
		('Explorer','exploring all areas in a game or level','http',4),
		('Completionist','completing every possible objective in a game or level','http',5),
		('High Score','scoring a certain amount in a game or level','http',4),
		('Perfect Score','achieving a perfect score in a specific level or game mode','http',5),
		('Hall of Famer','being in the top 10 of a specific leaderboard','http',1),
		('No Death Run','completing a game or level without dying','http',2),
		('Combo Master','achieving a specific combo or chain in a game','http',4),
		('Perfect Combo','achieving a perfect combo in a game','http',3),
		('Headshot','getting a headshot kill in a game','http',4),
		('Team Victory','winning a game as part of a team','http',3),
		('MVP','being the most valuable player in a game or match','http',2),
		('Boss Battle','defeating a specific boss in a game','http',3),
		('Crowd Control','killing a large number of enemies at once','http',1),
		('Sniper','killing enemies from a distance in a game','http',1),
		('Stealth Master','completing a level or game without being detected','http',2),
		('Master of Disguise','completing a level or game by using disguises','http',1),
		('Master of Unlocking','unlocking all secrets in a game or level','http',5),
		('Zoologist','finding and studying all animals or creatures in a game','http',3),
		('Collector','collecting all items or resources in a game','http',1),
		('Maxed Out','maxing out a character s stats or abilities in a game','http',1),
		('Jack of All Trades','mastering multiple skills or abilities in a game','http',3),
		('Art Connoisseur','appreciating all artwork in a game or level','http',1),
		('Lore Master','learning and mastering all lore and backstory in a game','http',2),
		('Environmentalist','preserving the environment in a game or level','http',3),
		('All the Feels','experiencing all possible emotions in a game or level','http',3),
		('Rookie','completing a game or level on the easiest difficulty','http',4),
		('Intermediate','completing a game or level on the medium difficulty','http',2),
		('Expert','completing a game or level on the hard difficulty','http',3),
		('Master','completing a game or level on the highest difficulty','http',1),
		('Speed Freak','completing a game or level quickly using shortcuts and tricks','http',2),
		('Versatile','mastering multiple playstyles or approaches in a game','http',1),
		('Troubleshooter','solving all errors and glitches in a game or level','http',3),
		('Survivor s Guilt','surviving a game while other characters did not','http',4),
		('Redemption','completing a game or level after a failure or setback','http',3),
		('Epic Fail','failing at a specific objective or challenge in a game','http',3),
		('Executioner','executing a specific number of enemies in a game','http',1),
		('Daredevil','taking risks and performing dangerous stunts in a game','http',5),
		('Rocketeer','mastering rocket science or piloting in a game','http',4),
		('Lone Wolf','completing a game or level alone, without assistance','http',3),
		('Diplomat','mastering negotiation and diplomacy skills in a game','http',5),
		('Party Animal','mastering social skills and networking in a game','http',3),
		('Surviving the Apocalypse','surviving a post-apocalyptic setting in a game','http',4);
	
	CREATE TABLE roles (
	role_id SERIAL ,
	role_name VARCHAR(50),
		PRIMARY KEY (role_id)
	);

	INSERT INTO roles (role_name) VALUES ('ADMIN');
	INSERT INTO roles (role_name) VALUES ('USER');

	CREATE TABLE user_role (
	user_id INT,
	role_id INT,
    CONSTRAINT user_id
      FOREIGN KEY(user_id) 
      REFERENCES users(user_id),
    CONSTRAINT role_id
      FOREIGN KEY(role_id) 
      REFERENCES roles(role_id),
    PRIMARY KEY (user_id, role_id)
	); 

END;
