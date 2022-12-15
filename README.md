# Notre projet BombParty :
La JavaDoc de notre projet se trouve [ici](https://projet-qualite-dev.github.io/BombParty-JavaDoc/main/module-summary.html). 

Pour pouvoir avoir notre projet vous avez 2 solutions :

## Installation manuelle :
Ouvrir un terminal de commande :
`git clone https://github.com/Projet-Qualite-Dev/BombParty.git`

## Installation avec Intellij IDEA :
Au lancement de la page d'accueil d'Intellij IDEA, cliquer sur **Get from VCS**. Dans la section **Repository ULR**, rentrer dans **URL** : `https://github.com/Projet-Qualite-Dev/BombParty.git`

## Pour pouvoir lancer BombParty :
Pour pouvoir lancer notre jeu, il faut importer la bibliothéque [JSON](https://github.com/stleary/JSON-java).
Le lien de téléchargement est : [téléchargement](https://search.maven.org/remotecontent?filepath=org/json/json/20220924/json-20220924.jar).

Pour pouvoir l'importer dans Intellij IDEA, il faut se rendre dans **File | Project Structure | Libraries**. Cliquer sur le **+**, **Java** et selectionner la bibliothèque téléchargée juste avant. Cliquer sur **OK** puis **Apply** et enfin **OK**.

## Règles du jeu :

• Il faut écrire un mot français (présent dans le dictionnaire français) contenant la suite de lettre affichée à l’écran.
→ Les noms propres ne sont donc pas acceptés.

• Pour chaque suite de lettre donnée, on dispose d’un certains nombre de secondes avant que la bombe “explose” et fait perdre une vie à l’utilisateur.

• On dispose d’un nombre d’essais infini pour une même suite de lettre, avec pour limite le temps que met la bombe pour exploser.

• La partie démarre avec 3 vies et se termine lorsque l’utilisateur n’en possède plus.

• Il est possible d’obtenir des vies en réalisant plusieurs mots avec certaines lettres de l’alphabet. Lorsque le l’alphabet est complété, une vie est ajoutée au total de l’utilisateur (voir exemple ci-dessous)

• L’alphabet à compléter se situe à gauche de l’image et est actuellement vide. 
L’utilisateur écrit le mot “BRIOCHE” pour la suite de lettre “BRI”.

![ImageDeJeu](https://www.cjoint.com/doc/22_12/LLpp6qYKCjE_Capture-du-2022-12-15-14-23-41.png)

L’utilisateur appuie sur la touche entrée :
Le mot est correct, les lettres présentes dans le mot “BRIOCHE” et également présentes dans l’alphabet se colorent donc en vertes dans l’alphabet.

![ImageDeJeu](https://www.cjoint.com/doc/22_12/LLpp6YpqO2E_Capture-du-2022-12-15-14-23-55.png)

Une fois cet alphabet complété, il se réinitialise et ajoute une vie au compteur de l’utilisateur.
Le nombre de vie n’est pas limité.

## Manuel d'utilisation : 
![](manuel_utilisation.gif)
