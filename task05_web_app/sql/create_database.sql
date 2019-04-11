CREATE DATABASE `quest_bd` DEFAULT CHARACTER SET utf8;

GRANT SELECT,INSERT,UPDATE,DELETE
ON `quest_bd`.*
TO quest_user@localhost
IDENTIFIED BY 'quest_password';

GRANT SELECT,INSERT,UPDATE,DELETE
ON `quest_bd`.*
TO quest_user@'%'
IDENTIFIED BY 'quest_password';