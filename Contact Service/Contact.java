/**Valeria Duharte
*  6/1/2025
*/
package Contact;

public class Contact {

    private final String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (contactID == null || contactID.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getter - must return String as per requirement
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}