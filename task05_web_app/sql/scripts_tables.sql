SELECT `id`, `name`, `surname`, `patronymic`, `dateOfBirth`, `email`, `phone` FROM client;

INSERT INTO `client` (`name`, `surname`, `patronymic`, `dateOfBirth`, `email`, `phone`) VALUES (?, ?, ?, ?, ?, ?);

SELECT `id`, `name`, `level`, `max_people` FROM quest;

DELETE FROM quest WHERE `id` = ?;

INSERT INTO quest (`name`, `level`, `max_people`) VALUES (?, ?, ?);

UPDATE quest SET `name` = ?, `level` = ?, `max_people` = ? WHERE `id` = ?;

SELECT `id`, `login`, `password`, `role` FROM `user`;

DELETE FROM user WHERE `id` = ?;

DELETE FROM user WHERE `id` = ? AND `role` = ?;

INSERT INTO user (`login`, `password`, `role`) VALUES (?, ?, ?);

UPDATE user SET `login` = ?, `password` = ?, `role` = ? WHERE `id` = ?;

SELECT * FROM client INNER JOIN quest ON client.id = quest.id;

SELECT * FROM client LEFT OUTER JOIN quest ON client.id = quest.id;

SELECT * FROM client RIGHT OUTER JOIN quest ON client.id = quest.id;

SELECT * FROM quest INNER JOIN quest_place ON quest.id = quest_place.id;

SELECT * FROM quest_place INNER JOIN image ON quest_place.id = image.id;





