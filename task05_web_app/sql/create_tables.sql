USE `quest_bd`;

CREATE TABLE IF NOT EXISTS `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`login` varchar(50) NOT NULL ,
	`password` varchar(64) NOT NULL ,
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
	`patronymic` varchar(64) NOT NULL,
	`dateOfBirth` DATE NOT NULL,
	`email` varchar(254) NOT NULL ,
	`phone` varchar(25) NOT NULL ,
	`imageAddress` VARCHAR(254) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `quest` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`title` varchar(255) NOT NULL ,
	`level` INT(1) NOT NULL ,
	`max_people` INT(1) NOT NULL ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `image` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`imageAddress` VARCHAR(254) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `quest_place` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(32) NOT NULL ,
	`phone` varchar(52) NOT NULL ,
	`address` varchar(129) NOT NULL ,
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
	`message` varchar(222) NOT NULL ,
	`date` DATE NOT NULL ,
	`quest_place_id` INT(11) NOT NULL,
	`client_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`)
);


# ALTER TABLE `client` ADD CONSTRAINT `client_fk0` FOREIGN KEY (`id`) REFERENCES `user`(`id`);

ALTER TABLE `quest_place` ADD CONSTRAINT `quest_place_fk0` FOREIGN KEY (`image_id`) REFERENCES `image`(`id`);

ALTER TABLE `quest_place` ADD CONSTRAINT `quest_place_fk1` FOREIGN KEY (`quest_id`) REFERENCES `quest`(`id`);

ALTER TABLE `used_quest` ADD CONSTRAINT `used_quest_fk0` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

ALTER TABLE `used_quest` ADD CONSTRAINT `used_quest_fk1` FOREIGN KEY (`quest_place_id`) REFERENCES `quest_place`(`id`);

ALTER TABLE `review` ADD CONSTRAINT `review_fk0` FOREIGN KEY (`quest_place_id`) REFERENCES `quest_place`(`id`);

ALTER TABLE `review` ADD CONSTRAINT `review_fk1` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);