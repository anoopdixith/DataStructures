package com.practice.algorithms;

import java.util.HashMap;

public class BfsDfsTreeConstruction {
  public static void mainDeleted(String args[]) {
    char[] bfs = {'a','b','c','d','g','e','f','h','i','j'};
    char[] dfs = {'a','b','d','e','f','c','g','h','j','i'};
    new BfsDfsTreeConstruction().constructTree(bfs, dfs);
  }
  
  BTNode root;
  BTNode temp;
  
  public BTNode constructTree(char[] bfs, char[] dfs) {    
    if(bfs.length != dfs.length || bfs[0] != dfs[0]) {
      return null;
    }
    root = new BTNode(bfs[0]);
    temp = root;
    //put one of the traversals in a hashmap to ease the lookup
    HashMap<Object, Integer> dfsHash = new HashMap<Object, Integer>();
    for(int i=0; i < dfs.length; i++) {
      dfsHash.put(dfs[i], i);
    }
    
    for(int i=1; i < bfs.length; i++) {
      BTNode current = new BTNode(bfs[i]);
      if(dfsHash.get(bfs[i]) == null) {
        //has already been added. So , just continue.
        continue;
      }
      if(bfs[i] == dfs[i]) {
        temp.left = current;
        temp.left.parent = temp;
        temp = temp.left;
        //we remove the used node from hashmap so that the hashmap also serves 
        //to check whether a node has been visited or not yet.
        dfsHash.remove(bfs[i]);
      }
      else if (dfsHash.get(bfs[i]) > i) {
        int dfsValue = dfsHash.get(bfs[i]);
        System.out.println("dfs value is " + dfsValue);
        temp.parent.right = current;
        temp.parent.right.parent = temp;
        temp = temp.parent.right;
        dfsHash.remove(bfs[i]);
        for(int j= i; j < dfsValue; j++) {
          if(dfsHash.get(dfs[j]) != null){
            //temp.parent.left = insertNodes(temp.parent.left, new BTNode(dfs[j]));
            //Below code is because java is pass by value
            BTNode nodeToInsert = new BTNode(dfs[j]);
            System.out.println("Inserting " + nodeToInsert.value);
            BTNode origin = temp.parent.left;
            if(origin == null) {
              temp.parent.left = nodeToInsert;
              continue;
            }
            while(origin.left != null) {
              origin = origin.left;
            }
            origin.left = nodeToInsert;
            origin.left.parent = origin;
            
            dfsHash.remove(dfs[j]);
          }
        }
        
      }
    }
    return root;
  }

  private BTNode insertNodes(BTNode origin, BTNode nodeToInsert) {
    BTNode tempRoot = origin;
    System.out.println("Inserting " + nodeToInsert.value);
    if(origin == null) {
      origin = nodeToInsert;
    }
    while(origin.left != null) {
      origin = origin.left;
    }
    origin.left = nodeToInsert;
    origin.left.parent = origin;
    return tempRoot;
  }
  
}
