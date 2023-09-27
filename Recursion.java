import java.util.Arrays;

/**
 * 
 * @author eddy Ayuketah
 *
 *
 */
public class Recursion {
	
	/**
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public static int power(int x, int n) {
		if (n== 0) {
			return 1;
		} else 
			return x * (power(x,n-1));
		
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 * {@inheritDoc}
	 * sums all values given
	 */
	
	public static int sumDigits(int n) {
		if (n == 0) {
			return 0;			
		} else 
			
			return n%10 + sumDigits(n/10); //using percent 10 because it is the remainder you get when
		// you divide with 10 : n = 752. n%10 = 2, n/10 = 75
	}
	
	/**
	 * 
	 * @param word
	 * {@inheritDoc}
	 * prints word backwards 
	 */
	public static void printBackwards(String word) {
		if (word.length() == 0) {
			System.out.println();
			return;
			}
	 else {
		System.out.print(word.charAt(word.length() -1));
		printBackwards(word.substring(0, word.length() -1 ));}
	}
	
	/**
	 * 
	 * @param word
	 * {@inheritDoc}
	 * checks if word is a palindrome
	 * @return
	 * 
	 */
	public static boolean isPalindrome(String word) {
		if(word.length() == 0 || word.length()==1) {
			return true;
		}
		if(word.charAt(0) == word.charAt(word.length()-1))
				return isPalindrome(word.substring(1, word.length() - 1));
		return false;
			
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int sumPositive(int[] array) {
		if(array.length == 0)
			return 0;
		else {
			if (array[array.length- 1] > 0)
			{
				return array[array.length - 1] + sumPositive(Arrays.copyOfRange(array, 0, array.length -1));
				/*
				 * copyOfRange: creates a copy of elements, within a specified range of the original array
				 */
			} else 
				return sumPositive(Arrays.copyOfRange(array, 0, array.length -1));
		}
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int max(int[] array) {
		if (array.length == 1) {
			return array[array.length - 1];
		}
		else 
			return Math.max(array[array.length - 1], max(Arrays.copyOfRange(array, 0, array.length - 1)));
	}
	
	

	public static void main(String[] args) {
		/**
		 * test Power
		 */
		System.out.println("power 3^2: "+power(3,2));
		System.out.println("power 7^2: "+power(7,2));
		 
		/**
		 * test Sum digits
		 */
		System.out.println( "2+5+9: " +sumDigits(259));
		
		/**
		 * test print Backwards 
		 */
		printBackwards("who");
		
		/**
		 *  test palindrome
		 */
		System.out.println(isPalindrome("civic"));
		
		/**
		 * test sum positive 
		 */
		
		System.out.println(sumPositive(new int[] {4,2,6,-3,3,-10}));
		
		/**
		 * test intmax
		 */
		System.out.println(max(new int[] {32,41,60}));

	}

}
