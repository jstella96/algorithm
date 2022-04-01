class Edge {
    
  String v;
  double quotient;
  
  public Edge (String v, double quotient) {
      
      this.v = v;
      this.quotient = quotient;
  }
}

class Solution {
  
  public void addEdge (Map<String, List<Edge>> graph, String u, String v, double quotient) {
      
      if (!graph.containsKey (u)) {
          graph.put (u, new ArrayList<> ());
      }
      
      graph.get (u).add (new Edge (v, quotient));
  }
  
  public double dfs (Map<String, List<Edge>> graph, Set<String> set, String u, String v) {
      
      if (!graph.containsKey (u) || !graph.containsKey (v)) {
          return -1;
      }
      else if (u.equals (v)) {
          return 1;
      }
      
      for (Edge edge : graph.get (u)) {
          if (set.contains (edge.v)) {
              continue;
          }
          else if (edge.v.equals (v)) {
              return edge.quotient;
          }
          
          set.add (u);
          double val = dfs (graph, set, edge.v, v);
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
          addEdge (graph, equation.get (0), equation.get (1), quotients[i]);
          addEdge (graph, equation.get (1), equation.get (0), 1 / quotients[i]);
      }
      
      for (int i = 0; i < answer.length; i++) {
          List<String> query = queries.get (i);
          answer[i] = dfs (graph, new HashSet<> (), query.get (0), query.get (1));
      }
      
      return answer;
  }
}