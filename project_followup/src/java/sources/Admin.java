/**
 *
 * @author Edanur
 */
package sources;

public class Admin extends Person {
    public int id;
    public String name;
    public String surname;
    public String email;
    public String password;

    public Admin(int id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
                this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    /*public Admin(int id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }*/

 /*   public Admin(String email, String password, String name, String surname) {
        super(name, surname);
        this.email = email;
        this.password = password;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     
}
