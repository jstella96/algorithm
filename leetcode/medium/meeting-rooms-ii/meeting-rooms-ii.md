# Meeting Rooms II

[문제링크](https://leetcode.com/problems/meeting-rooms-ii/)

## 문제 설명

회의시간을 나타내는 배열 `intervals`가 주어진다.
이 배열은 `intervals[i] = [start, end]` 이렇게 나타난다. 이때 필요한 최소 회의실 수를 반환하라.

## 입출력 예시

```
Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
```

```
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
```


## 문제 풀이

1. 서로 다른 배열에 둘 수 있다.
2. start < end 보장되기 때문에
3. 방을 사용하고 있었다면 end가 하나 나온다는건 그 중 하나의 방이 사용 종료 되었다는것

## 풀이 코드

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int max = 0, endPoint = 0, len = intervals.length;

        for(int i = 0; i < len; i++){
            if(startTime[i] < endTime[endPoint]){
                //사용중인 방의 갯수
                max = Math.max(max,i+1-endPoint);
            }else{
                endPoint++;
            }
        }
        return max;
    }
}
```
