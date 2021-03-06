package klib.trackr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "start", "end", "length", "travelTime", "maneuver" })
public class Leg {

	@JsonProperty("length")
	private Integer length;
	@JsonProperty("travelTime")
	private Integer travelTime;
	@JsonProperty("maneuver")
	private List<Maneuver> maneuver = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	@JsonProperty("length")
	public Integer getLength() {
		return length;
	}

	@JsonProperty("length")
	public void setLength(Integer length) {
		this.length = length;
	}

	@JsonProperty("travelTime")
	public Integer getTravelTime() {
		return travelTime;
	}

	@JsonProperty("travelTime")
	public void setTravelTime(Integer travelTime) {
		this.travelTime = travelTime;
	}

	@JsonProperty("maneuver")
	public List<Maneuver> getManeuver() {
		return maneuver;
	}

	@JsonProperty("maneuver")
	public void setManeuver(List<Maneuver> maneuver) {
		this.maneuver = maneuver;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return maneuver.toString();
	}
}
