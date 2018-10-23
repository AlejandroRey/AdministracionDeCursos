-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: gestiondecursos
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Alejandro','Rey','+549 11 3344 5555','dcjaskdckacgd@gmail.com'),(2,'Ricardo','Ferreira','+549 11 9999 2222','wqdqefqef@gmail.com'),(3,'Enzo','Perez','+549 11 2132 2321','dqdewf@gmail.com'),(4,'Milton','Casco','+549 11 2409 8792','twtferfe@gmail.com'),(5,'Rafael','Santos','+549 11 3791 0987','ertewrter@gmail.com'),(6,'Ramiro','Funes Moris','+549 11 3791 0987','eweeqwqe@gmail.com'),(7,'Ariel','Ortega','+549 11 3791 0987','jhjjhbdfg@gmail.com'),(8,'Vanina','Gomez','+549 11 3791 0987','pdwofqfwldl@gmail.com'),(9,'Susana','Lopez','+549 11 3791 0987','ksiwemdb@gmail.com'),(10,'Javier','Moro','+549 11 3791 0987','kashuewpo@gmail.com');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnoevento`
--

DROP TABLE IF EXISTS `alumnoevento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnoevento` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnoevento`
--

LOCK TABLES `alumnoevento` WRITE;
/*!40000 ALTER TABLE `alumnoevento` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumnoevento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencia` (
  `idAlumno` int(11) NOT NULL,
  `idClase` int(11) NOT NULL,
  `tipoAsistencia` varchar(255) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  KEY `fk_asistencia_clase1_idx` (`idClase`),
  KEY `fk_asistencia_inscripto1_idx` (`idAlumno`),
  CONSTRAINT `fk_asistencia_clase1` FOREIGN KEY (`idClase`) REFERENCES `fechacursadaclase` (`idFechaCursadaClase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asistencia_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Supervisor'),(2,'Administrativo'),(3,'Instructor');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursada`
--

DROP TABLE IF EXISTS `cursada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursada` (
  `idCursada` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` int(11) NOT NULL DEFAULT '1',
  `idCurso` int(11) NOT NULL,
  `idEstadoCurso` int(11) NOT NULL DEFAULT '1',
  `fechaInicioInscripcion` datetime NOT NULL,
  `fechaFinInscripcion` datetime NOT NULL,
  `vacantes` int(11) NOT NULL,
  `fechaInicioCursada` datetime NOT NULL,
  `diasDeClase` int(11) NOT NULL,
  PRIMARY KEY (`idCursada`),
  KEY `fk_cursada_curso1_idx` (`idCurso`),
  KEY `fk_cursada_estadoCurso1_idx` (`idEstadoCurso`),
  KEY `fk_cursada_empresa1_idx` (`idEmpresa`),
  CONSTRAINT `fk_cursada_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursada_estadoCurso1` FOREIGN KEY (`idEstadoCurso`) REFERENCES `estadocurso` (`idEstadoCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursada`
--

LOCK TABLES `cursada` WRITE;
/*!40000 ALTER TABLE `cursada` DISABLE KEYS */;
INSERT INTO `cursada` VALUES (1,1,1,1,'2018-01-01 00:00:00','2018-01-01 00:00:00',45,'2018-02-01 00:00:00',40),(2,2,2,2,'2018-01-01 00:00:00','2018-01-01 00:00:00',35,'2018-02-01 00:00:00',33),(3,3,3,3,'2018-01-01 00:00:00','2018-01-01 00:00:00',25,'2018-02-01 00:00:00',45);
/*!40000 ALTER TABLE `cursada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `idCursoTipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tema` varchar(45) NOT NULL,
  `temario` varchar(2550) NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `fk_curso_cursotipo1_idx` (`idCursoTipo`),
  CONSTRAINT `fk_curso_cursotipo1` FOREIGN KEY (`idCursoTipo`) REFERENCES `cursotipo` (`idCursoTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,1,'C#','Curso Programacion C#','AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA'),(2,1,'Java','Curso Programacion Java','BBBBBBBBBBBBBBBBBBBBBBBBBBBBB'),(3,1,'C++','Curso Programacion C++','CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursotipo`
--

DROP TABLE IF EXISTS `cursotipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursotipo` (
  `idCursoTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCursoTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursotipo`
--

LOCK TABLES `cursotipo` WRITE;
/*!40000 ALTER TABLE `cursotipo` DISABLE KEYS */;
INSERT INTO `cursotipo` VALUES (1,'Informatica'),(2,'Administracion de Empresas'),(3,'Gestion Aduanera'),(4,'Mecanica Automotriz');
/*!40000 ALTER TABLE `cursotipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diacursadaclase`
--

DROP TABLE IF EXISTS `diacursadaclase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diacursadaclase` (
  `idCursada` int(11) NOT NULL,
  `idDia` int(11) NOT NULL,
  `nombreDia` varchar(45) NOT NULL,
  `horaInicio` datetime NOT NULL,
  `horaFin` datetime NOT NULL,
  KEY `fk_horario_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_horario_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diacursadaclase`
--

LOCK TABLES `diacursadaclase` WRITE;
/*!40000 ALTER TABLE `diacursadaclase` DISABLE KEYS */;
INSERT INTO `diacursadaclase` VALUES (2,1,'Lunes','1970-01-01 00:00:00','1970-01-01 03:00:00'),(2,3,'Miércoles','1970-01-01 00:00:00','1970-01-01 03:00:00'),(1,1,'Lunes','1970-01-01 00:30:00','1970-01-01 02:00:00'),(1,3,'Miércoles','1970-01-01 00:30:00','1970-01-01 02:00:00');
/*!40000 ALTER TABLE `diacursadaclase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'N/A','N/A','N/A'),(2,'Sancor','+549 11 2111 9876','sancor@gmail.com'),(3,'Unilever','+549 11 1211 0998','unilever@gmail.com');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocurso`
--

DROP TABLE IF EXISTS `estadocurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadocurso` (
  `idEstadoCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocurso`
--

LOCK TABLES `estadocurso` WRITE;
/*!40000 ALTER TABLE `estadocurso` DISABLE KEYS */;
INSERT INTO `estadocurso` VALUES (1,'Inscripcion Abierta'),(2,'Curso Iniciado'),(3,'Curso Cerrado'),(4,'Curso Cancelado');
/*!40000 ALTER TABLE `estadocurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluacion`
--

DROP TABLE IF EXISTS `evaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluacion` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacion`
--

LOCK TABLES `evaluacion` WRITE;
/*!40000 ALTER TABLE `evaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluaciontipo`
--

DROP TABLE IF EXISTS `evaluaciontipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluaciontipo` (
  `idEvaluacionTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEvaluacionTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluaciontipo`
--

LOCK TABLES `evaluaciontipo` WRITE;
/*!40000 ALTER TABLE `evaluaciontipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluaciontipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fechacursadaclase`
--

DROP TABLE IF EXISTS `fechacursadaclase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fechacursadaclase` (
  `idFechaCursadaClase` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  PRIMARY KEY (`idFechaCursadaClase`),
  KEY `fk_clases_cursada1_idx` (`idCursada`),
  KEY `fk_calendariocursada_sala1_idx` (`idSala`),
  CONSTRAINT `fk_calendariocursada_sala1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_clases_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fechacursadaclase`
--

LOCK TABLES `fechacursadaclase` WRITE;
/*!40000 ALTER TABLE `fechacursadaclase` DISABLE KEYS */;
INSERT INTO `fechacursadaclase` VALUES (1,1,1,'2017-10-01 01:00:00','2017-10-01 03:02:00'),(2,1,1,'2017-10-01 05:00:00','2017-10-01 08:10:00'),(3,1,1,'2017-10-01 08:23:00','2017-10-01 09:45:00'),(4,2,2,'2017-10-01 10:00:00','2017-10-01 12:33:00'),(5,2,2,'2017-10-01 13:00:00','2017-10-01 15:30:00'),(6,2,2,'2017-10-01 18:00:00','2017-10-01 23:30:00');
/*!40000 ALTER TABLE `fechacursadaclase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripto`
--

DROP TABLE IF EXISTS `inscripto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripto` (
  `idAlumno` int(11) NOT NULL,
  `idCursada` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  KEY `fk_inscripto_alumno1_idx` (`idAlumno`),
  KEY `fk_inscripto_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_inscripto_alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripto_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripto`
--

LOCK TABLES `inscripto` WRITE;
/*!40000 ALTER TABLE `inscripto` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `idUsuario` int(11) NOT NULL,
  `idCursoTipo` int(11) NOT NULL,
  KEY `fk_Instructor_cursotipo1_idx` (`idCursoTipo`),
  KEY `fk_Instructor_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_Instructor_cursotipo1` FOREIGN KEY (`idCursoTipo`) REFERENCES `cursotipo` (`idCursoTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instructor_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructores`
--

DROP TABLE IF EXISTS `instructores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructores` (
  `idCursada` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  KEY `fk_instructores_cursada1_idx` (`idCursada`),
  KEY `fk_instructores_Instructor1_idx` (`idUsuario`),
  CONSTRAINT `fk_instructores_Instructor1` FOREIGN KEY (`idUsuario`) REFERENCES `instructor` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructores_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructores`
--

LOCK TABLES `instructores` WRITE;
/*!40000 ALTER TABLE `instructores` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `idAlumno` int(11) NOT NULL,
  `idPagoCalendario` int(11) NOT NULL,
  `fechadepago` datetime NOT NULL,
  KEY `fk_pago_inscripto1_idx` (`idAlumno`),
  KEY `fk_pago_pagocalendario1_idx` (`idPagoCalendario`),
  CONSTRAINT `fk_pago_inscripto1` FOREIGN KEY (`idAlumno`) REFERENCES `inscripto` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_pagocalendario1` FOREIGN KEY (`idPagoCalendario`) REFERENCES `pagocalendario` (`idPagoCalendario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagocalendario`
--

DROP TABLE IF EXISTS `pagocalendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagocalendario` (
  `idPagoCalendario` int(11) NOT NULL AUTO_INCREMENT,
  `idCursada` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idPagoCalendario`),
  KEY `fk_pago_cursada1_idx` (`idCursada`),
  CONSTRAINT `fk_pago_cursada1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagocalendario`
--

LOCK TABLES `pagocalendario` WRITE;
/*!40000 ALTER TABLE `pagocalendario` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagocalendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantidadAlumnos` int(11) NOT NULL,
  `cantidadPc` int(11) NOT NULL,
  `descripcion` varchar(510) NOT NULL,
  PRIMARY KEY (`idSala`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,'Salita Rosa',40,20,'Sala proxima a remodelarse'),(2,' Salita Azul',40,35,'Sala ok');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarea`
--

DROP TABLE IF EXISTS `tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarea` (
  `idTarea` int(11) NOT NULL AUTO_INCREMENT,
  `idAdministrativo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(1024) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaCierre` datetime NOT NULL,
  PRIMARY KEY (`idTarea`),
  KEY `fk_tarea_usuario1_idx` (`idAdministrativo`),
  CONSTRAINT `fk_tarea_usuario1` FOREIGN KEY (`idAdministrativo`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarea_usuario2` FOREIGN KEY (`idAdministrativo`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarea`
--

LOCK TABLES `tarea` WRITE;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_usuario_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'Alejandro','Rey','+549 11 2211 9999','alejakakjdjdj@gmail.com','alejandro','admin'),(2,1,'Marcos','Lever','+549 11 3443 9921','hdsdhewd@gmail.com','marcos','admin'),(3,2,'Pablo','Drink','+549 11 7755 9932','frerfsdscvsdc@gmail.com','pablo','admin'),(4,3,'Gonzalo','Paolinelli','+549 11 8272 5637','rqetgdfvdsaodkas@gmail.com','gonzalo','admin'),(5,1,'Emiliano','Saucedo','+549 11 6729 2891','ewrewwef@gmail.com','emiliano','admin'),(6,3,'Leandro','Jobs','+549 11 7589 2397','iuouewiowjj@gmail.com','leandro','admin'),(7,1,'Sofia','Catacata','+549 11 5378 9988','eourwieuwegvdc@gmail.com','sofia','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-21 12:57:09