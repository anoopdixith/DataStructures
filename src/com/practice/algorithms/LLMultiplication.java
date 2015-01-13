package com.practice.algorithms;

public class LLMultiplication {
  
  public MultiplicationNode multiplyLL(MultiplicationNode node1, MultiplicationNode node2) {
    MultiplicationNode result = new MultiplicationNode();
    node1 = reverse(node1);
    node2 = reverse(node2);
    MultiplicationNode tempNode1 = node1;
    //MultiplicationNode tempNode2 = node2;
    MultiplicationNode tempResult = result;
    MultiplicationNode finalNode = result;
    int stop = 0;
    while(node2 !=null) {
      while(node1 != null) {
        System.out.println("result value is " + result.value);
        int full = (result.value + result.carry + (node1.value * node2.value));
        System.out.println("Full is " + full);
        //result.value = (result.value + result.carry + (node1.value * node2.value )%10)%10;
        result.value = full % 10;
        if(result.next == null) {
          result.next = new MultiplicationNode();
        }
        result.next.carry = full/10;
        result.carry = 0;
        result = result.next;
        node1 = node1.next;
      }
      //Add the final node value
      result.value += result.carry;
      tempResult = tempResult.next;
      result = tempResult;
      node2 = node2.next;
      node1 = tempNode1;
    }
    return reverse(finalNode);
  }
  
  public MultiplicationNode reverse(MultiplicationNode node) {
  if(node == null)
      return null;
  if(node.next == null)
      return node;
  MultiplicationNode second = node.next;
  node.next = null;
  MultiplicationNode reversedList = reverse(second);
  second.next = node;
  return reversedList;
  }
  
  
}
