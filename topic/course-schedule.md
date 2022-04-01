---
index: 1
icon: creative
title: Course Schedule
category:
  - algorithm
tag:
  - topological
---

[문제링크](https://leetcode.com/problems/course-schedule/)

## 문제 설명

주어진 수업의 선수관계가 유효한가?

## 입출력 예시

```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
```

- 두 번째의 경우 1->0 0->1 선수관계 모순 되므로 false 반환

## 문제 풀이

선수관계 판별한다. true,false 만 체크함으로 visited와 finish 만 체크한다.
노드가 호출 되면 visited, 후수 과목이 다 호출되고 끝나면 finish 체크
더 자세한 건 아래 '코스 스케줄2' 풀이 참고  
**사이클 판별법**  
[조건]  
visited 는 1이고 finish 0 인거

## 풀이 코드

- 풀이참조

```java

```
