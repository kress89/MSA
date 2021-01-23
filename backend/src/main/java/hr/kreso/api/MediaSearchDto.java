package hr.kreso.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaSearchDto {
	@JsonProperty("Search")
	private List<MediaDto> search;

	@JsonProperty("totalResults")
	private String totalResults;

	@JsonProperty("Response")
	private String response;

	public List<MediaDto> getSearch() {
		return search;
	}

	public void setSearch(List<MediaDto> search) {
		this.search = search;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
