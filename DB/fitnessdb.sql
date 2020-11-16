-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fitnessdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fitnessdb` ;

-- -----------------------------------------------------
-- Schema fitnessdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnessdb` DEFAULT CHARACTER SET utf8 ;
USE `fitnessdb` ;

-- -----------------------------------------------------
-- Table `Exercise`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Exercise` ;

CREATE TABLE IF NOT EXISTS `Exercise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(1000) NOT NULL,
  `average_calories_per_hour` INT NOT NULL,
  `type_of_exercise` VARCHAR(100) NOT NULL,
  `comments` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS fitness@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'fitness'@'localhost' IDENTIFIED BY 'fitness';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'fitness'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Exercise`
-- -----------------------------------------------------
START TRANSACTION;
USE `fitnessdb`;
INSERT INTO `Exercise` (`id`, `name`, `description`, `average_calories_per_hour`, `type_of_exercise`, `comments`) VALUES (1, 'Running', 'Running has been described as the world\'s most accessible sport.', 398, 'cardio', 'Not the most fun exercise but great for your health');
INSERT INTO `Exercise` (`id`, `name`, `description`, `average_calories_per_hour`, `type_of_exercise`, `comments`) VALUES (2, 'Power Lifting', 'A strength sport focused on the execution of the squat, bench press and deadlift. There are certain guidelines and rules as there are with all sports and the main aim for powerlifters is to lift the heaviest possible weight of each exercise for 1 repetition with ideal form', 266 , 'weight training', 'Main lifts are squat, bench press and deadlift');
INSERT INTO `Exercise` (`id`, `name`, `description`, `average_calories_per_hour`, `type_of_exercise`, `comments`) VALUES (3, 'Biking', ' is a top-notch cardio workout.. Plus it strengthens your lower body, including your legs, hips, and glutes.', 400, 'cardio', 'Considered a top notch cardio workout');
INSERT INTO `Exercise` (`id`, `name`, `description`, `average_calories_per_hour`, `type_of_exercise`, `comments`) VALUES (4, 'Hiking', 'dynamic workout that increases your heart rate and metabolic rate, causing calories to burn faster.', 430, 'cardio', 'Hiking is worlds apart from walking since hiking is rarely on flat terrain requiring little effort.');
INSERT INTO `Exercise` (`id`, `name`, `description`, `average_calories_per_hour`, `type_of_exercise`, `comments`) VALUES (5, 'Swimming', 'Swimming is a good all-round activity because it: keeps your heart rate up but takes some of the impact stress off your body. builds endurance, muscle strength and cardiovascular fitness.', 493, 'cardio', 'Is a great workout due to moving your whole body against the resistance of the water');
INSERT INTO `Exercise` (`id`, `name`, `description`, `average_calories_per_hour`, `type_of_exercise`, `comments`) VALUES (6, 'Walking', ' Walking is good cardio exercise', 210, 'cardio', 'Good cardio exercise. Over time, this makes your heart stronger');
INSERT INTO `Exercise` (`id`, `name`, `description`, `average_calories_per_hour`, `type_of_exercise`, `comments`) VALUES (7, 'Crossfit', 'A form of high intensity interval training, CrossFit is a strength and conditioning workout that is made up of functional movement performed at a high intensity level.', 1305, 'weight training', 'At 261 calories burned on average each 20 minutes session its hard to beat this!');

COMMIT;

