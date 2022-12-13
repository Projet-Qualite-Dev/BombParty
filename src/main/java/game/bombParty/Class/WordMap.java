package game.bombParty.Class;

import Generate.GenerateMap;
import Generate.ParseJSON;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Map;

/**
 * Cette class permet d'avoir une Map qui contient en clef les syllabes de 3 lettre et un valeur une liste de mots associés à cette syllabe.
 */
public final class WordMap {

    /**
     * Map qui contient pour clefs les syllabes et pour valeurs les mots associés.
     */
    private Map<String, Set<String>> wordList;
    /**
     * Objet qui permet de choisir au hasard une syllabe sans prendre la même à chaque fois.
     */
    private final Random random;
    /**
     * Le temps d'execution.
     */
    private static String executeTime;


    /**
     * Le constructeur de la class WordMap.
     *
     * @param isSorted : Si le programme lance ou non l'algorithme de tri.
     * @throws URISyntaxException : Dans le cas où le nom du fichier n'est pas bon.
     * @throws IOException : Dans le cas où le fichier n'existe pas.
     */
    public WordMap(boolean isSorted) throws URISyntaxException, IOException {
        // Pour générer la Map à l'aide du dictionnaire
        this.wordList = new GenerateMap("dictionary.txt").generateLettersAndWordList();
        this.executeTime = GenerateMap.getExecuteTime();

        // Pour générer la Map à l'aide du JSON
//        this.wordList = new ParseJSON("wordList.json").JSONObjectToMap();
//        this.executeTime = ParseJSON.getExecuteTime();

        this.random = new Random();
        if (isSorted) this.sortWordList();
    }

    /**
     * Avoir le temps d'execution.
     *
     * @return Le temps d'execution.
     */
    public static String getExecuteTime() {
        return executeTime;
    }

    /**
     * Permet d'avoir une syllabe au hasard. C'est à chaque fois une différent.
     *
     * @param difficulty : Nombre de mots minimum.
     * @return String : La syllabe choisit au hasard.
     */
    public String getRandomSyllable(int difficulty) {
        int numberOfSyllable = this.random.nextInt(0, this.wordList.size());
        int index = 1;
        for (String key: this.wordList.keySet()) {
            if (index == numberOfSyllable) {
                if (this.wordList.get(key).size() > difficulty) {
                    return key;
                }
            }
            ++index;
        }
        return getRandomSyllable(difficulty);
    }

    /**
     * Permet de savoir si une valeur est dans un la liste avec une syllabe associée.
     * @param key : La syllabe.
     * @param value : La valeur associée à la syllabe.
     * @return Si la valeur contient la syllabe.
     */
    public boolean containsValueByKey(String key, String value) {
        return this.wordList.get(key).contains(value);
    }

    /**
     * Algorithme de tri par sélection qui tri des chaines de caractères par rapport à leur taille. Cela consiste à déterminer le plus petit élément, puis le deuxième petit élément, et ainsi de suite.
     * On le fait dans une liste de valeurs dont la clef est "ECT". On ne pas le faire dans toutes les listes de mots car la Map est beaucoup trop grande.
     * On ne met pas non plus le résultat dans la Map car le Set range de nouveau à l'ajout. Notre tri est donc supprimé.
     * On parcourt la liste avec une ListIterator qui permet d'avoir l'index et l'Iterator.
     */
    public void sortWordList() {
        List<String> listOfWords = new ArrayList<>(this.wordList.get("ECT"));
        ListIterator<String> listIterator = listOfWords.listIterator();
        while (listIterator.hasNext()){
            int min = listIterator.nextIndex();
            for (int j = listIterator.nextIndex(); j < listOfWords.size(); j++){
                if (listOfWords.get(j).length() <listOfWords.get(min).length()){
                    min = j;
                }
            }
            if (min != listIterator.nextIndex()){
                String temporary = listOfWords.get(listIterator.nextIndex());
                listOfWords.set(listIterator.nextIndex(), listOfWords.get(min));
                listOfWords.set(min, temporary);
            }
            listIterator.next();
        }
        System.out.println(this.wordList.get("ECT"));
        System.out.println(listOfWords);
    }
}