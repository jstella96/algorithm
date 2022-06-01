# coin-change

[문제링크](https://leetcode.com/problems/coin-change/)

## 문제 설명

다른 금액의 동전을 나타내는 정수 배열 `coins`과 총 금액을 나타내는 정수 금액이 제공됩니다. 해당 금액을 구성하는 데 필요한 가장 적은 수의 동전을 반환합니다. 동전의 어떤 조합으로도 그 금액을 채울 수 없으면 -1을 반환합니다. 각 종류의 동전이 무한히 있다고 가정할 수 있습니다.

## 입출력 예시

```
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

## 문제 풀이

1. 총 합계를 만들기 위해 동전을 하나씩 사용한다. 예제의 11 원을 만들기 위해서는 10 원에 1원을 사용, 9원에 2원을 사용, 6원에 5원을 사용. 총 3개의 이전 경우의 수가 있으며, 10원,9원,6원을 만들기 위해 필요했던 동전의 갯수에 +1을 더해주어야 한다. 위와 같은 계산을 식으로 나타내면 아래와 같다.

```java
// a(n) = min( a(n-1), a(n-2), a(n-5) ) + 1
// 문제 에서는 동전의 금액이 동적이므로 아래와 같이 나타낸다.
for(int i = 0; i < coins.length; i++) {
    min = min(min, a(n-conin[i])
}
```

2. 0원부터 구하려는 총합까지의 길이를 가진 배열을 선언하여, index(원)이 만들어 지는데 필요한 코인의 최소값을 배열에 저장하여 중복된 계산을 피한다.

## 풀이 코드

```java
class Solution {
    public static int coinChange(int[] coins, int amount) {
				//0~amount
        int[] amounts = new int[amount + 1];
				//coins 조합해 amount 를 만들 수 있는 경우 가능한 최소 코인 갯수가,
				//coins 조합해 amount 를 만들 수 없는 경우 Integer.MAX_VALUE 값이 리턴
        int min = recur(coins, amounts, amount);

        return min > amount ? -1 : min;
    }

    public static int recur(int[] coins, int[] amounts, int amount) {
				// -amount 값이 올경우, 값을 무시 하기 위해 최대값 리턴,-1 이유는 아래 계산에서 +1이 있기 때문에
				if (amount < 0) return Integer.MAX_VALUE - 1;
				//amount==0 이란 것은 해당 코인의 조합으로 amount 를 만들 수 있다는 것 계산시작.
        if (amount == 0) return 0;
				//이전에 이미 계산된 값이 있다면 중복계산제거 memorization
        if (amounts[amount] > 0) return amounts[amount];
        //비교 시작은 최대값-1
				int min = Integer.MAX_VALUE - 1;
        // 점화식이 표현 된 부분
        for (int i = 0; i < coins.length; i++) {
						//0원 0 -> 2원 1 -> 3원 2.. 6원.. 2
            min = Math.min(min, recur(coins, amounts, amount - coins[i]) + 1);
        }

        return amounts[amount] = min;
    }
}
```
