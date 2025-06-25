/**Valeria Duharte
*  6/1/2025
*/
package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.ContactService;

class ContactServiceTest {

    @AfterEach
    void tearDown() {
        ContactService.contactList.clear();
    }

    @DisplayName("Test addContact")
    @Test
    void testAddContact() {
        ContactService test = new ContactService();

        assertTrue(ContactService.contactList.isEmpty());

        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street");

        assertFalse(ContactService.contactList.isEmpty());
        assertEquals("0", ContactService.contactList.get(0).getContactID());
        assertEquals("Greg", ContactService.contactList.get(0).getFirstName());
        assertEquals("Hoffman", ContactService.contactList.get(0).getLastName());
        assertEquals("1234567891", ContactService.contactList.get(0).getPhoneNumber());
        assertEquals("123 Main Street", ContactService.contactList.get(0).getAddress());
    }

    @DisplayName("Test deleteContact")
    @Test
    void testDeleteContact() {
        ContactService test = new ContactService();

        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street"); // ID 0
        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street"); // ID 1
        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street"); // ID 2

        assertEquals(3, ContactService.contactList.size());

        test.deleteContact("1");

        assertEquals(2, ContactService.contactList.size());

        for (var contact : ContactService.contactList) {
            assertNotEquals("1", contact.getContactID(), "Contact with ID 1 should be deleted");
        }
    }

    @DisplayName("Test editing a phone number")
    @Test
    void testEditPhone() {
        ContactService test = new ContactService();
        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street");

        assertEquals("1234567891", ContactService.contactList.get(0).getPhoneNumber());

        test.editNumber("0", "1987654321");

        assertEquals("1987654321", ContactService.contactList.get(0).getPhoneNumber());
    }

    @DisplayName("Test editing a last name")
    @Test
    void testEditLast() {
        ContactService test = new ContactService();
        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street");

        assertEquals("Hoffman", ContactService.contactList.get(0).getLastName());

        test.editLastName("0", "Test_Name");

        assertEquals("Test_Name", ContactService.contactList.get(0).getLastName());
    }

    @DisplayName("Test editing a first name")
    @Test
    void testEditFirst() {
        ContactService test = new ContactService();
        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street");

        assertEquals("Greg", ContactService.contactList.get(0).getFirstName());

        test.editFirstName("0", "Test_First");

        assertEquals("Test_First", ContactService.contactList.get(0).getFirstName());
    }

    @DisplayName("Test editing an address")
    @Test
    void testEditAddress() {
        ContactService test = new ContactService();
        test.addContact("Greg", "Hoffman", "1234567891", "123 Main Street");

        assertEquals("123 Main Street", ContactService.contactList.get(0).getAddress());

        test.editAddress("0", "Test_Address");

        assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
    }
}