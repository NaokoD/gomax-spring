INSERT INTO utilisateur (nom, prenom)
VALUES ('DIA', 'Yannick');

INSERT INTO client (client_id,email, date_de_naissance, adresse, cp, ville, pays)
VALUES ((SELECT id FROM utilisateur where nom = 'DIA' and prenom ='Yannick'),'dia-yannick@gmail.com', DATE '2000-12-17','cesi','31670','Labege','FRANCE');