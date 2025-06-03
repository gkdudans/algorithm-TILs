import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            jobList.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        // 요청 시각 기준 정렬
        jobList.sort(Comparator.comparingInt(j -> j.requestTime));

        // pq 정의, 문제 조건에 따른 우선순위 큐 구성 
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.duration != b.duration) return a.duration - b.duration;
                else if (a.requestTime != b.requestTime) return a.requestTime - b.requestTime;
                else return a.id - b.id;
            }
        );
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int nowTime = jobList.get(0).requestTime; // 현재 시간 초기화 
        int answer = 0; // 누적 반환 시간 초기화
        int index = 1;
        int count = 0;
        pq.add(jobList.get(0));
        
        while(count < jobs.length) {
            while (index < jobList.size() && jobList.get(index).requestTime <= nowTime) {
                pq.offer(jobList.get(index)); 
                index++;
            }
            
            if(!pq.isEmpty()) {
                // 대기 중인 job이 있는 경우 
                Job now = pq.poll();
                nowTime += now.duration;
                answer += nowTime - now.requestTime;
                count++;                
            } else {
                // 대기 중인 job이 없으면 시간을 다음 요청 시각으로 이동 
                nowTime = jobList.get(index).requestTime;
            }
            
        }
        
        return answer / jobs.length;
    }
    
    class Job {
    int id;
    int requestTime;
    int duration;

    public Job(int id, int requestTime, int duration) {
        this.id = id;
        this.requestTime = requestTime;
        this.duration = duration;
    }
}
    
    
}