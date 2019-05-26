INSERT INTO `user` (
	`id`,
	`login`,
	`password`,
	`role`
) VALUES (
	1,
	"admin",
	"0F9210750E4D43C609619506D7120B0F", /* MD5 хэш пароля "admin" */
	0
);
-- login = admin, password = terlyukevish; (role = admin)
-- login = user1, password = 1234; (role = client)