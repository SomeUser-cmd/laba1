INSERT INTO `admin` (`role`, `first_name`, `last_name`, `password`) VALUES ('superadmin', 'Bogdan', 'Seredenko', '1234');
INSERT INTO `admin` (`role`, `first_name`, `last_name`, `password`) VALUES ('admin', 'Ivan', 'Notttt', '12345');
INSERT INTO `admin` (`role`, `first_name`, `last_name`, `password`) VALUES ('sa', 'asd', 'wqe', 'fggfdssd');

INSERT INTO `ads` (`url`, `title`) VALUES ('https://someUrl.com', 'Cool title');
INSERT INTO `ads` (`url`, `title`) VALUES ('https://som44eUrl.com', 'Cool that previous one');

INSERT INTO `available_credits` (`name`, `description`, `min_sum`, `max_sum`, `min_term`, `max_term`, `percent`) VALUES ('Credit 1', 'dfgkjdsfhgkj', '1 ', '2', '1', '2', '0.3');
INSERT INTO `available_credits` (`name`, `description`, `min_sum`, `max_sum`, `min_term`, `max_term`, `percent`) VALUES ('Credit 22', 'djgfhdkjfgh kjd', '33', '44', '2', '10', '1');

INSERT INTO `user` (`email`, `first_name`, `last_name`, `ads_id`, `password`) VALUES ('seredenko99@gmail.com', 'Serdenko', 'Bogdan', '1', '1234');
INSERT INTO `user` (`email`, `first_name`, `last_name`, `ads_id`, `password`) VALUES ('some@fdsf.com', 'Ssss', 'BBb ', '3', '1231241324');

INSERT INTO `users_credit` (`name`, `amount`, `start_date`, `end_date`, `already_paid`, `description`, `user_id`, `percent`) VALUES ('Credit', '2', '2015-05-07', '2015-05-08', '1', 'sdf sdf sd', '1', '0.2');
