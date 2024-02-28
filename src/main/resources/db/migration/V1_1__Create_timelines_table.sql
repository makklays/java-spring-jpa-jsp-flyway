DROP TABLE IF EXISTS `timelines`;

CREATE TABLE `timelines` (
   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
   `service_id` int(10) NULL DEFAULT NULL,
   `variation_id` int(10) NULL DEFAULT NULL,
   `question_type_id` int(10) NULL DEFAULT NULL,
   `category_id` int(10) NULL DEFAULT NULL,
   `sub_category_id` int(10) NULL DEFAULT NULL,
   `response_type` enum("P", "N") NOT NULL,
   `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `time` int(10) NOT NULL,
 PRIMARY KEY (`id`),
 KEY `service_id` (`service_id`),
 KEY `variation_id` (`variation_id`),
 KEY `question_type_id` (`question_type_id`),
 KEY `category_id` (`category_id`),
 KEY `sub_category_id` (`sub_category_id`),
 KEY `response_type` (`response_type`),
 KEY `date` (`date`),
 KEY `time` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

