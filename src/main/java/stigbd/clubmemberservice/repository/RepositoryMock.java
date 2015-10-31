package stigbd.clubmemberservice.repository;

import org.bson.types.ObjectId;
import stigbd.clubmemberservice.domain.Member;

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

    @Override
    public Member updateMemberById(String id, Member member) {
        return null;
    }

    @Override
    public String deleteMemberById(String id) {
        return null;
    }
}
