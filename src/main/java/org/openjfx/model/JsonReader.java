package org.openjfx.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonReader {

  public static JSONObject readJsonFromUrl(String url) throws JSONException, IOException {
    try (InputStream inputStream = new URL(url).openStream()) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
      String jsonText = readAll(reader);
      return new JSONObject(jsonText);
    }
  }

  private static String readAll(BufferedReader reader) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    int index;
    while ((index = reader.read()) != -1) {
      stringBuilder.append((char) index);
    }
    return stringBuilder.toString();
  }
}
