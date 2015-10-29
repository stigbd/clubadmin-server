package stigbd.clubadmin.server.repository;

import org.bson.types.ObjectId;
import stigbd.clubadmin.server.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;

public class RepositoryMock implements Repository {

    private static HashMap<ObjectId, Member> members = new HashMap<>();

    @Override
    public ArrayList<Member> listMembers() {

        return new ArrayList<>(members.values());
    }

    @Override
    public String createMember(Member member) {
        ObjectId id = new ObjectId();
        member.setId(id.toString());
        members.put(id, member);
        return id.toString();
    }

    @Override
    public Member retrieveMemberById(String id) {

        ObjectId oid = new ObjectId(id);
        return members.get(oid);
    }
}
