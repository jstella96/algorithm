# daily-temperatures

[문제링크](https://leetcode.com/problems/daily-temperatures/)

## 문제 설명

일일 온도를 나타내는 정수 배열`temperatures`이 주어질때, i번째 날 이후에 더 따뜻한 온도를 얻기 위해 기다려야 하는 일수를 answer[i]에 담아 반환하시오. 가능한 미래의 날이 없다면 answer[i] 에 0을 담아 반환하시오.

## 입출력 예시

```
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
```

## 문제 풀이

```
  	int answer = new int[배열 길이]
		temperatures for 문 돌면서 하나씩 검증
		포인트 온도 기준 이후 값들 for 문 돌면서 값이 올라가는 부분이 있다면 그 값을 answer에	입력 없다면 0입력

    다른 풀이: stack을 사용
```

## 풀이 코드

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[ ] answer = new int [temperatures.length];
        for(int i = 0; i < temperatures.length ; i++){
            for (int z= i+1; z< temperatures.length ; z++){
                if(temperatures[i] < temperatures[z]){
                    answer[i] = z-i;
                    break;
                }
                answer[i] = 0;
            }
        }
        return answer;
    }
}
```
