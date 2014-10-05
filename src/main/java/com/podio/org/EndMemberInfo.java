package com.podio.org;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.podio.space.SpaceMemberDetails;

public class EndMemberInfo {

	/**
	 * list of spaces the user would just be removed from
	 */
	private List<SpaceMemberDetails> toRemove;
	
	/**
	 * list of spaces where all other users will be promoted to admin
	 */
	private List<SpaceMemberDetails> toPromote;
	
	/**
	 * list of spaces which would be deleted
	 */
	private List<SpaceMemberDetails> toDelete;

	@JsonProperty("to_remove")
	public List<SpaceMemberDetails> getToRemove() {
		return toRemove;
	}

	@JsonProperty("to_promote")
	public List<SpaceMemberDetails> getToPromote() {
		return toPromote;
	}

	@JsonProperty("to_delete")
	public List<SpaceMemberDetails> getToDelete() {
		return toDelete;
	}
}
