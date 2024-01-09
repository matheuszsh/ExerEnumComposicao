package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private static StringBuilder builder = new StringBuilder();

    private String name;
    private String email;
    private Date birthDate;

    Client(){}

    public Client(String name, String email, Date birthDate){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Client(String name, Date birthDate) {
        this.name = name;
        setEmail(name);
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client: " + getName() + " (" + getBirthDate() + ") " + "- " + getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = String.valueOf(builder.append(name.toLowerCase().split(" ")[0]).append("@gmail.com"));
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
