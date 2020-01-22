package zipRangeConsolidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


/**
 * @author tunus
 * ZipRangeConsolidator class to consolidate list of zip ranges to a minimum list of non overlapping ranges
 *
 */
public class ZipRangeConsolidator {
	/**
	 * 1) Sort all zip ranges in order of start zip.
	 * 2) Iterate sorted ranges and modify the list by merging the ranges if they overlap
	 * @param zipRanges - List of zip ranges
	 * @return List of consolidated ranges
	 */
	
	public List<ZipRange> consolidateRanges(List<ZipRange> zipRanges)
	{
		Comparator<ZipRange> compareByStartZip = (ZipRange o1, ZipRange o2) -> o1.getStartZip().compareTo( o2.getStartZip() );

		//sort the ranges by the start zip
		Collections.sort(zipRanges, compareByStartZip);	
		//iterate and merge the overlapping  ranges
        Iterator<ZipRange> it = zipRanges.iterator();
        ZipRange zipRangeCurr = it.next();
        while (it.hasNext())
        {
        	ZipRange next = it.next();
        	if(zipRangeCurr.getEndZip() >= next.getStartZip())
        	{
        		//overlapping range - consolidate
        		zipRangeCurr.setEndZip(Math.max(zipRangeCurr.getEndZip(), next.getEndZip()));
        		zipRangeCurr.setStartZip(Math.min(zipRangeCurr.getStartZip(), next.getStartZip()));  
        		//remove the item from list
        		it.remove();
        		
        	}
        	else
        	{
        		//non overlapping check for the next range
        		zipRangeCurr = next;
        	}
        	
        }

		return zipRanges;

	}
	
    public static void main(String[] args) 
	{
		ArrayList<ZipRange> zipRanges = new ArrayList<ZipRange>();
		zipRanges.add(new ZipRange(94133,94133));
		zipRanges.add(new ZipRange(94200,94299));
		zipRanges.add(new ZipRange(94600,94699));

		System.out.println("Input Ranges 1 "+ zipRanges);

		ZipRangeConsolidator zipRangeConsolidator = new ZipRangeConsolidator();
		System.out.println("Consolidated Ranges 1"+zipRangeConsolidator.consolidateRanges(zipRanges));

		
		ArrayList<ZipRange> zipRanges2 = new ArrayList<ZipRange>();
		zipRanges2.add(new ZipRange(94133,94133));
		zipRanges2.add(new ZipRange(94200,94299));
		zipRanges2.add(new ZipRange(94226,94399));
		System.out.println("Input Ranges 2 "+ zipRanges);

		zipRangeConsolidator.consolidateRanges(zipRanges2);
		System.out.println("Consolidated Ranges 2"+zipRangeConsolidator.consolidateRanges(zipRanges2));


	}
}
