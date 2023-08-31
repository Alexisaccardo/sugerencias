-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-08-2023 a las 16:31:56
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sugerencias`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencias_bd`
--

CREATE TABLE `sugerencias_bd` (
  `codigo` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `sugerencias` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sugerencias_bd`
--

INSERT INTO `sugerencias_bd` (`codigo`, `marca`, `sugerencias`) VALUES
('abc123', 'computador msi', 'carga mala');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `sugerencias_bd`
--
ALTER TABLE `sugerencias_bd`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
