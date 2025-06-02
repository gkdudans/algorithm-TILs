class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 1;
        int[] answer = new int[2];
        
            
        for(int height=3; height<=(int)Math.sqrt(brown+yellow); height++) {
            if((brown + yellow) % height == 0) {
                int temp = (brown + yellow) / height; 
                if(temp >= height) width = temp;
            }
            if((width - 2)*(height - 2) == yellow 
               && width*height == (brown + yellow)) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
            
        }
        
        return answer;
    }
}