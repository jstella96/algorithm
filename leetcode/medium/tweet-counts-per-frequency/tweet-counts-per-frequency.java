
/*
시간복잡도 면에서 좋은 풀이가 아님....ㅜㅜ
*/
import java.util.*;

class TweetCounts {

  Map<String, List<Integer>> map;

  public TweetCounts() {
    map = new HashMap<String, List<Integer>>();
  }

  public void recordTweet(String tweetName, int time) {
    List<Integer> list = map.getOrDefault(tweetName, new ArrayList<>());
    list.add(time);
    map.put(tweetName, list);
  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    List<Integer> res = new ArrayList<Integer>();
    if (map.containsKey(tweetName)) {

      int factor = 60; // minute
      if (freq.equals("hour"))
        factor *= 60; // hour
      else if (freq.equals("day"))
        factor *= (60 * 24); // day

      List<Integer> list = map.get(tweetName);
      int[] factorArray = new int[((endTime - startTime) / factor) + 1]; // 구간갯수만큼

      for (int time : list) {
        if (time < startTime || time > endTime)
          continue;
        factorArray[(time - startTime) / factor]++;
      }

      for (int f : factorArray) {
        res.add(f);
      }
    }
    return res;
  }
}

/**
 * Your TweetCounts object will be instantiated and called as such: TweetCounts
 * obj = new TweetCounts(); obj.recordTweet(tweetName,time); List<Integer>
 * param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */