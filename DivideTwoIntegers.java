package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dividend = -2147483648;
		int divisor = -2147483648;
		Solution29 solu = new Solution29();
		System.out.println(solu.divide(dividend, divisor));
	}

}

class Solution29 {
	public int divide(int dividend, int divisor) {
		
		
/**		
 * 
 * 
 * 减法所
 * 消耗时间过长
		int ans = 0;
		if (dividend > Integer.MAX_VALUE || divisor > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (dividend >= 0 && divisor >= 0) {
			int temp = divisor;

			while (temp <= dividend) {
				if (ans < Integer.MAX_VALUE) {
					ans++;
					temp += divisor;
				}
			}
		} else if (dividend < 0 && divisor < 0) {
			int temp = divisor;
			while (temp >= dividend) {
				if (ans < Integer.MAX_VALUE) {
					ans++;
					temp += divisor;
				}
			}
		} else if ((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor >= 0)) {
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
			int temp = divisor;

			while (temp <= dividend) {
				if (ans < Integer.MAX_VALUE) {
					ans++;
					temp += divisor;
				} else {
					ans = Integer.MIN_VALUE;
				}
			}
			ans = -ans;

		}

		return ans;



**/
		/**
		 * 
		 * 
		 * A=a0*2^0+a1*2^1+a2*2^2+a3*2^3+……+an*2^n
		 * 
		 */
		
		
		long ans = 0;
		if(divisor==0)
		{
			ans = Integer.MAX_VALUE;
			return (int)ans;
		}
		long dividendTemp =Math.abs((long)dividend);
		long divisorTemp = Math.abs((long)divisor);
		if(dividendTemp<divisorTemp)
		{
			return (int)ans;
		}
		while(dividendTemp>=divisorTemp)
		{
		int count =0;
		
		while(dividendTemp>=divisorTemp)
		{
			 divisorTemp = divisorTemp<<1;
			 count++;
		}
		
		dividendTemp-=(divisorTemp>>1);
		ans+=((long)1<<(--count));
		divisorTemp = Math.abs((long)divisor);
		}
		ans=(PorN(dividend, divisor)?ans:-ans);
		
		
		if(ans>Integer.MAX_VALUE)
			ans=Integer.MAX_VALUE;
		if(ans<Integer.MIN_VALUE)
			ans=Integer.MIN_VALUE;
		return (int)ans;
	
	}
	private boolean PorN(int dividend , int divisor)
	{
		boolean PorNans = true;//判断最终符号正负，true为正，false为负
		if((dividend>0&&divisor<0)||(dividend<0&&divisor>0))
		{
			PorNans = false;
		}
		return PorNans;
	}
		
		
		
}