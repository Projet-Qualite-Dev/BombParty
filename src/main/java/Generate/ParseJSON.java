/**
 * Cette class permet de lire un fichier JSON avec les objets JSONArray et JSONObject qui sont dans une librairie importé.
 */

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

public final class ParseJSON {
    private final JSONObject JSON_OBJECT;
    private final Map<String, Set<String>> WORD_LIST = new HashMap<>();
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
     * @return String : Le temps d'execution.
     */
    public static String getExecuteTime() {
        return executeTime;
    }

    /**
     * Permet de mettre transformer le JSONObject en Map<String, Set<String>>.
     *
     * @return Map<String, Set<String>> : Map contenant les syllabes et la liste de mots contenant les syllabes.
     */
    public Map JSONObjectToMap() {
        for (String key: this.JSON_OBJECT.keySet()) {
            this.WORD_LIST.put(key, getAllWordBySyllab(key));
        }
        return this.WORD_LIST;
    }

    /**
     * Permet d'avoir tous les mots contenant une syllabe de 3 lettres.
     *
     * @param syllab : Syllabes de 3 lettres.
     * @return Set<String> : Liste des mots associés à la syllabe.
     */
    public Set<String> getAllWordBySyllab(String syllab) {
        JSONArray jsonArray = this.JSON_OBJECT.getJSONArray(syllab);
        Set<String> allWordsBySyllab = new HashSet<>();
        for (Object words: jsonArray) {
            allWordsBySyllab.add(words.toString());
        }
        return allWordsBySyllab;
    }
}