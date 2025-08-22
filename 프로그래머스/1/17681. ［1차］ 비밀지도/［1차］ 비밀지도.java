class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] map = new String[n][n];
        
        for(int i=0; i<n; i++) {
            String binary = String.format("%" + n + "s", Integer.toBinaryString(arr1[i]))
                        .replace(' ', '0');
            for(int j=0; j<n; j++) {
                map[i][j] = String.valueOf(binary.charAt(j));
            }
        }
        
        for(int i=0; i<n; i++) {
            String binary = String.format("%" + n + "s", Integer.toBinaryString(arr2[i]))
                        .replace(' ', '0');
            for(int j=0; j<n; j++) {
                String now = String.valueOf(binary.charAt(j));
                if(now.equals("1") || map[i][j].equals("1")) map[i][j] = "#";
                else map[i][j] = " ";
            }
        }
        
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}