SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP DATABASE IF EXISTS `data`;
CREATE DATABASE `data` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `data`;
DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
                                `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                `nombre` varchar(60) NOT NULL,
                                `jefeActual` bigint(20) NOT NULL,
                                `presupuesto` decimal (20) NOT NULL,
                                `proyectosTerminados` varchar(255) NOT NULL,
                                `proyectosEnDesarrollo` varchar(255),
                                `presupuestoAnual` decimal (20) NOT NULL,
                                `historicoJefes` varchar(255),

                                PRIMARY KEY (`id`),
                                FOREIGN KEY (`jefeActual`) REFERENCES programadores(`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de Departamentos';

INSERT INTO `departamento` (`id`, `nombre`, `jefeActual`,`presupuesto`,`proyectosEnDesarrollo`,`proyectosTerminados`,`presupuestoAnual`,`historicoJefes`) VALUES
                                                                                                                                                            (1,	'Finanzas', 103, 250000.50, 'Declaración de la renta;Balance económico; Estudio de mercado;Oportunidades nicho', 'Presupuestos 2022', 145000, '101,102'),
                                                                                                                                                            (2,	'Desarrollo Web', 202, 450000.75, 'Web Santander;Wordpress Prisa', 'Reestructuración Google', 375000, '201'),
                                                                                                                                                            (3,	'Recursos humanos', 301, 125000, 'Jornadas de acogida de nuevos trabajadores;Reestructuración de personal', null, 75000, null),
                                                                                                                                                            (4,	'Aplicaciones Moviles', 402, 500500, 'App Restaurantes;Servicio NH;Transportes Ministerio','App EMT;Organización datos DB;', null, 425000, '401');

DROP TABLE IF EXISTS `proyecto`;
CREATE TABLE `proyecto` (
                            `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                            `nombre` varchar(60) NOT NULL,
                            `jefeProyecto` bigint(20) NOT NULL,
                            `presupuesto` decimal (20) NOT NULL,
                            `fechaInicio` date NOT NULL,
                            `fechaFin` date NOT NULL,
                            `tecnologias` varchar(255) NOT NULL,
                            `repositorio` varchar(60) NOT NULL,

                            PRIMARY KEY (`nombre`),

                            FOREIGN KEY (`repositorio`) REFERENCES `repositorios` (`nombre`),
                            FOREIGN KEY (`jefeProyecto`) REFERENCES `programadores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de proyecto';

INSERT INTO `proyecto` (`id`, `nombre`, `jefeProyecto`, `fechaInicio`, `fechaFin`, `tecnologias`, `repositorio`) VALUES
                                                                                                                     (1,'Declaración de la renta','110',	'2020-10-01',	'2020-10-01',	'Calculadora',	'rep1'),
                                                                                                                     (2,'Balance económico', '110',	'2019-10-01',	'2021-11-01',	'Calculadora;Papel',	'rep2'),
                                                                                                                     (3,'Estudio de mercado', '110',	'2021-08-01',	'2021-11-01',	'Calculadora;Papel;Sobornos',	'rep3'),
                                                                                                                     (4,'Oportunidades nicho', '110',	'2021-09-02',	'2021-11-01',	'Calculadora;Papel;Espionaje',	'rep4'),
                                                                                                                     (5,'Presupuestos 2022', '110',	'2021-11-01',	null,	'Fe en Dios;Papel',	'rep5'),
                                                                                                                     (6,'Web Santander', '210',	'2021-10-02',	'2021-11-01',	'Java;Python',	'rep6'),
                                                                                                                     (7,'Wordpress Prisa', '210',	'2021-10-02',	'2021-11-01',	'Html;css;JavaScript',	'rep7'),
                                                                                                                     (8,'Reestructuracion Google', '210',	'2021-10-02',	null,	4,	'rep8'),
                                                                                                                     (9,'Jornadas de acogida de nuevos trabajadores', '310',	'2021-10-02',	'2020-10-01',	'Curriculums;Trituradora de papel',	'rep9'),
                                                                                                                     (10,'Reestructuración de personal', '310',	'2021-10-02',	'2020-10-01',	'Cartas de despido',	'rep10'),
                                                                                                                     (11,'App Restaurantes', '410',	'2021-10-02',	'2020-10-01',	'Java',	'rep11'),
                                                                                                                     (12,'Servicio NH', '410',	'2021-10-02',	'2020-10-01', 'Node, TypeScript',	'rep12'),
                                                                                                                     (13,'Transportes Ministerio', '410',	'2021-10-02',	'2020-10-01',	'Kobold',	'rep13'),
                                                                                                                     (14,'App EMT', '410',	'2021-10-02',	null,	'C;Kobold',	'rep14'),
                                                                                                                     (15,'Organización datos DB', '410',	'2021-10-02',	null,	'SQL', 'rep15');

DROP TABLE IF EXISTS `programadores`;
CREATE TABLE `programadores` (
                                 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                 `nombre` varchar(60) NOT NULL,
                                 `fechaAlta` date NOT NULL,
                                 `departamento` bigint(20) NOT NULL,
                                 `proyecto` varchar(255) NOT NULL,
                                 `commits`  varchar(255),
                                 `issues` varchar(255),
                                 `tecnologias` varchar(255) NOT NULL,
                                 `salario` decimal NOT NULL,
                                 `password` varchar(255) NOT NULL,

                                 PRIMARY KEY (`id`),
                                 FOREIGN KEY (`departamento`) REFERENCES `departamento` (`id`),
                                 FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`nombre`),
                                 FOREIGN KEY (`commits`) REFERENCES `commits` (`titulo`),
                                 FOREIGN KEY (`issues`) REFERENCES `issues` (`titulo`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de programadores';

INSERT INTO `programadores` (`id`,`nombre`,`fechaAlta`,`departamento`,`proyecto`,`commits`,`issues`,`tecnologias`,`salario`,`password`) VALUES
                                                                                                                                            (1,'Mario', '2001-01-01','Aplicaciones Moviles', 'App EMT', 'Primera actualización', null,'Java;Node',2500,'kugbfjhdzbgf'),
                                                                                                                                            (2,'Andrea', '2002-02-02','Desarrollo Web', 'Reestructuración Google', 'Poniendo Colorinchis', null, 'Csharp;Java;Canvas',2500,'sduat7683r'),
                                                                                                                                            (3,'Javi', '2003-03-03','Finanzas', 'Presupuestos 2022', 'Haciendo números', null, 'Java;Canvas',3000,'287ytbdsghfs'),
                                                                                                                                            (4,'Alex', '2004-04-04','Recursos Humanos', 'Jornadas de acogida de nuevos trabajadores', 'Juzgando carne fresca', null, 'Java',1750,'fgt768a3');


DROP TABLE IF EXISTS `repositorios`;
CREATE TABLE `repositorios` (
                                `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                `nombre` varchar(60) NOT NULL,
                                `fechaCreacion` date NOT NULL,
                                `proyecto` varchar(60) NOT NULL,
                                `commits`  varchar(255),
                                `issues` varchar(255),

                                PRIMARY KEY (`nombre`),

                                FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`nombre`),
                                FOREIGN KEY (`commits`) REFERENCES `commits` (`titulo`),
                                FOREIGN KEY (`issues`) REFERENCES `issues` (`titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de repositorios';

INSERT INTO `repositorios` ( `id`,`nombre`,`fechaCreacion`, `proyecto`, `commits`, `issues`) VALUES
                                                                                                 (1,'MarioRep',	'2021-09-02',	'App EMT',	'Primera actualización',	null),
                                                                                                 (2,'AndreaRep',	'2021-10-02',	'Reestructuración Google',	'Poniendo Colorinchis',	'2021-10-01 16:12:28',	null),
                                                                                                 (3,'JaviRep',	'2021-11-02',	'Presupuestos 2022',	'Haciendo números',	'2021-10-01 16:13:00',	null),
                                                                                                 (4,'AlexRep',	'2021-12-02',	'Jornadas de acogida de nuevos trabajadores',	'Juzgando carne fresca',	null);


DROP TABLE IF EXISTS `commits`;
CREATE TABLE `commits` (
                           `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                           `titulo` varchar(255) NOT NULL,
                           `texto` varchar(255) NOT NULL,
                           `fecha` date NOT NULL,
                           `repositorio` varchar(60) NOT NULL,
                           `proyecto` varchar(60) NOT NULL,
                           `autor` varchar(60) NOT NULL,

                           PRIMARY KEY (`titulo`),

                           FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`nombre`),
                           FOREIGN KEY (`autor`) REFERENCES `programadores` (`nombre`),
                           FOREIGN KEY (`repositorio`) REFERENCES `repositorios` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de commits';

INSERT INTO `commits` (`id`,`titulo`, `texto`, `fecha`, `repositorio`, `proyecto`, `autor`) VALUES
                                                                                                (1,'Primera actualización',	'texto culaquiera del commit 1','2021-09-02', 'MarioRep', 'App EMT'),
                                                                                                (2,'Poniendo Colorinchis',	'texto culaquiera del commit 2','2021-09-02', 'AndreaRep','Reestructuración Google'),
                                                                                                (3,'Haciendo números',	'texto culaquiera del commit 3',    '2021-09-02', 'JaviRep',  'Presupuestos 2022'),
                                                                                                (4,'Juzgando carne fresca',	'texto culaquiera del commit 4','2021-09-02', 'AlexRep',  'Jornadas de acogida de nuevos trabajadores');

DROP TABLE IF EXISTS `issues`;
CREATE TABLE `issues` (
                          `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                          `titulo` varchar(255) NOT NULL,
                          `texto` varchar(255) NOT NULL,
                          `fecha` date NOT NULL,
                          `programadores` varchar(255) NOT NULL,
                          `repositorio` varchar(60) NOT NULL,
                          `proyecto` varchar(60) NOT NULL,
                          `estado`  varchar(30) NOT NULL,

                          PRIMARY KEY (`titulo`),
                          FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`nombre`),
                          FOREIGN KEY (`programadores`) REFERENCES `programadores` (`nombre`),
                          FOREIGN KEY (`repositorio`) REFERENCES `repositorios` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de issues';

INSERT INTO `issues` (`id`,`titulo`, `texto`, `fecha`, `programadores`, `repositorio`, `proyecto`, `estado`) VALUES
                                                                                                                 (1,'issue1',	'Muchos issues en el caso 1','2021-09-02'	,	'Mario',	'MarioRep',   'App EMT' , 'pendiente'),
                                                                                                                 (2,'issue2',	'Muchos issues en el caso 2','2021-09-02'	,	'Andrea',	'AndreaRep',  'Reestructuración Google' , 'pendiente'),
                                                                                                                 (3,'issue3',	'Muchos issues en el caso 3','2021-09-02'	,	'Javi',	    'JaviRep',  'Presupuestos 2022','pendiente'),
                                                                                                                 (4,'issue4',	'Muchos issues en el caso 4','2021-09-02'	,	'Alex',	    'AlexRep',  'Jornadas de acogida de nuevos trabajadores','terminada');

DROP TABLE IF EXISTS `equiposProyecto`;
CREATE TABLE equipo
(
    `proyecto`    bigint(20) NOT NULL REFERENCES `proyecto` (`id`) MATCH SIMPLE ,
    `programador` bigint(20) NOT NULL REFERENCES `programadores` (`id`) MATCH SIMPLE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de equiposProyecto';


DROP TABLE IF EXISTS `jefesDepartamento`;
CREATE TABLE jefedepartamento
(
    `departamento` bigint(20) NOT NULL REFERENCES `departamento` (`id`) MATCH SIMPLE ,
    `programador`  bigint(20) NOT NULL REFERENCES `programadores` (`id`) MATCH SIMPLE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de jefesDepartamento';

INSERT INTO `jefeDepartamento` (`departamento`,`programador`) VALUES
                                                                   (1,103),
                                                                   (2,202),
                                                                   (3,301),
                                                                   (4,402);

DROP TABLE IF EXISTS jefesProyecto;
CREATE TABLE jefeproyecto
(
    `proyecto`    bigint(20) NOT NULL REFERENCES `proyecto` (`id`) MATCH SIMPLE,
    `programador` bigint(20) NOT NULL REFERENCES `programadores` (`id`) MATCH SIMPLE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de jefesProyecto';