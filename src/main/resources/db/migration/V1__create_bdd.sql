CREATE TABLE Cinema(
   idCinema INT NOT NULL AUTO_INCREMENT,
   nomCinema VARCHAR(255) NOT NULL,
   adresseCinema VARCHAR(255) NOT NULL,
   codePostalCinema VARCHAR(5) NOT NULL,
   VilleCinema VARCHAR(255) NOT NULL,
   PRIMARY KEY(idCinema)
)ENGINE=InnoDB;

CREATE TABLE Salle(
   idSalle INT NOT NULL AUTO_INCREMENT,
   planSalle VARCHAR(255) NOT NULL,
   numDeSalle INT NOT NULL,
   idCinema INT NOT NULL,
   PRIMARY KEY(idSalle),
   FOREIGN KEY(idCinema) REFERENCES Cinema(idCinema)
)ENGINE=InnoDB;

CREATE TABLE Tarif(
   idTarif INT NOT NULL AUTO_INCREMENT,
   libelleTarif VARCHAR(255) NOT NULL,
   montantTarif DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(idTarif)
)ENGINE=InnoDB;

CREATE TABLE Type_Siege(
   idTypeSiege INT NOT NULL AUTO_INCREMENT,
   libelleTypeSige VARCHAR(255) NOT NULL,
   PRIMARY KEY(idTypeSiege)
)ENGINE=InnoDB;

CREATE TABLE Majoration(
   idMajoration INT NOT NULL AUTO_INCREMENT,
   libelleMajoration VARCHAR(255) NOT NULL,
   remiseMajoration DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(idMajoration)
)ENGINE=InnoDB;

CREATE TABLE Snack(
   idSnack INT NOT NULL AUTO_INCREMENT,
   libelleSnack VARCHAR(255) NOT NULL,
   prixSnack DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(idSnack)
)ENGINE=InnoDB;

CREATE TABLE Horaire(
   idHoraire INT NOT NULL AUTO_INCREMENT,
   horaire TIME NOT NULL,
   PRIMARY KEY(idHoraire)
)ENGINE=InnoDB;

CREATE TABLE Categorire(
   idCategorie INT NOT NULL AUTO_INCREMENT,
   libelleCategorie VARCHAR(255) NOT NULL,
   PRIMARY KEY(idCategorie)
)ENGINE=InnoDB;

CREATE TABLE Film(
   idFilm INT NOT NULL AUTO_INCREMENT,
   titreFilm VARCHAR(255) NOT NULL,
   dureeFilm INT NOT NULL,
   PRIMARY KEY(idFilm)
)ENGINE=InnoDB;

CREATE TABLE Client(
   idClient INT NOT NULL AUTO_INCREMENT,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   dateDeNaissanceClient DATE NOT NULL,
   adresseClient VARCHAR(255) NOT NULL,
   codePostalClient VARCHAR(5) NOT NULL,
   villeClient VARCHAR(255) NOT NULL,
   paysClient VARCHAR(255) NOT NULL,
   numDeFideliteClient VARCHAR(50),
   PRIMARY KEY(idClient)
)ENGINE=InnoDB;

CREATE TABLE Siege(
   idSiege INT NOT NULL AUTO_INCREMENT,
   idTypeSiege INT NOT NULL,
   idSalle INT NOT NULL,
   PRIMARY KEY(idSiege),
   FOREIGN KEY(idTypeSiege) REFERENCES Type_Siege(idTypeSiege),
   FOREIGN KEY(idSalle) REFERENCES Salle(idSalle)
)ENGINE=InnoDB;

CREATE TABLE Seance(
   idSeance INT NOT NULL AUTO_INCREMENT,
   dateSeance DATE NOT NULL,
   idSalle INT NOT NULL,
   idFilm INT NOT NULL,
   idHoraire INT NOT NULL,
   PRIMARY KEY(idSeance),
   FOREIGN KEY(idSalle) REFERENCES Salle(idSalle),
   FOREIGN KEY(idFilm) REFERENCES Film(idFilm),
   FOREIGN KEY(idHoraire) REFERENCES Horaire(idHoraire)
)ENGINE=InnoDB;

CREATE TABLE Commande(
   idCommande INT NOT NULL AUTO_INCREMENT,
   idSeance INT NOT NULL,
   idClient INT NOT NULL,
   PRIMARY KEY(idCommande),
   FOREIGN KEY(idSeance) REFERENCES Seance(idSeance),
   FOREIGN KEY(idClient) REFERENCES Client(idClient)
)ENGINE=InnoDB;

CREATE TABLE Categorie_Film(
   idCategorie INT NOT NULL,
   idFilm INT NOT NULL,
   PRIMARY KEY(idCategorie, idFilm),
   FOREIGN KEY(idCategorie) REFERENCES Categorire(idCategorie),
   FOREIGN KEY(idFilm) REFERENCES Film(idFilm)
)ENGINE=InnoDB;

CREATE TABLE Commande_Snack(
   idCommande INT NOT NULL,
   idSnack INT NOT NULL,
   QuantiteSnack INT NOT NULL,
   PRIMARY KEY(idCommande, idSnack),
   FOREIGN KEY(idCommande) REFERENCES Commande(idCommande),
   FOREIGN KEY(idSnack) REFERENCES Snack(idSnack)
)ENGINE=InnoDB;

CREATE TABLE Commande_Siege(
   idSiege INT NOT NULL,
   idCommande INT NOT NULL,
   PRIMARY KEY(idSiege, idCommande),
   FOREIGN KEY(idSiege) REFERENCES Siege(idSiege),
   FOREIGN KEY(idCommande) REFERENCES Commande(idCommande)
)ENGINE=InnoDB;

CREATE TABLE Commande_Tarif(
   idTarif INT NOT NULL,
   idCommande INT NOT NULL,
   nbPlace INT NOT NULL,
   PRIMARY KEY(idTarif, idCommande),
   FOREIGN KEY(idTarif) REFERENCES Tarif(idTarif),
   FOREIGN KEY(idCommande) REFERENCES Commande(idCommande)
)ENGINE=InnoDB;
