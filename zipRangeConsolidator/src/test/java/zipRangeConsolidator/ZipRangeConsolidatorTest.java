package zipRangeConsolidator;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class ZipRangeConsolidatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidZips() {
		ZipRange invalidZips = new ZipRange(12,10);
		System.out.print(invalidZips);
	}
	@Test
	public void testConsolidateRanges1() {
		ArrayList<ZipRange> zipRanges = new ArrayList<ZipRange>();
		zipRanges.add(new ZipRange(94133,94133));
		zipRanges.add(new ZipRange(94200,94299));
		zipRanges.add(new ZipRange(94600,94699));
		
		ZipRangeConsolidator zipRangeConsolidator = new ZipRangeConsolidator();
		List<ZipRange> consolidatedRanges = zipRangeConsolidator.consolidateRanges(zipRanges);
		assertEquals(3, consolidatedRanges.size());
		assertEquals(94133, consolidatedRanges.get(0).getStartZip().intValue());
		assertEquals(94133, consolidatedRanges.get(0).getEndZip().intValue());
		assertEquals(94200, consolidatedRanges.get(1).getStartZip().intValue());
		assertEquals(94299, consolidatedRanges.get(1).getEndZip().intValue());
		assertEquals(94600, consolidatedRanges.get(2).getStartZip().intValue());
		assertEquals(94699, consolidatedRanges.get(2).getEndZip().intValue());

		}
	@Test
	public void testConsolidateRanges2() {
		ArrayList<ZipRange> zipRanges = new ArrayList<ZipRange>();
		zipRanges.add(new ZipRange(94133,94133));
		zipRanges.add(new ZipRange(94200,94299));
		zipRanges.add(new ZipRange(94226,94399));
		
		ZipRangeConsolidator zipRangeConsolidator = new ZipRangeConsolidator();
		List<ZipRange> consolidatedRanges = zipRangeConsolidator.consolidateRanges(zipRanges);
		assertEquals(2, consolidatedRanges.size());
		assertEquals(94133, consolidatedRanges.get(0).getStartZip().intValue());
		assertEquals(94133, consolidatedRanges.get(0).getEndZip().intValue());
		assertEquals(94200, consolidatedRanges.get(1).getStartZip().intValue());
		assertEquals(94399, consolidatedRanges.get(1).getEndZip().intValue());
		}
	

}
