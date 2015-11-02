package stigbd.clubmemberservice.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("members")
@Indexes({
        @Index(value = "lastName", fields = @Field("lastName")),
        @Index(value = "email", fields = @Field("email"))}
)
public class Member {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String birthDate;
    private String mobile;
    private String active;
    private String memberSince;
    //references can be saved without automatic loading
    private Key<Member> mainMember;
    //refs are stored**, and loaded automatically
    @Reference
    private List<Member> familyMembers = new ArrayList<Member>();

    public Key<Member> getMainMember() {
        return mainMember;
    }

    public void setMainMember(Key<Member> mainMember) {
        this.mainMember = mainMember;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;

    }
}
