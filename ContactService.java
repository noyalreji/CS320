package com.dropwizard.mobileapp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

    // Instance variable to store unique ID
    private String uniqueId;

    // List to store contacts
    private List<Contact> contactList = new ArrayList<>();

    // Initialization block to generate a unique ID
    {
        uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
    }

    // Method to create a new contact with a unique ID
    public void newContact() {
        Contact contact = new Contact(newUniqueId());
        contactList.add(contact);
    }

    // Method to create a new contact with a unique ID and first name
    public void newContact(String firstname) {
        Contact contact = new Contact(newUniqueId(), firstname);
        contactList.add(contact);
    }

    // Method to create a new contact with a unique ID, first name, and last name
    public void newContact(String firstname, String lastname) {
        Contact contact = new Contact(newUniqueId(), firstname, lastname);
        contactList.add(contact);
    }

    // Method to create a new contact with a unique ID, first name, last name, and phone number
    public void newContact(String firstname, String lastname, String phonenumber) {
        Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber);
        contactList.add(contact);
    }

    // Method to create a new contact with a unique ID, first name, last name, phone number, and address
    public void newContact(String firstname, String lastname, String phonenumber, String address) {
        Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
        contactList.add(contact);
    }

    // Method to delete a contact by ID
    public void deleteContact(String id) throws Exception {
        contactList.remove(searchForContact(id));
    }

    // Method to update first name of a contact by ID
    public void updateFirstName(String id, String firstName) throws Exception {
        searchForContact(id).updateFirstName(firstName);
    }

    // Method to update last name of a contact by ID
    public void updateLastName(String id, String lastName) throws Exception {
        searchForContact(id).updateLastName(lastName);
    }

    // Method to update phone number of a contact by ID
    public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
        searchForContact(id).updatePhoneNumber(phoneNumber);
    }

    // Method to update address of a contact by ID
    public void updateAddress(String id, String address) throws Exception {
        searchForContact(id).updateAddress(address);
    }

    // Method to get the list of contacts
    protected List<Contact> getContactList() {
        return contactList;
    }

    // Method to generate a new unique ID
    private String newUniqueId() {
        return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
    }

    // Method to search for a contact by ID
    private Contact searchForContact(String id) throws Exception {
        int index = 0;
        while (index < contactList.size()) {
            if (id.equals(contactList.get(index).getContactId())) {
                return contactList.get(index);
            }
            index++;
        }
        throw new Exception("The Contact does not exist!");
    }
}
