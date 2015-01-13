package com.datastructures.buildingblocks;

import java.util.HashMap;

public class TrieNode {
  private TrieNode parent;
  private TrieNode[] children;
  private boolean isLeaf;
  private boolean isWord;
  private char character;
  
  /*
   * Constructor for root node
   */
  public TrieNode()
  {
    children = new TrieNode[26];
    isWord = false;
    isLeaf = true;
  }
  
  /*
   * Constructor for child nodes
   */
  public TrieNode(char ch) {
    this();
    this.character = ch;
  }
  
  /*
   * Assumes a trie node has 26 children.
   * Checks if they're null or not
   */
  public void addWord(String word) {
    isLeaf = false;
    int charPos = word.charAt(0) - 'a';
    
    if(children[charPos] == null) {
      children[charPos] = new TrieNode(word.charAt(0));
      children[charPos].parent = this;
    }
    
    if(word.length() > 1) {
      children[charPos].addWord(word.substring(1));
    }
    else {
      children[charPos].isWord = true;
    }
    
    
  }
  
  public String toStringRep() {
    if(parent == null) {
      return("");
    }
    
    return parent.toStringRep() + character; 
    
  }
  
  
  
  
}
