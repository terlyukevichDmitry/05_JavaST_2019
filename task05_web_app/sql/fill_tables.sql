INSERT INTO `user` (
	`id`,`login`,`password`,`role`)
VALUES
			 (2, "user1", "81DC9BDB52D04DC20036DBD8313ED055", 2),
			 (3, "user2", "terlyukevish", 2),
			 (4, "user3", "ssdfsdfsdf", 2),
			 (5, "user4", "sdfcxvxreeKLJDFKLDKljksdfjlksjdf", 2);

INSERT INTO `client`
		(`id`, `name`, `surname`, `patronymic`, `dateOfBirth`, `email`, `phone`, `imageAddress`)
VALUES
			 (1, "Dmitry", "Terlyukevich", "Sergeevich", "2005-09-10", "lanselot_2000@mail.ru", "298619783", "images/1.jpg"),
			 (2, "Eugene", "Dragun", "Dmitrievich", "1999-09-10", "zheka@mail.ru", "337681345", "images/S0Uoi70KahA.jpg"),
			 (3, "Ivan", "Novik", "Ivanovich", "2000-07-12", "vanya@mail.ru", "297658374", "images/4gxI5C8MlXE.jpg"),
			 (4, "Savely", "Mikhnevich", "Sergeevich", "2000-04-22", "mmashina@mail.ru", "339874630", "images/ELLuFff8hko.jpg"),
			 (5, "Tsiruk", "Vladimir", "Andreevich", "2000-02-16", "vovodya@mail.ru", "291032450", "images/5GB6dwxzrvY.jpg");

INSERT INTO `quest`
		(`id`, `title`, `level`, `max_people`, `description`)
VALUES
			 (1, "Ghost hotel", 5, 9, "Today we are going to die!"),
			 (2, "Curse Emily", 5, 3, "In the early nineties, a young girl was found hanging in her own house. They say that she was possessed by a demon. However, the story is shrouded in mystery. It was rumored that the girl was being chased. Many residents of the city still believe that this someone mocked Emily for a long time, and then killed her."),
			 (3, "Brotherhood of Masons", 4, 5, "A lot of knowledge masons own. Mere mortals do not even realize that they are behind the loudest events in the history of mankind. What happens if this knowledge falls into the wrong hands?"),
			 (4, "Minecraft", 3, 6, "For an hour, children will live history, will be able to unite in a real strong team and defeat the main villain.
Small players themselves must extract the natural resources found in the environment."),
			 (5, "Lukomorye. Steampunk", 5, 4, "In the fairy-tale realm, Koschey keeps everyone in fear, as he got the secret of the steam engines, with the help of which he created the terrible monster, the Serpent Gorynych, as well as other nightmarish creatures. No one can defeat the villain, people are dying, so the only solution is to capture the snake itself, get into the castle of Koshchey, find the cherished needle and save the fabulous universe from extermination. However, the path is too dangerous, and not everyone will decide and be able to pass it. Are you ready to make a heroic feat?");

INSERT INTO `image`
		(`id`, `imageAddress`)
VALUES
			 (1, "images/yaschik_pandory_1408_otel_s_prizrakami_photo1.jpg"),
			 (2, "images/yaschik_pandory_proklyatie_emili_photo1.jpg"),
			 (3, "images/!Заглавная_1.jpg"),
			 (4, "images/minecraft-1746541.jpg"),
			 (5, "images/game_room_lukomore_stimpank_photo1.jpg");

INSERT INTO `quest_place`
		(`id`, `name`, `phone`, `address`, `image_id`, `quest_id`)
VALUES
			 (1, "Quest world", "298619783", "m. Frunzenskaya, st. King, 18", 1, 1),
			 (2, "Quest world", "298619783", "m. Frunzenskaya, st. King, 18", 2, 2),
			 (3, "iLocked", "296333279", "ul.Leonida Beda 29", 3, 3),
			 (4, "iLocked", "296333279", "ul.Leonida Beda 29", 4, 4),
			 (5, "Topkvest ", "293899595", "Minsk, Prospect Masherov, 54", 5, 5);

INSERT INTO `review`
		(`id`, `message`, `date`, `quest_place_id`, `client_id`)
VALUES
			 (1, "It was great. Thx for this day!", "1989-09-10", 1, 1),
			 (2, "These were unforgettable impressions and emotions !!! Thanks to the organizers for a cool birthday !!!", "2020-06-12", 1, 2),
			 (3, "Loved it. Recommend.", "2014-09-11", 2, 3);

INSERT INTO `used_quest`
		(`id`, `date`, `client_id`, `quest_place_id`, `control`)
VALUES
			 (1, "2019-05-12", 2, 1, false),
			 (2, "2019-05-12", 3, 2, false),
			 (3, "2019-05-12", 3, 3, false),
			 (4, "2019-05-12", 4, 5, false),
			 (5, "2019-05-11", 2, 4, false);






