package recursion.palindrom;

public class SentenceWithHelper {

	private String text;
	
	/**
	 * Constructs a sentence.
	 * 
	 * @param aText
	 *            a string containing all characters of the sentence
	 */
	public SentenceWithHelper(String aText) {
		text = aText;
	}

	/**
	 * Tests whether this sentence is a palindrome.
	 * 
	 * @return true if this sentence is a palindrome, false otherwise
	 */
	public boolean isPalindrome() {
		return isPalindrome(0, text.length() - 1);
	}

	/**
	 * Tests whether a substring of the sentence is a palindrome.
	 * @param start the index of the first character of the substring
	 * @param end the index of the last character of the substring
	 * @return true if the substring is a palindrome
	 */
	private boolean isPalindrome(int start, int end) {
		// Separate case for substrings of length 0 and 1.
		if (start >= end)
			return true;
		// Get first and last characters, converted to lowercase.
		char first = Character.toLowerCase(text.charAt(start));
		char last = Character.toLowerCase(text.charAt(end));
		if (Character.isLetter(first) && Character.isLetter(last)) {
			if (first == last) {
				// Test substring that doesn't contain the matching letters.
				return isPalindrome(start + 1, end - 1);
			} else
				return false;
		} else if (!Character.isLetter(last)) {
			// Test substring that doesn't contain the last character.
			return isPalindrome(start, end - 1);
		} else {
			// Test substring that doesn't contain the first character.
			return isPalindrome(start + 1, end);
		}
	}

	  public static void main(String[] args) {
		  SentenceWithHelper s = new SentenceWithHelper("Ein Neger mit Gazelle zagt im Regen nie");
		  System.out.println(s.isPalindrome());
	  }
	
}