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
   plan VARCHAR(255) NOT NULL,
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

CREATE TABLE Type_Siege(
   id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Majoration(
   id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(255) NOT NULL,
   remise DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Snack(
   id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(255) NOT NULL,
   prix DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Horaire(
   id INT NOT NULL AUTO_INCREMENT,
   horaire TIME NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Categorire(
   id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Film(
   id INT NOT NULL AUTO_INCREMENT,
   titre VARCHAR(255) NOT NULL,
   duree INT NOT NULL,
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Client(
   id INT NOT NULL AUTO_INCREMENT,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   date_de_naissance DATE NOT NULL,
   adresse VARCHAR(255) NOT NULL,
   cp VARCHAR(5) NOT NULL,
   ville VARCHAR(255) NOT NULL,
   pays VARCHAR(255) NOT NULL,
   numero_de_fidelite VARCHAR(50),
   PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Siege(
   id INT NOT NULL AUTO_INCREMENT,
   type_siege_id INT NOT NULL,
   salle_id INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(type_siege_id) REFERENCES Type_Siege(id),
   FOREIGN KEY(salle_id) REFERENCES Salle(id)
)ENGINE=InnoDB;

CREATE TABLE Seance(
   id INT NOT NULL AUTO_INCREMENT,
   date_seance DATE NOT NULL,
   salle_id INT NOT NULL,
   film_id INT NOT NULL,
   horaire_id INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(salle_id) REFERENCES Salle(id),
   FOREIGN KEY(film_id) REFERENCES Film(id),
   FOREIGN KEY(horaire_id) REFERENCES Horaire(id)
)ENGINE=InnoDB;

CREATE TABLE Commande(
   id INT NOT NULL AUTO_INCREMENT,
   seance_id INT NOT NULL,
   client_id INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(seance_id) REFERENCES Seance(id),
   FOREIGN KEY(client_id) REFERENCES Client(id)
)ENGINE=InnoDB;

CREATE TABLE Categorie_Film(
   categorie_id INT NOT NULL,
   film_id INT NOT NULL,
   PRIMARY KEY(categorie_id, film_id),
   FOREIGN KEY(categorie_id) REFERENCES Categorire(id),
   FOREIGN KEY(film_id) REFERENCES Film(id)
)ENGINE=InnoDB;

CREATE TABLE Commande_Snack(
   commande_id INT NOT NULL,
   snack_id INT NOT NULL,
   QuantiteSnack INT NOT NULL,
   PRIMARY KEY(commande_id, snack_id),
   FOREIGN KEY(commande_id) REFERENCES Commande(id),
   FOREIGN KEY(snack_id) REFERENCES Snack(id)
)ENGINE=InnoDB;

CREATE TABLE Commande_Siege(
   siege_id INT NOT NULL,
   commande_id INT NOT NULL,
   PRIMARY KEY(siege_id, commande_id),
   FOREIGN KEY(siege_id) REFERENCES Siege(id),
   FOREIGN KEY(commande_id) REFERENCES Commande(id)
)ENGINE=InnoDB;

CREATE TABLE Commande_Tarif(
   tarif_id INT NOT NULL,
   commande_id INT NOT NULL,
   nbPlace INT NOT NULL,
   PRIMARY KEY(tarif_id, commande_id),
   FOREIGN KEY(tarif_id) REFERENCES Tarif(id),
   FOREIGN KEY(commande_id) REFERENCES Commande(id)
)ENGINE=InnoDB;
