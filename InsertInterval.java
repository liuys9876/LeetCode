package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		Interval newInterval = new Interval(0,0);
		Interval temp1=new Interval(1,5);
		Interval temp2=new Interval(6,9);
		intervals.add(temp1);
		intervals.add(temp2);
		Solution57 solu = new Solution57();
		long timestart = System.currentTimeMillis();
		System.out.println(solu.insert(intervals,newInterval));
		long timeend = System.currentTimeMillis();
		System.out.println("s:" + timestart + "e:" + timeend + "t:" + (timeend - timestart));
	}

}



/**
 * 
 * @author cmcc
 * @param 9ms
 */
class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	intervals.add(newInterval);
    	Collections.sort(intervals,new mycomparator());
    	List<Interval> l = new ArrayList<Interval>();
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
    public class mycomparator implements Comparator<Interval>
    {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
    	
    }
}
/**
 * 
 * @author cmcc
 * @param 18ms
 *
/*
class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int newIntervalStart = newInterval.start;
    	int newIntervalEnd = newInterval.end;
    	if(intervals.isEmpty())
    	{
    		intervals.add(newInterval);
    		return intervals;
    	}
    	for(int i=0;i<intervals.size();i++)
    	{
    		Interval in =intervals.get(i);
    		if(in.end>=newIntervalStart)
    		{
    			if(in.start>newIntervalStart)
    			{
    				if(in.start<=newIntervalEnd)
    				{
    					intervals.get(i).start=newIntervalStart;
    				}
    				else
    				{
    					intervals.add(newInterval);
    					Collections.sort(intervals,new mycomparator());
    					break;
    				}
    			}
    			if(in.end>=newIntervalEnd)
    			{
    				break;
    			}
    			else
    			{
    				intervals.get(i).end=newIntervalEnd;
    				for(int j =i+1;j<intervals.size();)
    				{
    					Interval intemp=intervals.get(j); 
    						if(intemp.start>newIntervalEnd)
    						{
    							break;
    						}else if(intemp.start==newIntervalEnd)
    						{
    							intervals.get(i).end=intervals.get(j).end;
    							intervals.remove(j);
    							break;
    						}else
    						{
    							if(intemp.end<newIntervalEnd)
    							{
    								intervals.remove(j);
    							}else
    							{
    								intervals.get(i).end=intervals.get(j).end;
    								intervals.remove(j);
    								break;
    							}
    						}
    				}
    				break;
    			}
    		}
    		if(i==intervals.size()-1)
    		{
    			intervals.add(newInterval);
    		}
    	}
    	
    	return intervals;
        
    }
    public class mycomparator implements Comparator<Interval>
    {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
    	
    }
}
*/