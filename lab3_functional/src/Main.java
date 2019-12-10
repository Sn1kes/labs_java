import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        char c = 'a';
	    for(int i = 0; i < 10; ++i) {
	        int k = (int)(Math.random() * 255);
	        String str = String.valueOf(c);
	        ++c;
	        mp.put(k, str);
        }
	    List<String> arr = concat(mp);
        for(String str : arr) {
            System.out.println(str);
        }
    }

    static public ArrayList<String> concat(Map<Integer, String> mp) {
        return mp.entrySet().stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new));
    }
}
