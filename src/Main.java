import  methods.ContactBook;
import methods.Contact;
void main() {

    ContactBook myContactBook= new ContactBook();

    //Listing empty contact book
    myContactBook.listAllContacts();

    String[][] contacts = {
            {"Sarah",  "Okonkwo",   "0712345678", "sarah.o@email.com"},
            {"James",  "Mwangi",    "0798765432", "j.mwangi@gmail.com"},
            {"Priya",  "Nair",      "0723456789", "priya.nair@work.com"},
            {"David",  "Kimani",    "0756789012", "david.k@email.com"},
            {"Aisha",  "Hassan",    "0741234567", "aisha.hassan"},
            {"Chen",   "Wei",       "0734567890", "chen.wei@email.com"},
            {"Fatima", "Al-Rashid", "0767890123", "fatima.r@work.com"},
            {"Luca",   "Rossi",     "0778901234", "luca.rossi"},
            {"Amara",  "Diallo",    "0789012345", "amara.diallo@gmail.com"},
            {"Noah",   "Patel",     "0790123456", "noah.patel@email.com"},
            {"Yuki",   "Tanaka",    "0701234567", "yuki.tanaka@work.com"},
            {"Kwame",  "Asante",    "0712345670", "kwame123email.com"},
            {"Elena",  "Petrov",    "0723456780", "elena.petrov@gmail.com"},
            {"Elena",  "Petrov",    "0723456780", "elena.petrov@gmail.com"},
            {"Omar",   "Farouk",    "0734567891", "omar.farouk@work.com"},
            {"Zara",   "Osei",      "0745678902", "zara.osei@"}
    };

    //Adding contacts
    for (String[] c : contacts) {
        try {
            myContactBook.addContact(new Contact(c[0], c[1], c[2], c[3]));

        } catch (IllegalArgumentException e) {
            System.out.println("Skipped " + c[0] + ": " + e.getMessage());
        }
    }

    //Listing successfully added contacts
    myContactBook.listAllContacts();

    //Removing "Omar",   "Farouk
    System.out.println("\nRemoving Omar Farouk");
    myContactBook.removeContact("OmarFarouk");

    //Confirm Removed Contact
    System.out.println("\nConfirm Removed Contact Omar Farouk");
    myContactBook.findContact("OmarFarouk");

    //list Remaining contacts
    System.out.println("\nlist Remaining contacts");
    myContactBook.listAllContacts();

    //Final Count
    System.out.println("\nThe Final ContactBook List Count is: " + myContactBook.countContacts());

    System.out.println("\nSearching Amara");
    Optional<ArrayList<Contact>> findContact = myContactBook.searchContacts("amara");
    if (findContact.isPresent()) {
        for (Contact contact : findContact.get()) {
            System.out.println(contact.toString());
        }
    }

    System.out.println("\nSorting By last name\n");
    myContactBook.sortByLastName();

    System.out.println("\nFinding by phone Number");
    myContactBook.findByPhone("0790123456");
    myContactBook.findByPhone("43757866837");

}
