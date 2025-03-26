-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 26 mars 2025 à 14:39
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vectaledb`
--

-- --------------------------------------------------------

--
-- Structure de la table `card`
--

CREATE TABLE `card` (
  `id` bigint(20) NOT NULL,
  `ID_PACK` int(11) NOT NULL,
  `DISPONIBLE` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `card`
--

INSERT INTO `card` (`id`, `ID_PACK`, `DISPONIBLE`) VALUES
(1, 1, 0),
(2, 2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `pack`
--

CREATE TABLE `pack` (
  `ID` int(11) NOT NULL,
  `CODE` varchar(255) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  `pack_type` varchar(255) NOT NULL,
  `CREATE_DATE` date NOT NULL,
  `END_DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `pack`
--

INSERT INTO `pack` (`ID`, `CODE`, `ID_USER`, `pack_type`, `CREATE_DATE`, `END_DATE`) VALUES
(1, 'IDUSER1', 1, 'Vip', '2025-01-01', '2025-12-31'),
(2, 'IDUSER1', 1, 'Vip', '2025-01-01', '2025-12-31');

-- --------------------------------------------------------

--
-- Structure de la table `packmonths`
--

CREATE TABLE `packmonths` (
  `id` bigint(20) NOT NULL,
  `PACK_ID` int(11) NOT NULL,
  `MONTH_NUMBER` int(11) NOT NULL,
  `YEAR_NUMBER` int(11) NOT NULL,
  `IS_PAID` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `packmonths`
--

INSERT INTO `packmonths` (`id`, `PACK_ID`, `MONTH_NUMBER`, `YEAR_NUMBER`, `IS_PAID`) VALUES
(1, 2, 12, 2025, 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(255) NOT NULL,
  `PRENOM` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `DATENAISSANCE` date NOT NULL,
  `ADRESSE` varchar(255) NOT NULL,
  `CNI` varchar(255) NOT NULL,
  `CNE` varchar(255) NOT NULL,
  `USEREMAIL` varchar(255) NOT NULL,
  `USERPASSWORD` varchar(255) NOT NULL,
  `userimg` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`ID`, `NOM`, `PRENOM`, `tel`, `DATENAISSANCE`, `ADRESSE`, `CNI`, `CNE`, `USEREMAIL`, `USERPASSWORD`, `userimg`) VALUES
(1, 'abderrazak', 'Errifaouy', '0656561323', '2002-09-25', '123 Street, City, Country', 'CNI123456789', 'CNE123456789', 'johndoe@example.com', 'password123', '1');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ID_PACK` (`ID_PACK`);

--
-- Index pour la table `pack`
--
ALTER TABLE `pack`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_USER` (`ID_USER`);

--
-- Index pour la table `packmonths`
--
ALTER TABLE `packmonths`
  ADD PRIMARY KEY (`id`),
  ADD KEY `PACK_ID` (`PACK_ID`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `card`
--
ALTER TABLE `card`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `pack`
--
ALTER TABLE `pack`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `packmonths`
--
ALTER TABLE `packmonths`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `card_ibfk_1` FOREIGN KEY (`ID_PACK`) REFERENCES `pack` (`ID`);

--
-- Contraintes pour la table `pack`
--
ALTER TABLE `pack`
  ADD CONSTRAINT `pack_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `users` (`ID`);

--
-- Contraintes pour la table `packmonths`
--
ALTER TABLE `packmonths`
  ADD CONSTRAINT `packmonths_ibfk_1` FOREIGN KEY (`PACK_ID`) REFERENCES `pack` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
