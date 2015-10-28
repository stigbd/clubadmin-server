package stigbd.clubadmin.server.repository;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import stigbd.clubadmin.server.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class RepositoryDefault implements Repository {

    static final Morphia morphia = new Morphia();
    static final Datastore datastore = morphia.createDatastore(new MongoClient(), "stigbd_clubadmin");

    static {

        // tell Morphia where to find your classes
        // can be called multiple times with different packages or classes
        morphia.mapPackage("stigbd.clubadmin.server.domain");

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
        member.setId(id);
        datastore.save(member);
        return id.toString();
    }

    @Override
    public Member retrieveMemberById(String id) {

        ObjectId oid = new ObjectId(id);
        return datastore.find(Member.class).field("id").equal(oid).get();
    }
}
