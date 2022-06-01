# robot-bounded-in-circle


[문제링크](https://leetcode.com/problems/robot-bounded-in-circle/)

## 문제 설명

무한 평면에서 로봇은 처음에 (0, 0)에 서서 북쪽을 향하고 있습니다.

- 북쪽 방향은 y축의 양의 방향입니다.
- 남쪽 방향은 y축의 음의 방향입니다.
- 동쪽 방향은 x축의 양의 방향입니다.
- 서쪽 방향은 x축의 음의 방향입니다.
  로봇은 다음 세 가지 명령 중 하나를 받을 수 있습니다.
- "G": 1단위 직진합니다.
- "L": 왼쪽으로 90도 회전합니다(즉, 시계 반대 방향).
- "R": 오른쪽(즉, 시계 방향)으로 90도 회전합니다.

로봇은 주어진 지시를 순서대로 수행하고 영원히 반복합니다. 로봇이 원을 떠나지 않도록 평면에 원이 있는 경우에만 true를 반환합니다.

## 입출력 예시

```
Input: instructions = "GGLLGG"
Output: true
```

## 문제 풀이

구현 문제이다. 있는 그대로 풀기

## 풀이 코드

```java
class Solution {
    public boolean isRobotBounded(String instructions) {
       int x=0, y=0, direction = 0;

//          N 0
//     W 3       E 1
//          S 2

        for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                switch (direction){
                case 0: y++; break;
                case 1: x++; break;
                case 2: y--; break;
                case 3: x--; break;
                }

            }else if(ch == 'L'){
                direction = direction == 0 ? 3 : (direction-1);

            }else if(ch == 'R'){
                direction = direction == 3 ? 0 : (direction+1);
            }
        }
        if(direction!= 0 || (x == 0 && y == 0)){
            return true;
        }
        return false;
    }
}
```
