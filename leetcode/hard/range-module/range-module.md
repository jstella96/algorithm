# Range Module

# 문제

Range Module은 숫자의 범위를 추적하는 모듈입니다. 데이터 구조를 설계하여 half-open intervals으로 표시되는 범위를 추적한다

half-open interval [left, right) 는 안에는 정수 `x`값이 있다. left <= x < right.

RangeModule 클래스 구현:

- RangeModule() : 초기화.
- void addRange(int left, int right) : [left, right)간격의 매개변수 범위 값 추가
- boolean queryRange(int left, int right) : 매개변수 범위가 현재 가지고 있는 범위안에 전부 포함되면 `true` 리턴
- void removeRange(int left, int right) : 해당 범위 값 삭제

## 문제 설명

treeset 을 사용해 볼 수있는 좋은 문제
tailSet : 지정된객체보다 큰 객체 반환

## 풀이 코드

```java


class RangeModule {
    TreeSet<int[]> ts;
    public RangeModule() {
        this.ts = new TreeSet<>((a,b) -> a[1] - b[1]);
    }

    public void addRange(int left, int right) {
        Iterator<int[]> iter = ts.tailSet(new int[]{0, left}, true).iterator();
        while (iter.hasNext()) {
            int[] temp = iter.next();
            if (temp[0] > right) break;

            left = Math.min(left, temp[0]);
            right = Math.max(right, temp[1]);
            iter.remove();
        }

        ts.add(new int[]{left, right});
    }

    public boolean queryRange(int left, int right) {
        int[] ceiling = ts.ceiling(new int[]{0, right});
        return ceiling != null && ceiling[0] <= left;
    }

    public void removeRange(int left, int right) {
        Iterator<int[]> iter = ts.tailSet(new int[]{0, left}, false).iterator();

        int[] front = null;
        int[] back = null;

        while (iter.hasNext()) {
            int[] temp = iter.next();
            if (temp[0] >= right) break;

            if (temp[0] < left) front = new int[]{temp[0], left};
            if (right < temp[1]) back = new int[]{right, temp[1]};
            iter.remove();
        }

        if (front != null) ts.add(front);
        if (back != null) ts.add(back);
    }
}
/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
```
