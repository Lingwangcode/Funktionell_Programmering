import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


       /* List<String> list1 = Arrays.asList("abcdefg", "hifkdsljflsk", "hejsljflk");
        List<String> list2 = Arrays.asList("ahjkkkk", "aaaaittttttt", "bbbbbbbbk");

        for (int i = 0; i < list1.size(); i++) {
            String s1 = list1.get(i);
            String s2 = list2.get(i);
            for (int j = 0; j < s1.length(); j++) {
                char c = s1.charAt(j);
                if (s2.indexOf(c) >= 0) {
                    System.out.println("Found common character: " + c);
                }
            }
        }

        */

        List<String> list1 = Arrays.asList("abcdefg", "hifkdsljflsk", "hejsljflk");
        List<String> list2 = Arrays.asList("ahjkkkk", "aaaaittttttt", "bbbbbbbbk");
        List<String> list3 = Arrays.asList("azzzzzzz", "iooooo", "kgggggg");

        for (int i = 0; i < list1.size(); i++) {
            String s1 = list1.get(i);
            String s2 = list2.get(i);
            String s3 = list3.get(i);

            for (char c : s1.toCharArray()) {
                if (s2.indexOf(c) >= 0 && s3.indexOf(c) >= 0) {
                    System.out.println("Common char: " + c);
                }
            }
        }
    }


}