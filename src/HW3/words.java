package HW3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class words {
    public static void main(String[] args) {

        String[] word = {
                "accept", "access", "account", "actor", "actual", "additional",
                "advance", "adventure", "adviser", "afraid", "agenda", "agree",
                "alliance", "almost", "amazing", "anniversary", "apart", "artistic",
                "ask", "asleep", "background", "beat", "besides", "between",
                "account", "actor", "actual", "additional", "advance"
        };
        HashMap<String, Integer> sortWords = new HashMap<>();
        for(String newWord : word){
            sortWords.put(newWord, sortWords.getOrDefault(newWord,0) +1);
        }
        System.out.println(sortWords);
    }
}

