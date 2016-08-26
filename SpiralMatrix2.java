package leetcode;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =3;
		Solution59 solu = new Solution59();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.generateMatrix(n));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}
class Solution59 {
    public int[][] generateMatrix(int n) {
    	int[][] arr=new int[n][n];
    	
    	return arr;
    }
}