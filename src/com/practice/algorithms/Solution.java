package com.practice.algorithms;

import java.util.*;

/**
 * For the graph traversing algorithm.
 */
public class Solution {
  
    /**
     * A node in a graph
     */
    private static class Node {
        private final Set<Node> neighbors;

        Node() {
            this.neighbors = new HashSet<>();
        }
    }
    
    
    /** @return a map from degree to number of nodes of that degree */
    private static Map<Integer, Integer> calculateDegreeCount(Node node) {
      // YOUR CODE HERE
        Map<Integer, Integer> outputMap = new HashMap<Integer, Integer>();
        Set<Node> neighborNodes = node.neighbors;
        ArrayList<Integer> degreeCount = new ArrayList<Integer>();
        degreeCount.add(neighborNodes.size());
        for(Node each:neighborNodes) {
            degreeCount.add(each.neighbors.size());
        }
        for(Integer each:degreeCount) {
          outputMap.put(each, (outputMap.get(each)) + 1);
        }
        return outputMap;
    }
    

    /**
     * Parses the input edge list into connected {@link Node} graph.
     *
     * Do not modify this method.
     */
    public static void main(String[] args) {
        String line;
        Scanner stdin = new Scanner(System.in);
        Map<Integer, Node> graph = new HashMap<>();
        Node firstNode = null;

        while(stdin.hasNextLine() && !( line = stdin.nextLine() ).equals( "" ))
        {
            String[] tokens = line.split(" ");
            // Edge list can only be one or two nodes per line.
            if (tokens.length != 1 && tokens.length != 2) {
                throw new RuntimeException("Unknown format");
            }

            for (int i = 0; i < tokens.length; i++) {
                int id = Integer.parseInt(tokens[i]);
                if (!graph.containsKey(id)) {
                    graph.put(id, new Node());
                }
            }

            Node node0 = graph.get(Integer.parseInt(tokens[0]));
            if (firstNode == null) {
                firstNode = node0;
            }

            if (tokens.length == 2) {
                Node node1 = graph.get(Integer.parseInt(tokens[1]));

                node0.neighbors.add(node1);
                node1.neighbors.add(node0);
            }

        }
        stdin.close();

        TreeMap treeMap = new TreeMap(calculateDegreeCount(firstNode));
        System.out.println(treeMap);
    }

}