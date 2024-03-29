### Gotta Map'Em All : Projet de génie logiciel et gestion de projet (INFO-F-307)

Ce projet consiste à développer une application pour la création d’une cartographie pour le repérage des Pokémons. L’application est assistée par ordinateur exécutable sous Linux, Windows et MacOS, pour ce faire, Java est le langage de programmation utilisé. L’objectif principal du projet est de concevoir un environnement pour la création d’une carte partagée entre plusieurs utilisateurs du système. L’application permet d’afficher les cartes d'un moteur de , sur lesquelles on peut ajouter l’emplacement des Pokémons ou de modifier la réputation des information existantes.

# Utilisation

## Compilation

`$ gradle distZip`

Gradle s'occupera d'installer les packages et dependencies nécessaires, comme GMapsFX

Après avoir cloner le répertoire [Gitlab](https://gitlab.com/INFO307-1617/Groupe07) sur Eclipse, il faut faire : Import > Gradle > Gradle project. Puis il faut choisir le bon répertoire Gitlab, et finalement il faut encore cliquer sur « Finish » Pour l’execution il faut juste faire un « Run ».


## Démarrage

```
$ gradle server:run &
$ gradle client:run
```

Deux fichiers exécutables `.jar` sont aussi fournis dans le dossier `dist` pour faciliter la tâche d’exécution, si Gradle ne veut pas être utilisé.

## Outils et librairies

Eclipse disponible sur - http://www.eclipse.org

EGit plugin Git en Java pour Eclipse - http://www.eclipse.org/egit

Java 1.8 téléchargable sur - http://www.oracle.com

e(fx)clipse plugin JavaFX pour Eclipse - http://www.eclipse.org/efxclipse (Installation : http://www.eclipse.org/efxclipse/install.html )

GMapsFX JavaFX API for Google Maps - http://rterp.github.io/GMapsFX/

Spark: A tiny Java web framework - http://sparkjava.com/

### Données Pokemon

PokéAPI: The Pokemon RESTFUL API - https://pokeapi.co/

PkParaíso, images et sprites https://www.pkparaiso.com/

# Configuration :

## Serveur

Le serveur a besoin de deux bases de données Mongo: `gmta` et `gtma-test`. Ses URI sont specifiées dans le fichier `Database.java`:

```java
final String prod_db = "mongodb://gmta:bonjourmdp@ds163010.mlab.com:63010/gmta";
final String test_db = "mongodb://gmta:bonjourmdp@ds115131.mlab.com:15131/gmta-test";

```

## Client

Une clé Google Maps JavaScript API doit être fourni.

# Tests

```
$ gradle test
```
Gradle executera les tests pour le client et le serveur.

# Misc

Happy Mapping !

## Développement

Pull requests welcome !

## Screenshot

![Screenshot 1](team/images/screenshot1.png "Map view and clusters")
![Screenshot 2](team/images/screenshot2.png "Geo localisation")
![Screenshot 3](team/images/screenshot3.png "Add a pokemon")

## License

> This is free and unencumbered software released into the public domain.

> Anyone is free to copy, modify, publish, use, compile, sell, or distribute this software, either in source code form or as a compiled binary, for any purpose, commercial or non-commercial, and by any means.

> In jurisdictions that recognize copyright laws, the author or authors of this software dedicate any and all copyright interest in the software to the public domain. We make this dedication for the benefit of the public at large and to the detriment of our heirs and successors. We intend this dedication to be an overt act of relinquishment in perpetuity of all present and future rights to this software under copyright law.

> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

> For more information, please refer to <http://unlicense.org/>

See the license of the libraries used for more information.
