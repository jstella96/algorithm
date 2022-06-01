# subarray-sum-equals-k

[문제링크](https://leetcode.com/problems/subarray-sum-equals-k/)

## 문제 설명

정수 배열 `nums`와 정수 `k`가 주어질때, 배열의 합계가 k인 부분 배열의 총 개수를 반환합니다.

## 입출력 예시

```
Input: nums = [1,2,3], k = 3
Output: 2
```

## 문제 풀이

```
  subArray
  A: 1, 1, 1
  SS : 0,1,2,3
  subarrysum : ss[i] - ss[j] (맨앞에 0 넣기 )
  i-j까지 합을 바로 구할 수 있다.
```

합계 배열을 순차적으로 앞 배열과 비교 했을 때 값이 k만큼 증가하는 갯수를 리턴한다.
k=2라면 (0,2) (1,3) => return 2 가 된다.
nums를 for문 돌리면서 sum에 값을 더하고 map에 put(sum, 현재까지 같은 sum을 가진 숫자)
현재 sum - k 값과 동일한 key를 가진 value 를 answer에 더힌다. 그 시기의 sum은 본인의 index를 포함하기 때문에, 매 순회마다 같은 작업을 해줘야한다.



## 풀이 코드

```java
class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
        int answer = 0;
        int sum = 0;

        for(int i = 0; i < nums.length ; i++){
            map.put( sum, map.getOrDefault(sum ,0) + 1 );
            sum += nums[i];
            if(map.containsKey(sum-k)){
                answer += map.get(sum-k);
            }
        }
        return answer;
    }
}
```
