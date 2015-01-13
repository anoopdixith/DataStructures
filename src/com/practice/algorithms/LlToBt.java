package com.practice.algorithms;

import com.datastructures.buildingblocks.SpecialNode;

public class LlToBt {
  
  public SpecialNode llToBt(SpecialNode node) {
    SpecialNode temp = node;
    SpecialNode returnNode = node;

    if(node == null)
      return null;
    if(node.next == null)
      return node;
    int count = 0, i = 0;
    while(node != null) {
      count++;
      node = node.next;
    }
    node = returnNode;
    SpecialNode[] originalList = new SpecialNode[count];
    while(node != null) {
      originalList[i++] = node;
      node = node.next;
    }
    i=1;
    node = returnNode;
    
    while(node != null) {
      
      temp = temp.next;
      //System.out.println("temp value is " + temp.value);
      if(temp == null) {
        //node.next = null;
        //node.another = null;
        //return returnNode;
        break;
      }
      node.next = temp;
      
      temp = temp.next;
      if(temp == null) {
        //node.next = null;
        //node.another = null;
        //return returnNode;
        break;
      }
      node.another = temp;
      node = originalList[i++];
    }
    //System.out.println("i is " + i);
    while(i < count) {
      node = originalList[i];
      node.next = null;
      i++;
    }
    return returnNode;
  }
}
