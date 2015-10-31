package stigbd.clubmemberservice.repository;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import stigbd.clubmemberservice.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class RepositoryDefault implements Repository {

    static final Morphia morphia = new Morphia();
    static final Datastore datastore = morphia.createDatastore(new MongoClient("mongo"), "clubmember");

    static {

        // tell Morphia where to find your classes
        // can be called multiple times with different packages or classes
        morphia.mapPackage("stigbd.clubmemberservice.domain");

        // create the Datastore connecting to the default port on the local host
        datastore.ensureIndexes();
    }

    @Override
    public ArrayList<Member> listMembers() {

        final Query<Member> query = datastore.createQuery(Member.class);
        final List<Member> members = query.asList();
        return (ArrayList<Member>) members;
    }

    @Override
    public String createMember(Member member) {
        ObjectId id = new ObjectId();
        member.setId(id.toString());
        datastore.save(member);
        return member.getId();
    }

    @Override
    public Member retrieveMemberById(String id) {

        return datastore.find(Member.class).field("id").equal(id).get();
    }

    @Override
    public Member updateMemberById(String id, Member member) {
        System.out.println("DEBUG---:" + id);
        if (datastore.find(Member.class).field("id").equal(id).get() == null) {
            return null;
        }

        UpdateOperations<Member> ops = datastore.createUpdateOperations(Member.class);
        Query<Member> updateQuery = datastore.createQuery(Member.class).field("id").equal(id);

        if (member.getFirstName() != null) {
            ops.set("firstName", member.getFirstName());
        }
        if (member.getLastName() != null) {
            ops.set("lastName", member.getLastName());
        }
        if (member.getEmail() != null) {
            ops.set("email", member.getEmail());
        }
        if (member.getSex() != null) {
            ops.set("sex", member.getSex());
        }
        if (member.getBirthDate() != null) {
            ops.set("birthDate", member.getBirthDate());
        }
        if (member.getMobile() != null) {
            ops.set("mobile", member.getMobile());
        }
        if (member.getActive() != null) {
            ops.set("active", member.getActive());
        }
        if (member.getMemberSince() != null) {
            ops.set("memberSince", member.getMemberSince());
        }


        if (ops != null) {
            datastore.update(updateQuery, ops);
        }
        return member;
    }

    @Override
    public String deleteMemberById(String id) {
        if (datastore.find(Member.class).field("id").equal(id).get() == null) {
            return null;
        }
        final Query<Member> deleteMemberQuery = datastore.createQuery(Member.class).field("id").equal(id);
        datastore.delete(deleteMemberQuery);
        return id;
    }
}
