# merge-intervals

[문제링크](https://leetcode.com/problems/merge-intervals/)

## 문제 설명

intervals[i] = [starti, endi]인 간격의 배열이 주어지면 겹치는 모든 간격을 병합하고 입력의 모든 간격을 포함하는 겹치지 않는 간격의 배열을 반환합니다.

## 입출력 예시

```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
```

## 문제 풀이

배열을 0번째 index 기준으로 정렬, 배열을 순회하면서 현재 지점의 1번째 index와 다음 지점의 0번째 index를 비교하고,
그 다음 각 지점의 1번째 index를 비교한다. 합쳐지는 값을 다음 지점에 넣는다  
합쳐졌다면 더 이상 앞에 지점을 볼필요가 없다. 뒷 지점이이 합집합을 가지고 있다. 현재지점과 다음지점이 합쳐지는 구간이 없을 때 
현재 지점을 list에 넣는다.

## 풀이 코드

```java
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for(int i =0 ; i < intervals.length ; i++){
           if(intervals.length-1 == i){
               list.add(intervals[i]);
               break;
           }
           if( intervals[i][1] >= intervals[i+1][0] ){
                intervals[i+1][0] = intervals[i][0];
                if(intervals[i][1] > intervals[i+1][1])
                    intervals[i+1][1] = intervals[i][1];
           }else{
               list.add(intervals[i]);
           }
        }
       return list.toArray(new int[list.size()][]);
    }
}
```
