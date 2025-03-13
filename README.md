# Projet Reviva

Bienvenue dans le projet Reviva ! Ce projet est divisé en deux parties principales : le backend et le frontend. Voici un guide pour vous aider à démarrer.

## Structure du Projet

- **emilab** : Ce dossier contient le backend du projet. Il est responsable de la logique métier, de la gestion des données et de l'API.
- **rv** : Ce dossier contient le frontend du projet. Il s'agit de l'interface utilisateur avec laquelle les utilisateurs interagissent.

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- [Node.js](https://nodejs.org/) (pour le frontend et le backend)
- [npm](https://www.npmjs.com/) (gestionnaire de paquets)
- [Git](https://git-scm.com/) (pour cloner le dépôt)

## Installation et Exécution

### Option 1 : Exécuter les deux projets localement

1. **Backend (emilab)** :
   - Accédez au dossier `emilab` :
     ```bash
     cd emilab
     ```
   - Lancer via SpringBoot
   - Le backend sera accessible à l'adresse `http://localhost:8082`.

2. **Frontend (rv)** :
   - Accédez au dossier `rv` :
     ```bash
     cd rv
     ```
   - Installez les dépendances :
     ```bash
     npm install
     ```
   - Démarrez l'application frontend :
     ```bash
     npm run dev
     ```
   - Le frontend sera accessible à l'adresse `http://localhost:3000`.

### Option 2 : Utiliser le frontend déployé

Si vous ne souhaitez pas exécuter le frontend localement, vous pouvez utiliser la version déployée du frontend. Assurez-vous simplement que le backend est en cours d'exécution localement.

1. **Backend (emilab)** :
   - Accédez au dossier `emilab` :
     ```bash
     cd emilab
     ```
   - Lancer via SpringBoot
   - Le backend sera accessible à l'adresse `http://localhost:8082`.
   - Le backend sera accessible à l'adresse `http://localhost:8082`.

2. **Frontend déployé** :
   - Accédez au frontend déployé via ce lien : [Lien du Frontend Déployé](https://reviva-emiilab.vercel.app/)

## Remarque

-Si vous avez des soucis pour vous connecter à la base de données, essayez ed changer de WiFi!
