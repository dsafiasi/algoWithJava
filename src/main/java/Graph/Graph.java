package Graph;


import java.util.LinkedList;

/**
 * 邻接表法
 */
public class Graph {
  private static int count = 0;
  private static LinkedList[] graph;

  public Graph(int count) {
    graph = new LinkedList[count];
  }
}
