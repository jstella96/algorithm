# Maximum Profit in Job Scheduling

[문제링크](https://leetcode.com/problems/maximum-profit-in-job-scheduling/)

## 문제 설명

n개의 작업이 있으며 모든 작업이 `startTime[i]`에서 `endTime[i]`까지 수행되고 이때 `profit[i]`의 이익을 얻습니다. startTime, endTime 및 profit 배열이 주어질때,
시간 범위가 겹치는 두 개의 작업이 없도록 취할 수 있는 최대 이익을 반환합니다. X 시간에 끝나는 작업을 선택하면 X 시간에 시작하는 다른 작업을 시작할 수 있습니다.

## 입출력 예시

```
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
```

## 문제 풀이

dp를 이용해서 지금 이익보다 이 다음 이익이 크면, 그게 최대 이익이라고 생각한다.

## 풀이 코드

```java

import java.util.*;

class Job {
  int startTime, endTime, profit;

  Job(int startTime, int endTime, int profit) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.profit = profit;
  }
}

class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int len = startTime.length;

    Job[] jobs = new Job[len];
    for (int i = 0; i < len; i++) {
      Job job = new Job(startTime[i], endTime[i], profit[i]);
      jobs[i] = job;
    }
    Arrays.sort(jobs, new Comparator<Job>() {
      @Override
      public int compare(Job o1, Job o2) {
      // o1.startTime - o2.startTime : 오름차순정렬
      // o2.startTime - o1.startTime : 내림차순정렬
       return o1.startTime - o2.startTime;
      }
    });

    int[] dp = new int[len];

    for (int i = len - 1; i >= 0; i--) {
      if(i == len-1){
          dp[len - 1] = jobs[len - 1].profit;
          continue;
      }
      //지금 이익보다 이 다음 이익이 크면 최대 이익
      dp[i] = Math.max(jobs[i].profit, dp[i + 1]);
      for (int j = i + 1; j < len; j++) {
        if (jobs[i].endTime <= jobs[j].startTime) {
          dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
          break;
        }
      }
    }
    return dp[0];
  }
}
```
