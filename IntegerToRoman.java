package leetcode;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 247;
		Solution12 solu = new Solution12() {
		};
		System.out.println(solu.intToRoman(num));
	}

}
 class Solution12 {
    public String intToRoman(int num) {
    	String ans ="";
    	int temp=0;
    	temp = num/1000;
    	num %=1000;
    	for(int i =0;i<temp;i++)
    	{
    		ans+="M";
    	}
    	if(num<=899&&num>=500)
    	{
    		ans+="D";
    		num%=500;
    	}
    	if(num>899)
    	{
    		ans+="CM";
    		num%=900;
    	}
    	if(num>399)
    	{
    		ans+="CD";
    		num%=400;
    	}
    	if(num>=100&&num<=399)
    	{
    		temp=num/100;
    		for(int i =0;i<temp;i++)
        	{
        		ans+="C";
        	}
    		num%=100;
    	}
    	if(num<=89&&num>=50)
    	{
    		ans+="L";
    		num%=50;
    	}
    	if(num>89)
    	{
    		ans+="XC";
    		num%=90;
    	}if(num>39)
    	{
    		ans+="XL";
    		num%=40;
    	}
    	if(num>=10&&num<=39)
    	{
    		temp=num/10;
    		for(int i =0;i<temp;i++)
        	{
        		ans+="X";
        	}
    		num%=10;
    	}if(num<=8&&num>=5)
    	{
    		ans+="V";
    		num%=5;
    	}
    	if(num>8)
    	{
    		ans+="IX";
    		num%=9;
    		
    	}if(num>3)
    	{
    		ans+="IV";
    		num%=4;
    	}
    	if(num>=1&&num<=3)
    	{
    		temp=num;
    		for(int i =0;i<temp;i++)
        	{
        		ans+="I";
        	}
    	}
    	
    	return ans;
        
    }
}