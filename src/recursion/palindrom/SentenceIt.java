package recursion.palindrom;

public class SentenceIt {

	private String text;
	
	/**
	 * Constructs a sentence.
	 * 
	 * @param aText
	 *            a string containing all characters of the sentence
	 */
	public SentenceIt(String aText) {
		text = aText;
	}

	/**
	 * Tests whether this sentence is a palindrome.
	 * 
	 * @return true if this sentence is a palindrome, false otherwise
	 */
	public boolean isPalindrome() { 
		int start = 0; 
		int end = text.length() - 1; 
		while (start < end) { 
			char first = 
				Character.toLowerCase(text.charAt(start)); 
			char last = 
				Character.toLowerCase(text.charAt(end)); 
			if (Character.isLetter(first) && 
					Character.isLetter(last))  { 
				// Both are letters. 
				if (first == last) { 
					start++; 
					end--; 
				} 
				else 
					return false; 
			} 
			if (!Character.isLetter(last)) 
				end--; 
			if (!Character.isLetter(first)) 
				start++;    
		}
		return true; 

	}

	public static void main(String[] args) {
		SentenceIt s = new SentenceIt("Ein Neger mit Gazelle zagt im Regen nie");
		System.out.println(s.isPalindrome());
	}

}