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


-- Volcando estructura de base de datos para formar_grupo5
CREATE DATABASE IF NOT EXISTS `formar_grupo5` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `formar_grupo5`;

-- Volcando estructura para tabla formar_grupo5.alumno
CREATE TABLE IF NOT EXISTS `alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.alumno: ~21 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`idAlumno`, `nombre`, `apellido`, `telefono`, `email`) VALUES
	(1, 'Alejandro', 'Rey', '+549 11 3344 5555', 'dcjaskdckacgd@gmail.com'),
	(2, 'Ricardo', 'Ferreira', '+549 11 9999 2222', 'wqdqefqef@gmail.com'),
	(3, 'Enzo', 'Perez', '+549 11 2132 2321', 'dqdewf@gmail.com'),
	(4, 'Milton', 'Casco', '+549 11 2409 8792', 'twtferfe@gmail.com'),
	(5, 'Rafael', 'Santos', '+549 11 3791 0987', 'ertewrter@gmail.com'),
	(6, 'Ramiro', 'Funes Moris', '+549 11 3791 0987', 'eweeqwqe@gmail.com'),
	(7, 'Ariel', 'Ortega', '+549 11 3791 0987', 'jhjjhbdfg@gmail.com'),
	(8, 'Vanina', 'Gomez', '+549 11 3791 0987', 'pdwofqfwldl@gmail.com'),
	(9, 'Susana', 'Lopez', '+549 11 3791 0987', 'ksiwemdb@gmail.com'),
	(10, 'Javier', 'Moro', '+549 11 3791 0987', 'kashuewpo@gmail.com'),
	(11, 'Nicolas', 'Dominguez', '1122334455', 'nico@hotmail.com'),
	(12, 'Nicolas', 'Dominguez', '1122334455', 'nico@hotmail.com'),
	(13, 'Juan', 'Fernandez', '1199887766', 'juan@hotmail.com'),
	(14, 'Juan', 'Fernandez', '113344556677', 'juan@hotmail.com'),
	(15, 'Gaston', 'Gimenez', '1155664433', 'gaston@hotmail.com'),
	(16, 'Gaston', 'Gimenez', '1122333322', 'gaston@hotmail.com'),
	(17, 'Nicolas', 'Dominguez', '1122334455', 'nico@hotmail.com'),
	(18, 'Cristian', 'Ramirez', 'Ramirez', 'cris@hotmail.com'),
	(19, 'Roberto', 'Acosta', '1125639874', 'robert@hotmail.com'),
	(20, 'Patricio', 'Esponja', '1165987412', 'pato@hotmail.com'),
	(21, 'Nicolas', 'Sanchez', '1154789632', 'nico@hotmail.com'),
	(22, 'Tomas', 'Alvarez', '1125639874', 'tom@hotmail.com'),
	(23, 'Hugo', 'Viciconte', '1145789632', 'hugo@gmail.com'),
	(24, 'Fabricio', 'Mendez', '1136524789', 'f@gmail.com');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.alumnoevento
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

-- Volcando datos para la tabla formar_grupo5.alumnoevento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alumnoevento` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumnoevento` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.asistencia
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

-- Volcando datos para la tabla formar_grupo5.asistencia: ~12 rows (aproximadamente)
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
INSERT INTO `asistencia` (`idAlumno`, `idFechaCursadaClase`, `tipoAsistencia`, `comentario`) VALUES
	(2, 343, 1, ''),
	(4, 343, 1, ''),
	(7, 343, 0, ''),
	(2, 373, -1, ''),
	(4, 373, -1, ''),
	(7, 373, -1, ''),
	(2, 375, -1, ''),
	(4, 375, -1, ''),
	(7, 375, -1, ''),
	(2, 374, -1, ''),
	(4, 374, -1, ''),
	(7, 374, -1, '');
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.categoria: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`idCategoria`, `nombre`) VALUES
	(1, 'Supervisor'),
	(2, 'Administrativo'),
	(3, 'Instructor');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.contacto
CREATE TABLE IF NOT EXISTS `contacto` (
  `idContacto` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `idAdministrativo` int(11) NOT NULL,
  `idTarea` int(11) DEFAULT NULL,
  `idCurso` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `fechaContactar` datetime NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idContacto`),
  KEY `fk_contacto_alumno1_idx` (`idAlumno`),
  KEY `fk_contacto_administrativo1_idx` (`idAdministrativo`),
  KEY `fk_contacto_tarea1_idx` (`idTarea`),
  KEY `fk_contacto_curso1_idx` (`idCurso`),
  CONSTRAINT `fk_contacto_administrativo1` FOREIGN KEY (`idAdministrativo`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_tarea1` FOREIGN KEY (`idTarea`) REFERENCES `tarea` (`idTarea`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.contacto: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
INSERT INTO `contacto` (`idContacto`, `idAlumno`, `idAdministrativo`, `idTarea`, `idCurso`, `descripcion`, `fechaContactar`, `fechaCreacion`, `estado`) VALUES
	(2, 3, 3, NULL, 1, 'dsad', '2018-11-12 00:00:00', '2018-11-18 11:46:10', 1),
	(3, 14, 3, 20, 1, 'saddasd', '2018-02-14 00:00:00', '2018-11-18 12:04:36', 1),
	(4, 14, 3, 21, 1, 'saddasd', '2018-02-15 00:00:00', '2018-11-18 14:17:50', 1),
	(5, 14, 3, 22, 1, 'saddasd', '2018-05-16 00:00:00', '2018-11-18 14:19:50', 1);
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.cursada
CREATE TABLE IF NOT EXISTS `cursada` (
  `idCursada` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` int(11) NOT NULL DEFAULT '1',
  `idCurso` int(11) NOT NULL,
  `idEstadoCurso` int(11) NOT NULL DEFAULT '1',
  `idAdministrativo` int(11) NOT NULL,
  `idInstructor` int(11) NOT NULL,
  `fechaInicioInscripcion` datetime NOT NULL,
  `fechaFinInscripcion` datetime NOT NULL,
  `vacantes` int(11) NOT NULL,
  `fechaInicioCursada` datetime NOT NULL,
  `diasDeClase` int(11) NOT NULL,
  PRIMARY KEY (`idCursada`),
  KEY `fk_cursada_empresa1_idx` (`idEmpresa`),
  KEY `fk_cursada_curso1_idx` (`idCurso`),
  KEY `fk_cursada_estadocurso1_idx` (`idEstadoCurso`),
  KEY `fk_cursada_administrativo1_idx` (`idAdministrativo`),
  KEY `fk_cursada_instructor1_idx` (`idInstructor`),
  CONSTRAINT `fk_cursada_administrativo1` FOREIGN KEY (`idAdministrativo`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cursada_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cursada_empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cursada_estadocurso1` FOREIGN KEY (`idEstadoCurso`) REFERENCES `estadocurso` (`idEstadoCurso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cursada_instructor1` FOREIGN KEY (`idInstructor`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.cursada: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cursada` DISABLE KEYS */;
INSERT INTO `cursada` (`idCursada`, `idEmpresa`, `idCurso`, `idEstadoCurso`, `idAdministrativo`, `idInstructor`, `fechaInicioInscripcion`, `fechaFinInscripcion`, `vacantes`, `fechaInicioCursada`, `diasDeClase`) VALUES
	(8, 1, 4, 2, 3, 9, '2018-02-02 00:00:00', '2018-03-02 00:00:00', 20, '2018-04-02 00:00:00', 10),
	(9, 1, 1, 2, 3, 6, '2018-05-01 00:00:00', '2018-05-29 00:00:00', 15, '2018-06-13 00:00:00', 10);
/*!40000 ALTER TABLE `cursada` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `idCursoTipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tema` varchar(45) NOT NULL,
  `temario` varchar(2550) NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `fk_curso_cursotipo1_idx` (`idCursoTipo`),
  CONSTRAINT `fk_curso_cursotipo1` FOREIGN KEY (`idCursoTipo`) REFERENCES `cursotipo` (`idCursoTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.curso: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idCurso`, `idCursoTipo`, `nombre`, `tema`, `temario`) VALUES
	(1, 1, 'C#', 'Curso Programacion C#', 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA'),
	(2, 1, 'Java', 'Curso Programacion Java', 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBB'),
	(3, 1, 'C++', 'Curso Programacion C++', 'CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC'),
	(4, 1, 'JS', 'Curso Programacion Java Script', 'Fundamentos\n\nClases\n\nFunciones');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.cursotipo
CREATE TABLE IF NOT EXISTS `cursotipo` (
  `idCursoTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCursoTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.cursotipo: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cursotipo` DISABLE KEYS */;
INSERT INTO `cursotipo` (`idCursoTipo`, `nombre`) VALUES
	(1, 'Informatica'),
	(2, 'Administracion de Empresas'),
	(3, 'Gestion Aduanera'),
	(4, 'Mecanica Automotriz');
/*!40000 ALTER TABLE `cursotipo` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.diacursadaclase
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

-- Volcando datos para la tabla formar_grupo5.diacursadaclase: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `diacursadaclase` DISABLE KEYS */;
INSERT INTO `diacursadaclase` (`idCursada`, `idDia`, `nombreDia`, `horaInicio`, `horaFin`, `idSala`) VALUES
	(9, 1, 'Lunes', '08:00:00', '12:00:00', 1),
	(9, 3, 'Miércoles', '08:00:00', '12:00:00', 1),
	(8, 2, 'Martes', '14:00:00', '18:00:00', 1),
	(8, 4, 'Jueves', '14:00:00', '18:00:00', 1);
/*!40000 ALTER TABLE `diacursadaclase` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.empresa: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`idEmpresa`, `nombre`, `telefono`, `email`) VALUES
	(1, 'N/A', 'N/A', 'N/A'),
	(2, 'Sancor', '+549 11 2111 9876', 'sancor@gmail.com'),
	(3, 'Unilever', '+549 11 1211 0998', 'unilever@gmail.com');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.estadocurso
CREATE TABLE IF NOT EXISTS `estadocurso` (
  `idEstadoCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.estadocurso: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `estadocurso` DISABLE KEYS */;
INSERT INTO `estadocurso` (`idEstadoCurso`, `nombre`) VALUES
	(1, 'Inscripcion Abierta'),
	(2, 'Curso Iniciado'),
	(3, 'Curso Cerrado'),
	(4, 'Curso Cancelado');
/*!40000 ALTER TABLE `estadocurso` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.evaluacion
CREATE TABLE IF NOT EXISTS `evaluacion` (
  `idEvaluacion` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `idEvaluacionTipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idEvaluacion`),
  KEY `fk_evaluacion_cursada1_idx` (`idCursada`),
  KEY `fk_evaluacion_evaluaciontipo1_idx` (`idEvaluacionTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.evaluacion: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluacion` DISABLE KEYS */;
INSERT INTO `evaluacion` (`idEvaluacion`, `idCursada`, `idEvaluacionTipo`, `nombre`, `fecha`) VALUES
	(1, 1, 1, 'Progra 1', '2018-05-12 00:00:00'),
	(2, 9, 1, '1', '2018-05-25 00:00:00'),
	(3, 9, 3, '2', '2018-05-27 00:00:00'),
	(4, 9, 2, 'Final', '2018-06-12 00:00:00');
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.evaluaciontipo
CREATE TABLE IF NOT EXISTS `evaluaciontipo` (
  `idEvaluacionTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEvaluacionTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.evaluaciontipo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluaciontipo` DISABLE KEYS */;
INSERT INTO `evaluaciontipo` (`idEvaluacionTipo`, `nombre`) VALUES
	(1, 'Parcial'),
	(2, 'Final'),
	(3, 'TP');
/*!40000 ALTER TABLE `evaluaciontipo` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.fechacursadaclase
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.fechacursadaclase: ~21 rows (aproximadamente)
/*!40000 ALTER TABLE `fechacursadaclase` DISABLE KEYS */;
INSERT INTO `fechacursadaclase` (`idFechaCursadaClase`, `idCursada`, `idSala`, `fechaInicio`, `fechaFin`, `estadoSala`) VALUES
	(203, 8, 1, '2018-04-03 14:00:00', '2018-04-03 18:00:00', 0),
	(204, 8, 1, '2018-04-05 14:00:00', '2018-04-05 18:00:00', 0),
	(205, 8, 1, '2018-04-10 14:00:00', '2018-04-10 18:00:00', 0),
	(206, 8, 1, '2018-04-12 14:00:00', '2018-04-12 18:00:00', 0),
	(207, 8, 1, '2018-04-17 14:00:00', '2018-04-17 18:00:00', 0),
	(208, 8, 1, '2018-04-19 14:00:00', '2018-04-19 18:00:00', 0),
	(209, 8, 1, '2018-04-24 14:00:00', '2018-04-24 18:00:00', 0),
	(210, 8, 1, '2018-04-26 14:00:00', '2018-04-26 18:00:00', 0),
	(211, 8, 1, '2018-05-01 14:00:00', '2018-05-01 18:00:00', 0),
	(212, 8, 1, '2018-05-03 14:00:00', '2018-05-03 18:00:00', 0),
	(343, 9, 1, '2018-06-13 08:00:00', '2018-06-13 12:00:00', 1),
	(373, 9, 1, '2018-06-13 08:00:00', '2018-06-13 12:00:00', 0),
	(374, 9, 1, '2018-06-18 08:00:00', '2018-06-18 12:00:00', 1),
	(375, 9, 1, '2018-06-20 08:00:00', '2018-06-20 12:00:00', 1),
	(376, 9, 1, '2018-06-25 08:00:00', '2018-06-25 12:00:00', 1),
	(377, 9, 1, '2018-06-27 08:00:00', '2018-06-27 12:00:00', 1),
	(378, 9, 1, '2018-07-02 08:00:00', '2018-07-02 12:00:00', 1),
	(379, 9, 1, '2018-07-04 08:00:00', '2018-07-04 12:00:00', 1),
	(380, 9, 1, '2018-07-09 08:00:00', '2018-07-09 12:00:00', 1),
	(381, 9, 1, '2018-07-11 08:00:00', '2018-07-11 12:00:00', 1),
	(382, 9, 1, '2018-07-16 08:00:00', '2018-07-16 12:00:00', 1);
/*!40000 ALTER TABLE `fechacursadaclase` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.feriado
CREATE TABLE IF NOT EXISTS `feriado` (
  `idFeriado` int(11) NOT NULL AUTO_INCREMENT,
  `feriado` date NOT NULL,
  PRIMARY KEY (`idFeriado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.feriado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `feriado` DISABLE KEYS */;
INSERT INTO `feriado` (`idFeriado`, `feriado`) VALUES
	(1, '2018-11-21');
/*!40000 ALTER TABLE `feriado` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.inscripto
CREATE TABLE IF NOT EXISTS `inscripto` (
  `idAlumno` int(11) NOT NULL,
  `idCursada` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `estado` tinyint(1) NOT NULL,
  KEY `fk_inscripto_alumno1_idx` (`idAlumno`),
  KEY `fk_inscripto_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_inscripto_alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripto_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.inscripto: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `inscripto` DISABLE KEYS */;
INSERT INTO `inscripto` (`idAlumno`, `idCursada`, `fecha`, `estado`) VALUES
	(4, 9, '2018-11-26 01:20:01', 1),
	(2, 9, '2018-11-26 01:20:03', 1),
	(7, 9, '2018-11-26 01:20:05', 1);
/*!40000 ALTER TABLE `inscripto` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.instructor
CREATE TABLE IF NOT EXISTS `instructor` (
  `idUsuario` int(11) NOT NULL,
  `idCursoTipo` int(11) NOT NULL,
  KEY `fk_Instructor_cursotipo1_idx` (`idCursoTipo`),
  KEY `fk_Instructor_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_Instructor_cursotipo1` FOREIGN KEY (`idCursoTipo`) REFERENCES `cursotipo` (`idCursoTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instructor_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.instructor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.instructorcursada
CREATE TABLE IF NOT EXISTS `instructorcursada` (
  `idCursada` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  KEY `fk_instructorcursada_cursada1_idx` (`idCursada`),
  KEY `fk_instructorcursada_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_instructorcursada_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructorcursada_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.instructorcursada: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `instructorcursada` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructorcursada` ENABLE KEYS */;

-- Volcando estructura para procedimiento formar_grupo5.modEstadosSalasSP
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `modEstadosSalasSP`(
IN param1 DATETIME,
IN param2 DATETIME,
IN param3 INT)
BEGIN

DECLARE dateTimeInicio DATETIME; 
DECLARE dateTimeFinal DATETIME; 
DECLARE salaId INT;

SET @dateTimeInicio = param1;
SET @dateTimeFinal = param2;
SET @salaId = param3;

SELECT 
b.idSala AS idSala, 
IF (d.name = 'Libre', 0, b.estadoSala) AS estadoSala, 
IF (d.name = 'Libre', @dateTimeInicio, b.inicio) as dispDesde,
IF (d.name = 'Libre', b.inicio, @dateTimeInicio := b.inicio + INTERVAL b.duration MINUTE) AS dispHasta,
d.name AS estado
FROM 
(SELECT 1 AS place, 'Libre' AS name UNION SELECT 2 AS place, 'Ocupado' AS name ) AS d 
INNER JOIN 
(SELECT 
idSala, 
estadoSala, 
fechaInicio AS inicio, 
TIMESTAMPDIFF(MINUTE, fechaInicio, fechaFin) AS duration   
FROM fechacursadaclase WHERE idSala = @salaId 
AND fechaInicio BETWEEN @dateTimeInicio AND @dateTimeFinal ORDER BY fechaInicio ASC) AS b
HAVING dispDesde < dispHasta
UNION SELECT @salaId AS idSala, 0 AS estadoSala, @dateTimeInicio AS dispDesde, @dateTimeFinal AS dispHasta, 'Libre' AS estado 
FROM (SELECT 1) as g
WHERE @dateTimeInicio < @dateTimeFinal  
ORDER BY dispDesde, dispHasta;

END//
DELIMITER ;

-- Volcando estructura para tabla formar_grupo5.nota
CREATE TABLE IF NOT EXISTS `nota` (
  `idNota` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `idEvaluacion` int(11) NOT NULL,
  `nota` varchar(45) NOT NULL,
  PRIMARY KEY (`idNota`),
  KEY `fk_nota_evaluacion1_idx` (`idEvaluacion`),
  KEY `fk_nota_inscripto1_idx` (`idAlumno`),
  CONSTRAINT `fk_nota_evaluacion1` FOREIGN KEY (`idEvaluacion`) REFERENCES `evaluacion` (`idEvaluacion`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.nota: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` (`idNota`, `idAlumno`, `idEvaluacion`, `nota`) VALUES
	(3, 2, 2, '7'),
	(4, 4, 2, '8'),
	(5, 7, 2, '6'),
	(6, 2, 3, '7'),
	(7, 4, 3, '8'),
	(8, 7, 3, '10'),
	(9, 2, 4, '5'),
	(10, 4, 4, '7'),
	(11, 7, 4, '7');
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.notificacion
CREATE TABLE IF NOT EXISTS `notificacion` (
  `idNotificacion` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `tipoNotificacion` int(1) NOT NULL,
  `mensaje` varchar(200) NOT NULL,
  `visto` tinyint(1) NOT NULL DEFAULT '0',
  `fechaHora` datetime NOT NULL,
  PRIMARY KEY (`idNotificacion`),
  KEY `fk_notificacion_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_notificacion_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.notificacion: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
INSERT INTO `notificacion` (`idNotificacion`, `idUsuario`, `tipoNotificacion`, `mensaje`, `visto`, `fechaHora`) VALUES
	(1, 8, 2, 'Se te ha asignado una tarea. Revisa la sección Tareas', 0, '2018-11-24 18:15:33'),
	(2, 8, 2, 'Se te ha asignado una tarea. Revisa la sección Tareas', 0, '2018-11-24 18:16:36'),
	(3, 3, 2, 'Se te ha asignado una tarea. Revisa la sección Tareas', 0, '2018-11-25 13:19:35'),
	(4, 3, 2, 'Se te ha asignado una tarea. Revisa la sección Tareas', 0, '2018-11-25 13:19:45'),
	(5, 3, 2, 'Se te ha asignado una tarea. Revisa la sección Tareas', 0, '2018-11-26 01:20:31');
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.pago
CREATE TABLE IF NOT EXISTS `pago` (
  `idAlumno` int(11) NOT NULL,
  `idPagoCalendario` int(11) NOT NULL,
  `fechadepago` datetime NOT NULL,
  KEY `fk_pago_inscripto1_idx` (`idAlumno`),
  KEY `fk_pago_pagocalendario1_idx` (`idPagoCalendario`),
  CONSTRAINT `fk_pago_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_pagocalendario1` FOREIGN KEY (`idPagoCalendario`) REFERENCES `pagocalendario` (`idPagoCalendario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.pago: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.pagocalendario
CREATE TABLE IF NOT EXISTS `pagocalendario` (
  `idPagoCalendario` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idPagoCalendario`),
  KEY `fk_pago_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_pago_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.pagocalendario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pagocalendario` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagocalendario` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.recado
CREATE TABLE IF NOT EXISTS `recado` (
  `idRecado` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuarioDe` int(11) NOT NULL,
  `idUsuarioPara` int(11) NOT NULL,
  `asunto` varchar(255) NOT NULL DEFAULT 'Sin asunto',
  `mensaje` varchar(255) NOT NULL,
  `fechaHoraEnvio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `visto` tinyint(1) NOT NULL DEFAULT '0',
  `eliminado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idRecado`),
  KEY `FK_recado_usuarioDe` (`idUsuarioDe`),
  KEY `FK_recado_usuario` (`idUsuarioPara`),
  CONSTRAINT `FK_recado_usuario` FOREIGN KEY (`idUsuarioPara`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `FK_recado_usuarioDe` FOREIGN KEY (`idUsuarioDe`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.recado: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `recado` DISABLE KEYS */;
INSERT INTO `recado` (`idRecado`, `idUsuarioDe`, `idUsuarioPara`, `asunto`, `mensaje`, `fechaHoraEnvio`, `visto`, `eliminado`) VALUES
	(1, 1, 3, '', 'hola', '2018-11-18 21:08:09', 1, 0),
	(2, 3, 1, 'RE: ', 'Enviado: 21:08:09 - 18/11/2018\nVisto: 14:19:07 - 25/11/2018. \n ------------------------------------------- \nhola', '2018-11-25 14:19:07', 0, 0);
/*!40000 ALTER TABLE `recado` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.sala
CREATE TABLE IF NOT EXISTS `sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantidadAlumnos` int(11) NOT NULL,
  `cantidadPc` int(11) NOT NULL,
  `descripcion` varchar(510) NOT NULL,
  PRIMARY KEY (`idSala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.sala: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` (`idSala`, `nombre`, `cantidadAlumnos`, `cantidadPc`, `descripcion`) VALUES
	(1, 'Sin Asignar', 0, 2, 'Sala sin uso.Desea asignarla.'),
	(3, 'Plata', 33, 25, 'Sala ok'),
	(4, 'Bronce', 25, 25, 'Sala ok'),
	(5, 'Oro', 25, 25, 'Sala ok');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.tarea
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

-- Volcando datos para la tabla formar_grupo5.tarea: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
INSERT INTO `tarea` (`idTarea`, `idAdministrativo`, `idAlumno`, `nombre`, `descripcion`, `estado`, `fechaCreacion`, `fechaRealizar`, `fechaCierre`) VALUES
	(14, 3, 18, 'sdsad\r ', 'asd', 'Pendiente', '2018-11-24 18:15:31', '2018-11-18 00:00:00', NULL),
	(15, 3, NULL, 'dasdad', 'dsa', 'Pendiente', '2018-11-24 18:16:36', '2018-11-18 00:00:00', NULL),
	(17, 3, 19, 'ibbiibmlkmo', 'nbiubyuvy', 'Pendiente', '2018-11-18 03:02:53', '2018-05-12 00:00:00', NULL),
	(20, 3, 14, 'sadsad', 'adasddasd', 'Pendiente', '2018-11-18 12:04:36', '2018-02-14 00:00:00', NULL),
	(21, 8, 14, 'nueva', 'se llamo', 'Realizada', '2018-11-20 01:10:44', '2018-11-20 00:00:00', '2018-11-20 01:10:44'),
	(22, 3, 14, 'nueva llamada', 'llamar otra vez.-', 'Pendiente', '2018-11-25 13:19:45', '2018-11-25 00:00:00', NULL),
	(26, 3, 7, 'Notificar inasistencia', 'Se debe llamar al alumno por telefono', 'Pendiente', '2018-11-26 01:20:30', '2018-11-28 01:20:30', '2018-11-30 01:20:30');
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.usuario
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.usuario: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`, `idCategoria`, `nombre`, `apellido`, `telefono`, `email`, `usuario`, `password`, `nombreDia`, `horaInicio`, `horaFin`) VALUES
	(1, 1, 'Alejandro', 'Rey', '+549 11 2211 9999', 'alejakakjdjdj@gmail.com', 'alejandro', 'admin', NULL, NULL, NULL),
	(2, 1, 'Marcos', 'Lever', '+549 11 3443 9921', 'hdsdhewd@gmail.com', 'marcos', 'admin', NULL, NULL, NULL),
	(3, 2, 'Pablo', 'Drink', '+549 11 7755 9932', 'frerfsdscvsdc@gmail.com', 'pablo', 'admin', NULL, NULL, NULL),
	(4, 3, 'Gonzalo', 'Paolinelli', '+549 11 8272 5637', 'rqetgdfvdsaodkas@gmail.com', 'gonzalo', 'admin', NULL, NULL, NULL),
	(5, 1, 'Emiliano', 'Saucedo', '+549 11 6729 2891', 'ewrewwef@gmail.com', 'emiliano', 'admin', NULL, NULL, NULL),
	(6, 3, 'Leandro', 'Jobs', '+549 11 7589 2397', 'iuouewiowjj@gmail.com', 'leandro', 'admin', NULL, NULL, NULL),
	(7, 1, 'Sofia', 'Catacata', '+549 11 5378 9988', 'eourwieuwegvdc@gmail.com', 'sofia', 'admin', NULL, NULL, NULL),
	(8, 2, 'Lucas', 'G', '1245789963', 'lucas@hotmail.com', 'lucas', 'lucas', NULL, NULL, NULL),
	(9, 3, 'Daniel', 'Sanchez', '+549 11 8564 4564', 'dani@hotmail.com', 'dani', 'admin', NULL, NULL, NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
