package org.rvaidya.utilities.jsonUtilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFile {

    public static synchronized JsonObject getJsonFileObject(String filePath) {
        JsonObject data = null;
        Path path = Paths.get(filePath);
        try {
            Reader reader = Files.newBufferedReader(path);
            JsonElement jsonElement = JsonParser.parseReader(reader);
            data = jsonElement.getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static synchronized JsonArray getJsonFileArray(String filePath) {
        JsonArray data = null;
        Path path = Paths.get(filePath);
        try {
            Reader reader = Files.newBufferedReader(path);
            JsonElement jsonElement = JsonParser.parseReader(reader);
            data = jsonElement.getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
