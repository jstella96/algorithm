# 3sum


[문제링크](https://leetcode.com/problems/3sum/)

## 문제 설명

정수 배열 `nums`가 주어지면
`i != j`, `i != k`, `j != k`, `nums[i] + 숫자[j] + 숫자[k]` == 0 를 만족하는
삼중항 [nums[i], nums[j], nums[k]]를 반환하시오.
중복 값이 포함되면 안됩니다.

## 입출력 예시

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

## 문제 풀이

앞측으로 이동하면서 투포인터 사용한다.

## 풀이 코드

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 중복값처리 때문에 필요하다.
        int len = nums.length;
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        for(int i =0; i < len ; i++ ){
            if (i > 0 && nums[i] == nums[i-1]) //중복값처리
                continue;
            int leftPoint = i+1;
            int rightPoint = len-1;
            while(leftPoint <rightPoint){ //포인터가 스치는 순간 까지
                int sum  =nums[i] + nums[leftPoint] +  nums[rightPoint];
                if(sum<0){
                   leftPoint++;
                }else if(sum>0){
                   rightPoint--;
                }else{
                    List<Integer> sums = new ArrayList<Integer>();
                    sums.add(nums[i]);
                    sums.add(nums[leftPoint]);
                    sums.add(nums[rightPoint]);

                    answer.add(sums);

                    while(leftPoint <rightPoint &&nums[leftPoint]==nums[leftPoint+1]){
                         leftPoint++;
                    }
                    while(leftPoint <rightPoint &&nums[rightPoint]==nums[rightPoint-1]){
                         rightPoint--;
                    }
                    leftPoint++;
                    rightPoint--;
                }
            }
        }
        return answer;
    }
}

```
