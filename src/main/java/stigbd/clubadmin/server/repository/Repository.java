package stigbd.clubadmin.server.repository;

import stigbd.clubadmin.server.domain.Member;

import java.util.List;

public interface Repository {

    List<Member> listMembers();

    String createMember(Member member);

    Member retrieveMemberById(String id);
}
