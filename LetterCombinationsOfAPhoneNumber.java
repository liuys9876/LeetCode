package leetcode;

import java.util.List;
import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "12312";
		Solution17 solu = new Solution17() {
		};
		System.out.println(solu.letterCombinations(digits));
	}

}

class Solution17 {
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<String>();
		
			if (digits.length() > 1) {
					List<String> temp = new ArrayList<String>();
					temp=letterCombinations(digits.substring(1, digits.length()));
					if(letter(digits.charAt(0)).length==0)
					{
						ans=temp;
					}
			for (char temp_char : letter(digits.charAt(0))) {
				
					for(int i = 0;i<temp.size();i++)
					{
					ans.add(temp_char+temp.get(i));
					}
					
				}
			}else if(digits.length()==1){
				for (char temp_char : letter(digits.charAt(0))) {
					ans.add(String.valueOf(temp_char));
				}
			}

	return ans;
		}
	

	public char[] letter(char num) {
		char[] letter_return = new char[] {};
		switch (num) {
		case '1':
			break;
		case '2':
			letter_return = new char[] { 'a', 'b', 'c' };
			break;
		case '3':
			letter_return = new char[] { 'd', 'e', 'f' };
			break;
		case '4':
			letter_return = new char[] { 'g', 'h', 'i' };
			break;
		case '5':
			letter_return = new char[] { 'j', 'k', 'l' };
			break;
		case '6':
			letter_return = new char[] { 'm', 'n', 'o' };
			break;
		case '7':
			letter_return = new char[] { 'p', 'q', 'r', 's' };
			break;
		case '8':
			letter_return = new char[] { 't', 'u', 'v' };
			break;
		case '9':
			letter_return = new char[] { 'w', 'x', 'y', 'z' };
			break;
		}
		return letter_return;
	}

}