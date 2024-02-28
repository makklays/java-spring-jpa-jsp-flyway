DROP TABLE IF EXISTS `timelines`;

CREATE TABLE `queries` (
   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
   `service_id` int(10) NULL DEFAULT NULL,
   `variation_id` int(10) NULL DEFAULT NULL,
   `question_type_id` int(10) NULL DEFAULT NULL,
   `category_id` int(10) NULL DEFAULT NULL,
   `sub_category_id` int(10) NULL DEFAULT NULL,
   `response_type` enum("P", "N") NOT NULL,
   `date_from` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `date_to` timestamp NULL DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `service_id` (`service_id`),
 KEY `variation_id` (`variation_id`),
 KEY `question_type_id` (`question_type_id`),
 KEY `category_id` (`category_id`),
 KEY `sub_category_id` (`sub_category_id`),
 KEY `response_type` (`response_type`),
 KEY `date_from` (`date_from`),
 KEY `date_to` (`date_to`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

# create database
# CREATE DATABASE `ohh` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

