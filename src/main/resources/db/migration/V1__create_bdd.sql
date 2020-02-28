CREATE TABLE Cinema(
   id INT NOT NULL AUTO_INCREMENT,
   nom VARCHAR(255) NOT NULL,
   adresse VARCHAR(255) NOT NULL,
   cp VARCHAR(5) NOT NULL,
   ville VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Salle(
   id INT NOT NULL AUTO_INCREMENT,
   plan TEXT NOT NULL,
   numero INT NOT NULL,
   cinema_id INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(cinema_id) REFERENCES Cinema(id)
)ENGINE=InnoDB;

CREATE TABLE Tarif(
   id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(255) NOT NULL,
   montant DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Majoration(
   id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(255) NOT NULL,
   remise DECIMAL(15,5) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Snack(
   id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(255) NOT NULL,
   prix DECIMAL(15,2) NOT NULL,
   image VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Film(
   id INT NOT NULL AUTO_INCREMENT,
   titre VARCHAR(255) NOT NULL,
   duree BIGINT NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Utilisateur(
   id INT NOT NULL AUTO_INCREMENT,
   prenom VARCHAR(255) NOT NULL,
   nom VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Accompagnant(
   accompagnant_id INT NOT NULL,
   PRIMARY KEY(accompagnant_id),
   FOREIGN KEY(accompagnant_id) REFERENCES Utilisateur(id)
);

CREATE TABLE Client(
   client_id INT NOT NULL,
   email VARCHAR(255) NOT NULL,
   date_de_naissance DATE NOT NULL,
   adresse VARCHAR(255) NOT NULL,
   cp VARCHAR(5) NOT NULL,
   ville VARCHAR(255) NOT NULL,
   pays VARCHAR(255) NOT NULL,
   numero_de_fidelite VARCHAR(50),
   PRIMARY KEY(client_id),
   FOREIGN KEY(client_id) REFERENCES Utilisateur(id)
)ENGINE=InnoDB;

CREATE TABLE Siege(
   id INT NOT NULL AUTO_INCREMENT,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Seance(
   id INT NOT NULL AUTO_INCREMENT,
   date_seance datetime NOT NULL,
   salle_id INT NOT NULL,
   film_id INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(salle_id) REFERENCES Salle(id),
   FOREIGN KEY(film_id) REFERENCES Film(id)
)ENGINE=InnoDB;

CREATE TABLE Commande(
   id INT NOT NULL AUTO_INCREMENT,
   seance_id INT NOT NULL,
   client_id INT NOT NULL,
   date_de_creation DATE DEFAULT CURRENT_DATE,
   PRIMARY KEY(id),
   FOREIGN KEY(seance_id) REFERENCES Seance(id),
   FOREIGN KEY(client_id) REFERENCES Client(client_id)
)ENGINE=InnoDB;

CREATE TABLE Commande_Snack(
   commande_id INT NOT NULL,
   snack_id INT NOT NULL,
   quantite INT NOT NULL,
   PRIMARY KEY(commande_id, snack_id),
   FOREIGN KEY(commande_id) REFERENCES Commande(id),
   FOREIGN KEY(snack_id) REFERENCES Snack(id)
)ENGINE=InnoDB;

CREATE TABLE Commande_Siege(
   commande_id INT NOT NULL,
   siege_id INT NOT NULL,
   PRIMARY KEY(commande_id, siege_id),
   FOREIGN KEY(siege_id) REFERENCES Siege(id),
   FOREIGN KEY(commande_id) REFERENCES Commande(id)
)ENGINE=InnoDB;

CREATE TABLE Commande_Tarif(
   commande_id INT NOT NULL,
   tarif_id INT NOT NULL,
   nb_place INT NOT NULL,
   PRIMARY KEY(commande_id, tarif_id),
   FOREIGN KEY(tarif_id) REFERENCES Tarif(id),
   FOREIGN KEY(commande_id) REFERENCES Commande(id)
)ENGINE=InnoDB;

CREATE TABLE Commande_Accompagnant(
    commande_id INT NOT NULL,
    accompagnant_id INT NOT NULL,
    PRIMARY KEY(commande_id, accompagnant_id),
    FOREIGN KEY(accompagnant_id) REFERENCES Accompagnant(accompagnant_id),
    FOREIGN KEY(commande_id) REFERENCES Commande(id)
)ENGINE=InnoDB;
