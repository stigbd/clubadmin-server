package stigbd.clubmemberservice.representation;

import stigbd.clubmemberservice.domain.Member;

import java.util.logging.Logger;

public class MemberIdRepresentation {
    final Logger logger = Logger.getLogger(MemberIdRepresentation.class.getName());

    private String id;

    public MemberIdRepresentation(){

    }

    public MemberIdRepresentation(Member m) {
        this.id = m.getId().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }
}
