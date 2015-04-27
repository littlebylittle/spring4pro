package domain;

import java.io.Serializable;

class ContactDetailList implements Serializable {
	private Long id;
	private Long contactId;
	private String telType;
	private String telNumber;

	@Override
	public String toString() {
		return "ContactDetailList{" + "id=" + id + ", contactId=" + contactId + ", telType=" + telType + ","
				+ " telNumber=" + telNumber + '}';
	}
}