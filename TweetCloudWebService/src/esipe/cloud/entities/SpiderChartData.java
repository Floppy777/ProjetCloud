package esipe.cloud.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SpiderChartData {
	@XmlElement
	private final String name;
	@XmlElement
	private final Integer[] data;
	@XmlElement
	private final String pointPlacement;
	
	public SpiderChartData(String name, Integer[] array){
		this.name = name;
		this.data = array;
		this.pointPlacement  ="on";
	}
	
	public String getName() {
		return name;
	}

	public Integer[] getData() {
		return data;
	}

	public String getPointPlacement() {
		return pointPlacement;
	}

	
}
