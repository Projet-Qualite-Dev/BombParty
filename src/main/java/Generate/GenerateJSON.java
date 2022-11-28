package Generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GenerateJSON {
    private String dictionnaire;
    private Map<String,Set<String>> Letters;

    public GenerateJSON(String dictionnaire) {
        this.dictionnaire = dictionnaire;
        this.Letters = new HashMap<>();
    }

    /*public void GenerateLetters() { // Méthode qui permet de générer une map mais n'est pas utilisable car on n'a pas les mots dans une variable.
        long startTime = System.nanoTime();
        for (int i = 0; i < this.dictionnaire.length() - 2; i++) {
            String current = dictionnaire.substring(i, i + 3);
            if (!current.contains("\n")) {
                if (this.Letters.containsKey(current)) {
                    this.Letters.put(current, this.Letters.get(current) + 1);
                } else {
                    this.Letters.put(current, 1);
                }
            }
        }
        System.out.println(System.nanoTime() - startTime);
    }*/

    public void GenerateLettersAndWordList() {
        long startTime = System.nanoTime();
        for (String currentWord: this.dictionnaire.split("\n")) {
            for (int i = 0; i < currentWord.length() - 2; ++i) {
                String currentSyllab = currentWord.substring(i, i + 3);
                if (this.Letters.containsKey(currentSyllab)) {
                    this.Letters.get(currentSyllab).add(currentWord);
                } else {
                    this.Letters.put(currentSyllab, new HashSet<>(List.of(currentWord)));
                }
            }
        }
        System.out.println(System.nanoTime() - startTime);
    }

    public String getDictionnaire() {
        return dictionnaire;
    }

    public Map<String, Set<String>> getLetters() {
        return Letters;
    }

    public void generateJSON() {

//        File myObj = new File("filename.txt");
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (String key: this.Letters.keySet()) {
            sb.append("\t\"" + key + "\": [\n");
            int i = 0;
            for (String word: this.Letters.get(key)) {
                ++i;
                if (i == this.Letters.get(key).size()) {
                    sb.append("\t\t\"" + word + "\"\n");
                } else {
                    sb.append("\t\t\"" + word + "\",\n");
                }
            }
            sb.append("\t],\n");
        }
        sb.append('}');
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/game/bombParty/wordList.json");
            myWriter.write(sb.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        String content = new String(Files.readAllBytes(Paths.get(GenerateJSON.class.getResource("/game/bombParty/dictionary.txt").toURI())));
        GenerateJSON json = new GenerateJSON(content);
        json.GenerateLettersAndWordList();
        json.generateJSON();
    }

}
