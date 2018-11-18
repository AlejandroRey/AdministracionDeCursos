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

-- Volcando datos para la tabla gestiondecursos.alumno: ~17 rows (aproximadamente)
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
	(17, 'Nicolas', 'Dominguez', '1122334455', 'nico@hotmail.com');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.alumnoevento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alumnoevento` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumnoevento` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.asistencia: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.categoria: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`idCategoria`, `nombre`) VALUES
	(1, 'Supervisor'),
	(2, 'Administrativo'),
	(3, 'Instructor');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.contacto: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
INSERT INTO `contacto` (`idContacto`, `idCurso`, `idAlumno`, `nombre`, `apellido`, `descripcion`, `telefono`, `email`, `fechaCreacion`, `fechaAccion`) VALUES
	(1, 2, 0, 'Nicolas', 'Dominguez', 'Interes en cursos Java', '1122334455', 'nico@hotmail.com', '2018-11-05 00:00:00', '2018-11-20 00:00:00'),
	(3, 3, 0, 'Juan Carlos', 'Fernandez', 'Interes en curso C++', '113344556677', 'juan@hotmail.com', '2018-11-04 00:00:00', '2018-11-21 00:00:00'),
	(5, 3, 0, 'Gaston', 'Gimenez', 'Interes en C#', '1122333322', 'gaston@hotmail.com', '2018-11-01 00:00:00', '2018-11-21 00:00:00'),
	(6, 2, 0, 'Nicolas', 'Dominguez', 'Java', '1122334455', 'nico@hotmail.com', '2018-11-07 00:00:00', '2018-11-25 00:00:00');
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.cursada: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `cursada` DISABLE KEYS */;
INSERT INTO `cursada` (`idCursada`, `idEmpresa`, `idCurso`, `idEstadoCurso`, `idAdministrativo`, `fechaInicioInscripcion`, `fechaFinInscripcion`, `vacantes`, `fechaInicioCursada`, `diasDeClase`) VALUES
	(1, 1, 1, 2, 3, '2018-01-01 00:00:00', '2018-01-01 00:00:00', 45, '2018-02-01 00:00:00', 40),
	(2, 2, 2, 2, 3, '2018-01-01 00:00:00', '2018-01-01 00:00:00', 35, '2018-02-01 00:00:00', 33),
	(3, 3, 3, 3, 3, '2018-01-01 00:00:00', '2018-01-01 00:00:00', 25, '2018-02-01 00:00:00', 45);
/*!40000 ALTER TABLE `cursada` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.curso: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idCurso`, `idCursoTipo`, `nombre`, `tema`, `temario`) VALUES
	(1, 1, 'C#', 'Curso Programacion C#', 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA'),
	(2, 1, 'Java', 'Curso Programacion Java', 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBB'),
	(3, 1, 'C++', 'Curso Programacion C++', 'CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.cursotipo
CREATE TABLE IF NOT EXISTS `cursotipo` (
  `idCursoTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCursoTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.cursotipo: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cursotipo` DISABLE KEYS */;
INSERT INTO `cursotipo` (`idCursoTipo`, `nombre`) VALUES
	(1, 'Informatica'),
	(2, 'Administracion de Empresas'),
	(3, 'Gestion Aduanera'),
	(4, 'Mecanica Automotriz');
/*!40000 ALTER TABLE `cursotipo` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.diacursadaclase: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `diacursadaclase` DISABLE KEYS */;
INSERT INTO `diacursadaclase` (`idCursada`, `idDia`, `nombreDia`, `horaInicio`, `horaFin`, `idSala`) VALUES
	(2, 1, 'Lunes', '00:00:00', '03:00:00', NULL),
	(2, 3, 'Miércoles', '00:00:00', '03:00:00', NULL),
	(1, 1, 'Lunes', '00:30:00', '02:00:00', NULL),
	(1, 3, 'Miércoles', '00:30:00', '02:00:00', NULL);
/*!40000 ALTER TABLE `diacursadaclase` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.empresa: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`idEmpresa`, `nombre`, `telefono`, `email`) VALUES
	(1, 'N/A', 'N/A', 'N/A'),
	(2, 'Sancor', '+549 11 2111 9876', 'sancor@gmail.com'),
	(3, 'Unilever', '+549 11 1211 0998', 'unilever@gmail.com');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.estadocurso
CREATE TABLE IF NOT EXISTS `estadocurso` (
  `idEstadoCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.estadocurso: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `estadocurso` DISABLE KEYS */;
INSERT INTO `estadocurso` (`idEstadoCurso`, `nombre`) VALUES
	(1, 'Inscripcion Abierta'),
	(2, 'Curso Iniciado'),
	(3, 'Curso Cerrado'),
	(4, 'Curso Cancelado');
/*!40000 ALTER TABLE `estadocurso` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.evaluacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.evaluaciontipo
CREATE TABLE IF NOT EXISTS `evaluaciontipo` (
  `idEvaluacionTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEvaluacionTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.evaluaciontipo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluaciontipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluaciontipo` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.fechacursadaclase: ~132 rows (aproximadamente)
/*!40000 ALTER TABLE `fechacursadaclase` DISABLE KEYS */;
INSERT INTO `fechacursadaclase` (`idFechaCursadaClase`, `idCursada`, `idSala`, `fechaInicio`, `fechaFin`, `estadoSala`) VALUES
	(1, 1, 1, '2018-02-05 04:00:00', '2018-02-05 06:00:00', 0),
	(2, 1, 1, '2018-02-05 10:00:00', '2018-02-05 18:30:00', 0),
	(3, 1, 1, '2018-02-12 04:00:00', '2018-02-12 06:00:00', 0),
	(4, 1, 1, '2018-02-12 10:00:00', '2018-02-12 18:30:00', 0),
	(5, 1, 1, '2018-02-19 04:00:00', '2018-02-19 06:00:00', 0),
	(6, 1, 1, '2018-02-19 10:00:00', '2018-02-19 18:30:00', 0),
	(7, 1, 1, '2018-02-26 04:00:00', '2018-02-26 06:00:00', 0),
	(8, 1, 1, '2018-02-26 10:00:00', '2018-02-26 18:30:00', 0),
	(9, 1, 1, '2018-03-05 04:00:00', '2018-03-05 06:00:00', 0),
	(10, 1, 1, '2018-03-05 10:00:00', '2018-03-05 18:30:00', 0),
	(11, 1, 1, '2018-03-12 04:00:00', '2018-03-12 06:00:00', 0),
	(12, 1, 1, '2018-03-12 10:00:00', '2018-03-12 18:30:00', 0),
	(13, 1, 1, '2018-03-19 04:00:00', '2018-03-19 06:00:00', 0),
	(14, 1, 1, '2018-03-19 10:00:00', '2018-03-19 18:30:00', 0),
	(15, 1, 1, '2018-03-26 04:00:00', '2018-03-26 06:00:00', 0),
	(16, 1, 1, '2018-03-26 10:00:00', '2018-03-26 18:30:00', 0),
	(17, 1, 1, '2018-04-02 04:00:00', '2018-04-02 06:00:00', 0),
	(18, 1, 1, '2018-04-02 10:00:00', '2018-04-02 18:30:00', 0),
	(19, 1, 1, '2018-04-09 04:00:00', '2018-04-09 06:00:00', 0),
	(20, 1, 1, '2018-04-09 10:00:00', '2018-04-09 18:30:00', 0),
	(21, 1, 1, '2018-04-16 04:00:00', '2018-04-16 06:00:00', 0),
	(22, 1, 1, '2018-04-16 10:00:00', '2018-04-16 18:30:00', 0),
	(23, 1, 1, '2018-04-23 04:00:00', '2018-04-23 06:00:00', 0),
	(24, 1, 1, '2018-04-23 10:00:00', '2018-04-23 18:30:00', 0),
	(25, 1, 1, '2018-04-30 04:00:00', '2018-04-30 06:00:00', 0),
	(26, 1, 1, '2018-04-30 10:00:00', '2018-04-30 18:30:00', 0),
	(27, 1, 1, '2018-05-07 04:00:00', '2018-05-07 06:00:00', 0),
	(28, 1, 1, '2018-05-07 10:00:00', '2018-05-07 18:30:00', 0),
	(29, 1, 1, '2018-05-14 04:00:00', '2018-05-14 06:00:00', 0),
	(30, 1, 1, '2018-05-14 10:00:00', '2018-05-14 18:30:00', 0),
	(31, 1, 1, '2018-05-21 04:00:00', '2018-05-21 06:00:00', 0),
	(32, 1, 1, '2018-05-21 10:00:00', '2018-05-21 18:30:00', 0),
	(33, 1, 1, '2018-05-28 04:00:00', '2018-05-28 06:00:00', 0),
	(34, 1, 1, '2018-05-28 10:00:00', '2018-05-28 18:30:00', 0),
	(35, 1, 1, '2018-06-04 04:00:00', '2018-06-04 06:00:00', 0),
	(36, 1, 1, '2018-06-04 10:00:00', '2018-06-04 18:30:00', 0),
	(37, 1, 1, '2018-06-11 04:00:00', '2018-06-11 06:00:00', 0),
	(38, 1, 1, '2018-06-11 10:00:00', '2018-06-11 18:30:00', 0),
	(39, 1, 1, '2018-06-18 05:00:00', '2018-06-18 06:00:00', 0),
	(40, 1, 1, '2018-06-18 17:00:00', '2018-06-18 18:30:00', 0),
	(41, 1, 1, '2018-02-05 04:00:00', '2018-02-05 06:00:00', 0),
	(42, 1, 1, '2018-02-05 10:00:00', '2018-02-05 18:30:00', 0),
	(43, 1, 1, '2018-02-12 04:00:00', '2018-02-12 06:00:00', 0),
	(44, 1, 1, '2018-02-12 10:00:00', '2018-02-12 18:30:00', 0),
	(45, 1, 1, '2018-02-19 04:00:00', '2018-02-19 06:00:00', 0),
	(46, 1, 1, '2018-02-19 10:00:00', '2018-02-19 18:30:00', 0),
	(47, 1, 1, '2018-02-26 04:00:00', '2018-02-26 06:00:00', 0),
	(48, 1, 1, '2018-02-26 10:00:00', '2018-02-26 18:30:00', 0),
	(49, 1, 1, '2018-03-05 04:00:00', '2018-03-05 06:00:00', 0),
	(50, 1, 1, '2018-03-05 10:00:00', '2018-03-05 18:30:00', 0),
	(51, 1, 1, '2018-03-12 04:00:00', '2018-03-12 06:00:00', 0),
	(52, 1, 1, '2018-03-12 10:00:00', '2018-03-12 18:30:00', 0),
	(53, 1, 1, '2018-03-19 04:00:00', '2018-03-19 06:00:00', 0),
	(54, 1, 1, '2018-03-19 10:00:00', '2018-03-19 18:30:00', 0),
	(55, 1, 1, '2018-03-26 04:00:00', '2018-03-26 06:00:00', 0),
	(56, 1, 1, '2018-03-26 10:00:00', '2018-03-26 18:30:00', 0),
	(57, 1, 1, '2018-04-02 04:00:00', '2018-04-02 06:00:00', 0),
	(58, 1, 1, '2018-04-02 10:00:00', '2018-04-02 18:30:00', 0),
	(59, 1, 1, '2018-04-09 04:00:00', '2018-04-09 06:00:00', 0),
	(60, 1, 1, '2018-04-09 10:00:00', '2018-04-09 18:30:00', 0),
	(61, 1, 1, '2018-04-16 04:00:00', '2018-04-16 06:00:00', 0),
	(62, 1, 1, '2018-04-16 10:00:00', '2018-04-16 18:30:00', 0),
	(63, 1, 1, '2018-04-23 04:00:00', '2018-04-23 06:00:00', 0),
	(64, 1, 1, '2018-04-23 10:00:00', '2018-04-23 18:30:00', 0),
	(65, 1, 1, '2018-04-30 04:00:00', '2018-04-30 06:00:00', 0),
	(66, 1, 1, '2018-04-30 10:00:00', '2018-04-30 18:30:00', 0),
	(67, 1, 1, '2018-05-07 04:00:00', '2018-05-07 06:00:00', 0),
	(68, 1, 1, '2018-05-07 10:00:00', '2018-05-07 18:30:00', 0),
	(69, 1, 1, '2018-05-14 04:00:00', '2018-05-14 06:00:00', 0),
	(70, 1, 1, '2018-05-14 10:00:00', '2018-05-14 18:30:00', 0),
	(71, 1, 1, '2018-05-21 04:00:00', '2018-05-21 06:00:00', 0),
	(72, 1, 1, '2018-05-21 10:00:00', '2018-05-21 18:30:00', 0),
	(73, 1, 1, '2018-05-28 04:00:00', '2018-05-28 06:00:00', 0),
	(74, 1, 1, '2018-05-28 10:00:00', '2018-05-28 18:30:00', 0),
	(75, 1, 1, '2018-06-04 04:00:00', '2018-06-04 06:00:00', 0),
	(76, 1, 1, '2018-06-04 10:00:00', '2018-06-04 18:30:00', 0),
	(77, 1, 1, '2018-06-11 04:00:00', '2018-06-11 06:00:00', 0),
	(78, 1, 1, '2018-06-11 10:00:00', '2018-06-11 18:30:00', 0),
	(79, 1, 1, '2018-06-18 05:00:00', '2018-06-18 06:00:00', 0),
	(80, 1, 1, '2018-06-18 17:00:00', '2018-06-18 18:30:00', 0),
	(81, 1, 1, '2018-11-11 05:00:00', '2018-11-11 06:00:00', 0),
	(82, 1, 1, '2018-11-11 17:00:00', '2018-11-11 18:00:00', 0),
	(83, 1, 1, '2018-11-02 04:00:00', '2018-11-02 06:00:00', 0),
	(84, 1, 1, '2018-11-02 16:00:00', '2018-11-02 17:00:00', 0),
	(85, 1, 1, '2018-10-11 05:00:00', '2018-10-11 06:00:00', 0),
	(86, 1, 1, '2018-10-11 17:00:00', '2018-10-11 18:00:00', 0),
	(87, 1, 1, '2018-10-12 04:00:00', '2018-10-12 06:00:00', 0),
	(88, 1, 1, '2018-10-12 16:00:00', '2018-10-12 17:00:00', 0),
	(89, 1, 1, '2018-09-21 05:00:00', '2018-09-21 06:00:00', 0),
	(90, 1, 1, '2018-09-21 17:00:00', '2018-09-21 18:00:00', 0),
	(91, 1, 1, '2018-09-02 04:00:00', '2018-09-02 06:00:00', 0),
	(92, 1, 1, '2018-09-02 16:00:00', '2018-09-02 17:00:00', 0),
	(93, 1, 1, '2018-08-11 05:00:00', '2018-08-11 06:00:00', 0),
	(94, 1, 1, '2018-08-11 17:00:00', '2018-08-11 18:00:00', 0),
	(95, 1, 1, '2018-08-11 04:00:00', '2018-08-11 05:00:00', 0),
	(96, 1, 1, '2018-08-11 16:00:00', '2018-08-11 17:00:00', 0),
	(97, 1, 1, '2018-07-11 07:00:00', '2018-07-11 08:00:00', 0),
	(98, 1, 1, '2018-07-11 17:00:00', '2018-07-11 18:00:00', 0),
	(99, 1, 1, '2018-07-11 04:00:00', '2018-07-11 06:00:00', 0),
	(100, 1, 1, '2018-07-14 16:00:00', '2018-07-14 17:00:00', 0),
	(101, 1, 1, '2018-11-15 05:00:00', '2018-11-15 06:00:00', 0),
	(102, 1, 1, '2018-11-15 17:00:00', '2018-11-15 18:00:00', 0),
	(103, 1, 1, '2018-11-15 04:00:00', '2018-11-15 06:00:00', 0),
	(104, 1, 1, '2018-11-15 16:00:00', '2018-11-15 17:00:00', 0),
	(105, 1, 1, '2018-10-19 05:00:00', '2018-10-19 06:00:00', 0),
	(106, 1, 1, '2018-10-19 17:00:00', '2018-10-19 18:00:00', 0),
	(107, 1, 1, '2018-10-19 04:00:00', '2018-10-19 06:00:00', 0),
	(108, 1, 1, '2018-10-19 15:00:00', '2018-10-19 17:00:00', 0),
	(109, 1, 1, '2018-09-05 04:00:00', '2018-09-05 06:00:00', 0),
	(110, 1, 1, '2018-09-05 16:00:00', '2018-09-05 18:00:00', 0),
	(111, 1, 1, '2018-09-05 02:00:00', '2018-09-05 03:00:00', 0),
	(112, 1, 1, '2018-09-05 18:00:00', '2018-09-05 19:00:00', 0),
	(113, 1, 1, '2018-08-17 04:00:00', '2018-08-17 06:00:00', 0),
	(114, 1, 1, '2018-08-17 16:00:00', '2018-08-17 18:00:00', 0),
	(115, 1, 1, '2018-08-17 02:00:00', '2018-08-17 04:00:00', 0),
	(116, 1, 1, '2018-08-17 18:00:00', '2018-08-17 20:00:00', 0),
	(117, 1, 1, '2018-07-25 06:00:00', '2018-07-25 08:00:00', 0),
	(118, 1, 1, '2018-07-25 16:00:00', '2018-07-25 18:00:00', 0),
	(119, 1, 1, '2018-07-25 04:00:00', '2018-07-25 06:00:00', 0),
	(120, 1, 1, '2018-07-25 18:00:00', '2018-07-25 21:00:00', 0),
	(121, 1, 1, '2018-07-31 06:00:00', '2018-07-31 08:00:00', 0),
	(122, 1, 1, '2018-07-31 16:00:00', '2018-07-31 18:00:00', 0),
	(123, 1, 1, '2018-07-31 04:00:00', '2018-07-31 06:00:00', 0),
	(124, 1, 1, '2018-07-31 18:00:00', '2018-07-31 21:00:00', 0),
	(125, 1, 1, '2018-11-27 02:00:00', '2018-11-27 06:00:00', 0),
	(126, 1, 1, '2018-11-27 16:00:00', '2018-11-27 18:00:00', 0),
	(127, 1, 1, '2018-11-27 04:00:00', '2018-11-27 06:00:00', 0),
	(128, 1, 1, '2018-11-27 18:00:00', '2018-11-27 21:00:00', 0),
	(129, 1, 1, '2018-10-25 02:00:00', '2018-10-25 06:00:00', 0),
	(130, 1, 1, '2018-10-25 17:00:00', '2018-10-25 21:00:00', 0),
	(131, 1, 1, '2018-10-25 06:00:00', '2018-10-25 10:00:00', 0),
	(132, 1, 1, '2018-10-25 15:00:00', '2018-10-25 17:00:00', 0);
/*!40000 ALTER TABLE `fechacursadaclase` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.inscripto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `inscripto` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripto` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.instructor
CREATE TABLE IF NOT EXISTS `instructor` (
  `idUsuario` int(11) NOT NULL,
  `idCursoTipo` int(11) NOT NULL,
  KEY `fk_Instructor_cursotipo1_idx` (`idCursoTipo`),
  KEY `fk_Instructor_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_Instructor_cursotipo1` FOREIGN KEY (`idCursoTipo`) REFERENCES `cursotipo` (`idCursoTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instructor_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.instructor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.instructorcursada
CREATE TABLE IF NOT EXISTS `instructorcursada` (
  `idCursada` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  KEY `fk_instructorcursada_cursada1_idx` (`idCursada`),
  KEY `fk_instructorcursada_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_instructorcursada_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructorcursada_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.instructorcursada: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `instructorcursada` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructorcursada` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.nota: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.pago: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.pagocalendario
CREATE TABLE IF NOT EXISTS `pagocalendario` (
  `idPagoCalendario` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idPagoCalendario`),
  KEY `fk_pago_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_pago_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.pagocalendario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pagocalendario` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagocalendario` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondecursos.sala
CREATE TABLE IF NOT EXISTS `sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantidadAlumnos` int(11) NOT NULL,
  `cantidadPc` int(11) NOT NULL,
  `descripcion` varchar(510) NOT NULL,
  PRIMARY KEY (`idSala`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestiondecursos.sala: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` (`idSala`, `nombre`, `cantidadAlumnos`, `cantidadPc`, `descripcion`) VALUES
	(1, 'Sin Asignar', 0, 2, 'Sala sin uso.Desea asignarla.'),
	(3, 'Plata', 33, 25, 'Sala ok'),
	(4, 'Bronce', 25, 25, 'Sala ok'),
	(5, 'Oro', 25, 25, 'Sala ok');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.tarea: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;

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

-- Volcando datos para la tabla gestiondecursos.usuario: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`, `idCategoria`, `nombre`, `apellido`, `telefono`, `email`, `usuario`, `password`, `nombreDia`, `horaInicio`, `horaFin`) VALUES
	(1, 1, 'Alejandro', 'Rey', '+549 11 2211 9999', 'alejakakjdjdj@gmail.com', 'alejandro', 'admin', NULL, NULL, NULL),
	(2, 1, 'Marcos', 'Lever', '+549 11 3443 9921', 'hdsdhewd@gmail.com', 'marcos', 'admin', NULL, NULL, NULL),
	(3, 2, 'Pablo', 'Drink', '+549 11 7755 9932', 'frerfsdscvsdc@gmail.com', 'pablo', 'admin', NULL, NULL, NULL),
	(4, 3, 'Gonzalo', 'Paolinelli', '+549 11 8272 5637', 'rqetgdfvdsaodkas@gmail.com', 'gonzalo', 'admin', NULL, NULL, NULL),
	(5, 1, 'Emiliano', 'Saucedo', '+549 11 6729 2891', 'ewrewwef@gmail.com', 'emiliano', 'admin', NULL, NULL, NULL),
	(6, 3, 'Leandro', 'Jobs', '+549 11 7589 2397', 'iuouewiowjj@gmail.com', 'leandro', 'admin', NULL, NULL, NULL),
	(7, 1, 'Sofia', 'Catacata', '+549 11 5378 9988', 'eourwieuwegvdc@gmail.com', 'sofia', 'admin', NULL, NULL, NULL),
	(8, 2, 'Lucas', 'G', '1245789963', 'lucas@hotmail.com', 'lucas', 'lucas', NULL, NULL, NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
