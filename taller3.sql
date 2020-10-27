-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2020 a las 15:11:44
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `taller3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actores`
--

CREATE TABLE `actores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `edad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `actores`
--

INSERT INTO `actores` (`id`, `nombre`, `apellido`, `edad`) VALUES
(2, 'Will', 'Smith', 43),
(11, 'Jaime', 'Cardona', 21),
(12, 'Brad', 'Pitt', 54);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actores_peliculas`
--

CREATE TABLE `actores_peliculas` (
  `id` int(11) NOT NULL,
  `actorID` int(11) DEFAULT NULL,
  `peliculaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `actores_peliculas`
--

INSERT INTO `actores_peliculas` (`id`, `actorID`, `peliculaID`) VALUES
(3, 2, 7),
(6, 2, 7),
(7, 2, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`id`, `nombre`) VALUES
(3, 'Suspenso'),
(5, 'Ciencia Ficcion'),
(7, 'Accion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `generoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `nombre`, `generoID`) VALUES
(7, 'Los Hombres de negro', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actores`
--
ALTER TABLE `actores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `actores_peliculas`
--
ALTER TABLE `actores_peliculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `actorID` (`actorID`),
  ADD KEY `peliculaID` (`peliculaID`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `generoID` (`generoID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actores`
--
ALTER TABLE `actores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `actores_peliculas`
--
ALTER TABLE `actores_peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actores_peliculas`
--
ALTER TABLE `actores_peliculas`
  ADD CONSTRAINT `actores_peliculas_ibfk_1` FOREIGN KEY (`actorID`) REFERENCES `actores` (`id`),
  ADD CONSTRAINT `actores_peliculas_ibfk_2` FOREIGN KEY (`peliculaID`) REFERENCES `peliculas` (`id`);

--
-- Filtros para la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD CONSTRAINT `peliculas_ibfk_1` FOREIGN KEY (`generoID`) REFERENCES `generos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
