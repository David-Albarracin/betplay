-- CREAR TABLAS
USE `betplay` ;

-- -----------------------------------------------------
-- Table `betplay`.`teams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `betplay`.`teams` (
  `team_id` INT NOT NULL AUTO_INCREMENT,
  `team_name` VARCHAR(45) NULL,
  `pj` INT NULL,
  `pg` INT NULL,
  `pp` INT NULL,
  `pe` INT NULL,
  `gf` INT NULL,
  `gc` INT NULL,
  `tp` INT NULL,
  `active` TINYINT NULL,
  `team_stadium` VARCHAR(45) NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE INDEX `team_name_UNIQUE` (`team_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `betplay`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `betplay`.`players` (
  `player_id` INT NOT NULL AUTO_INCREMENT,
  `player_name` VARCHAR(45) NULL,
  `player_surname` VARCHAR(45) NULL,
  `player_age` INT NULL,
  `nationality` VARCHAR(45) NULL,
  `position` INT NULL,
  `shirtNumber` VARCHAR(4) NULL,
  `goals` INT NULL,
  `redTargets` INT NULL,
  `yellowTargets` INT NULL,
  `teams_id` INT NOT NULL,
  PRIMARY KEY (`player_id`),
  INDEX `fk_players_teams_idx` (`teams_id` ASC),
  CONSTRAINT `fk_players_teams`
    FOREIGN KEY (`teams_id`)
    REFERENCES `betplay`.`teams` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `betplay`.`matchs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `betplay`.`matchs` (
  `match_id` INT NOT NULL AUTO_INCREMENT,
  `team_local_id` INT NOT NULL,
  `team_visitor_id` INT NOT NULL,
  `match_date` DATE NULL,
  `match_time` TIME NULL,
  `stadium` VARCHAR(45) NULL,
  PRIMARY KEY (`match_id`),
  INDEX `fk_matchs_teams1_idx` (`team_local_id` ASC),
  INDEX `fk_matchs_teams2_idx` (`team_visitor_id` ASC),
  CONSTRAINT `fk_matchs_teams1`
    FOREIGN KEY (`team_local_id`)
    REFERENCES `betplay`.`teams` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matchs_teams2`
    FOREIGN KEY (`team_visitor_id`)
    REFERENCES `betplay`.`teams` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `betplay`.`match_result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `betplay`.`match_result` (
  `match_result_id` INT NOT NULL,
  `matchs_id` INT NOT NULL,
  `local_goals` INT NULL,
  `visitor_goals` INT NULL,
  `redTargets` INT NULL,
  `yellowTargets` INT NULL,
  PRIMARY KEY (`match_result_id`),
  INDEX `fk_match_result_matchs1_idx` (`matchs_id` ASC),
  CONSTRAINT `fk_match_result_matchs1`
    FOREIGN KEY (`matchs_id`)
    REFERENCES `betplay`.`matchs` (`match_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `betplay`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `betplay`.`persons` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `person_name` VARCHAR(45) NULL,
  `person_surname` VARCHAR(45) NULL,
  `person_age` INT NULL,
  `nationality` VARCHAR(45) NULL,
  `rol` VARCHAR(45) NULL,
  `idFederation` VARCHAR(4) NULL,
  `yearsExperience` INT NULL,
  `teams_id` INT NOT NULL,
  PRIMARY KEY (`person_id`),
  INDEX `fk_players_teams_idx` (`teams_id` ASC),
  CONSTRAINT `fk_players_teams0`
    FOREIGN KEY (`teams_id`)
    REFERENCES `betplay`.`teams` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;