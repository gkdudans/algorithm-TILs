import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {

        List<Music> result = new ArrayList<>();
        // '#' 처리 (대문자 → 소문자, '#' 제거)
        StringBuilder music = new StringBuilder(m);
        int i = 1;
        while (i < music.length()) {
            if (music.charAt(i) == '#') {
                char prev = music.charAt(i - 1);
                char newChar = Character.toLowerCase(prev);
                music.setCharAt(i - 1, newChar);
                music.deleteCharAt(i); 
            } else {
                i++;
            }
        }

        // 음악 정보 파싱 
        for (int j = 0; j < musicinfos.length; j++) {
            // playLength 계산
            String[] info = musicinfos[j].split(",");
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
            int playLength = end - start;

            List<String> notes = new ArrayList<>();
            String melody = info[3];
            for(int k=0; k<melody.length(); k++) {
                // '#' 포함된 음인 경우 
                if(k+1 < melody.length() && melody.charAt(k+1) == '#') {
                    notes.add(melody.substring(k, k+2)); 
                    k++;
                // 아닌 경우 
                } else {
                    notes.add(melody.substring(k, k+1)); 
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int t=0; t<playLength; t++) {
                sb.append(notes.get(t % notes.size()));
            }

            // '#' 처리 (대문자 → 소문자, '#' 제거)
            i = 1;
            while (i < sb.length()) {
                if (sb.charAt(i) == '#') {
                    char prev = sb.charAt(i - 1);
                    char newChar = Character.toLowerCase(prev);
                    sb.setCharAt(i - 1, newChar);
                    sb.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            if (sb.toString().contains(music.toString())) {
                result.add(new Music(j, playLength, info[2]));
            }
        }
        Collections.sort(result);
        return result.size() > 0 ? result.get(0).title : "(None)";
    }

    static class Music implements Comparable<Music> {
        int index;
        int length;
        String title;

        Music(int index, int length, String title) {
            this.index = index;
            this.length = length;
            this.title = title;
        }

        @Override
        public int compareTo(Music m) {
            if (this.length == m.length) return this.index - m.index;
            return m.length - this.length;
        }
    }
}
