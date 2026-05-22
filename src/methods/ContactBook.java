package methods;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Optional;
import java.util.HashMap;

public class ContactBook {
    private ArrayList<Contact> contactBookArrayList = new ArrayList<Contact>();
    public ContactBook()
    {
        System.out.println("\nInitialized the contact book");
    }

    public void addContact(Contact c)
    {
        try
        {
            contactBookArrayList.add(c);
            System.out.println("[SUCCESS]\t: Contact added Successfully");
        }
        catch (Exception e) {
            System.out.println("[ERROR]\t: "+e.toString());
      }
    }

    public void findContact(String fullName)
    {
        if (fullName == null) {
            throw new IllegalArgumentException("Enter a valid FullName !");
        }
        String noSpaceFullName = fullName.replaceAll("\\s", "");
        int count = 0;
        for(Contact C : contactBookArrayList)
        {
            if(fullName.equals(C.getFullName()) )
            {
                count++;
                C.toString();
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
        String noSpaceFullName = fullName.replaceAll("\\s", "");
        int count = 0;
        for(int i = 0 ; i < contactBookArrayList.size() ; i++ )
        {
            if(fullName.equals(contactBookArrayList.get(i).getFullName()) )
            {
                count++;
                contactBookArrayList.remove(i);
                System.out.println("\n[SUCCESS]\t: Contact "+ fullName +" removed Successfully");
            }
        }
        if(count == 0)
        {
            System.out.println("\nContact not found");
        }


    }

    public void listAllContacts()
    {
        if(contactBookArrayList.isEmpty())
        {
            System.out.println("\nNo contacts saved");
        }
        else {
            for(int i = 0 ; i < contactBookArrayList.size() ; i++ )
            {
                System.out.println("[ "+i+" ]"+contactBookArrayList.get(i).toString());

            }
        }
    }

    public int countContacts()
    {
        return contactBookArrayList.size();
    }

    public Optional<ArrayList<Contact>> searchContacts(String keyword)
    {
        ArrayList<Contact> foundContacts = new ArrayList<>();
        String smallKeyword = keyword.toLowerCase();
        for(Contact c: contactBookArrayList)
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
        TreeMap<String , Contact> contactSortedByLastName= new TreeMap<>();
        if(contactBookArrayList.isEmpty())
        {
            System.out.println("\nNo contacts saved");
        }
        else {
            for(Contact c : contactBookArrayList)
            {
                contactSortedByLastName.put(c.getLastName() , c);
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
        HashMap<String , Contact> contactOrderByPhone = new HashMap<>();
        for(Contact C : contactBookArrayList)
        {
            contactOrderByPhone.put(C.getPhoneNumber() , C);
        }

        if(contactOrderByPhone.get(phoneNumber) != null)
        {
            System.out.println(contactOrderByPhone.get(phoneNumber).toString());
        }
        else
        {
            System.out.println("No contact found with that number :\t"+phoneNumber);
        }

    }




}
