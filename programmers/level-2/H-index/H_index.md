# H-Index

[문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42747)

## 문제 설명

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 `citations`가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해라.

H-Index란 발표한 **논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값**이 과학자의 H-Index이다.


## 입출력 예시

```answers
Input: [3, 0, 6, 1, 5]
Output:	3
3번 이상 인용된 논문이 6, 5, 3 으로 3편이상

Input: [9, 9, 9, 12]
Output:	4
4번 이상 인용된 논문이 9,9,9,12로 4편이상

```

## 문제 풀이

주어진 논문 인용 횟수를 담은 배열 `citations`을 오름차순으로 정렬 한 후  
**h번 이상 인용된 논문이 h편 이상** 이 부분을 만족시키는 부분을 찾는다. 오름차순 정렬이므로 가장 먼저 찾아진 값이 답이다.  

내림차순으로도 풀 수 있다.

## 풀이 코드 Java

```java
//오름차순 풀이
import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
         for(int i = 0; i < citations.length; i++){
              // 이 지점이 최대값의 지점 더 갈 필요가 없음.
             if( citations[i] >= (citations.length - i)  ){
                return citations.length - i;
             }
        }
        return 0;
    }
}
```

## 풀이 코드 JavaScript
```js
//내림차순 풀이
function solution(citations) {
  let answer = 0;
  citations.sort((a, b) => b - a);
  for (let i = 0; i < citations.length; i++) {
    if (citations[i] >= i + 1) answer++;
    else return answer;
  }
  return answer;
}
```
