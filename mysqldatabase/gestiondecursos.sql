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
-- Table `gestiondecursos`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `idEmpresa` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_cliente_empresa1_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_cliente_empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `gestiondecursos`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Table `gestiondecursos`.`temario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`temario` (
  `idTemario` INT NOT NULL AUTO_INCREMENT,
  `idCurso` INT NOT NULL,
  `programa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idTemario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `idCursoTipo` INT NOT NULL,
  `idTemario` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `tema` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCurso`),
  INDEX `fk_curso_cursotipo1_idx` (`idCursoTipo` ASC),
  INDEX `fk_curso_temario1_idx` (`idTemario` ASC),
  CONSTRAINT `fk_curso_cursotipo1`
    FOREIGN KEY (`idCursoTipo`)
    REFERENCES `gestiondecursos`.`cursotipo` (`idCursoTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_temario1`
    FOREIGN KEY (`idTemario`)
    REFERENCES `gestiondecursos`.`temario` (`idTemario`)
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
-- Table `gestiondecursos`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `idCategoria` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_categoria1_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_usuario_categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `gestiondecursos`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`instructor` (
  `idInstructor` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `idCursoTipo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idInstructor`),
  INDEX `fk_instructor_cursotipo1_idx` (`idCursoTipo` ASC),
  INDEX `fk_instructor_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_instructor_cursotipo1`
    FOREIGN KEY (`idCursoTipo`)
    REFERENCES `gestiondecursos`.`cursotipo` (`idCursoTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
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
-- Table `gestiondecursos`.`cursada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`cursada` (
  `idCursada` INT NOT NULL AUTO_INCREMENT,
  `idCurso` INT NOT NULL,
  `idInstructor` INT NOT NULL,
  `idSala` INT NOT NULL,
  `idEstadoCurso` INT NOT NULL DEFAULT 1,
  `fechaInicio` DATETIME NOT NULL,
  `fechaFin` DATETIME NOT NULL,
  `vacantes` INT NOT NULL,
  `cantidadClase` INT NOT NULL,
  `horasClase` INT NOT NULL,
  PRIMARY KEY (`idCursada`),
  INDEX `fk_cursada_curso1_idx` (`idCurso` ASC),
  INDEX `fk_cursada_sala1_idx` (`idSala` ASC),
  INDEX `fk_cursada_instructor1_idx` (`idInstructor` ASC),
  INDEX `fk_cursada_estadoCurso1_idx` (`idEstadoCurso` ASC),
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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`alumno` (
  `idAlumno` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idCursada` INT NOT NULL,
  PRIMARY KEY (`idAlumno`),
  INDEX `fk_alumno_cliente1_idx` (`idCliente` ASC),
  INDEX `fk_alumno_cursada1_idx` (`idCursada` ASC),
  CONSTRAINT `fk_alumno_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `gestiondecursos`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`adminstrativo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`adminstrativo` (
  `idAdminstrativo` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `idTarea` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdminstrativo`),
  INDEX `fk_adminstrativo_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_adminstrativo_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Table `gestiondecursos`.`nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`nota` (
  `idNota` INT NOT NULL AUTO_INCREMENT,
  `idAlumno` INT NOT NULL,
  `idNotaTipo` INT NOT NULL,
  `nota` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idNota`),
  INDEX `fk_nota_notatipo1_idx` (`idNotaTipo` ASC),
  INDEX `fk_nota_alumno1_idx` (`idAlumno` ASC),
  CONSTRAINT `fk_nota_notatipo1`
    FOREIGN KEY (`idNotaTipo`)
    REFERENCES `gestiondecursos`.`notatipo` (`idNotaTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_alumno1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`clientevento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`clientevento` (
  `idClienteEvento` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `cursosDeInteres` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idClienteEvento`),
  INDEX `fk_clientevento_cliente1_idx` (`idCliente` ASC),
  CONSTRAINT `fk_clientevento_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `gestiondecursos`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`alumnorecado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`alumnorecado` (
  `idAlumnoRecado` INT NOT NULL AUTO_INCREMENT,
  `idAlumno` INT NOT NULL,
  `recado` VARCHAR(255) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idAlumnoRecado`),
  INDEX `fk_alumnorecado_alumno1_idx` (`idAlumno` ASC),
  CONSTRAINT `fk_alumnorecado_alumno1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`dia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`dia` (
  `idDia` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`horario` (
  `idHorario` INT NOT NULL AUTO_INCREMENT,
  `idSala` INT NOT NULL,
  `idDia` INT NOT NULL,
  `horaInicio` VARCHAR(45) NOT NULL,
  `horaFin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idHorario`),
  INDEX `fk_horario_dia1_idx` (`idDia` ASC),
  INDEX `fk_horario_sala1_idx` (`idSala` ASC),
  CONSTRAINT `fk_horario_dia1`
    FOREIGN KEY (`idDia`)
    REFERENCES `gestiondecursos`.`dia` (`idDia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario_sala1`
    FOREIGN KEY (`idSala`)
    REFERENCES `gestiondecursos`.`sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`supervisor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`supervisor` (
  `idSupervisor` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSupervisor`),
  INDEX `fk_adminstrativo_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_adminstrativo_usuario10`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`tarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`tarea` (
  `idTarea` INT NOT NULL AUTO_INCREMENT,
  `idAdmistartivo` INT NOT NULL,
  `idSupervisor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTarea`),
  INDEX `fk_tarea_adminstrativo1_idx` (`idAdmistartivo` ASC),
  INDEX `fk_tarea_supervisor1_idx` (`idSupervisor` ASC),
  CONSTRAINT `fk_tarea_adminstrativo1`
    FOREIGN KEY (`idAdmistartivo`)
    REFERENCES `gestiondecursos`.`adminstrativo` (`idAdminstrativo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarea_supervisor1`
    FOREIGN KEY (`idSupervisor`)
    REFERENCES `gestiondecursos`.`supervisor` (`idSupervisor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`recado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`recado` (
  `idRecado` INT NOT NULL AUTO_INCREMENT,
  `idUsuarioRemitente` INT NOT NULL,
  `idUsuarioDestinatario` INT NOT NULL,
  `recado` VARCHAR(255) NOT NULL,
  `leido` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idRecado`),
  INDEX `fk_recado_usuario1_idx` (`idUsuarioRemitente` ASC),
  INDEX `fk_recado_usuario2_idx` (`idUsuarioDestinatario` ASC),
  CONSTRAINT `fk_recado_usuario1`
    FOREIGN KEY (`idUsuarioRemitente`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recado_usuario2`
    FOREIGN KEY (`idUsuarioDestinatario`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
