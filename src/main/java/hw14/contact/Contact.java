package hw14.contact;

import hw14.util.NameUtils;
import hw14.util.PhoneUtils;

public class Contact {

    private final String name;
    private final String surname;
    private final String patronymic;
    private final String phone;

    public Contact() {
        this(NameUtils.randomizeName(), NameUtils.randomizeSurname(), NameUtils.randomizePatronymic(), PhoneUtils.generatePhone());
    }

    public Contact(String name, String surname, String patronymic, String phone) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
    }

    public Contact(ContactWithOthers contact) {
        this(contact.getName(), contact.getSurname(), contact.getPatronymic(), contact.getPhone());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
