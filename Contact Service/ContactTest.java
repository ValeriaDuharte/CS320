/**Valeria Duharte
*  6/1/2025
*/
package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {

    @DisplayName("Test a valid constructor")
    @Test
    void testValidConstructor() {
        Contact contact = new Contact("1", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertEquals("1", contact.getContactID());
        assertEquals("Greg", contact.getFirstName());
        assertEquals("Hoffman", contact.getLastName());
        assertEquals("1234567891", contact.getPhoneNumber());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @DisplayName("Test constructor with invalid phone number length")
    @Test
    void testConstructorInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("2", "Greg", "Hoffman", "123", "123 Main Street");
        });
    }

    @DisplayName("Test valid setFirstName")
    @Test
    void testValidSetFirstName() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        contact.setFirstName("Test");
        assertEquals("Test", contact.getFirstName());
    }

    @DisplayName("Test invalid null setFirstName")
    @Test
    void testNullSetFirstName() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @DisplayName("Test too long setFirstName")
    @Test
    void testLongSetFirstName() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("WayTooLongFirstName");
        });
    }

    @DisplayName("Test getContactID returns correct String")
    @Test
    void testGetContactID() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertEquals("3", contact.getContactID());
    }

    @DisplayName("Test invalid long contactID")
    @Test
    void testInvalidLongContactID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678910111213", "Greg", "Hoffman", "1234567891", "123 Main Street");
        });
    }

    @DisplayName("Test invalid null setLastName")
    @Test
    void testNullSetLastName() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @DisplayName("Test too long setLastName")
    @Test
    void testLongSetLastName() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("WayTooLongLastName");
        });
    }

    @DisplayName("Test valid setLastName")
    @Test
    void testValidSetLastName() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        contact.setLastName("Tester");
        assertEquals("Tester", contact.getLastName());
    }

    @DisplayName("Test invalid null setPhoneNumber")
    @Test
    void testNullSetPhoneNumber() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber(null);
        });
    }

    @DisplayName("Test invalid length setPhoneNumber")
    @Test
    void testInvalidLengthSetPhoneNumber() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("123"); // too short
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("1234567890123456"); // too long
        });
    }

    @DisplayName("Test valid setPhoneNumber")
    @Test
    void testValidSetPhoneNumber() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());
    }

    @DisplayName("Test null setAddress")
    @Test
    void testNullSetAddress() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @DisplayName("Test too long setAddress")
    @Test
    void testTooLongSetAddress() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901234567890");
        });
    }

    @DisplayName("Test valid setAddress")
    @Test
    void testValidSetAddress() {
        Contact contact = new Contact("3", "Greg", "Hoffman", "1234567891", "123 Main Street");
        contact.setAddress("456 Elm Street");
        assertEquals("456 Elm Street", contact.getAddress());
    }
}