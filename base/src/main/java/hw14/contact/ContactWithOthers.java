package hw14.contact;

import java.util.Collection;
import java.util.HashSet;

public class ContactWithOthers extends Contact {

    private Collection<Contact> linkedContacts;

    public ContactWithOthers() {
        this.linkedContacts = new HashSet<>();
    }

    public Collection<Contact> getLinkedContacts() {
        return linkedContacts;
    }
}
