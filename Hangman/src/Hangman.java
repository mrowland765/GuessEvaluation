import java.util.ArrayList;
import java.util.Scanner;
public class Hangman{
	
	static public void guessEvaluation(String word, int guesses) {
		char[] emptySpace = new char[word.length()];
		int i = 0;
		while(i < word.length()) {
			emptySpace[i] = '*';
			if(word.charAt(i) ==' ') {
				emptySpace[i] = ' ';
			}
			i++;
		}
		System.out.print(emptySpace);
		System.out.println(" guesses Remaining = " + guesses);
		
		Scanner input = new Scanner(System.in);
		
		ArrayList<Character> charList = new ArrayList<Character>();
		
		while(guesses > 0) {
			char x = input.next().charAt(0);
			
			if(charList.contains(x)) {
				System.out.println("You've already entered that letter!");
				continue;
			}
			
			charList.add(x);
			
			if(word.contains(x + "")) {
				for(int y = 0; y < word.length(); y++) {
					if(word.charAt(y) == x) {
						emptySpace[y] = x;
					}
				}
			}
			else {
				guesses--;
			}
			if(word.equals(String.valueOf(emptySpace))) {
				System.out.println(emptySpace);
				System.out.println("You Win!!!");
				input.close();
				break;
			}
				
			System.out.print(emptySpace);
			System.out.println(" Guesses Remaining = " + guesses);
		}
		
		if(guesses == 0) {
			System.out.println("You Lost...");
			input.close();
		}
		
	}
	
	public static void main(String[] args) {
		
		String word = "guess the word";
		int guesses = 5;
		guessEvaluation(word, guesses);
		
	}
}