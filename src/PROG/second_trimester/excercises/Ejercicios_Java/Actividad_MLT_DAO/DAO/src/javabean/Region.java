package javabean;

import java.util.Objects;

public class Region {
	
	private int regionId;
	private String regionName;
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(regionId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Region)) {
			return false;
		}
		Region other = (Region) obj;
		return regionId == other.regionId;
	}
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}
	public Region(int regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}
	public Region() {
		super();
	}
}
