- [1. Installation de la base de données du site Brain Buddy](#1-installation-de-la-base-de-données-du-site-brain-buddy)
  - [1.1. Docker](#11-docker)
  - [1.2. Connexion à PgAdmin](#12-connexion-à-pgadmin)
  - [1.3. Ajouter un nouveau serveur](#13-ajouter-un-nouveau-serveur)
  - [1.4. Peupler notre BDD](#14-peupler-notre-bdd)


# 1. Installation de la base de données du site Brain Buddy

## 1.1. Docker
Installez Docker : https://www.docker.com/
Exécutez Docker, il doit être actif pour la suite de la procédure
Dans un terminal, naviguez jusqu'à l'emplacement du docker-compose.yml situé dans le dossier Docker fourni dans le zip de notre projet puis exécuter dans le terminal la commande suivante :

```bash
docker compose up -d
```
Ouvrez votre navigateur à l'adresse suivante :

http://localhost:8888/

## 1.2. Connexion à PgAdmin

Complétez le formulaire de connexion de PgAdmin pour accéder à notre BDD en saisissant :

Email : admin@admin.com
Mot de passe : admin

## 1.3. Ajouter un nouveau serveur

Dans "Suick Links", cliquez sur ajouter un nouveau serveur "**Add new server**", une pop up s'ouvre, vous devrez y saisir :

Dans l'onglet Général :
    **Name** : brainBuddy

Dans l'onglet Connection :
    **Host name** / address : db
    Port : 5432 (prérempli)
    Maintenance database : postgres (prérempli)
    Username: admin (prérempli)
    **Password** : admin

Sauvegarder votre serveur = Cliquez sur **Save** en bas à droite de la fenêtre.

## 1.4. Peupler notre BDD 

Dans la colonne de gauche à l'écran, suivez le chemin suivant
    Object explorer >
        Databases >
            postgres >
                Schemas >
                    public >
                        Tables

Effectuez un clic droit sur "Tables" et choisissez "Query tool"

Copiez coller **l'intégralité du script SQL** du document **brainBuddy.sql** (fourni dans le dossier **Docker** du projet) dans **l'interface "Query tool"** puis **exécutez** le script en cliquant sur le bouton "Play" (le bouton avec cet icone ▶️ )

Si tout s'est bien déroulé, la **console de pgAdmin**, située en pied de page, devrait vous annoncer **"success" ou "COMMIT"**

Faites un **clic droit sur Tables** et sélectionnez **Refresh**.

Vous devriez pouvoir **dérouler "Tables"** et y trouver toutes les tables de notre base de données fraichement peuplée.
