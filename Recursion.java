//Advanced Topics
//Chapter 12 Recursion page 809-810
//Exercises 9, 10, 12, & 13
//Calvin Grabowski
//10.29.2023

public class Recursion 
{
   
   private static int index = 0;
   //I need this for the last question to keep an index without it being a parameter
   public static void main(String[] args)
   {
      System.out.println("sumTo: 2 and 3" + sumTo(2) + " " + sumTo(3));
      System.out.println("digitMatch: 12023 and 2123: 2 and 23 match so answer is: " + digitMatch(12023,2123));
      System.out.println("isReverse: horse and esroh: " + isReverse("horse","esroh") + ", and when it isn't the same: " + isReverse("same", "ames"));
      System.out.println("indexOf: when it is in the phrase it gives the index: " + indexOf("house of horror is back", "is") + " when it isn't " + indexOf("house of horror is back", "isn't"));
   
   }
   
   //Exercise 9
   public static double sumTo(int n) 
   {
      //this adds all the fractions counting down with n amount of counts
      if(n > 1)
      {
         return ((1/n) + sumTo(n-1));
      }
      if(n == 1) 
      {
         return 1;
      }
      if(n == 0)
      {
         return 0.0;
      }
      
      throw new IllegalArgumentException("no negative numbers nerd");
      //This should only happen when there is a negative number
     
   }
   
   //exercise 10 returns how many matching numbers
   //12023 and 2123 would be 3-3, 2-2, 0-1, 2-2, 1-_, so it returns 3 for three of the numbers matching
   public static int digitMatch(int x, int y) {
   
      if(x >= 10 && y >= 10)
      {
         //this compares the numbers and sees if the current numbers match the current number on the other number
         if(x%10 == y%10) 
            return 1 + digitMatch(x/10,y/10);
         else
            return digitMatch(x/10,y/10);
         //it will recurse through all the numbers until there are no numbers left resending the same line minus the first digit so 1000 would go to 100
      }
      if(x%10 == y%10) 
         return 1;
      else
         return 0;
      
   
   }
   
   //exercise 12
   public static boolean isReverse(String t, String s)
   {
      //System.out.println("t: " + t + ". s: " + s); makes it easier to visualize
      //makes string t's first charater and compares it to s's last character to see if it is the same
      if(t.substring(0,1).equals(s.substring(s.length()-1))) 
      {
         if(t.length()==1 && s.length()==1)
         {
            //if all the characters are the same it is true
            return true;
         }
         //calls itself for recursion to go to the next letters of the word
         return isReverse(t.substring(1), s.substring(0,s.length()-1));
      }
      else 
      {
         //if any of the characters aren't the same the code results in false
         return false;
      }
   
   }
   
   //recursion exercise 13
   public static int indexOf(String line, String part)
   {  
      
      if(line.length() - part.length() >= 0)
      {
         if(line.substring(0,part.length()).equals(part))
         {
            //when the part is found in the line this ends the loop
            int num = index;
            index = 0;
            return num;
         }
         else
         {
            //when the part isn't found in the line yet it keeps going
            index++;
            return indexOf(line.substring(1), part) ;
         }
      }
      
      //doesn't return the index and only returns -1 if the word isn't in the phrase
      return -1; 
                    
   }
      
   
   


}