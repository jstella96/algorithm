---
index: 1
icon: creative
title: Course Schedule II
category:
  - algorithm
tag:
  - topological
---

[문제링크](https://leetcode.com/problems/course-schedule-ii/)

## 문제 설명

수강해야 하는 총 `numCourses` 과정이 있으며 선수과목 관계가 배열로 주어진다.모든 과정을 마치기 위해 수강해야 하는 과정의 순서를 반환해야한다. 유효한 답변이 많으면 그 중 하나를 반환하고, 모든 과정을 마치는 것이 불가능한 경우 빈 배열을 반환한다.

## 입출력 예시

```
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
```

## 문제 풀이

topological 알고리즘을 사용한다.
노드를 돌아다니면서 startTime과 endTime을 기록한다.  
한노드를 무작위로 선택 후 후수 과목 호출 호출된 노드는 startTime을 기록 그리고 아래 모든 후수 과목 노드들을 돌았을 때 endTime을 적고 상위 노드로 이동. 모든 노드들을 돌면서 그래프에 값을 준다.
그 후 endTime이 크다는 것은 1)선수과목이거나 2)관련이 없다는 것을 의미하므로
endTime이 큰 것 부터 한다는 것은 후수과목을 먼저할 일이 없다. 사이클없는것만 가능
(참고)노드가 x노드, y노드 두개 있을때 y노드의 endTime 이 더 크다면 무엇이 선수 과목일까? y이다. 아니면 관련이 없을 수 도 있다.

**사이클 판별법**
[조건]

1.  start 타임이 이미 있고 endTime 안 적혀있는 노드를 호출 했을 때(후수과목이라 생각하고 호출)
2.  start 타임이 있는 노드에 endTime 안적혔다는 것은 이후에 호출되는 애들이 다 해당노드보다 후수과목이란건데, 근데 해당노드를 불렀으니까 이건 사이클이 된다.

## 풀이 코드

- 풀이참조

```java

```
