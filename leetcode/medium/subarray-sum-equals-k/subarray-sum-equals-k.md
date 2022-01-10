# subarray-sum-equals-k

## 풀이코드

```java
//새 풀이  - 합 개수를 저장
/*
	[풀이 과정]
		예시 :
		nums = [1,1,1]
		sums = [0,1,2,3] 이 된다.
		합계 배열을 순차적으로 앞 배열과 비교 했을 때 값이 k만큼 증가하는 갯수를 리턴
		k=2라면 (0,2) (1,3) => return 2 가 된다.
		nums를 for문 돌리면서 sum에 값을 더하고 map에 put(sum, 현재까지 같은 sum을 가진 숫자)
	  현재 sum - k 값과 동일한 key를 가진 value 를 answer에 더힌다.
	[수정]
		-값이 들어올 수 있는 걸 고려 x -> hashSet(합계) 사용 -> hashMap 변경
		map 키 값에 index를 넣음 이중 for문으로 O(n^2) 시간초과 -> map(sum, sum갯수) 변경
*/
class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
        int answer = 0;
        int sum = 0;

        for(int i = 0; i < nums.length ; i++){
            map.put( sum, map.getOrDefault( sum ,0) + 1 );
            sum += nums[i];
            if(map.containsKey(sum-k)){
                answer += map.get(sum-k);
            }
        }
        return answer;
    }
}
```
