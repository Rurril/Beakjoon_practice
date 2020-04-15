package Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      Set<String> set = new HashSet();
   
      for(int i=0; i<num; i++) {
         set.add(sc.next());
      }
      
      String[] words  = new String[set.size()];
      set.toArray(words);
      
      Arrays.parallelSort(words);
      
      
      for(int i=0; i<words.length;i++) {
         
         int temp = words[i].length();
         int index = i;
         for(int j= i+1 ; j<words.length;j++) {
            if(temp>words[j].length()) {
               temp = words[j].length();
               index = j;
            }
         }
         
         String t = words[index];
         words[index] = words[i];
         words[i] = t;
         
      }
      
      
      
      
      for(int i=0;i<words.length;i++) {
         System.out.println(words[i]);
      }
   }
}