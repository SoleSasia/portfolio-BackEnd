-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 01-09-2022 a las 21:10:26
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portfolio_solesasia`
--
CREATE DATABASE IF NOT EXISTS `portfolio_solesasia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `portfolio_solesasia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `educacion`
--

CREATE TABLE `educacion` (
  `id` bigint(20) NOT NULL,
  `descripcion_edu` varchar(255) DEFAULT NULL,
  `nombre_institu_edu` varchar(255) DEFAULT NULL,
  `periodo_edu` varchar(255) DEFAULT NULL,
  `titulo_edu` varchar(255) DEFAULT NULL,
  `url_logo_edu` varchar(255) DEFAULT NULL,
  `institucion_edu` varchar(255) DEFAULT NULL,
  `persona_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

CREATE TABLE `experiencia` (
  `id` bigint(20) NOT NULL,
  `descripcion_expe` varchar(255) DEFAULT NULL,
  `organismo_expe` varchar(255) DEFAULT NULL,
  `periodo_expe` varchar(255) DEFAULT NULL,
  `persona_id` bigint(20) DEFAULT NULL,
  `puesto_expe` varchar(255) DEFAULT NULL,
  `url_logo_expe` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidad_blanda`
--

CREATE TABLE `habilidad_blanda` (
  `id` bigint(20) NOT NULL,
  `nombre_habilidad` varchar(255) DEFAULT NULL,
  `persona_id` bigint(20) DEFAULT NULL,
  `url_icono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidad_tecnica`
--

CREATE TABLE `habilidad_tecnica` (
  `id` bigint(20) NOT NULL,
  `nivel_id` bigint(20) DEFAULT NULL,
  `nombre_habilidad` varchar(255) DEFAULT NULL,
  `persona_id` bigint(20) DEFAULT NULL,
  `url_icono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivel_habilidad`
--

CREATE TABLE `nivel_habilidad` (
  `id` bigint(20) NOT NULL,
  `nombre_nivel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `banner_url` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `github_url` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `linkedin_url` varchar(255) DEFAULT NULL,
  `ocupacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `id` bigint(20) NOT NULL,
  `descripcion_proyecto` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `live_url` varchar(255) DEFAULT NULL,
  `nombre_proyecto` varchar(255) DEFAULT NULL,
  `persona_id` bigint(20) DEFAULT NULL,
  `repo_url` varchar(255) DEFAULT NULL,
  `descripcion_proye` varchar(255) DEFAULT NULL,
  `nombre_proye` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `educacion`
--
ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8co4tldnpfbl6l8oc06veg4jr` (`persona_id`);

--
-- Indices de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK30e9aa2tv4x2kirmadmmggsme` (`persona_id`);

--
-- Indices de la tabla `habilidad_blanda`
--
ALTER TABLE `habilidad_blanda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3e2i66m8s6byd8xx4tk17u16` (`persona_id`);

--
-- Indices de la tabla `habilidad_tecnica`
--
ALTER TABLE `habilidad_tecnica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1fnpwtwuw5s57dk4gyqvy2hm9` (`persona_id`),
  ADD KEY `FKp89vdk8q4q5wjq2wwrln79njd` (`nivel_id`);

--
-- Indices de la tabla `nivel_habilidad`
--
ALTER TABLE `nivel_habilidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `educacion`
--
ALTER TABLE `educacion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `habilidad_blanda`
--
ALTER TABLE `habilidad_blanda`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `habilidad_tecnica`
--
ALTER TABLE `habilidad_tecnica`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `nivel_habilidad`
--
ALTER TABLE `nivel_habilidad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `educacion`
--
ALTER TABLE `educacion`
  ADD CONSTRAINT `FK8co4tldnpfbl6l8oc06veg4jr` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD CONSTRAINT `FK30e9aa2tv4x2kirmadmmggsme` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `habilidad_blanda`
--
ALTER TABLE `habilidad_blanda`
  ADD CONSTRAINT `FK3e2i66m8s6byd8xx4tk17u16` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `habilidad_tecnica`
--
ALTER TABLE `habilidad_tecnica`
  ADD CONSTRAINT `FK1fnpwtwuw5s57dk4gyqvy2hm9` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`),
  ADD CONSTRAINT `FKp89vdk8q4q5wjq2wwrln79njd` FOREIGN KEY (`nivel_id`) REFERENCES `nivel_habilidad` (`id`);

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `fk` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
