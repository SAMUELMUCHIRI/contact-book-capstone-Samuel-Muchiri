package methods;
import java.util.ArrayList;

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
}
