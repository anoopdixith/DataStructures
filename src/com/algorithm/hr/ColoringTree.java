package com.algorithm.hr;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class ColoringTree {
  
  public class Node {
    int id;
    List<Node> neighbors;
    int colorId;
    public Node(int id,List<Node> neighbors, int colorId) {
      this.id = id;
      this.neighbors = neighbors;
      this.colorId = colorId;
    }
  }
  public static void main(String args[]) {
    List<Node> allNodes = new ArrayList<Node>();
    int N =0;
    int M =0;
    int s = 0;
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    String initial = scanner.nextLine();
    StringTokenizer tokenizer = new StringTokenizer(initial);  
    N = Integer.parseInt((String) tokenizer.nextElement());
    M = Integer.parseInt((String) tokenizer.nextElement());
    s = Integer.parseInt((String) tokenizer.nextElement());
    
    for(int i=1; i <= N; i++) {
      Node e = new ColoringTree().new Node(i, new ArrayList<Node>(), 0);
      allNodes.add(e);
    }
    for(int i=0; i < N-1; i++) {
      tokenizer = new StringTokenizer(scanner.nextLine());
      int node1Id = Integer.parseInt((String) tokenizer.nextElement());
      int node2Id = Integer.parseInt((String) tokenizer.nextElement());
      allNodes.get(node1Id - 1).neighbors.add(allNodes.get(node2Id - 1));
      allNodes.get(node2Id - 1).neighbors.add(allNodes.get(node1Id - 1));
    }
    
    for(int i=0; i < N; i++) {
      int color = scanner.nextInt();
      allNodes.get(i).colorId = color;
    }
    int[] lengths = new int[M];
    
    
    Node rootNode = allNodes.get(s - 1);
    allNodes = reshape(allNodes, rootNode);
    /*
    for(int i=0; i < allNodes.size(); i++) {
      System.out.println("id is " + allNodes.get(i).id);
      System.out.println("Neighbors are ");
      for(Node n:allNodes.get(i).neighbors) {
        System.out.print(n.id + ",");
      }
      System.out.println();
      System.out.println("============");
    }
    */
    int[] neededResult = new int[M];
    for(int m =0; m < M; m++) {
      neededResult[m] = scanner.nextInt();
    }
    for(int m =0; m < M; m++) {
      Set<Integer> allResults = getDistinctColors(neededResult[m], allNodes, new HashSet<Integer>());
      //lengths[m] = allResults.size();
      System.out.println(allResults.size());
    }
    //print(lengths);
    scanner.close();
  }
  private static List<Node> reshape(List<Node> allNodes, Node rootNode) {
    //System.out.println("Rootnode is " + rootNode.id);
    for(Node n:rootNode.neighbors) {
      //System.out.println("n is " + n.id);
      //System.out.println("size before removal " + n.neighbors.size());
      int tempSize = n.neighbors.size();
      for(int x=0; x < tempSize;x++) {
        if(n.neighbors.get(x).id == rootNode.id) {
          //System.out.println("Removing");
          n.neighbors.remove(x);
          break;
        }
      }
      //System.out.println("size after removal " + n.neighbors.size());
      allNodes.set(n.id - 1, n);
      allNodes = reshape(allNodes, n);
    }
    return allNodes;
  }
  
  
  private static void print(int[] lengths) {
      for(int i:lengths) {
        System.out.println(i);
      }
  }
  static Stack<Node> stack = new Stack<Node>();

  private static Set<Integer> getDistinctColors(int root, List<Node> allNodes, HashSet<Integer> allColors) {
    Node node = allNodes.get(root - 1);
    allColors.add(node.colorId);
    for(Node n:node.neighbors) {
      stack.push(n);
    }
    
    while(!stack.isEmpty()) {
      Node temp = stack.pop();
      getDistinctColors(temp.id, allNodes, allColors);
    }
    return allColors;
  }
  /*
  static Set<Integer> visitedNodes = new HashSet<Integer>();
  private static boolean presentBetween(int originalRoot, int root, int id, List<Node> allNodes) {
    if(originalRoot != root) {
      visitedNodes.add(originalRoot);
      for(Node no:allNodes.get(originalRoot-1).neighbors) {
        if(!doesContain(no.id)) {
          return presentBetween(no.id, root, id, allNodes);
        }
      }
    }
    return doesContain(id);
  }
  private static boolean doesContain(int id) {
    for(Integer i:visitedNodes) {
      if(i.equals(new Integer(id))) {
        return true;
      }
    }
    return false;
  }
  */
  
}
