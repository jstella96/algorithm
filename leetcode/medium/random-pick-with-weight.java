import java.util.concurrent.ThreadLocalRandom;

class Solution {

  int[] sum;

  public Solution(int[] w) {
    for (int i = 1; i < w.length; i++) {
      w[i] = w[i - 1] + w[i];
    }
    sum = w;
    // sum[w[0]+(w[0]+w[1]) ]
    // w= [1,3,6]
    // sum =[0,4,10]
    // 개수니까 .. 2는 6/10확률
  }

  public int pickIndex() {
    int random = ThreadLocalRandom.current().nextInt(1, sum[sum.length - 1] + 1);
    // nextInt 는 정상적인 경우 최대 값을 포함하지 않기 때문에 +1 ,합계는 최소 1부터 시작
    return binarySearch(random, 0, sum.length - 1);
  }

  int binarySearch(int target, int start, int end) {
    int mid = (start + end) / 2;
    int rangeStart = mid == 0 ? 1 : sum[mid - 1] + 1;
    int rangeEnd = sum[mid];

    if (target >= rangeStart && target <= rangeEnd) {
      return mid;
    }

    if (target < rangeStart) {
      return binarySearch(target, start, mid - 1);
    }

    return binarySearch(target, mid + 1, end);
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */