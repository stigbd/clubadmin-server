package stigbd.clubmemberservice.domain;

import org.mongodb.morphia.annotations.*;

@Entity("members")
@Indexes({
        @Index(value = "lastName", fields = @Field("lastName")),
        @Index(value = "email", fields = @Field("email"))}
)
public class Member {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }
}
