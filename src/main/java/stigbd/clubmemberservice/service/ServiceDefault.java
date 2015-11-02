package stigbd.clubmemberservice.service;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import stigbd.clubmemberservice.dao.MemberDAO;
import stigbd.clubmemberservice.domain.Member;

import java.util.List;

public class ServiceDefault implements Service{


    //TODO: Refactor to use DAO, ref http://www.informit.com/guides/content.aspx?g=java&seqNum=640
    // Create a Mongo instance that points to the MongoDB running on local host

    static final Morphia morphia = new Morphia();
    static final MongoClient mongoClient = new MongoClient("mongo");


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
        Member m = memberDao.get(oid);
        return m;
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

}
