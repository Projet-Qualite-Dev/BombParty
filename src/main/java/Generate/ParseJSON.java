package Generate;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Cette class permet de lire un fichier JSON avec les objets JSONArray et JSONObject qui sont dans une librairie importée.
 */
public final class ParseJSON {

    /**
     * L'objet qui lit le contenu du fichier JSON.
     */
    private final JSONObject JSON_OBJECT;
    /**
     * Map qui contient pour clefs les syllabes et pour valeurs les mots associés.
     */
    private final Map<String, Set<String>> WORD_LIST = new HashMap<>();
    /**
     * Le temps d'execution.
     */
    private static String executeTime = "";

    /**
     * Le constructeur de la class ParseJSON.
     *
     * @param filename : Nom du fichier JSON contenant les syllabes et les mots associés.
     * @throws URISyntaxException : Dans le cas où le nom du fichier n'est pas bon.
     * @throws IOException : Dans le cas où le fichier n'existe pas.
     */
    public ParseJSON(String filename) throws IOException, URISyntaxException {
        long startTime = System.nanoTime();
        String content = new String(Files.readAllBytes(Paths.get(getClass().getResource("/Generate/" + filename).toURI())));
        this.JSON_OBJECT = new JSONObject(content);
        this.JSONObjectToMap();
        executeTime = "Temps d'execution de la lecture du JSON (en seconde) : " + (System.nanoTime() - startTime) / Math.pow(10, 9);
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
     * Permet de mettre transformer le JSONObject en une Map.
     */
    public void JSONObjectToMap() {
        for (String key: this.JSON_OBJECT.keySet()) {
            this.WORD_LIST.put(key, getAllWordBySyllable(key));
        }
    }

    /**
     * Permet d'avoir tous les mots contenant une syllabe de 3 lettres.
     *
     * @param syllable : Syllabes de 3 lettres.
     * @return Liste des mots associés à la syllabe.
     */
    public Set<String> getAllWordBySyllable(String syllable) {
        JSONArray jsonArray = this.JSON_OBJECT.getJSONArray(syllable);
        Set<String> allWordsBySyllable = new HashSet<>();
        for (Object words: jsonArray) {
            allWordsBySyllable.add(words.toString());
        }
        return allWordsBySyllable;
    }
}