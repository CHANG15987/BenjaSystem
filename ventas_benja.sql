-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2024 a las 14:29:05
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ventas_benja`
--
CREATE DATABASE IF NOT EXISTS `ventas_benja` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ventas_benja`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias_productos`
--

DROP TABLE IF EXISTS `categorias_productos`;
CREATE TABLE `categorias_productos` (
  `id_categoria` varchar(10) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `categorias_productos`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `id_cliente` varchar(10) NOT NULL,
  `dni` int(9) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `apellido` varchar(70) DEFAULT NULL,
  `telefono` int(12) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `id_distrito` varchar(10) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `clientes`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobantes`
--

DROP TABLE IF EXISTS `comprobantes`;
CREATE TABLE `comprobantes` (
  `id_comprobante` varchar(10) NOT NULL,
  `id_usuario` varchar(10) NOT NULL,
  `tipo_comprobante` enum('boleta','factura') NOT NULL,
  `numero_comprobante` varchar(20) NOT NULL,
  `fecha_compra` timestamp NOT NULL DEFAULT current_timestamp(),
  `monto_total` decimal(10,2) NOT NULL,
  `impuestos` decimal(10,2) NOT NULL,
  `metodo_pago` enum('efectivo','tarjeta_credito','tarjeta_debito','transferencia','yape','plin') NOT NULL,
  `estado_pago` enum('pendiente','pagado','cancelado','') NOT NULL DEFAULT 'pendiente',
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `comprobantes`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distritos`
--

DROP TABLE IF EXISTS `distritos`;
CREATE TABLE `distritos` (
  `id_distrito` varchar(10) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `distritos`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id_producto` varchar(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `id_categoria` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `productos`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` varchar(10) NOT NULL,
  `dni` int(9) NOT NULL,
  `nombre` varchar(70) NOT NULL DEFAULT 'NOT NULL',
  `apellido` varchar(70) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `contrasena` varchar(255) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `genero` enum('M','F','O') NOT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `id_distrito` varchar(10) NOT NULL,
  `telefono` int(20) DEFAULT NULL,
  `tipo_usuario` enum('admin','vendedor','usuario') NOT NULL DEFAULT 'usuario',
  `estado` enum('activo','inactivo') NOT NULL DEFAULT 'activo',
  `fecha_creacion` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `usuarios`:
--

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `dni`, `nombre`, `apellido`, `email`, `contrasena`, `fecha_nacimiento`, `genero`, `direccion`, `id_distrito`, `telefono`, `tipo_usuario`, `estado`, `fecha_creacion`) VALUES
('U00001', 78377486, 'CHANG KEVIN', 'GUEVARA SAPA', 'KGUEVARASAPA@GMAIL.COM', '12345678', '2001-07-30', 'M', 'AV.ALEJANDRO BERTELLO383', 'D00001', 935356701, 'admin', 'activo', '2024-06-17 07:27:08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `id_venta` varchar(10) NOT NULL,
  `id_producto` varchar(10) NOT NULL,
  `id_usuario` varchar(10) NOT NULL,
  `cantidad_vendida` int(11) NOT NULL,
  `total_venta` decimal(10,2) NOT NULL,
  `fecha_venta` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `ventas`:
--

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias_productos`
--
ALTER TABLE `categorias_productos`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `id_distrito` (`id_distrito`);

--
-- Indices de la tabla `distritos`
--
ALTER TABLE `distritos`
  ADD PRIMARY KEY (`id_distrito`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `id_distrito` (`id_distrito`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`);


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para la tabla categorias_productos
--

--
-- Metadatos para la tabla clientes
--

--
-- Metadatos para la tabla comprobantes
--

--
-- Metadatos para la tabla distritos
--

--
-- Metadatos para la tabla productos
--

--
-- Metadatos para la tabla usuarios
--

--
-- Metadatos para la tabla ventas
--

--
-- Metadatos para la base de datos ventas_benja
--
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
