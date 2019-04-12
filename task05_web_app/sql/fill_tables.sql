INSERT INTO `user` (
	`id`,`login`,`password`,`role`)
VALUES
			 (2, "user1", "HELLOGUYSHOWAREYOUTODAYAMANWHATA", 1),
			 (3, "user2", "EE11CBB19052E40B07AAC0CA060C23EE", 2),
			 (4, "user3", "HELLOWORLD180420ABCGDEHIMANWHATA", 2);

INSERT INTO `client`
		(`id`, `name`, `surname`, `patronymic`, `years`, `email`, `phone`)
VALUES
			 (1, "Dmitry", "Terlyukevich", "Sergeevich", 18, "lanselot_2000@mail.ru", "+375298619783"),
			 (2, "Eugene", "Dragun", "Dmitrievich", 18, "zheka@mail.ru", "+375337681345"),
			 (3, "Ivan", "Ivanov", "Ivanovich", 20, "ivan@mail.ru", "+375337431986"),
			 (4, "Petr", "Petrov", "Petrovich", 15, "petrov_forever@mail.ru", "+80295673521");

INSERT INTO `author_quest`
		(`id`, `name`, `surname`, `patronymic`, `year_of_birth`, `year_of_death`)
VALUES
			 (1, "Ivan", "Ivanov", "Ivanovich", "1994", "1"),
			 (2, "Sidor", "Sidorov", "Sidorovich", "1964", "2019"),
			 (3, "Ivan", "Ivanov", "Ivanovich", "1970", "2015");

INSERT INTO `quest`
		(`id`, `title`, `level`, `max_people`, `author_id`)
VALUES
			 (1, "first quest", 5, 9, 1),
			 (2, "second quest", 5, 3, 1),
			 (3, "third quest", 4, 5, 2);