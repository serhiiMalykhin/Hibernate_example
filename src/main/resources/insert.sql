SELECT * FROM concretepage.author;


INSERT INTO `concretepage`.`book` (`id`, `name`) VALUES ('1', 'book1');
INSERT INTO `concretepage`.`book` (`id`, `name`) VALUES ('2', 'book2');
INSERT INTO `concretepage`.`book` (`id`, `name`) VALUES ('3', 'book3');

INSERT INTO `concretepage`.`author` (`id`, `last_name`, `name`) VALUES ('1', 'auth_last_name_1', 'name1');
INSERT INTO `concretepage`.`author` (`id`, `last_name`, `name`) VALUES ('2', 'auth_last_name_2', 'name2');
INSERT INTO `concretepage`.`author` (`id`, `last_name`, `name`) VALUES ('3', 'auth_last_name_3', 'name3');


INSERT INTO `concretepage`.`author_book` (`author_id`, `book_id`) VALUES ('1', '1');
INSERT INTO `concretepage`.`author_book` (`author_id`, `book_id`) VALUES ('2', '1');
INSERT INTO `concretepage`.`author_book` (`author_id`, `book_id`) VALUES ('2', '2');
INSERT INTO `concretepage`.`author_book` (`author_id`, `book_id`) VALUES ('3', '3');

INSERT INTO `concretepage`.`employee` (`id`, `city`, `name`) VALUES ('1', 'city1', 'name1');
INSERT INTO `concretepage`.`employee` (`id`, `city`, `name`) VALUES ('2', 'city2', 'name2');

INSERT INTO `concretepage`.`employee_book` VALUES ('1', '1');
INSERT INTO `concretepage`.`employee_book` VALUES ('2', '1');
INSERT INTO `concretepage`.`employee_book` VALUES ('2', '2');

commit;