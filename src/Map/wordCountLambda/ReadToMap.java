package Map.wordCountLambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ReadToMap {

    public static void main(String[] args) {
        try{
            URL url = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");
            BufferedReader words = new BufferedReader(new InputStreamReader(url.openStream()));


            Map<Integer, List<String>> wordMap = words.lines().collect(groupingBy(w-> w.length()));
            Collection<List<String>> wordsList = wordMap.values();

           // wordMap.forEach((k,v) -> System.out.println(k + " " + v));

            wordsList.stream().collect(Collectors.toMap((w -> w.get(0).length()), (w-> w.size()))).forEach((k, v) -> System.out.println(k + " " + v));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
