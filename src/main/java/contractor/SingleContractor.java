package contractor;

import contractor.Role;

public class SingleContractor {

    private String firstName;

    private String lastName;

     private Role role;

    private Adress adress;

    public SingleContractor(String firstName, String lastName, Role role, Adress adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.adress = adress;
    }
}
