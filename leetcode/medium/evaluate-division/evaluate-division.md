# evaluate-division

[문제링크](https://leetcode.com/problems/evaluate-division/)

## 문제 설명

변수 쌍의 배열`equations`과 실수 배열`values` 이 제공된다.  
여기서 equations[i] = [A, B] 및 values[i]은 방정식 A/B = values[i]을 나타낸다.  
또한 변수 쌍 배열 `queries`이 주어진다. C/D 의 값을 찾아서 해당 배열에 자리에 답을 담아서 리턴하면 된다.  
만일 답변을 구할 수 없을 시 -1을 리턴한다.

## 입출력 예시

```
Input: equations = [["a","b"]], values = [0.5],
       queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
```

- 주어진 a/b= 0.5 란 값으로 a/b, b/a의 값을 구할 수 있지만 a/c, x/y의 값은 구하지 못 한다.

## 문제 풀이

1. Edge 객체를 만들어서 해당 객체 안에 변수명과 값을 담는다.
2. graph map을 만든다 해당 map의 키는 변수쌍의 '0'번째 인덱스 즉 나눌 대상이 들어가고 해당 map의 값에는 변수쌍의 '1'번째 인덱스 즉 나눌 값이 들어가는데 나눌 값의 경우에는 하나가 아닌 여러개가 주어 질 수 있으니 List를 선언해서 모두 저장한다  
   (ex. ['a','b'],['a','c'] 처럼 a/b, a/c 여러개가 들어 올 수 있다.)
   |키|값|
   |--|--|
   |a|[ Edge, Edge..]|
   |b|[ Edge]|
3. 위에서 주의할 점은 만약 주어진 equation 이 ['a','b']였다면 a/b, b/a 총 두개의 값이 나온다는 것이다.
4. 해당 그래프가 완성 되었다면 dfs를 통해 그래프를 탐색해서 문제를 풀 수 있다. 출발 값과 도착 값이 정해져 있으니 map.get(출발 값)을 하여 나오는 List를 전체 순회하면서 도착 값에 도달 할 수 있나 체크
5. 다녀온 Edge에 다시 방문하지 못하도록 visited검사 또한 필요하다.

## 풀이 코드

```java
class Edge {

  String v;
  double quotient;

  public Edge (String v, double quotient) {

      this.v = v;
      this.quotient = quotient;
  }
}

class Solution {


  public double dfs (Map<String, List<Edge>> graph, Set<String> visited, String dividend, String divisor) {

      if (!graph.containsKey (dividend) || !graph.containsKey (divisor) ) {
          return -1;
      } //예외 처리1. 구해야 할 정보가 그래프에 없을 때
      else if (dividend.equals (divisor)) {
          return 1;
      } //예외 처리2. 나눌 대상과 나눠야 할 값이 같을 때

      for (Edge edge : graph.get (dividend)) {
          if (visited.contains (edge.v)) {
              continue;
          }
          else if (edge.v.equals (divisor)) {
              return edge.quotient;
          }

          visited.add (dividend);
          double val = dfs (graph, visited, edge.v, divisor);
          if (val != -1) {
              return val * edge.quotient;
          }
      }

      return -1;
  }

  public double[] calcEquation(List<List<String>> equations, double[] quotients, List<List<String>> queries) {

      double[] answer = new double[queries.size ()];
      Map<String, List<Edge>> graph = new HashMap<> ();

      for (int i = 0; i < quotients.length; i++) {
          List<String> equation = equations.get (i);
          if (!graph.containsKey (equation.get (0))) {
              graph.put (equation.get (0), new ArrayList<> ());
          }
          if (!graph.containsKey (equation.get (1))) {
              graph.put (equation.get (1), new ArrayList<> ());
          }

          graph.get (equation.get (0)).add (new Edge (equation.get (1), quotients[i]));
          graph.get (equation.get (1)).add (new Edge (equation.get (0), 1/quotients[i]));
      }
      //graph 만드는 로직 하나의 쿼리로 a->b,b->a 두 개의 값을 알 수 있다.

      for (int i = 0; i < answer.length; i++) {
          List<String> query = queries.get (i);
          answer[i] = dfs (graph, new HashSet<> (), query.get (0), query.get (1));
      }//그래프 탐색

      return answer;
  }
}
```
