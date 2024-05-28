package br.ucs.caxiaslixozero.Infrastructure.Utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.HashMap;

public class Utils {

    /**
     * @param clazz
     * @implNote Retorna objeto com chaves "geo" ou "maps"
     * @return
     */
    public static HashMap<String, String> getKeys(Class<?> clazz) {
        HashMap<String, String> keys = new HashMap<>();

        try {
            var path = Path.of(clazz
                    .getClassLoader()
                    .getResource("keys.json")
                    .toURI());

            Reader reader = new BufferedReader(new FileReader(path.toString()));
            JsonObject object = JsonParser.parseReader(reader).getAsJsonObject();

            keys.put("maps", object.get("maps").getAsString());
            keys.put("geo", object.get("maps").getAsString());

            return keys;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
