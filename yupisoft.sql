-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 05-05-2018 a las 08:54:24
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `yupi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `averia`
--

CREATE TABLE `averia` (
  `idProducto` int(6) NOT NULL,
  `razonAveria` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `IdProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`IdProducto`, `cantidad`) VALUES
(800, 90),
(12466, 89);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lote`
--

CREATE TABLE `lote` (
  `fecha` varchar(10) NOT NULL,
  `idLote` varchar(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `precioCompra` double NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lote`
--

INSERT INTO `lote` (`fecha`, `idLote`, `idProducto`, `precioCompra`, `cantidad`) VALUES
('02/05/2018', 'CD0001', 123, 123456, 12),
('02/05/2018', 'CD0002', 1234, 234, 34),
('03/05/2018', 'CD0003', 800, 4, 4),
('03/05/2018', 'CD0004', 1234, 23, 34);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(6) NOT NULL,
  `nombreProducto` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `precioVenta` int(11) NOT NULL,
  `descripcion` char(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `precioVenta`, `descripcion`) VALUES
(800, 'YUPI', 900, 'SDOJFL'),
(12466, 'jh', 55, 'jjh');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidaventa`
--

CREATE TABLE `salidaventa` (
  `fecha` date NOT NULL,
  `idProducto` int(6) NOT NULL,
  `cantidad` int(5) NOT NULL,
  `idVendedor` int(10) NOT NULL,
  `idVenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `idVendedor` int(15) NOT NULL,
  `nombreVendedor` char(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(16) NOT NULL,
  `codigoZona` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`idVendedor`, `nombreVendedor`, `direccion`, `telefono`, `codigoZona`) VALUES
(1067935900, 'Kimberly Garces', 'Cra 4D#95-37', '3135098673', 123456);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioUni` double NOT NULL,
  `precioTotal` double NOT NULL,
  `idVendedor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zona`
--

CREATE TABLE `zona` (
  `codigoZona` int(6) NOT NULL,
  `nombreZona` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `porcentaje` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `zona`
--

INSERT INTO `zona` (`codigoZona`, `nombreZona`, `porcentaje`) VALUES
(12345, '', 0.3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `averia`
--
ALTER TABLE `averia`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`idLote`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `salidaventa`
--
ALTER TABLE `salidaventa`
  ADD PRIMARY KEY (`fecha`),
  ADD KEY `idVendedor` (`idVendedor`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`idVendedor`),
  ADD KEY `codigoZona` (`codigoZona`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `idVendedor` (`idVendedor`);

--
-- Indices de la tabla `zona`
--
ALTER TABLE `zona`
  ADD PRIMARY KEY (`codigoZona`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
