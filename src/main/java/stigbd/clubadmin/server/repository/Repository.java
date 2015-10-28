package stigbd.clubadmin.server.repository;

import stigbd.clubadmin.server.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;

public class Repository {

    private static HashMap<Long, Member> members = new HashMap<>();

    public ArrayList<Member> listMembers() {

        return new ArrayList<>(members.values());
    }

    public Long createMember(Member member) {
        Long id = (long) (members.size() + 1);
        member.setId(id);
        members.put(id, member);

        return id;
    }

    public Member retrieveMember(Long id) {

        return members.get(id);
    }
}
