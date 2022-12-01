package Generate;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GenerateMap {
    private String dictionary;
    private Map<String,Set<String>> wordList;

    public GenerateMap(String filename) throws URISyntaxException, IOException {
        this.dictionary = new String(Files.readAllBytes(Paths.get(getClass().getResource("/Generate/" + filename).toURI())));
        this.wordList = new HashMap<>();
    }

/*
 * Méthode qui permet de générer une map mais n'est pas utilisable car on n'a pas les mots dans une variable.
 * Elle consiste à prendre caractère par caractère sans prendre en compte que c'est des mots. Si la syllabe contient un "\n", alors on passe à l'itération suivante.
*/
//    public void generateLetters() {
//        long startTime = System.nanoTime();
//        for (int i = 0; i < this.dictionary.length() - 2; i++) {
//            String current = dictionary.substring(i, i + 3);
//            if (!current.contains("\n")) {
//                if (this.wordList.containsKey(current)) {
//                    this.wordList.put(current, this.wordList.get(current) + 1);
//                } else {
//                    this.wordList.put(current, 1);
//                }
//            }
//        }
//        System.out.println(System.nanoTime() - startTime);
//    }

    public Map generateLettersAndWordList() {
        long startTime = System.nanoTime();
        for (String currentWord: this.dictionary.split("\n")) {
            for (int i = 0; i < currentWord.length() - 2; ++i) {
                String currentSyllab = currentWord.substring(i, i + 3);
                if (this.wordList.containsKey(currentSyllab)) {
                    this.wordList.get(currentSyllab).add(currentWord);
                } else {
                    this.wordList.put(currentSyllab, new HashSet<>(List.of(currentWord)));
                }
            }
        }
        System.out.println("Temps d'execution de la lecture du dictionnaire (en seconde) : " + (System.nanoTime() - startTime) / Math.pow(10, 9));
        return this.wordList;
    }

    public void generateJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (String key: this.wordList.keySet()) {
            stringBuilder.append("\t\"" + key + "\": [\n");
            int i = 0;
            for (String word: this.wordList.get(key)) {
                ++i;
                if (i == this.wordList.get(key).size()) {
                    stringBuilder.append("\t\t\"" + word + "\"\n");
                } else {
                    stringBuilder.append("\t\t\"" + word + "\",\n");
                }
            }
            stringBuilder.append("\t],\n");
        }
        stringBuilder.append('}');
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/Generate/wordList.json");
            myWriter.write(stringBuilder.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}