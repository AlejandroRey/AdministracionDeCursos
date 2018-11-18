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
  `temario` VARCHAR(2550) NOT NULL,
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
  `cantidadAlumnos` INT NOT NULL,
  `cantidadPc` INT NOT NULL,
  `descripcion` VARCHAR(510) NOT NULL,
  PRIMARY KEY (`idSala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`estadocurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`estadocurso` (
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
  `idEstadoCurso` INT NOT NULL DEFAULT 1,
  `fechaInicioInscripcion` DATETIME NOT NULL,
  `fechaFinInscripcion` DATETIME NOT NULL,
  `vacantes` INT NOT NULL,
  `fechaInicioCursada` DATETIME NOT NULL,
  `diasDeClase` INT NOT NULL,
  PRIMARY KEY (`idCursada`),
  INDEX `fk_cursada_curso1_idx` (`idCurso` ASC),
  INDEX `fk_cursada_estadoCurso1_idx` (`idEstadoCurso` ASC),
  INDEX `fk_cursada_empresa1_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_cursada_curso1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `gestiondecursos`.`curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_estadoCurso1`
    FOREIGN KEY (`idEstadoCurso`)
    REFERENCES `gestiondecursos`.`estadocurso` (`idEstadoCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `gestiondecursos`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`evaluaciontipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`evaluaciontipo` (
  `idEvaluacionTipo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEvaluacionTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`evaluacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`evaluacion` (
  `idEvaluacion` INT NOT NULL AUTO_INCREMENT,
  `idCursada` INT NOT NULL,
  `idEvaluacionTipo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`idEvaluacion`),
  INDEX `fk_evaluacion_cursada1_idx` (`idCursada` ASC),
  INDEX `fk_evaluacion_evaluaciontipo1_idx` (`idEvaluacionTipo` ASC),
  CONSTRAINT `fk_evaluacion_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evaluacion_evaluaciontipo1`
    FOREIGN KEY (`idEvaluacionTipo`)
    REFERENCES `gestiondecursos`.`evaluaciontipo` (`idEvaluacionTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`inscripto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`inscripto` (
  `idAlumno` INT NOT NULL,
  `idCursada` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
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
  `idEvaluacion` INT NOT NULL,
  `nota` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idNota`),
  INDEX `fk_nota_evaluacion1_idx` (`idEvaluacion` ASC),
  INDEX `fk_nota_inscripto1_idx` (`idAlumno` ASC),
  CONSTRAINT `fk_nota_evaluacion1`
    FOREIGN KEY (`idEvaluacion`)
    REFERENCES `gestiondecursos`.`evaluacion` (`idEvaluacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_inscripto1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`inscripto` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
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
-- Table `gestiondecursos`.`alumnoevento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`alumnoevento` (
  `idAlumnoEvento` INT NOT NULL AUTO_INCREMENT,
  `idAlumno` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  `idCurso` INT NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `fechaContactar` DATETIME NOT NULL,
  `fechaCreacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idAlumnoEvento`),
  INDEX `fk_alumnoevento_alumno1_idx` (`idAlumno` ASC),
  INDEX `fk_alumnoevento_usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_alumnoevento_curso1_idx` (`idCurso` ASC),
  CONSTRAINT `fk_alumnoevento_alumno1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnoevento_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnoevento_curso1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `gestiondecursos`.`curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`diacursadaclase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`diacursadaclase` (
  `idCursada` INT NOT NULL,
  `idDia` INT NOT NULL,
  `nombreDia` VARCHAR(45) NOT NULL,
  `horaInicio` DATETIME NOT NULL,
  `horaFin` DATETIME NOT NULL,
  INDEX `fk_horario_cursada1_idx` (`idCursada` ASC),
  CONSTRAINT `fk_horario_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`tarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`tarea` (
  `idTarea` INT NOT NULL AUTO_INCREMENT,
  `idAdministrativo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(1024) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaCierre` DATETIME NOT NULL,
  PRIMARY KEY (`idTarea`),
  INDEX `fk_tarea_usuario1_idx` (`idAdministrativo` ASC),
  CONSTRAINT `fk_tarea_usuario1`
    FOREIGN KEY (`idAdministrativo`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarea_usuario2`
    FOREIGN KEY (`idAdministrativo`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`pagocalendario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`pagocalendario` (
  `idPagoCalendario` INT NOT NULL AUTO_INCREMENT,
  `idCursada` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`idPagoCalendario`),
  INDEX `fk_pago_cursada1_idx` (`idCursada` ASC),
  CONSTRAINT `fk_pago_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`Instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`Instructor` (
  `idUsuario` INT NOT NULL,
  `idCursoTipo` INT NOT NULL,
  INDEX `fk_Instructor_cursotipo1_idx` (`idCursoTipo` ASC),
  INDEX `fk_Instructor_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Instructor_cursotipo1`
    FOREIGN KEY (`idCursoTipo`)
    REFERENCES `gestiondecursos`.`cursotipo` (`idCursoTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instructor_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `gestiondecursos`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`fechacursadaclase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`fechacursadaclase` (
  `idFechaCursadaClase` INT NOT NULL AUTO_INCREMENT,
  `idCursada` INT NOT NULL,
  `idSala` INT NOT NULL,
  `fechaInicio` DATETIME NOT NULL,
  `fechaFin` DATETIME NOT NULL,
  PRIMARY KEY (`idFechaCursadaClase`),
  INDEX `fk_clases_cursada1_idx` (`idCursada` ASC),
  INDEX `fk_calendariocursada_sala1_idx` (`idSala` ASC),
  CONSTRAINT `fk_clases_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_calendariocursada_sala1`
    FOREIGN KEY (`idSala`)
    REFERENCES `gestiondecursos`.`sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`asistencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`asistencia` (
  `idAlumno` INT NOT NULL,
  `idClase` INT NOT NULL,
  `tipoAsistencia` VARCHAR(255) NOT NULL,
  `comentario` VARCHAR(255) NULL,
  INDEX `fk_asistencia_clase1_idx` (`idClase` ASC),
  INDEX `fk_asistencia_inscripto1_idx` (`idAlumno` ASC),
  CONSTRAINT `fk_asistencia_clase1`
    FOREIGN KEY (`idClase`)
    REFERENCES `gestiondecursos`.`fechacursadaclase` (`idFechaCursadaClase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asistencia_inscripto1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`inscripto` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`pago` (
  `idAlumno` INT NOT NULL,
  `idPagoCalendario` INT NOT NULL,
  `fechadepago` DATETIME NOT NULL,
  INDEX `fk_pago_inscripto1_idx` (`idAlumno` ASC),
  INDEX `fk_pago_pagocalendario1_idx` (`idPagoCalendario` ASC),
  CONSTRAINT `fk_pago_inscripto1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `gestiondecursos`.`inscripto` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_pagocalendario1`
    FOREIGN KEY (`idPagoCalendario`)
    REFERENCES `gestiondecursos`.`pagocalendario` (`idPagoCalendario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestiondecursos`.`instructores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestiondecursos`.`instructores` (
  `idCursada` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  INDEX `fk_instructores_cursada1_idx` (`idCursada` ASC),
  INDEX `fk_instructores_Instructor1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_instructores_cursada1`
    FOREIGN KEY (`idCursada`)
    REFERENCES `gestiondecursos`.`cursada` (`idCursada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructores_Instructor1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `gestiondecursos`.`Instructor` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
