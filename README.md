# MSA-Car_Rental
MSA Spring Boot application for car rental service

### Service véhicules

Route | Méthode | Description
-|:-:|-
`http://<host>:<port>/vehicules/` | `GET` | Lister tous les véhicules
`http://<host>:<port>/vehicules/<id>` | `GET` | Afficher le véhicule avec l'id
`http://<host>:<port>/vehicules/cm/<id>` | `GET` | Lister les tickets de maintenance d'un véhicules id
`http://<host>:<port>/vehicules/` | `POST` | Enregistrer un nouveau vehicule
`http://<host>:<port>/vehicules/` | `PUT` | Modifier un véhicule
`http://<host>:<port>/vehicules/<id>` | `DELETE` | Supprimer un véhicule
`http://<host>:<port>/vehicules/available?startDate=<date>&endDate=<date>` | `GET` | Lister les véhicules disponible entre les dates
`http://<host>:<port>/vehicules/?brand=<brand&type=<type>&color=<color>&fiscalHp=<fiscalHp>` | `GET` | Lister les véhicules par marque/type/couleur/puissance

### Service clients

Route | Méthode | Description
-|:-:|-
`http://<host>:<port>/customers/` | `GET` | Lister tous les clients
`http://<host>:<port>/customers/<id>` | `GET` | Afficher le client avec l'id
`http://<host>:<port>/customers/` | `POST` | Enregistrer un nouveau client
`http://<host>:<port>/customers/` | `PUT` | Modifier une fiche client
`http://<host>:<port>/customers/<id>` | `DELETE` | Supprimer un client
`http://<host>:<port>/customers/getReservation/<id>` | `GET` | Lister les véhicules réservé par un client

### Service reservation

Route | Méthode | Description
-|:-:|-
`http://<host>:<port>/reservations/` | `GET` | Lister toutes les réservations
`http://<host>:<port>/reservations/<id>` | `GET` | Afficher la réservation avec l'id
`http://<host>:<port>/reservations/` | `POST` | Enregistrer une nouvelle réservation
`http://<host>:<port>/reservations/` | `PUT` | Modifier une réservation
`http://<host>:<port>/reservations/<id>` | `DELETE` | Supprimer une réservation
`http://<host>:<port>/reservations/return/<kilométrage>` | `PUT` | Rendre un véhicule