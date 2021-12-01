SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP DATABASE IF EXISTS `data`;
CREATE DATABASE `data`;
USE `data`;
DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
                                `idDepartamento`   varchar(36)  NOT NULL,
                                `nombre`           varchar(40)  NOT NULL,
                                `Jefe`             varchar(255) NOT NULL,
                                `programadores`    varchar(255) NOT NULL,
                                `presupuesto`      double       NOT NULL,
                                `proyFinalizados`  varchar(255) NOT NULL,
                                `proyDesarrollo`   varchar(255) NOT NULL,
                                `presupuestoAnual` double       NOT NULL,
                                `historialJefes`   varchar(255) NOT NULL,
                                PRIMARY KEY (`idDepartamento`)

);
INSERT INTO `departamento` (`idDepartamento`, `nombre`, `Jefe`, `programadores`, `presupuesto`, `proyFinalizados`,
                            `proyDesarrollo`, `presupuestoAnual`, `historialJefes`)
VALUES ('1e89386d-be37-4930-b6ae-bcba6c9917b4', 'Recursos Humanos', '53269670-1586-49ac-9df5-62ddd55f96cc',
        'ba2bfe86-855d-4f2c-bb92-2ad8f1db788e;53269670-1586-49ac-9df5-62ddd55f96cc', 5000,
        '81ee1211-760c-493d-968a-380e6af67363', 'f89062d9-ba34-40a4-b6af-a21a0dc093be', 25000,
        '606aba4c-b76e-4fa3-9eb8-48e20d729353;53269670-1586-49ac-9df5-62ddd55f96cc12q'),


       ('2d1d1422-fede-4e27-8883-3ffdb1be1a7c', 'Marketing', '1376acc9-79a9-4bf1-9084-c82e9a07f432',
        '1376acc9-79a9-4bf1-9084-c82e9a07f432;5cc55142-469b-4d42-9b9b-b9df2614bcc7;d63f0d73-3f1b-4afd-b5d0-821449daa4a3',
        12000, '',
        'f89062d9-ba34-40a4-b6af-a21a0dc093be;10f2db5c-a0c3-40ec-a1bf-a95cab6bebdf', 100000,
        '606aba4c-b76e-4fa3-9eb8-48e20d729353;d63f0d73-3f1b-4afd-b5d0-821449daa4a3;1376acc9-79a9-4bf1-9084-c82e9a07f432'),


       ('512a0695-3294-4c2c-86d9-4babd4485fa8', 'Logistica', '606aba4c-b76e-4fa3-9eb8-48e20d729353',
        '606aba4c-b76e-4fa3-9eb8-48e20d729353;6a69db52-f903-4978-ac08-dc32831d362e;6ba7cbcb-7f95-4c6f-b735-2a5e0a363e52',
        15500, '3730b275-3ed2-4d77-8ff4-f5ce82ea98ea;81ee1211-760c-493d-968a-380e6af67363',
        'f89062d9-ba34-40a4-b6af-a21a0dc093be', 92800,
        '5cc55142-469b-4d42-9b9b-b9df2614bcc7;606aba4c-b76e-4fa3-9eb8-48e20d729353');

DROP TABLE IF EXISTS `commit`;
CREATE TABLE `commit`
(
    `idCommit`    varchar(36)  NOT NULL,
    `titulo`      varchar(15)  NOT NULL,
    `texto`       varchar(150) NOT NULL,
    `fecha`       date         NOT NULL,
    `repositorio` varchar(36)  NOT NULL,
    `proyecto`    varchar(36)  NOT NULL,
    `autor`       varchar(36)  NOT NULL,
    `issue`       varchar(36)  NOT NULL,
    PRIMARY KEY (`idCommit`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `commit` (`idCommit`, `titulo`, `texto`, `fecha`,
                      `repositorio`, `proyecto`, `autor`, `issue`)
VALUES ('5b64bfd6-08e4-4325-b037-bd4fcfafe783', 'commit 1', 'cambio 1',
        '2002-02-01', 'f64c5364-faa7-41b7-bca9-3b27f95d8fa8',
        '81ee1211-760c-493d-968a-380e6af67363', '53269670-1586-49ac-9df5-62ddd55f96cc',
        '53269670-1586-49ac-9df5-62ddd55f96cc'),

       ('649ad8bd-6d6e-4430-af04-9fcfe370db84', 'commit 2', 'cambio 2',
        '2012-12-10', 'f1174508-8659-4654-82ce-af2704a152de',
        'f89062d9-ba34-40a4-b6af-a21a0dc093be', '606aba4c-b76e-4fa3-9eb8-48e20d729353',
        '6c5b7c5a-d30b-400f-9c11-84dc2b49f01e'),

       ('3a1690b0-b7f3-4303-8413-1f63578c3194', 'commit 3', 'cambio 3',
        '2016-05-10', 'f1174508-8659-4654-82ce-af2704a152de',
        'f89062d9-ba34-40a4-b6af-a21a0dc093be', '606aba4c-b76e-4fa3-9eb8-48e20d729353',
        '6c5b7c5a-d30b-400f-9c11-84dc2b49f01e');
