import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, List<Song>> genreSongMap = new HashMap<>();
        Map<String, Integer> genreCountMap = new HashMap<>();
        
        // genreSongMap에 요소 추가 
        for(int i=0; i<genres.length; i++) {
            genreSongMap.computeIfAbsent(genres[i], k -> new ArrayList<>())
            .add(new Song(i, plays[i]));
        }
        
        List<String> genreList = new ArrayList<>(genreSongMap.keySet());
        
        // genreSongMap의 genre마다 재생 횟수 sum 
        for(int i=0; i<genreList.size(); i++) {
            int count = 0;
            List<Song> songs = genreSongMap.get(genreList.get(i));
            for(int j=0; j<songs.size(); j++) {
                count += songs.get(j).count;
            }
            genreCountMap.put(genreList.get(i), count);
        }
        
        // sum이 큰 순서대로 sort 
        List<String> sortedGenres = new ArrayList<>(genreCountMap.keySet());
        sortedGenres.sort((a, b) -> genreCountMap.get(b) - genreCountMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongMap.get(genre);
            Collections.sort(songs);
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).index);
            }
        }
        
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    
    static class Song implements Comparable<Song>{
        int index;
        int count;
        
        Song(int index, int count) {
            this.index = index;
            this.count = count;
        }
        
        @Override
        public int compareTo(Song o) {
            // 재생 횟수가 같으면 index가 낮은 노래 
            if (this.count == o.count) {
                return this.index - o.index;
            }
            // 재생 횟수가 큰 것 먼저 
            return o.count - this.count;
        }
    }
}