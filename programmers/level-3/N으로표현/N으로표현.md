# N으로 표현

[문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42895)

## 문제 설명

주어진 숫자 `N`과 사칙연산만을 사용해서 타겟숫자 `number`를 만들어야 한다. 이때 같은 숫자를 연속해서 붙이는 것도 가능하다 
이때 `N`사용 횟수의 최솟값을 return해라. 

## 입출력 예시
```
Input:
    N: 5
    number: 12
Output: 4

Input:
    N: 2
    number: 11
Output: 3
```


## 문제 풀이

풀이식을 문자열로 늘려나간다. 해당 문자열 풀이식을 eval()함수를 사용해서 숫자로 만들어서 타겟숫자와 같은지 비교한다.
이렇게 푸는 이유는 단지 사칙연산을 이어붙이는 것 뿐 아니라 숫자를 이어붙여야하는 경우가 있기 때문이다. 
풀이식을 늘려가는 부분을 재귀함수로 처리해서 숫자하나를 추가할 때 마다 가능한 모든 풀이식을 호출한다.

## 풀이코드 JavaScript

```js
let min = 10;
function solution(N, number) {
     
    tryCalculation(N,N,number,1)
    return min > 8 ? -1: min;
}

function tryCalculation(base ,number, target, count){
    if(count > 8)return;
    //문자열로 만들고 값을 받아서 비교.
    if(eval(base) == target){ min = Math.min(count,min) };
    tryCalculation(`${base}+1`,number,target, count + 2)
    tryCalculation(`${base}-1`,number,target, count + 2)
    tryCalculation(`${base}+${number}`,number,target, count + 1)
    tryCalculation(`${base}-${number}`,number,target, count + 1)
    tryCalculation(`(${base})*${number}`,number,target, count + 1)
    tryCalculation(`(${base})/${number}`,number,target, count + 1)
    tryCalculation(`${base}${number}`, number,target, count + 1)
}
```
