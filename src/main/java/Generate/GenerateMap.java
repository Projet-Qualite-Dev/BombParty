package Generate;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Cette class permet de générer une Map contenant dans les clefs les syllabes de 3 lettres et dans les valeurs, les mots contenant ces syllabes.
 * On le génère avec un dictionnaire français où tous les mots sont en majuscules et sans accents et dans l'ordre alphabétique.
 *
 * Nous avons fait deux méthodes pour extraire le dictionnaire :
 *  - Une en lisant ligne par ligne en extrayant le maximum de syllabes dans le même mot.
 *  - Une en lisant lettre par lettre en évitant les sauts de lignes. Cette méthode ne fonctionne pas car on n'a pas la possibilité d'avoir le mot sur lequel on est facilement.
 */
public final class GenerateMap {

    /**
     * Le contenu du fichier dictionnaire.
     */
    private final String DICTIONARY;
    /**
     * Map qui contient pour clefs les syllabes et pour valeurs les mots associés.
     */
    private final Map<String,Set<String>> WORD_LIST;
    /**
     * Le temps d'execution.
     */
    private static String executeTime = "";

    /**
     * Le constructeur de la class GenerateMap.
     *
     * @param filename : Nom du fichier contenant les mots du dictionnaire.
     * @throws URISyntaxException : Dans le cas où le nom du fichier n'est pas bon.
     * @throws IOException : Dans le cas où le fichier n'existe pas.
     */
    public GenerateMap(String filename) throws URISyntaxException, IOException {
        this.DICTIONARY = new String(Files.readAllBytes(Paths.get(getClass().getResource("/Generate/" + filename).toURI())));
        this.WORD_LIST = new HashMap<>();
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
     * Fonction qui essaye de génèrer la Map mais qui n'est pas fonctionnel car on n'a pas les mots. Elle lit caractère par caractère en évitant les sauts de lignes.
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

    /**
     * Fonction qui génère la Map en lisant le dictionnaire ligne par ligne.
     *
     * @return Map contenant les syllabes et la liste de mots contenant les syllabes.
     */
    public Map generateLettersAndWordList() {
        long startTime = System.nanoTime();
        for (String currentWord: this.DICTIONARY.split(System.lineSeparator())) {
            for (int i = 0; i < currentWord.length() - 2; ++i) {
                String currentSyllable = currentWord.substring(i, i + 3);
                if (this.WORD_LIST.containsKey(currentSyllable)) {
                    this.WORD_LIST.get(currentSyllable).add(currentWord);
                } else {
                    this.WORD_LIST.put(currentSyllable, new HashSet<>(List.of(currentWord)));
                }
            }
        }
        this.executeTime = "Temps d'execution de la lecture du dictionnaire (en seconde) : " + (System.nanoTime() - startTime) / Math.pow(10, 9);
        return this.WORD_LIST;
    }

    /**
     * Permet de générer un fichier JSON à partir de la Map.
     */
    public void generateJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (String key: this.WORD_LIST.keySet()) {
            stringBuilder.append("\t\"" + key + "\": [\n");
            int i = 0;
            for (String word: this.WORD_LIST.get(key)) {
                ++i;
                if (i == this.WORD_LIST.get(key).size()) {
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