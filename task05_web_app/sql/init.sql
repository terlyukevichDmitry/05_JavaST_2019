USE `quest_bd`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(64) UNIQUE NOT NULL ,
  `password` varchar(32) NOT NULL ,
  /*
   * 0 - администратор (Role.ADMINISTRATOR)
   * 1 - менеджер (Role.Manager)
   * 2 - клиент (Role.Client)
   */
  `role` TINYINT NOT NULL CHECK (`role` IN (0, 1, 2)),
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `client` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL ,
  `surname` varchar(32) NOT NULL ,
  `patronymic` varchar(32) NOT NULL,
  `dateOfBirth` DATE NOT NULL,
  `email` varchar(254) UNIQUE NOT NULL ,
  `phone` varchar(9) NOT NULL ,
  `imageAddress` VARCHAR(254) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `quest` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) UNIQUE NOT NULL ,
  `level` INT(1) NOT NULL ,
  `max_people` INT(1) NOT NULL ,
  `description` TEXT NOT NULL ,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `image` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `imageAddress` VARCHAR(254) NOT NULL,
  PRIMARY KEY (`id`)
);;

CREATE TABLE IF NOT EXISTS `quest_place` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL ,
  `phone` varchar(9) NOT NULL ,
  `address` varchar(254) NOT NULL ,
  `image_id` INT(11) NOT NULL ,
  `quest_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `used_quest` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `client_id` INT(11) NOT NULL ,
  `quest_place_id` INT(11) NOT NULL ,
  `control` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(254) NOT NULL ,
  `date` DATE NOT NULL ,
  `quest_place_id` INT(11) NOT NULL,
  `client_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `quest_place` ADD CONSTRAINT `quest_place_fk0` FOREIGN KEY (`image_id`) REFERENCES `image`(`id`);

ALTER TABLE `quest_place` ADD CONSTRAINT `quest_place_fk1` FOREIGN KEY (`quest_id`) REFERENCES `quest`(`id`);

ALTER TABLE `used_quest` ADD CONSTRAINT `used_quest_fk0` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

ALTER TABLE `used_quest` ADD CONSTRAINT `used_quest_fk1` FOREIGN KEY (`quest_place_id`) REFERENCES `quest_place`(`id`);

ALTER TABLE `review` ADD CONSTRAINT `review_fk1` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

INSERT INTO `user` (
    `id`, `login`, `password`, `role`)
VALUES
       (1, "admin", "0F9210750E4D43C609619506D7120B0F", 0);

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
