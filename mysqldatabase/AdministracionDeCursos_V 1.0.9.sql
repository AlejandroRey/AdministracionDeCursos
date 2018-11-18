-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.37-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para gestiondecursos
CREATE DATABASE IF NOT EXISTS `gestiondecursos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gestiondecursos`;

-- Volcando estructura para tabla gestiondecursos.alumno
CREATE TABLE IF NOT EXISTS `alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.alumnoevento
CREATE TABLE IF NOT EXISTS `alumnoevento` (
  `idAlumnoEvento` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `fechaContactar` datetime NOT NULL,
  `fechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idAlumnoEvento`),
  KEY `fk_alumnoevento_alumno1_idx` (`idAlumno`),
  KEY `fk_alumnoevento_usuario1_idx` (`idUsuario`),
  KEY `fk_alumnoevento_curso1_idx` (`idCurso`),
  CONSTRAINT `fk_alumnoevento_alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnoevento_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnoevento_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.asistencia
CREATE TABLE IF NOT EXISTS `asistencia` (
  `idAlumno` int(11) NOT NULL,
  `idFechaCursadaClase` int(11) NOT NULL,
  `tipoAsistencia` tinyint(1) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  KEY `fk_asistencia_clase1_idx` (`idFechaCursadaClase`),
  KEY `fk_asistencia_inscripto1_idx` (`idAlumno`),
  CONSTRAINT `fk_asistencia_clase1` FOREIGN KEY (`idFechaCursadaClase`) REFERENCES `fechacursadaclase` (`idFechaCursadaClase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asistencia_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.contacto
CREATE TABLE IF NOT EXISTS `contacto` (
  `idContacto` int(11) NOT NULL AUTO_INCREMENT,
  `idCurso` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaAccion` datetime NOT NULL,
  PRIMARY KEY (`idContacto`),
  KEY `fk_contacto_curso1_idx` (`idCurso`),
  CONSTRAINT `fk_contacto_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.cursada
CREATE TABLE IF NOT EXISTS `cursada` (
  `idCursada` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` int(11) NOT NULL DEFAULT '1',
  `idCurso` int(11) NOT NULL,
  `idEstadoCurso` int(11) NOT NULL DEFAULT '1',
  `idAdministrativo` int(11) NOT NULL,
  `fechaInicioInscripcion` datetime NOT NULL,
  `fechaFinInscripcion` datetime NOT NULL,
  `vacantes` int(11) NOT NULL,
  `fechaInicioCursada` datetime NOT NULL,
  `diasDeClase` int(11) NOT NULL,
  PRIMARY KEY (`idCursada`),
  KEY `fk_cursada_curso1_idx` (`idCurso`),
  KEY `fk_cursada_estadoCurso1_idx` (`idEstadoCurso`),
  KEY `fk_cursada_empresa1_idx` (`idEmpresa`),
  KEY `fk_cursada_administrativo1_idx` (`idAdministrativo`),
  CONSTRAINT `fk_cursada_administrativo1_idx` FOREIGN KEY (`idAdministrativo`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_estadoCurso1` FOREIGN KEY (`idEstadoCurso`) REFERENCES `estadocurso` (`idEstadoCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `idCursoTipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tema` varchar(45) NOT NULL,
  `temario` varchar(2550) NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `fk_curso_cursotipo1_idx` (`idCursoTipo`),
  CONSTRAINT `fk_curso_cursotipo1` FOREIGN KEY (`idCursoTipo`) REFERENCES `cursotipo` (`idCursoTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.cursotipo
CREATE TABLE IF NOT EXISTS `cursotipo` (
  `idCursoTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCursoTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.diacursadaclase
CREATE TABLE IF NOT EXISTS `diacursadaclase` (
  `idCursada` int(11) NOT NULL,
  `idDia` int(11) NOT NULL,
  `nombreDia` varchar(45) NOT NULL,
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL,
  `idSala` int(11) DEFAULT NULL,
  KEY `fk_horario_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_horario_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.estadocurso
CREATE TABLE IF NOT EXISTS `estadocurso` (
  `idEstadoCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.evaluacion
CREATE TABLE IF NOT EXISTS `evaluacion` (
  `idEvaluacion` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `idEvaluacionTipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idEvaluacion`),
  KEY `fk_evaluacion_cursada1_idx` (`idCursada`),
  KEY `fk_evaluacion_evaluaciontipo1_idx` (`idEvaluacionTipo`),
  CONSTRAINT `fk_evaluacion_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evaluacion_evaluaciontipo1` FOREIGN KEY (`idEvaluacionTipo`) REFERENCES `evaluaciontipo` (`idEvaluacionTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.evaluaciontipo
CREATE TABLE IF NOT EXISTS `evaluaciontipo` (
  `idEvaluacionTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEvaluacionTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.fechacursadaclase
CREATE TABLE IF NOT EXISTS `fechacursadaclase` (
  `idFechaCursadaClase` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  `estadoSala` tinyint(1) NOT NULL,
  PRIMARY KEY (`idFechaCursadaClase`),
  KEY `fk_clases_cursada1_idx` (`idCursada`),
  KEY `fk_calendariocursada_sala1_idx` (`idSala`),
  CONSTRAINT `fk_calendariocursada_sala1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_clases_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.inscripto
CREATE TABLE IF NOT EXISTS `inscripto` (
  `idAlumno` int(11) NOT NULL,
  `idCursada` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `estado` tinyint(1) NOT NULL,
  KEY `fk_inscripto_alumno1_idx` (`idAlumno`),
  KEY `fk_inscripto_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_inscripto_alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripto_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.instructor
CREATE TABLE IF NOT EXISTS `instructor` (
  `idUsuario` int(11) NOT NULL,
  `idCursoTipo` int(11) NOT NULL,
  KEY `fk_Instructor_cursotipo1_idx` (`idCursoTipo`),
  KEY `fk_Instructor_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_Instructor_cursotipo1` FOREIGN KEY (`idCursoTipo`) REFERENCES `cursotipo` (`idCursoTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instructor_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.instructorcursada
CREATE TABLE IF NOT EXISTS `instructorcursada` (
  `idCursada` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  KEY `fk_instructorcursada_cursada1_idx` (`idCursada`),
  KEY `fk_instructorcursada_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_instructorcursada_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructorcursada_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.nota
CREATE TABLE IF NOT EXISTS `nota` (
  `idNota` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `idEvaluacion` int(11) NOT NULL,
  `nota` varchar(45) NOT NULL,
  PRIMARY KEY (`idNota`),
  KEY `fk_nota_evaluacion1_idx` (`idEvaluacion`),
  KEY `fk_nota_inscripto1_idx` (`idAlumno`),
  CONSTRAINT `fk_nota_evaluacion1` FOREIGN KEY (`idEvaluacion`) REFERENCES `evaluacion` (`idEvaluacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.pago
CREATE TABLE IF NOT EXISTS `pago` (
  `idAlumno` int(11) NOT NULL,
  `idPagoCalendario` int(11) NOT NULL,
  `fechadepago` datetime NOT NULL,
  KEY `fk_pago_inscripto1_idx` (`idAlumno`),
  KEY `fk_pago_pagocalendario1_idx` (`idPagoCalendario`),
  CONSTRAINT `fk_pago_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_pagocalendario1` FOREIGN KEY (`idPagoCalendario`) REFERENCES `pagocalendario` (`idPagoCalendario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.pagocalendario
CREATE TABLE IF NOT EXISTS `pagocalendario` (
  `idPagoCalendario` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idPagoCalendario`),
  KEY `fk_pago_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_pago_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.sala
CREATE TABLE IF NOT EXISTS `sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantidadAlumnos` int(11) NOT NULL,
  `cantidadPc` int(11) NOT NULL,
  `descripcion` varchar(510) NOT NULL,
  PRIMARY KEY (`idSala`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.tarea
CREATE TABLE IF NOT EXISTS `tarea` (
  `idTarea` int(11) NOT NULL AUTO_INCREMENT,
  `idAdministrativo` int(11) NOT NULL,
  `idAlumno` int(11) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(1024) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaRealizar` datetime NOT NULL,
  `fechaCierre` datetime DEFAULT NULL,
  PRIMARY KEY (`idTarea`),
  KEY `fk_tarea_usuario1_idx` (`idAdministrativo`),
  KEY `fk_tarea_alumno_idx` (`idAlumno`),
  CONSTRAINT `fk_tarea_alumno` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarea_usuario` FOREIGN KEY (`idAdministrativo`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla gestiondecursos.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nombreDia` varchar(45) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_usuario_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
