import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WordFetcher {

    public String getWord(int length) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://random-word-api.herokuapp.com/word?length=" + length))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200) return extractWordFromJsonArray(response.body());
            else {
                LocalCorrectWords localWord = new LocalCorrectWords();
                return localWord.getCorrectWord(length);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String extractWordFromJsonArray(String jsonArray) {
        jsonArray = jsonArray.trim();
        if (jsonArray.startsWith("[") && jsonArray.endsWith("]")) {
            return jsonArray.substring(1, jsonArray.length() - 1).replace("\"", "").trim();
        }
        return null;
    }
}
