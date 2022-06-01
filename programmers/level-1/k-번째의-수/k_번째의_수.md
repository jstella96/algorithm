# K 번째의 수


[문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42748)

## 문제 설명

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려고 한다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 `commands`가 매개변수로 주어질 때, `commands`의 모든 원소에 대해 앞서 설명한 연산을 적용하여 나온 결과를 배열에 담아 
return 하도록 solution 함수를 작성하라.

## 입출력 예시

```
Input:
  array: [1, 5, 2, 6, 3, 7, 4]
  commands: [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
Output: [5, 6, 3]
```

## 문제 풀이

문제 그대로 commands를 반복문으로 순회하면서 배열을 자른후 정렬하여 해당 지점의 원소를 구한다. 단순 구현 문제이다.


## 풀이코드 Java

```java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int i=0; i<len; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}
```

## 풀이 코드 JavaScript 
```js
function solution(array, commands) {
    const answer = [];
    for(let command of commands){
        let [startIndex, endIndex, K] = command;
        let temp = array.slice(startIndex-1, endIndex);
        temp.sort((a, b) => a - b)
        answer.push(temp[K-1])
    }
    return answer;
}
```
