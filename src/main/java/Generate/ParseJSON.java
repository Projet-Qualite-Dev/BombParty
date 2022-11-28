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

public class ParseJSON {
    private JSONObject JSONObject;
    private Map<String, Set<String>> wordList = new HashMap<>();

    public ParseJSON(String filename) throws IOException, URISyntaxException {
        long startTime = System.nanoTime();
        String content = new String(Files.readAllBytes(Paths.get(getClass().getResource("/Generate/" + filename).toURI())));
        this.JSONObject = new JSONObject(content);
        this.JSONObjectToMap();
        System.out.println(System.nanoTime() - startTime);
    }

    private void JSONObjectToMap() {
        for (String key: this.JSONObject.keySet()) {
            this.wordList.put(key, getAllWordBySyllab(key));
        }
    }

    public Set<String> getAllWordBySyllab(String syllab) {
        JSONArray jsonArray = this.JSONObject.getJSONArray(syllab);
        Set<String> allWordsBySyllab = new HashSet<>();
        for (Object words: jsonArray) {
            allWordsBySyllab.add(words.toString());
        }
        return allWordsBySyllab;
    }
}