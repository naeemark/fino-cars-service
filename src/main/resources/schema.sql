-- ----------------------------
-- Table structure for cars
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars` (
  `id` int(11) NOT NULL,
  `city_miles_per_gallon` int(11) NOT NULL,
  `classification` varchar(255) NOT NULL,
  `driveline` varchar(255) NOT NULL,
  `engine_type` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `fuel_type` varchar(255) NOT NULL,
  `highway_miles_per_gallon` int(11) NOT NULL,
  `horsepower` int(11) NOT NULL,
  `model_id` varchar(255) NOT NULL,
  `make` varchar(255) NOT NULL,
  `model_year` varchar(255) NOT NULL,
  `number_of_forward_gears` int(11) NOT NULL,
  `transmission` varchar(255) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `image_uri` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;