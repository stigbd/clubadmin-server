package stigbd.clubmemberservice.representation;

import stigbd.clubmemberservice.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberRepresentation {
    final Logger logger = Logger.getLogger(MemberRepresentation.class.getName());

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String birthDate;
    private String mobile;
    private String active;
    private String memberSince;
    private MemberIdRepresentation mainMemberId;
    private List<MemberIdRepresentation> familyMemberIds = null;

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

        if (m.getMainMember() != null) {
            this.mainMemberId = new MemberIdRepresentation(m.getMainMember());
        }

        if (m.getFamilyMembers() != null && m.getFamilyMembers().size() > 0) {
            logger.log(Level.INFO, "m.getFamilyMembers ->" + m.getFamilyMembers());
            this.familyMemberIds = new ArrayList<>();
            for (Member familyMember : m.getFamilyMembers()) {
                this.familyMemberIds.add(new MemberIdRepresentation(familyMember));
            }
        }
    }


    public MemberIdRepresentation getMainMember() {
        return mainMemberId;
    }
    public void setMainMember(MemberIdRepresentation mainMemberId) {
        this.mainMemberId = mainMemberId;
    }

    public List<MemberIdRepresentation> getFamilyMembers() {
        return familyMemberIds;
    }

    public void setFamilyMembers(List<MemberIdRepresentation> familyMembers) {
        this.familyMemberIds = familyMembers;
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
