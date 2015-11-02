package stigbd.clubmemberservice.service;

import stigbd.clubmemberservice.domain.Member;

import java.util.List;

public interface Service {

    List<Member> listMembers();
    String createMember(Member member);
    Member retrieveMember(String id);
    String changeMember(String id, Member m);
    String removeMember(String id);
}
