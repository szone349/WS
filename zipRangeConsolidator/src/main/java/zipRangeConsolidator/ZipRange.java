package zipRangeConsolidator;

/**
 * Class to hold the zip range
 * @author tunus
 *
 */
public class ZipRange {
	private Integer startZip;
	private Integer endZip;
	
	public ZipRange(int start, int end)
	{
		if(!isValidZip(start) || !isValidZip(end) || start>end)
		{
			throw new IllegalArgumentException("Invalid start and/or end zip");
		}
		this.startZip = start;
		this.endZip = end;
	}
	public boolean isValidZip(int zip)
	{
		return zip>10000 && zip<99999 ? true: false;
	}

	public Integer getStartZip() {
		return startZip;
	}

	public void setStartZip(int startZip) {
		this.startZip = startZip;
	}

	public Integer getEndZip() {
		return endZip;
	}

	@Override
	public String toString() {
		return "[" + startZip + ", " + endZip + "]";
	}

	public void setEndZip(int endZip) {
		this.endZip = endZip;
	}

}
