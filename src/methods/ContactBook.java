package methods;
import java.util.*;

public class ContactBook {
    // Changed to Haspmap
    private Map<String, Contact> contactsByPhone = new  HashMap<>();
    public ContactBook()
    {
        System.out.println("\nInitialized the contact book");
    }

    public void addContact(Contact c)
    {
        try
        {
            //Warm on duplicate entry
           if(contactsByPhone.containsKey(c.getPhoneNumber()))
            {
                System.out.println("[WARN]\t: Contact already exists");
            }
           else {
               //Modify to fit hash map formart
               contactsByPhone.put(c.getPhoneNumber() , c);
               System.out.println("[SUCCESS]\t: Contact added Successfully");

           }
        }
        catch (Exception e) {
            System.out.println("[ERROR]\t: "+e.toString());
      }
    }
    // I had left out an unused variable "NospaceFullName" and compared using lowercase
    public void findContact(String fullName)
    {
        if (fullName == null) {
            throw new IllegalArgumentException("Enter a valid FullName !");
        }
        String lowerCaseFullName = fullName.toLowerCase();
        int count = 0;
        for(Contact c : contactsByPhone.values() )
        {
            if(lowerCaseFullName.equals(c.getFullName().toLowerCase()) )
            {
                count++;
                System.out.println(c.toString());
            }
        }
        if(count == 0)
        {
            System.out.println("Contact not found");
        }

    }

    public void removeContact(String fullName)
    {
        if (fullName == null) {
            throw new IllegalArgumentException("Enter a valid FullName !");
        }


        // AI suggested to use mapping
        contactsByPhone.entrySet().removeIf(entry -> entry.getValue().getFullName().equals(fullName));

    }

    public void listAllContacts()
    {
        if(contactsByPhone.isEmpty())
        {
            System.out.println("\nNo contacts saved");
        }
        else {
            int count = 0;
            for(    Contact c:  contactsByPhone.values() )
            {
                System.out.println("[ "+count+" ]"+c.toString());
                count++;

            }
        }
    }

    public int countContacts()
    {
        return contactsByPhone.size();
    }

    public Optional<ArrayList<Contact>> searchContacts(String keyword)
    {
        ArrayList<Contact> foundContacts = new ArrayList<>();
        String smallKeyword = keyword.toLowerCase();
        for(Contact c: contactsByPhone.values())
        {
            if(c.getFullDetails().toLowerCase().contains(smallKeyword))
            {
                foundContacts.add(c);
            }
        }

        if(foundContacts.isEmpty()) {
            System.out.println("No contacts matched your search");
            return Optional.empty();
        }
        return Optional.of(foundContacts);
    }

    public void sortByLastName()
    {
        //direct conversion to tree map instead of looping through
        TreeMap<String , Contact> contactSortedByLastName= new TreeMap<>();
        if(contactsByPhone.isEmpty())
        {
            System.out.println("\nNo contacts saved");
        }


        else {
            for(Contact c : contactsByPhone.values())
            {
                contactSortedByLastName.put(c.getLastName(),c);
            }

            int count = 0;
            for(Contact c : contactSortedByLastName.values() )
            {
                System.out.println("[ "+count+" ]"+c.toString());
                count++;

            }
        }


    }

    public void findByPhone(String phoneNumber)
    {
        //O(1) LOOKUP
        Contact findContact =contactsByPhone.get(phoneNumber);
        if(findContact != null)
        {
            System.out.println(findContact.toString());
        }
        else        {
            System.out.println("No contact found with that number :\t"+phoneNumber);
        }

    }




}
