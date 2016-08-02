package leetcode;

import sun.launcher.resources.launcher;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = new int[] {1,1};
		Solution11 solu = new Solution11() {
		};
		System.out.println(solu.maxArea(height));
	}

}

class Solution11 {
	public int maxArea(int[] height) {
	/*  
	 * Time Limit Exceeded
	 * 
	  	int area = 0;

		int temp = 0;
		if (height.length < 2) {
			area = 0;
		} else {
			for (int i = 1; i < height.length; i++) {
				for (int j = 0; j < i; j++) {
					temp = (Math.min(height[i], height[j]) * (i - j));
					if (Math.min(height[i], height[j]) * (i - j) > area) {
						area = temp;
					}
				}
			}
		}
		return area;
*/
/*
 * 

		int area = 0;
		int temp=0;
		int[] array_temp = new int[height.length];   //从1到n的可能组合对应在x轴上的长度有n种
		if (height.length < 2) {
			area = 0;
		} else {
			for (int i = 1; i < height.length; i++) {
				for (int j = 0; j < i; j++) {
					temp=Math.min(height[i], height[j]);
					if(array_temp[i-j-1]<temp)
					{
						array_temp[i-j-1]=temp;
					}
					}
				}
			for(int i=0;i<array_temp.length;i++)
			{
				temp=array_temp[i]*(i+1);
				if(area<temp)
				{
					area=temp;
				}
			}
		}
		return area;
		*/
		
		
		//双方向向中间移动
		int area =0;
		int left=0,right=height.length-1;
		int temp =0;
		while(right>left)
		{
			area = Math.max(Math.min(height[left], height[right])*(right-left),area);
			if(height[left]<height[right])
			{
				
				temp =++left;
				while(temp<right&&height[temp]<height[left])
				{
					temp++;
				}
				left=temp;
				
			}else
			{
				temp=--right;
				while(left<temp&&height[temp]<height[right])
				{
					temp--;
				}
				right=temp;
			}
		}
		return area;
	}
}