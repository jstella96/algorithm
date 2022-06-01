# find-the-celebrity


[문제링크](https://leetcode.com/problems/find-the-celebrity/)

## 문제 설명

n명의 사람들이 있는 파티에 있고 그 중 한 명의 유명인이 있을 수 있다고 가정한다. 유명인의 정의는 다른 n - 1명의 사람들은 모두 유명인을 알고 있지만 유명인은 아무도 모른다는 것이다.
유명인 을 찾기 위해서는 "안녕, A. B를 아세요? "라는 질문만 할 수 있으며 가능한 한 적은 질문을 하여 유명인을 찾아야 한다. 유명인이 없으면 -1을 반환한다.

## 입출력 예시

```
Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
Output: 1
```

- graph가 주어지는 것이아닌 판별할 수 있는 함수 knows가 주어진다.

## 문제 풀이

이 문제는 3가지 방법으로 풀 수 있다고 생각 되는데

- n^2 : 일반적인 풀이 브루트 포스
- n^2 > x > n : 일반적인 그래프 서치 카운트
- 2n : 문제 특화.
  한번 물어 볼 때 마다 한명씩 지울 수 있다. 만약 물어 본 사람을 아는 경우는 물어본 해당 노드를 삭제하고, 모른다 하면 모른다 한 그 노드를 삭제한다. 그럼 n만에 셀럽 후보 한명이 나온다. (본인이 아는 사람을 없는 애를 찾는다.) 이 때 본인이 아무도 모르는 애는 한명은 있어햐 한다. 만약 2명이 존재한다면 그 집단은 셀럽이 없다. 둘 다 서로 모른다.
  그럼 그때 이 사람이 셀럽이 아닌 예외 케이스를 위해서 모두가 모두가 그를 아는지 검증한다. 이때 n이 필요하다.

## 풀이 코드

```java
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
         //한명의 후보를 찾는다.
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        //후보자를 검증한다
         for (int i = 0; i < n; i++) {
            if(i== candidate) continue;
            if (knows(candidate,i) || !knows(i,candidate)) {
                return -1;
            }
        }
        return candidate;
    }
}
```
