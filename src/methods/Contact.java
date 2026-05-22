package methods;

public class Contact {
    private String firstName, lastName, phoneNumber, email ;

    public  Contact(String firstName,String lastName,String phoneNumber,String email)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return  email;
    }
    public String getFullName()
    {
        return firstName+lastName;
    }

    public String getFullDetails()
    {
        return firstName+" "+lastName+" "+email;
    }

    //Setters
    public void setFirstName(String firstName)
    {
        if (firstName == null ||  firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("firstName must not be null or blank");
        }
        this.firstName = firstName ;

    }

    public void setLastName(String lastName)
    {
        if (lastName == null ||  lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("lastName must not be null or blank");
        }
        this.lastName = lastName ;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Enter a valid phoneNumber !");
        }
        String trimmed = phoneNumber.trim();
        if(trimmed.length() < 7)
        {
            throw new IllegalArgumentException("phoneNumber must not be less than 7 digits");
        }

        if (!trimmed.matches("^\\d+$")) {
            throw new IllegalArgumentException("Enter a valid PhoneNumber !");
        }
        this.phoneNumber = trimmed ;
    }

    public void setEmail(String email)
    {
        if (email == null) {
            throw new IllegalArgumentException("Enter a valid email !");
        }
        String trimmed = email.trim();
        this.email = isValidEmail(trimmed) ;
    }

    public String isValidEmail(String email)
    {
        if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("Enter a valid email !");
        }
        return email ;
    }

    public String toString()
    {
        return "\t FirstName\t: "+firstName+"\n\t LastName\t: "+lastName+"\n\t PhoneNumber\t: "+phoneNumber+"\n\t Email\t: "+email;
    }


}
