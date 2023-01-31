package hangman;

public class hangedMan {

    public static void showLives(int lives) {

  if(lives == 6) {
   System.out.println("|----------");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(lives == 5) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(lives == 4) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|    |");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(lives == 3) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(lives == 2) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|-");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(lives == 1) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|-");
   System.out.println("|    |");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else{
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|-");
   System.out.println("|    |");
   System.out.println("|   / \\ ");
   System.out.println("|");
   System.out.println("|");
  }
  }
 }






