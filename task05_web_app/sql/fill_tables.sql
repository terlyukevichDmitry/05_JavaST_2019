INSERT INTO `user` (
	`id`,`login`,`password`,`role`)
VALUES
			 (2, "user1", "HELLOGUYSHOWAREYOUTODAYAMANWHATA", 1),
			 (3, "user2", "EE11CBB19052E40B07AAC0CA060C23EE", 2),
			 (4, "user3", "HELLOWORLD180420ABCGDEHIMANWHATA", 2);

INSERT INTO `client`
		(`id`, `name`, `surname`, `patronymic`, `date_of_birth`, `email`, `phone`)
VALUES
			 (1, "Dmitry", "Terlyukevich", "Sergeevich", "2005-09-10", "lanselot_2000@mail.ru", "+375298619783"),
			 (2, "Eugene", "Dragun", "Dmitrievich", "1999-09-10", "zheka@mail.ru", "+375337681345"),
			 (3, "Ivan", "Ivanov", "Ivanovich", "2001-09-10", "ivan@mail.ru", "+375337431986"),
			 (4, "Petr", "Petrov", "Petrovich", "2010-09-10", "petrov_forever@mail.ru", "+80295673521");

INSERT INTO `quest`
		(`id`, `title`, `level`, `max_people`)
VALUES
			 (1, "first quest", 5, 9),
			 (2, "second quest", 5, 3),
			 (3, "third quest", 4, 5);

INSERT INTO `image`
		(`id`, `imageAddress`)
VALUES
			 (1, "C:\05_JavaST_2019\task05_web_app\web\css\logo.png"),
			 (2, "C:\05_JavaST_2019\task05_web_app\web\css\logo.png"),
			 (3, "C:\05_JavaST_2019\task05_web_app\web\css\logo.png");

INSERT INTO `quest_place`
		(`id`, `name`, `phone`, `address`, `image_id`, `quest_id`)
VALUES
			 (1, "Halloween", "+375298619783", "ulicaPushkina Dom Kolotushkina", 1, 1),
			 (2, "New York", "+375294345583", "ulicaPushkina Dom Kolotushkina", 3, 2),
			 (3, "New Day", "+375293453456", "ulicaPushkina Dom Kolotushkina", 2, 2);

INSERT INTO `review`
		(`id`, `message`, `date`, `quest_place_id`, `client_id`)
VALUES
			 (1, "first", "1989-09-10", 1, 1),
			 (2, "second", "2020-06-12", 1, 2),
			 (3, "third", "2014-09-11", 2, 3);

INSERT INTO `used_quest`
		(`id`, `date`, `client_id`, `quest_place_id`)
VALUES
			 (1, "2019-02-05", 1, 1),
			 (2, "2019-10-10", 2, 1),
			 (3, "2019-12-01", 1, 3);






