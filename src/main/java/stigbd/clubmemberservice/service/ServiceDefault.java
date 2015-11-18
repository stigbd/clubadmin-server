package stigbd.clubmemberservice.service;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import stigbd.clubmemberservice.dao.MemberDAO;
import stigbd.clubmemberservice.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class ServiceDefault implements Service{


    //TODO: Refactor to use DAO, ref http://www.informit.com/guides/content.aspx?g=java&seqNum=640
    // Create a Mongo instance that points to the MongoDB running on local host

    static final Morphia morphia = new Morphia();
    static final MongoClient mongoClient = new MongoClient("clubmemberservice_mongo_1");


    // Create a DAOs
    MemberDAO memberDao = new MemberDAO( mongoClient, morphia );

    public List<Member> listMembers() {

        return memberDao.find().asList();
    }

    @Override
    public String createMember(Member member) {

        return memberDao.save(member).getId().toString();
    }

    @Override
    public Member retrieveMember(String id) {
        ObjectId oid = new ObjectId(id);
        return memberDao.get(oid);
    }

    @Override
    public String changeMember(String id, Member m) {
        ObjectId oid = new ObjectId(id);
        m.setId(oid);
        return memberDao.save(m).getId().toString();
    }

    @Override
    public String removeMember(String id) {
        ObjectId oid = new ObjectId(id);
        memberDao.deleteById(oid);
        return id;
    }

    @Override
    public String createMainMemberRelation(String memberId, String mainMemberId) {
        if (memberId == null || mainMemberId == null) {
            return null;
        }
        if (memberId.equalsIgnoreCase(mainMemberId)) {
            return null;
        }

        // Check if member exist:
        ObjectId memberOid = new ObjectId(memberId);
        Member m = memberDao.get(memberOid);
        // Check if mainMember exist:
        ObjectId mainMemberOid = new ObjectId(mainMemberId);
        Member mm = memberDao.get(mainMemberOid);
        if (m != null && mm != null) {
            // Set the mainmember of member
            m.setMainMember(mm);
            // Add member to mainmember's familymemberlist
            if (mm.getFamilyMembers() != null) {
                mm.getFamilyMembers().add(m);
            } else {
                mm.setFamilyMembers(new ArrayList<>());
                mm.getFamilyMembers().add(m);
            }
            memberDao.save(m);
            memberDao.save(mm);
        } else {
            return null;
        }
        return mm.getId().toString();
    }
}
