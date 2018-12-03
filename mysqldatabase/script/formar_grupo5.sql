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

-- Volcando datos para la tabla formar_grupo5.alumno: ~24 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

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
  CONSTRAINT `fk_cursada_administrativo1` FOREIGN KEY (`idAdministrativo`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_estadocurso1` FOREIGN KEY (`idEstadoCurso`) REFERENCES `estadocurso` (`idEstadoCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_instructor1` FOREIGN KEY (`idInstructor`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.cursada: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cursada` DISABLE KEYS */;
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
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;

-- Volcando estructura para tabla formar_grupo5.evaluaciontipo
CREATE TABLE IF NOT EXISTS `evaluaciontipo` (
  `idEvaluacionTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEvaluacionTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.evaluaciontipo: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluaciontipo` DISABLE KEYS */;
INSERT INTO `evaluaciontipo` (`idEvaluacionTipo`, `nombre`) VALUES
	(1, 'Parcial'),
	(2, 'Final'),
	(3, 'Trabajo Practico');
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
  CONSTRAINT `fk_inscripto_alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripto_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.inscripto: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `inscripto` DISABLE KEYS */;
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
  CONSTRAINT `fk_nota_evaluacion1` FOREIGN KEY (`idEvaluacion`) REFERENCES `evaluacion` (`idEvaluacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.nota: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
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
  CONSTRAINT `FK_recado_usuario` FOREIGN KEY (`idUsuarioPara`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_recado_usuarioDe` FOREIGN KEY (`idUsuarioDe`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla formar_grupo5.recado: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `recado` DISABLE KEYS */;
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
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
