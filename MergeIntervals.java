package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		Interval temp1=new Interval(2,3);
		Interval temp2=new Interval(5,5);
		Interval temp3=new Interval(2,2);
		Interval temp4=new Interval(3,4);
		Interval temp5=new Interval(3,4);
		intervals.add(temp1);
		intervals.add(temp2);
		intervals.add(temp3);
		intervals.add(temp4);
		intervals.add(temp5);
		Solution56 solu = new Solution56();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.merge(intervals));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}
class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }


/**
 *	÷ÿ–¥comparator ∑Ω∑®
 * @author cmcc
 *
 */
class Solution56 {
	    public List<Interval> merge(List<Interval> intervals) {
	    	List<Interval> l = new ArrayList<Interval>();
	    	Collections.sort(intervals, new Mycomparator());
	    	if(intervals.size()<2)
	    	{
	    		return intervals;
	    	}
	    	int firststart,firstend,secondstart,secondend;
	    	for(int i  = 0 ; i<intervals.size()-1;i++)
	    	{
	    		firststart=intervals.get(i).start;
	    		firstend=intervals.get(i).end;
	    		secondstart=intervals.get(i+1).start;
	    		secondend=intervals.get(i+1).end;
	    		if(firstend<secondstart)
	    		{
	    			l.add(intervals.get(i));
	    		}
	    		else if(secondend>=firstend)
	    		{
	    			intervals.get(i+1).start=firststart;
	    		}else
	    		{
	    			intervals.get(i+1).start=firststart;
	    			intervals.get(i+1).end=firstend;
	    		}
	    		
	    	}
	    	l.add(intervals.get(intervals.size()-1));
	        return l;
	    }
	    public class Mycomparator implements Comparator<Interval>
	    {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
	    	
	    }
	}