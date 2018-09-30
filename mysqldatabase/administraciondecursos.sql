-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gestiondecursos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gestiondecursos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gestiondecursos` DEFAULT CHARACTER SET utf8 ;
USE `gestiondecursos` ;

-- -----------------------------------------------------
-- Table `gestiondecursos`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`alumno` (
  `idAlumno` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAlumno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`cursotipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`cursotipo` (
  `idCursoTipo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCursoTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `idCursoTipo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `tema` VARCHAR(45) NOT NULL,
  `temario` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idCurso`),
  INDEX `fk_curso_cursotipo1_idx` (`idCursoTipo` ASC),
  CONSTRAINT `fk_curso_cursotipo1`
    FOREIGN KEY (`idCursoTipo`)
    REFERENCES `gestiondecursos`.`cursotipo` (`idCursoTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`sala` (
  `idSala` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `capacidad` INT NOT NULL,
  PRIMARY KEY (`idSala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`adminstrativo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`adminstrativo` (
  `idAdminstrativo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdminstrativo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`notatipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`notatipo` (
  `idNotaTipo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idNotaTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`instructor` (
  `idInstructor` INT NOT NULL AUTO_INCREMENT,
  `idCursoTipo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idInstructor`),
  INDEX `fk_instructor_cursotipo1_idx` (`idCursoTipo` ASC),
  CONSTRAINT `fk_instructor_cursotipo1`
    FOREIGN KEY (`idCursoTipo`)
    REFERENCES `gestiondecursos`.`cursotipo` (`idCursoTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`estadoCurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`estadoCurso` (
  `idEstadoCurso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstadoCurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`cursada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`cursada` (
  `idCursada` INT NOT NULL AUTO_INCREMENT,
  `idEmpresa` INT NOT NULL DEFAULT 1,
  `idCurso` INT NOT NULL,
  `idInstructor` INT NOT NULL,
  `idSala` INT NOT NULL,
  `idEstadoCurso` INT NOT NULL DEFAULT 1,
  `vacantes` INT NOT NULL,
  PRIMARY KEY (`idCursada`),
  INDEX `fk_cursada_curso1_idx` (`idCurso` ASC),
  INDEX `fk_cursada_sala1_idx` (`idSala` ASC),
  INDEX `fk_cursada_instructor1_idx` (`idInstructor` ASC),
  INDEX `fk_cursada_estadoCurso1_idx` (`idEstadoCurso` ASC),
  INDEX `fk_cursada_empresa1_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_cursada_curso1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `gestiondecursos`.`curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_sala1`
    FOREIGN KEY (`idSala`)
    REFERENCES `gestiondecursos`.`sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_instructor1`
    FOREIGN KEY (`idInstructor`)
    REFERENCES `gestiondecursos`.`instructor` (`idInstructor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_estadoCurso1`
    FOREIGN KEY (`idEstadoCurso`)
    REFERENCES `gestiondecursos`.`estadoCurso` (`idEstadoCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `gestiondecursos`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`inscripto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`inscripto` (
  `idAlumno` INT NOT NULL,
  `idCursada` INT NOT NULL,
  INDEX `fk_inscripto_alumno1_idx` (`idAlumno` ASC),
  INDEX `fk_inscripto_cursada1_idx` (`idCursada` ASC),
  CONSTRAINT `fk_inscripto_alumno1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripto_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`nota` (
  `idNota` INT NOT NULL AUTO_INCREMENT,
  `idAlumno` INT NOT NULL,
  `idNotaTipo` INT NOT NULL,
  `nota` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idNota`),
  INDEX `fk_nota_notatipo1_idx` (`idNotaTipo` ASC),
  INDEX `fk_nota_inscripto1_idx` (`idAlumno` ASC),
  CONSTRAINT `fk_nota_notatipo1`
    FOREIGN KEY (`idNotaTipo`)
    REFERENCES `gestiondecursos`.`notatipo` (`idNotaTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_inscripto1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`inscripto` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`alumnoevento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`alumnoevento` (
  `idAlumnoEvento` INT NOT NULL AUTO_INCREMENT,
  `idAlumno` INT NOT NULL,
  `idAdministrativo` INT NOT NULL,
  `cursosDeInteres` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `fechaContactar` DATETIME NOT NULL,
  `fechaCreacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idAlumnoEvento`),
  INDEX `fk_alumnoevento_alumno1_idx` (`idAlumno` ASC),
  INDEX `fk_alumnoevento_adminstrativo1_idx` (`idAdministrativo` ASC),
  CONSTRAINT `fk_alumnoevento_alumno1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnoevento_adminstrativo1`
    FOREIGN KEY (`idAdministrativo`)
    REFERENCES `gestiondecursos`.`adminstrativo` (`idAdminstrativo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`horario` (
  `idHorario` INT NOT NULL AUTO_INCREMENT,
  `idCursada` INT NOT NULL,
  `fechaHoraInicio` DATETIME NOT NULL,
  `fechaHoraFin` DATETIME NOT NULL,
  PRIMARY KEY (`idHorario`),
  INDEX `fk_horario_cursada1_idx` (`idCursada` ASC),
  CONSTRAINT `fk_horario_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`supervisor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`supervisor` (
  `idSupervisor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSupervisor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`tarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`tarea` (
  `idTarea` INT NOT NULL AUTO_INCREMENT,
  `idAdministrativo` INT NOT NULL,
  `idSupervisor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTarea`),
  INDEX `fk_tarea_supervisor1_idx` (`idSupervisor` ASC),
  INDEX `fk_tarea_adminstrativo1_idx` (`idAdministrativo` ASC),
  CONSTRAINT `fk_tarea_supervisor1`
    FOREIGN KEY (`idSupervisor`)
    REFERENCES `gestiondecursos`.`supervisor` (`idSupervisor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarea_adminstrativo1`
    FOREIGN KEY (`idAdministrativo`)
    REFERENCES `gestiondecursos`.`adminstrativo` (`idAdminstrativo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`categoria` (
  `idcategoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `idPersona` INT NOT NULL,
  `idCategoria` INT NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_categoria1_idx` (`idCategoria` ASC),
  INDEX `fk_usuario_instructor1_idx` (`idPersona` ASC),
  CONSTRAINT `fk_usuario_categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `gestiondecursos`.`categoria` (`idcategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_instructor1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `gestiondecursos`.`instructor` (`idInstructor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_supervisor1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `gestiondecursos`.`supervisor` (`idSupervisor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_adminstrativo1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `gestiondecursos`.`adminstrativo` (`idAdminstrativo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `idAlumno` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`idPago`),
  INDEX `fk_pago_inscripto1_idx` (`idAlumno` ASC),
  CONSTRAINT `fk_pago_inscripto1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`inscripto` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
