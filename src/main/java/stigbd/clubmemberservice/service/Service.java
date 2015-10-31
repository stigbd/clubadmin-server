package stigbd.clubmemberservice.service;

import stigbd.clubmemberservice.domain.Member;
import stigbd.clubmemberservice.repository.Repository;

import java.util.List;

public class Service {

    private static Repository REPOSITORY;

    public static void setREPOSITORY(Repository r) {
        REPOSITORY = r;
    }

    public List<Member> listMembers() {

        return REPOSITORY.listMembers();
    }

    public String createMember(Member member) {

        return REPOSITORY.createMember(member);
    }

    public Member retrieveMember(String id) {

        return REPOSITORY.retrieveMemberById(id);
    }

    public Member changeMember(String id, Member member) {

        return REPOSITORY.updateMemberById(id, member);
    }

    public String removeMember(String id) {

        return REPOSITORY.deleteMemberById(id);
    }
}
