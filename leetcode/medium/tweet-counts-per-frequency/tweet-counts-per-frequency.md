# tweet-counts-per-frequency


[문제링크](https://leetcode.com/problems/tweet-counts-per-frequency/)

## 문제 설명

소셜 미디어 회사는 특정 기간에 발생하는 트윗 수를 분석하여 사이트 활동을 모니터링하려고 합니다. 이러한 기간은 특정 빈도(분, 시간 또는 매일)에 따라 더 작은 시간 청크로 분할될 수 있습니다. 예를 들어, 기간 [10, 10000](초)은 다음 빈도로 다음 시간 청크로 분할됩니다.

예를 들어
기간 [10, 10000](초)은 다음 빈도로 다음 시간 청크로 분할됩니다.

- 매분(60초 청크): [10,69], [70,129], [130,189], ..., [9970,10000]
- 매시간(3600초 청크): [10,3609], [3610,7209], [7210,10000]
- 매일(86400초 청크): [10,10000] 마지막 청크는 지정된 빈도의 청크 크기보다 짧을 수 있으며 항상 기간의 종료 시간(위의 예에서 10000)으로 끝납니다.

분석에 도움이 되는 API를 설계하고 구현합니다.

- `TweetCounts()` : TweetCounts 개체를 초기화합니다.
- `void recordTweet(String tweetName, int time)` : 기록된 시간(초 단위)의 tweetName을 저장합니다.
- `List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime)`:   주어진 기간 [startTime, endTime](초) 동안 각 시간 청크에서 tweetName이 있는 트윗 수를 나타내는 정수 목록을 반환합니다. freq는 "분", "시" 또는 "일" 중 하나이며 각각 분, 시간 또는 일의 빈도를 나타냅니다.

## 문제 풀이

기본적인 바이너리 서치 문제이다. Map안에서 바이나리 서치로 값을 찾는다.

## 풀이 코드

```java
class TweetCounts {

    Map<String, List<Integer>> map;
    public TweetCounts() {
        map = new HashMap<String,List<Integer>>();
    }
    public void recordTweet(String tweetName, int time) {
        List<Integer> list  = map.getOrDefault(tweetName, new ArrayList<>());
        list.add(time);
        map.put(tweetName,list);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<Integer>();
        if(map.containsKey(tweetName)){

            int factor = 60; //minute
            if(freq.equals("hour"))factor *=60; //hour
            else if(freq.equals("day"))factor *=(60*24); //day

            List<Integer> list = map.get(tweetName);
            int[] factorArray = new int[((endTime-startTime)/factor)+1]; //구간갯수만큼

            for(int time : list){
                if( time<startTime || time > endTime) continue;
                factorArray[(time-startTime)/factor]++;
            }

            for(int f : factorArray){
                res.add(f);
            }
        }
        return res;
    }
}

```
