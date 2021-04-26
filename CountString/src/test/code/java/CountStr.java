package test.code.java;

import java.util.HashMap;
import java.util.Map;

public final class CountStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = new String("Betty bought a bit of butter , but the butter was so bitter , So she bought some better butter , to make the bitter butter better");
		String[] words = sentence.split(" ");
		
		
		Map<String,Integer> wordMap = new HashMap<>();	
		for(String word : words) {
			if(wordMap.containsKey(word)) {
				int count = wordMap.get(word);
				wordMap.put(word, count + 1);
			}
			else {
				wordMap.put(word, 1);
			}		
		}
		int total = 0;
		System.out.println("Words Count");
		System.out.println("*************");
		wordMap.forEach((k,v)->{
			System.out.format("%s=>%d%n",k ,v);
		});
		
		
	}		

}
