package stigbd.clubmemberservice.dao;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import stigbd.clubmemberservice.domain.Member;

/**
 * Created by sbd on 31.10.15.
 */
public class MemberDAO extends BasicDAO<Member, ObjectId> {

    public MemberDAO(MongoClient mongoClient, Morphia morphia) {
        super(mongoClient, morphia, "clubmember");
    }

    public Member retrieveMemberById(String id) {

        ObjectId oid = new ObjectId(id);
        Member m = super.getDatastore().find(Member.class).field("id").equal(oid).get();

        System.out.println("DEBUG---: Member retrieved->" + m.getId());
        return m;

    }
}