package Generate;

import java.io.*;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class ParseJSON {
    private String filename;
    private JSONObject JSONObject;

    public ParseJSON(String filename) throws IOException, URISyntaxException {
        String content = new String(Files.readAllBytes(Paths.get(getClass().getResource("/game/bombParty/exemple.json").toURI())));
        this.filename = filename;
        this.JSONObject = new JSONObject(content);
    }

    public Set<String> getAllWordBySyllab() {

    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        ParseJSON a = new ParseJSON("exemple.json");
    }
}