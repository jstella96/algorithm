import java.util.*;

class Document {
  int id;
  int priority;

  public Document(int id, int priority) {
    this.id = id;
    this.priority = priority;
  }
}

class Solution {
  public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Document> Q = new LinkedList<>();
    for (int i = 0; i < priorities.length; i++) {
      Q.offer(new Document(i, priorities[i]));
    }
    while (!Q.isEmpty()) { // 아래서 없애는 작업
      Document tmp = Q.poll();
      for (Document x : Q) {
        if (x.priority > tmp.priority) { // 대기목록에 현재 보다 우선순위 높은 문서가 있다.
          Q.offer(tmp); // 다시 뒤로 넣는다 .
          tmp = null;
          break;
        }
      }
      if (tmp != null) { // 없으면 지나가기 빠지고
        answer++;// 순서추가
        if (tmp.id == location)
          return answer;
      }
    }
    return answer;
  }
}