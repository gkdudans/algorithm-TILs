import java.util.*;

class Solution {
    public String solution(String s) {

        String[] words = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.length() > 0) {

                char first = w.charAt(0);
                if (Character.isLetter(first)) {
                    sb.append(Character.toUpperCase(first));
                } else {
                    sb.append(first);
                }

                if (w.length() > 1) {
                    sb.append(w.substring(1).toLowerCase());
                }
            }

            
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
