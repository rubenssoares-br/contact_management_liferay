package contact.rest.client.dto.v1_0;

import contact.rest.client.function.UnsafeSupplier;
import contact.rest.client.serdes.v1_0.ContactEntrySerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Rubens Soares
 * @generated
 */
@Generated("")
public class ContactEntry implements Cloneable, Serializable {

	public static ContactEntry toDTO(String json) {
		return ContactEntrySerDes.toDTO(json);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddress(
		UnsafeSupplier<String, Exception> addressUnsafeSupplier) {

		try {
			address = addressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String address;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public void setContactId(
		UnsafeSupplier<Integer, Exception> contactIdUnsafeSupplier) {

		try {
			contactId = contactIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer contactId;

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public void setEntryId(
		UnsafeSupplier<Integer, Exception> entryIdUnsafeSupplier) {

		try {
			entryId = entryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer entryId;

	public String getFamilyRelationship() {
		return familyRelationship;
	}

	public void setFamilyRelationship(String familyRelationship) {
		this.familyRelationship = familyRelationship;
	}

	public void setFamilyRelationship(
		UnsafeSupplier<String, Exception> familyRelationshipUnsafeSupplier) {

		try {
			familyRelationship = familyRelationshipUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String familyRelationship;

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public void setPhone(
		UnsafeSupplier<Integer, Exception> phoneUnsafeSupplier) {

		try {
			phone = phoneUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer phone;

	@Override
	public ContactEntry clone() throws CloneNotSupportedException {
		return (ContactEntry)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContactEntry)) {
			return false;
		}

		ContactEntry contactEntry = (ContactEntry)object;

		return Objects.equals(toString(), contactEntry.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ContactEntrySerDes.toJSON(this);
	}

}