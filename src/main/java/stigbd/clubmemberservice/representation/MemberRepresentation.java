package stigbd.clubmemberservice.representation;

import stigbd.clubmemberservice.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepresentation {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String birthDate;
    private String mobile;
    private String active;
    private String memberSince;
    private MemberRepresentation mainMember;
    private List<MemberRepresentation> familyMembers = new ArrayList<MemberRepresentation>();

    public MemberRepresentation(){

    }

    public MemberRepresentation(Member m) {
        this.id = m.getId().toString();
        this.firstName = m.getFirstName();
        this.lastName = m.getLastName();
        this.email = m.getEmail();
        this.sex = m.getSex();
        this.birthDate = m.getBirthDate();
        this.mobile = m.getMobile();
        this.active = m.getActive();
        this.memberSince = m.getMemberSince();

    }


    public MemberRepresentation getMainMember() {
        return mainMember;
    }

    public void setMainMember(MemberRepresentation mainMember) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }
}
