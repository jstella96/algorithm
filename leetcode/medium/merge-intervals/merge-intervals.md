# merge-intervals

## 풀이 과정

    앞 배열 기준으로 정렬,
    for 문을 돌면서 현재 포인트의 두번째와 다음 배열의 첫번째를 비교하고,
    그 다음 각 배열의 두번째를 비교한다 합쳐지는 값을 뒷 배열에 넣는다\
    합쳐지지않으면

```java
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for(int i =0 ; i < intervals.length ; i++){
           if(intervals.length-1 == i){
               res.add(intervals[i]);
               break;
           }
           if( intervals[i][1] >= intervals[i+1][0] ){
                intervals[i+1][0] = intervals[i][0];
                if(intervals[i][1] > intervals[i+1][1])
                    intervals[i+1][1] = intervals[i][1];
           }else{
               res.add(intervals[i]);
           }
        }
       return res.toArray(new int[res.size()][]);
    }
}
```
