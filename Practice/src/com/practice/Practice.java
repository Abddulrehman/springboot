package com.practice;

import java.util.Random;

public class Practice {

	public static void main(String[] args) {

//		String vovels[] = { "a", "e", "i", "o", "u" };
//		String consonents[] = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v",
//				"w", "x", "y", "z" };
//
//		Random random = new Random();
//		String newWord = "";
//		int vl = vovels.length;
//		int cl = consonents.length;
//		int index = 0;
//
//		for (int x = 1; x <= 5; x++) {
//
//			for (int i = 0; i < vl; i++) {
//
//				if (newWord.length() == 5)
//					break;
//
//				index = random.nextInt(vovels.length);
//				newWord = newWord + vovels[index];
//
//				for (int j = i; j <= i + 1; j++) {
//					if (newWord.length() == 5)
//						break;
//					index = random.nextInt(consonents.length);
//					newWord = newWord + consonents[index];
//
//				}
//			
//			}
//
//			System.out.println("  " + newWord);
//
//		}
		
		for(int x=1; x<=5; x++) {
	
		 char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
	       // StringBuilder newString = new StringBuilder();
	        String res ="";
	        Random random = new Random();

	        for(int i=0;i<=vowels.length; i++)
			{
				int vowelIndex = random.nextInt(vowels.length);
				
				if(res.length() ==5)
					break;
				res=res+vowels[vowelIndex];

				int consonantCount = 0;
				for (int j = 0; j <= 2; j++) {
					int consonantIndex = random.nextInt(consonants.length);
					if(res.length() ==5)
						break;
					res= res+consonants[consonantIndex];
					
					if (consonantCount >= 1) {
						break;
					}
					consonantCount++;
				}

			}

	        System.out.println(res.toString());
		}
	}

}
