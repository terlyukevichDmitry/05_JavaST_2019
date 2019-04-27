SELECT `id`, `name`, `surname`, `patronymic`, `date_of_birth`, `email`, `phone` FROM client;

DELETE FROM client WHERE `id` = ?;

UPDATE client SET `name` = ?, `surname` = ?, `patronymic` = ?, `date_of_birth` = ?, `email` = ?, `phone` = ? WHERE `id` = ?;

INSERT INTO `client` (`name`, `surname`, `patronymic`, `date_of_birth`, `email`, `phone`) VALUES (?, ?, ?, ?, ?, ?);

SELECT `id`, `title`, `level`, `max_people` FROM quest;

DELETE FROM quest WHERE `id` = ?;

INSERT INTO quest (`title`, `level`, `max_people`) VALUES (?, ?, ?);

UPDATE quest SET `title` = ?, `level` = ?, `max_people` = ? WHERE `id` = ?;

SELECT `id`, `login`, `password`, `role` FROM `user`;

DELETE FROM user WHERE `id` = ? AND `role` = ?;

DELETE FROM user WHERE `id` = ?;

INSERT INTO user (`login`, `password`, `role`) VALUES (?, ?, ?);

UPDATE user SET `login` = ?, `password` = ?, `role` = ? WHERE `id` = ?;

SELECT * FROM client INNER JOIN quest ON client.id = quest.id;

SELECT * FROM quest INNER JOIN quest_place ON quest.id = quest_place.id;

SELECT * FROM quest_place INNER JOIN image ON quest_place.id = image.id;






