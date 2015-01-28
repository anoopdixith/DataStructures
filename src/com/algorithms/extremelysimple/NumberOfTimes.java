package com.algorithms.extremelysimple;

public class NumberOfTimes {
 public static void main(String args[]) {
   String str = "AUDRYBERNITAEATVIVANBROOKSEATJENIEATMICHALELASANDRALATIAEATLIDIAEATDEANDRAEATSYBILEATMONROEEATLATRISHAALTAEATDERICKEATROSANNLEVILIBBYKIRSTENCHARLESEATELLYNEATJANEEEATSTASIAEATJULIETTARANDIEATNORBERTSAGEEATARACELIKATINAMERNAEATISAIASWINNIEEATARLETHAEATMILOCAMIEEATANNABELEATLEANORABERTHASYBLECHANAEATREAGANERICKVALENTINAEATDORETHEASEBASTIANKRISROBERTAEATIVONNEEATAI";
   System.out.println(repeated(str, "EAT"));
 }

private static int repeated(String str, String pattern) {
  char[] input = str.toCharArray();
  char[] patt = pattern.toCharArray();
  int count = 0;
  for(int i=0; i < input.length - 2; i++) {
    if(input[i] == patt[0] && input[i+1] == patt[1] && input[i+2] == patt[2]) {
      count++;
      i += 2;
    }
  }
  return count;
}
}
