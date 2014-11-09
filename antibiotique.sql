-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 09 Novembre 2014 à 21:45
-- Version du serveur :  5.6.16
-- Version de PHP :  5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `antibiotique`
--

-- --------------------------------------------------------

--
-- Structure de la table `formulaire`
--

CREATE TABLE IF NOT EXISTS `formulaire` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `numero` int(11) NOT NULL,
  `region` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `date_declaration` date NOT NULL,
  `duree` int(11) NOT NULL,
  `date_entre` date NOT NULL,
  `date_sortie` date NOT NULL,
  `numero_veterinaire` int(10) NOT NULL,
  `remarque` mediumtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`),
  KEY `numero_veterinaire` (`numero_veterinaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Contenu de la table `formulaire`
--

INSERT INTO `formulaire` (`id`, `nom`, `prenom`, `numero`, `region`, `date_declaration`, `duree`, `date_entre`, `date_sortie`, `numero_veterinaire`, `remarque`) VALUES
(1, 'hd', 'amine', 5, 'berlin', '2014-10-01', 15, '2014-04-06', '2014-11-01', 15, 'رجيش');

-- --------------------------------------------------------

--
-- Structure de la table `veterinaire`
--

CREATE TABLE IF NOT EXISTS `veterinaire` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `veterinaire`
--

INSERT INTO `veterinaire` (`id`, `nom`, `prenom`) VALUES
(2, 'fdgfg', 'dfd'),
(3, 'gjghj', 'jjjj'),
(5, 'بيل', 'يبل'),
(7, 'سيب', 'سيب'),
(9, 'ddd', 'ddd'),
(11, 'vxc', 'xxx'),
(12, 'VFDV', 'VDF'),
(14, 'xvc', 'vcx'),
(15, 'llll', 'kjl');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `formulaire`
--
ALTER TABLE `formulaire`
  ADD CONSTRAINT `formulaire_ibfk_1` FOREIGN KEY (`numero_veterinaire`) REFERENCES `veterinaire` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
