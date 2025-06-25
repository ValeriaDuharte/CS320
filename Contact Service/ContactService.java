/**Valeria Duharte
*  6/1/2025
*/
package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    
    private final Map<String, Contact> contactMap = new HashMap<>();
    private int currentIDNum = 0;

    // Add a new contact with a generated unique ID
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        String stringID = String.valueOf(currentIDNum++);
        Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
        contactMap.put(stringID, newContact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        if (!contactMap.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contactMap.remove(contactID);
    }

    // Edit methods
    public void editFirstName(String contactID, String firstName) {
        getContact(contactID).setFirstName(firstName);
    }

    public void editLastName(String contactID, String lastName) {
        getContact(contactID).setLastName(lastName);
    }

    public void editNumber(String contactID, String phoneNumber) {
        getContact(contactID).setPhoneNumber(phoneNumber);
    }

    public void editAddress(String contactID, String address) {
        getContact(contactID).setAddress(address);
    }

    // Helper method to retrieve a contact
    private Contact getContact(String contactID) {
        Contact contact = contactMap.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contact;
    }

    // For testing or display
    public int getContactCount() {
        return contactMap.size();
    }

    public Contact getContactPublic(String contactID) {
        return contactMap.get(contactID);
    }
}