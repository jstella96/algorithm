# random-pick-with-weight


[문제링크](https://leetcode.com/problems/time-based-key-value-store/)

## 문제 설명

w[i]는 i번째 인덱스의 가중치를 나타내는 양의 정수 배열이 제공된다.
[0, w.length - 1] 범위에서 무작위로 인덱스를 선택하여 반환하는 pickIndex() 함수를 구현해야 합니다.
인덱스 i를 선택할 확률은 w[i] / sum(w)입니다.

예를 들어 w = [1, 3]인 경우 지수 0을 선택할 확률은 1 / (1 + 3) = 0.25(즉, 25%)이고 지수 1을 선택할 확률은 3 / (1 + 3)입니다. = 0.75(즉, 75%).

## 문제 풀이

```
//1] w배열 제공
//2] w[i] = i번째의  가중치
//3] pickIndex 랜덤으로 가중치에 비례하는 정수반환
//4] [1,3] 이면 1/4 , 3/4 로 0반환 확률 25% 1반환 확률 75%
//5] i를 선택할 확률은 w[i] / sum(w)
//6] 좀 더 다르게 말하면 0, 1, 1, 1 중 한개 반환 간단하게 보면, - 단순 갯수일뿐. index가 몇개 있다 느낌.
//7] 즉 분모는 언제나 sum 이 1~sum 번째가 있다고 할 때 번호 추첨후 해당되는 index 주면 됨
//8] 다 나열하면 시간이 아주 어마무시함 !!(조건이 10^5) -> 바이너리 서치 사용
//9] 1 ~4 사이 숫자야 -> 1번 ! 이게 됨
/*[코드]
    1] Solution () =>
        for 돌면서 sum 에 가중치를 달아준다
        sum =[w[0]+(w[0]+w[1])+(w[0]+w[1]+w[2])]
    2] pickIndex() =>
        random 값을 1 ~ sum[sum.length - 1] 값으로 잡는다.
        찾는 값은 나열한 숫자 0,1,1,1 중에 random번째의 index 찾는거니까

*/
```

## 풀이 코드

```java
class Solution {

    int[] sum;
    public Solution(int[] w) {
        for(int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + w[i];
        }
        sum = w;
        //sum[w[0]+(w[0]+w[1]) ]
        //w= [1,3,6]
        //sum =[0,4,10]
        //개수니까 .. 2는 6/10확률
    }

    public int pickIndex() {

    int random = ThreadLocalRandom.current().nextInt(1, sum[sum.length - 1] + 1);
		//nextInt 는 정상적인 경우 최대 값을 포함하지 않기 때문에 +1 ,합계는 최소 1부터 시작
        return binarySearch(random, 0, sum.length - 1);
    }

		//재귀 함수로 구현!
    int binarySearch(int target, int start, int end) {
        int mid = (start + end) / 2;
        int rangeStart = mid == 0 ? 1 : sum[mid - 1] + 1; // 이부분만 조심
        int rangeEnd = sum[mid];

        if(target >= rangeStart && target <= rangeEnd) {
            return mid;
        }

        if(target < rangeStart) {
            return binarySearch(target, start, mid - 1);
        }

        return binarySearch(target, mid + 1, end);

    }
}

```
