package com.podio.search;

import java.util.List;

public class SearchInAppResponse {
    
        /**
         * Counts for each type of object
         */
        private Counts counts;
            
        /**
	 * The items returned
	 */
	private List<SearchResult> results;
        
	@Override
	public String toString() {
		return "SearchInAppResponse [counts=" + counts.toString() + ", results=" + results.toString() + "]";
	}

        public Counts getCounts() {
                return counts;
        }

        public void setCounts(Counts counts) {
                this.counts = counts;
        }

        public List<SearchResult> getResults() {
                return results;
        }

        public void setResults(List<SearchResult> results) {
                this.results = results;
        }
        
}
