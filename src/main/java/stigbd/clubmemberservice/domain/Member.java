package stigbd.clubmemberservice.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

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
    private String email2;
    @Reference
    private Member mainMember;
    @Reference
    private List<Member> familyMembers = null;

    public Member getMainMember() {
        return mainMember;
    }

    public void setMainMember(Member mainMember) {
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

    public List<Member> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<Member> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }


}
