# Maximum Profit in Job Scheduling

## 문제 설명

> We have n jobs, where every job is scheduled to be done from `startTime[i]` to `endTime[i]`, obtaining a profit of `profit[i]`.
> You're given the `startTime`, `endTime` and `profit` arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
> If you choose a job that ends at time `X` you will be able to start another job that starts at time `X`.

n개의 작업이 있는데 모든 작업은 `startTime[i]` 부터 `endTime[i]`까지 수행되며, 각 작업은 `profit[i]`의 이윤을 남긴다. `startTime[i]`, 시간이 겹치지 않고 얻을 수 있는 최대의 이익을 반환해라. 만약 시간 X에 끝나는 일을 선택한다면, 시간 X에 시작하는 다른 일을 시작할 수 있다.

시작시간 으로부터

```
profit[n], dp[n-1], while k
k.endTime < n.startTime
dp[k] + profit[n]
```

## 입출력 예시

```
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
```

```
Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job.
Profit obtained 150 = 20 + 70 + 60.
```

```
Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
```

## 문제 풀이

**<풀이 1 - endTime 기준 정렬>**

**시간복잡도:**  
**보완점:**

**<풀이 2 - dp>**

**시간복잡도:**  
**보완점:**

## 풀이코드

**<풀이 1 >**

```java

import java.util.*;

class Job {
  int startTime, endTime, profit;

  Job(int startTime, int endTime, int profit) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.profit = profit;
  }

  public int compareTo(Job otherJob) {
    return this.startTime - otherJob.startTime;
  }
  /*
   * Arrays.sort(jobs, new Comparator<Job>() {
   *
   * @Override
   * public int compare(Job o1, Job o2) {
   * // o1.startTime - o2.startTime : 오름차순정렬
   * // o2.startTime - o1.startTime : 내림차순정렬
   * return o1.startTime - o2.startTime;
   * }
   * })
   */

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
      //지금 이익보다 이 다음 이익이 크면, 그게 최대 이익이야.
      //총 3가지 경우

      dp[i] = Math.max(jobs[i].profit, dp[i + 1]);
      for (int j = i + 1; j < len; j++) {
        if (jobs[i].endTime <= jobs[j].startTime) {
          //dp업데이트 시작시간 긴거 나와서
          dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
          break;
        }
      }
    }
    return dp[0];
  }
}
```

**<풀이 2>**
