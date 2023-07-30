-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3310
-- Généré le : dim. 30 juil. 2023 à 23:27
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `api`
--

-- --------------------------------------------------------

--
-- Structure de la table `choix`
--

CREATE TABLE `choix` (
  `id` bigint(20) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `etat` bit(1) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `choix`
--

INSERT INTO `choix` (`id`, `contenu`, `etat`, `question_id`) VALUES
(1, 'Éléphant', b'1', 1),
(2, 'Girafe', b'0', 1),
(3, 'Serpent', b'0', 2),
(4, 'Aigle', b'1', 2),
(5, 'Tortue', b'0', 2),
(6, 'Lion', b'0', 3),
(7, 'Dauphin', b'1', 3),
(8, 'Gorille', b'0', 3),
(9, 'Panda', b'0', 3),
(10, 'Zèbre', b'1', 4),
(11, 'Kangourou', b'0', 4),
(12, 'Chameau', b'0', 4),
(13, 'Lapin', b'0', 5),
(14, 'Ours', b'1', 5),
(15, 'Léopard', b'0', 5),
(16, 'Corée du Sud', b'1', 6),
(17, 'Japon', b'0', 6),
(18, 'Paris', b'1', 7),
(19, 'Londres', b'0', 7),
(20, 'Berlin', b'0', 7),
(21, 'William Shakespeare', b'1', 8),
(22, 'Molière', b'0', 8),
(23, 'Leonardo da Vinci', b'1', 9),
(24, 'Pablo Picasso', b'0', 9),
(25, 'Vincent van Gogh', b'0', 9),
(26, 'O2', b'1', 10),
(27, 'H2O', b'0', 10),
(28, 'C', b'0', 10),
(29, 'Barcelone', b'0', 11),
(30, 'Madrid', b'1', 11),
(31, 'Rome', b'0', 11),
(32, 'Toronto', b'0', 12),
(33, 'Ottawa', b'1', 12),
(34, 'Montréal', b'0', 12),
(35, 'Sydney', b'0', 13),
(36, 'Canberra', b'1', 13),
(37, 'Melbourne', b'0', 13),
(38, 'Perth', b'0', 13),
(39, 'Mumbai', b'0', 14),
(40, 'New Delhi', b'1', 14),
(41, 'Kolkata', b'0', 14),
(42, 'Rio de Janeiro', b'0', 15),
(43, 'Brasilia', b'1', 15),
(44, 'Sao Paulo', b'0', 15),
(45, 'Java', b'0', 16),
(46, 'Python', b'0', 16),
(47, 'JavaScript', b'1', 16),
(48, 'MySQL', b'1', 17),
(49, 'Oracle', b'0', 17),
(50, 'MongoDB', b'0', 17),
(51, 'Cascading Style Sheets', b'1', 18),
(52, 'Centralized System Software', b'0', 18),
(53, 'Computer Symbolic System', b'0', 18),
(54, 'Java', b'0', 19),
(55, 'R', b'0', 19),
(56, 'C++', b'0', 19),
(57, 'Python', b'1', 19),
(58, 'HTTP', b'0', 20),
(59, 'FTP', b'1', 20),
(60, 'SMTP', b'0', 20),
(61, '1914', b'1', 21),
(62, '1939', b'0', 21),
(63, '1918', b'0', 21),
(64, 'La chute du mur de Berlin', b'1', 22),
(65, 'La Révolution russe', b'0', 22),
(66, 'La guerre du Vietnam', b'0', 22),
(67, 'Malcolm X', b'0', 23),
(68, 'Martin Luther King Jr.', b'1', 23),
(69, 'Nelson Mandela', b'0', 23),
(70, 'L\'attaque de Pearl Harbor', b'0', 24),
(71, 'Le débarquement en Normandie', b'0', 24),
(72, 'L\'invasion de la Pologne', b'1', 24),
(73, 'États-Unis', b'0', 25),
(74, 'Union soviétique', b'1', 25),
(75, 'Chine', b'0', 25),
(76, 'Cœur', b'1', 26),
(77, 'Poumon', b'0', 26),
(78, 'Cerveau', b'0', 26),
(79, 'Rein', b'0', 26),
(80, 'Oxygène', b'0', 27),
(81, 'Hydrogène', b'1', 27),
(82, 'Carbone', b'0', 27),
(83, 'Vénus', b'0', 28),
(84, 'Mars', b'0', 28),
(85, 'Jupiter', b'1', 28),
(86, 'Léopard', b'0', 29),
(87, 'Guépard', b'1', 29),
(88, 'Lion', b'0', 29),
(89, 'Océan Atlantique', b'0', 30),
(90, 'Océan Indien', b'0', 30),
(91, 'Océan Pacifique', b'1', 30),
(92, 'Lionel Messi', b'0', 31),
(93, 'Neymar Jr.', b'0', 31),
(94, 'Cristiano Ronaldo', b'1', 31),
(95, 'Allemagne', b'0', 32),
(96, 'Brésil', b'0', 32),
(97, 'France', b'1', 32),
(98, 'Real Madrid', b'1', 33),
(99, 'FC Barcelone', b'0', 33),
(100, 'Manchester United', b'0', 33),
(101, 'Liverpool', b'0', 33),
(102, 'Diego Maradona', b'0', 34),
(103, 'Lionel Messi', b'1', 34),
(104, 'Pele', b'0', 34),
(105, 'Cristiano Ronaldo', b'0', 34),
(106, 'Barcelone', b'1', 35),
(107, 'Madrid', b'0', 35),
(108, 'Paris', b'0', 35),
(109, 'One Piece', b'1', 36),
(110, 'Naruto', b'0', 36),
(111, 'Dragon Ball', b'0', 36),
(112, 'Naruto', b'0', 37),
(113, 'One Piece', b'0', 37),
(114, 'Harry Potter', b'1', 37),
(115, 'Naruto', b'0', 38),
(116, 'One Piece', b'0', 38),
(117, 'Hunter x Hunter', b'1', 38),
(118, 'Dragon Ball', b'0', 39),
(119, 'One Piece', b'1', 39),
(120, 'Naruto', b'0', 39),
(121, 'Naruto', b'0', 40),
(122, 'One Piece', b'1', 40),
(123, 'Dragon Ball', b'0', 40),
(124, 'Naruto Uzumaki', b'1', 41),
(125, 'Monkey D. Luffy', b'0', 41),
(126, 'Goku', b'0', 41),
(127, 'One Piece', b'0', 42),
(128, 'Naruto', b'0', 42),
(129, 'Dragon Ball', b'1', 42),
(130, 'Naruto Uzumaki', b'0', 43),
(131, 'Monkey D. Luffy', b'1', 43),
(132, 'Son Goku', b'0', 43),
(133, 'Naruto Uzumaki', b'0', 44),
(134, 'Monkey D. Luffy', b'0', 44),
(135, 'Son Goku', b'1', 44),
(136, 'Naruto Uzumaki', b'0', 45),
(137, 'Monkey D. Luffy', b'1', 45),
(138, 'Son Goku', b'0', 45),
(139, 'Bamako', b'1', 46),
(140, 'Dakar', b'0', 46),
(141, 'Nouakchott', b'0', 46),
(142, 'Le Niger', b'1', 47),
(143, 'Le Nil', b'0', 47),
(144, 'Le Congo', b'0', 47),
(145, 'Afrique', b'1', 48),
(146, 'Asie', b'0', 48),
(147, 'Amérique', b'0', 48),
(148, 'Couscous', b'1', 49),
(149, 'Paella', b'0', 49),
(150, 'Riz au poulet', b'0', 49),
(151, 'La Tour Eiffel', b'0', 50),
(152, 'La Mosquée de Djenné', b'1', 50),
(153, 'Le Colisée de Rome', b'0', 50),
(154, 'Un framework d\'intégration de données', b'0', 51),
(155, 'Une plateforme de développement Web', b'0', 51),
(156, 'Un framework pour le développement Java', b'1', 51),
(157, 'Python', b'0', 52),
(158, 'JavaScript', b'0', 52),
(159, 'Java', b'1', 52),
(160, 'Architecture MVC', b'0', 53),
(161, 'Architecture REST', b'1', 53),
(162, 'Architecture SOAP', b'0', 53),
(163, 'pom.xml', b'1', 54),
(164, 'web.xml', b'0', 54),
(165, 'app.properties', b'0', 54),
(166, '@RestController', b'1', 55),
(167, '@Controller', b'0', 55),
(168, '@Service', b'0', 55);

-- --------------------------------------------------------

--
-- Structure de la table `domaine`
--

CREATE TABLE `domaine` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `domaine`
--

INSERT INTO `domaine` (`id`, `nom`) VALUES
(1, 'Sciences naturelles'),
(2, 'Culture'),
(3, 'Géographie'),
(4, 'Informatique'),
(5, 'Histoire'),
(6, 'Mangas'),
(7, 'Football');

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id` int(11) NOT NULL,
  `score` bigint(20) DEFAULT NULL,
  `quiz_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id`, `score`, `quiz_id`, `user_id`) VALUES
(1, 36, 9, 2),
(2, 15, 8, 2),
(3, 0, 4, 2);

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `point` bigint(20) DEFAULT NULL,
  `quiz_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`id`, `content`, `point`, `quiz_id`) VALUES
(1, 'Quel animal a une trompe ?', 5, 1),
(2, 'Quel animal vole ?', 10, 1),
(3, 'Quel animal vit principalement dans l\'eau ?', 8, 1),
(4, 'Quel animal est connu pour sa tache noire autour de son œil ?', 6, 1),
(5, 'Quel animal hiberne pendant l\'hiver ?', 7, 1),
(6, 'Quel est le pays d\'origine du groupe de musique BTS ?', 5, 2),
(7, 'Quelle est la capitale de la France ?', 10, 2),
(8, 'Qui a écrit la pièce de théâtre \'Roméo et Juliette\' ?', 8, 2),
(9, 'Quel célèbre peintre a réalisé \'La Joconde\' ?', 6, 2),
(10, 'Quel est le symbole chimique de l\'oxygène ?', 7, 2),
(11, 'Quelle est la capitale de l\'Espagne ?', 5, 3),
(12, 'Quelle est la capitale du Canada ?', 10, 3),
(13, 'Quelle est la capitale de l\'Australie ?', 8, 3),
(14, 'Quelle est la capitale de l\'Inde ?', 6, 3),
(15, 'Quelle est la capitale du Brésil ?', 7, 3),
(16, 'Quel langage de programmation est souvent utilisé pour créer des pages web interactives ?', 5, 4),
(17, 'Quel système de gestion de base de données est open-source et largement utilisé dans les applications web ?', 10, 4),
(18, 'Qu\'est-ce que CSS signifie en informatique ?', 8, 4),
(19, 'Quel langage est souvent utilisé pour l\'analyse et la manipulation de données dans le domaine de l\'intelligence artificielle ?', 6, 4),
(20, 'Quel protocole est utilisé pour transférer des fichiers sur le Web ?', 7, 4),
(21, 'En quelle année a débuté la Première Guerre mondiale ?', 5, 5),
(22, 'Quel événement a marqué la fin de la Guerre froide ?', 10, 5),
(23, 'Qui a été le leader du mouvement des droits civiques aux États-Unis dans les années 1960 ?', 8, 5),
(24, 'Quel événement a marqué le début de la Seconde Guerre mondiale ?', 6, 5),
(25, 'Quel pays a été le premier à envoyer un homme dans l\'espace ?', 7, 5),
(26, 'Quel est l\'organe responsable de la pompe du sang dans le corps humain ?', 5, 6),
(27, 'Quel est l\'élément chimique le plus abondant dans l\'univers ?', 10, 6),
(28, 'Quelle est la plus grande planète du système solaire ?', 8, 6),
(29, 'Quel est l\'animal terrestre le plus rapide ?', 6, 6),
(30, 'Quel est l\'océan le plus grand du monde ?', 7, 6),
(31, 'Quel joueur de football est surnommé \'CR7\' ?', 5, 7),
(32, 'Quel pays a remporté la Coupe du Monde de la FIFA en 2018 ?', 10, 7),
(33, 'Quelle équipe de club a remporté le plus de Ligue des Champions de l\'UEFA ?', 8, 7),
(34, 'Quel joueur a remporté le plus de Ballon d\'Or ?', 6, 7),
(35, 'Dans quelle ville se trouve le stade de football \'Camp Nou\' ?', 7, 7),
(36, 'Quel manga a été créé par Eiichiro Oda ?', 5, 8),
(37, 'Dans quel manga un jeune sorcier nommé Harry Potter est-il le protagoniste ?', 10, 8),
(38, 'Quelle série de mangas raconte l\'histoire d\'un jeune garçon appelé Gon Freecss cherchant à devenir un Hunter ?', 8, 8),
(39, 'Quel est le manga le plus vendu de tous les temps ?', 6, 8),
(40, 'Quel manga met en scène des pirates à la recherche du trésor légendaire \'One Piece\' ?', 7, 8),
(41, 'Quel personnage de manga a le pouvoir du Rasengan ?', 5, 9),
(42, 'Dans quel manga, le personnage principal est-il un jeune garçon avec une queue de singe et une force incroyable ?', 10, 9),
(43, 'Quel personnage est un pirate en quête du \'One Piece\' dans le manga éponyme ?', 8, 9),
(44, 'Quel personnage de manga est connu pour ses célèbres Kamehameha ?', 6, 9),
(45, 'Quel personnage de manga est aussi appelé le \'Seigneur des Pirates\' ?', 7, 9),
(46, 'Quelle est la capitale du Mali ?', 5, 10),
(47, 'Quel est le fleuve principal qui traverse le Mali ?', 10, 10),
(48, 'Dans quel continent se situe le Mali ?', 8, 10),
(49, 'Quel est le plat national du Mali ?', 6, 10),
(50, 'Quel est le monument emblématique du Mali, inscrit au patrimoine mondial de l\'UNESCO ?', 7, 10),
(51, 'Qu\'est-ce que Spring Boot ?', 5, 11),
(52, 'Quel langage de programmation est principalement utilisé pour le développement avec Spring Boot ?', 10, 11),
(53, 'Quel type d\'architecture favorise Spring Boot ?', 8, 11),
(54, 'Quel fichier de configuration est utilisé pour définir les dépendances dans un projet Spring Boot ?', 6, 11),
(55, 'Quelle annotation est utilisée pour définir qu\'une classe est un contrôleur dans Spring Boot ?', 7, 11);

-- --------------------------------------------------------

--
-- Structure de la table `quiz`
--

CREATE TABLE `quiz` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `domaine_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `quiz`
--

INSERT INTO `quiz` (`id`, `nom`, `domaine_id`, `user_id`) VALUES
(1, 'Quiz sur les animaux', 1, 1),
(2, 'Quiz de culture générale', 2, 1),
(3, 'Quiz sur les capitales du monde', 3, 1),
(4, 'Quiz de programmation', 4, 1),
(5, 'Quiz sur l\'histoire du 20ème siècle', 5, 1),
(6, 'Quiz sur la science et la nature', 1, 1),
(7, 'Pour les fans de foot', 7, 1),
(8, 'Quiz sur les mangas populaires', 6, 1),
(9, 'Quiz sur les personnages de mangas', 6, 1),
(10, 'Quiz sur le Mali', 3, 1),
(11, 'Quiz sur Spring Boot', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `scores`
--

CREATE TABLE `scores` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `point` int(11) NOT NULL,
  `quiz_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `nom`, `prenom`, `pseudo`) VALUES
(1, 'Diakit2e@gmail.com', 'Diakite', 'Ibrahim blonkon', 'Diallo'),
(2, 'lonpo@gmail.com', 'Diakite', 'Ibrahim blonkon', 'Lonpo');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `choix`
--
ALTER TABLE `choix`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtbpcarcolo5tyw601c257v472` (`question_id`);

--
-- Index pour la table `domaine`
--
ALTER TABLE `domaine`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4bjxo57o36oak3f7g9b7phvid` (`quiz_id`),
  ADD KEY `FKfputwcduinudasn7es02c12ra` (`user_id`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb0yh0c1qaxfwlcnwo9dms2txf` (`quiz_id`);

--
-- Index pour la table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsesg6fa0xwpuoyyfd2y9j8tch` (`domaine_id`),
  ADD KEY `FK1tofsm1qynhakggx7ttqh8ihu` (`user_id`);

--
-- Index pour la table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmxlhwx7yaa7ja9x3rrghxokhj` (`quiz_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UK_it5d8tethuijmhllwd27doaqv` (`pseudo`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `choix`
--
ALTER TABLE `choix`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=169;

--
-- AUTO_INCREMENT pour la table `domaine`
--
ALTER TABLE `domaine`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `participation`
--
ALTER TABLE `participation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT pour la table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `scores`
--
ALTER TABLE `scores`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `choix`
--
ALTER TABLE `choix`
  ADD CONSTRAINT `FKtbpcarcolo5tyw601c257v472` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `FK4bjxo57o36oak3f7g9b7phvid` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`),
  ADD CONSTRAINT `FKfputwcduinudasn7es02c12ra` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FKb0yh0c1qaxfwlcnwo9dms2txf` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`);

--
-- Contraintes pour la table `quiz`
--
ALTER TABLE `quiz`
  ADD CONSTRAINT `FK1tofsm1qynhakggx7ttqh8ihu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKsesg6fa0xwpuoyyfd2y9j8tch` FOREIGN KEY (`domaine_id`) REFERENCES `domaine` (`id`);

--
-- Contraintes pour la table `scores`
--
ALTER TABLE `scores`
  ADD CONSTRAINT `FKmxlhwx7yaa7ja9x3rrghxokhj` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
