package Generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GenerateJSON {
    private String dictionnaire;
    private Map<String, Integer> Letters;

    public GenerateJSON(String dictionnaire) {
        this.dictionnaire = dictionnaire;
        this.Letters = new HashMap<>();
    }

    public void GenerateLettersFirstMethod() {
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
    }
    public void GenerateLettersSecondMethod() {
        long startTime = System.nanoTime();
        for (String currentWord: this.dictionnaire.split("\n")) {
            for (int i = 0; i < currentWord.length() - 2; ++i) {
                String currentSyllab = currentWord.substring(i, i + 3);
                if (this.Letters.containsKey(currentSyllab)) {
                    this.Letters.put(currentSyllab, this.Letters.get(currentSyllab) + 1);
                } else {
                    this.Letters.put(currentSyllab, 1);
                }
            }
        }
        System.out.println(System.nanoTime() - startTime);
    }

    public String getDictionnaire() {
        return dictionnaire;
    }

    public Map<String, Integer> getLetters() {
        return Letters;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        String content = new String(Files.readAllBytes(Paths.get(GenerateJSON.class.getResource("/game/bombParty/dictionary.txt").toURI())));
        GenerateJSON json = new GenerateJSON(content);
        json.GenerateLettersFirstMethod();
        System.out.println(json.getLetters());
    }

}
