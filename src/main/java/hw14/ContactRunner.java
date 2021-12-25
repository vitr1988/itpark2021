package hw14;

import hw14.contact.Contact;
import hw14.contact.ContactWithOthers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContactRunner {

    private static final Integer LIMIT = 10_000;
    private static final Integer LIMIT_OF_LINKED_CONTACTS = 100;

    public static void main(String[] args) {
//        long seconds = TimeUnit.SECONDS.convert(spentTime, TimeUnit.MILLISECONDS);
        ContactWithOthers[] contacts = generateElementsInArrayAndMeasureTime(ContactRunner::fillContactArrays);
        Collection<ContactWithOthers> contactsList = generateElementsAndMeasureTime(ContactRunner::fillContactList);
        Collection<ContactWithOthers> contactsSet = generateElementsAndMeasureTime(ContactRunner::fillContactSet);

        System.out.println("-------------");
        fillLinkedContacts(contactsList);
        System.out.println("-------------");
        fillLinkedContacts(contactsSet);

        System.out.println("-------------");
        Map<Contact, Collection<Contact>> mapOfContactsWithLinkedContacts =
                contactsList.stream().collect(Collectors.toMap(Contact::new, ContactWithOthers::getLinkedContacts));
        System.out.println(mapOfContactsWithLinkedContacts);

        Map<Contact, Integer> mapOfContacts = contactsList.stream().map(ContactWithOthers::getLinkedContacts)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Function.identity(), contact -> 1, Integer::sum));
        System.out.println("-------------");
        System.out.println(contactsList);
        System.out.println("-------------");
        mapOfContacts.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);

    }

    private static void fillLinkedContacts(Collection<ContactWithOthers> contactsList) {
        long now = System.currentTimeMillis();
        for (ContactWithOthers contact : contactsList) {
            IntStream.range(0, LIMIT_OF_LINKED_CONTACTS).boxed()
                    .map(i -> randomElement(contactsList)).forEach(contact.getLinkedContacts()::add);
        }
        long spentTime = System.currentTimeMillis() - now;
        System.out.printf("Заполнение связнных контактов %s из %d элементов потребовало %.2f секунд\n",
                contactsList instanceof List ? "списка" : "множества",
                LIMIT_OF_LINKED_CONTACTS, spentTime / 1000d);
    }

    public static ContactWithOthers[] generateElementsInArrayAndMeasureTime(Supplier<ContactWithOthers[]> supplier) {
        long now = System.currentTimeMillis();
        ContactWithOthers[] collection = supplier.get();
        long spentTime = System.currentTimeMillis() - now;
        System.out.printf("Заполнение массива из %d элементов потребовало %.2f секунд\n", collection.length, spentTime / 1000d);
        return collection;
    }

    public static Collection<ContactWithOthers> generateElementsAndMeasureTime(Supplier<Collection<ContactWithOthers>> supplier) {
        long now = System.currentTimeMillis();
        Collection<ContactWithOthers> collection = supplier.get();
        long spentTime = System.currentTimeMillis() - now;
        System.out.printf("Заполнение %s из %d элементов потребовало %.2f секунд\n",
                collection instanceof List ? "списка" : "множества",
                collection.size(), spentTime / 1000d);
        return collection;
    }

    private static ContactWithOthers[] fillContactArrays() {
        ContactWithOthers[] contacts = new ContactWithOthers[LIMIT];
        for (int i = 0; i < contacts.length; i++) {
            contacts[i] = new ContactWithOthers();
        }
        return contacts;
    }

    private static List<ContactWithOthers> fillContactList() {
        List<ContactWithOthers> contacts = new ArrayList<>(LIMIT);
        IntStream.range(0, LIMIT).forEach(value -> {
            contacts.add(new ContactWithOthers());
        });
        return contacts;
    }

    private static Set<ContactWithOthers> fillContactSet() {
        Set<ContactWithOthers> contacts = new HashSet<>(LIMIT);
        IntStream.range(0, LIMIT).forEach(value -> {
            contacts.add(new ContactWithOthers());
        });
        return contacts;
    }

    private static Contact randomElement(Collection<ContactWithOthers> collection) {
        int counter = 0;
        int randomCounter = new Random().nextInt(collection.size());
        for (Contact contact : collection) {
            if (counter++ == randomCounter) {
                return contact;
            }
        }
        throw new IllegalStateException("Мы сюда зайти не должны");
    }
}
