-- CREAR TABLAS
USE `betplay` ;

-- -----------------------------------------------------
-- Table `betplay`.`teams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `betplay`.`teams` (
  `team_id` INT NOT NULL AUTO_INCREMENT,
  `team_name` VARCHAR(50) NOT NULL,
  `pj` INT NULL,
  `pg` INT NULL,
  `pp` INT NULL,
  `pe` INT NULL,
  `gf` INT NULL,
  `gc` INT NULL,
  `tp` INT NULL,
  PRIMARY KEY (`team_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `betplay`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `betplay`.`players` (
  `player_id` INT NOT NULL AUTO_INCREMENT,
  `player_name` VARCHAR(50) NOT NULL,

  `gf` INT NULL,
  `ta` INT NULL,
  `tr` INT NULL,
  PRIMARY KEY (`team_id`))
ENGINE = InnoDB;