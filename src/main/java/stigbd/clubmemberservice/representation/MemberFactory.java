package stigbd.clubmemberservice.representation;

import org.bson.types.ObjectId;
import stigbd.clubmemberservice.domain.Member;
import stigbd.clubmemberservice.service.Service;
import stigbd.clubmemberservice.service.ServiceDefault;

import java.util.logging.Logger;

public class MemberFactory {

    static final Logger logger = Logger.getLogger(MemberFactory.class.getName());
    private static final Service SERVICE_DEFAULT = new ServiceDefault();

    static public Member createMember(MemberRepresentation memberRepresentation) {
        Member member = new Member();

        member.setFirstName(memberRepresentation.getFirstName());
        member.setLastName(memberRepresentation.getLastName());
        member.setEmail(memberRepresentation.getEmail());
        member.setEmail2(memberRepresentation.getEmail2());
        member.setBirthDate(memberRepresentation.getBirthDate());
        member.setActive(memberRepresentation.getActive());
        member.setBirthDate(memberRepresentation.getBirthDate());
        member.setMemberSince(memberRepresentation.getMemberSince());
        member.setMobile(memberRepresentation.getMobile());
        member.setSex(memberRepresentation.getSex());

        if (memberRepresentation.getMainMember() != null) {
            //logger.log(Level.INFO, "mainMemberRep ->" + memberRepresentation.getMainMember());
            Member mainMember = SERVICE_DEFAULT.retrieveMember(memberRepresentation.getMainMember().getId());
            if (mainMember != null) {
                //logger.log(Level.INFO, "mainMember ->" + mainMember.getId());
                member.setMainMember(mainMember);
            } else {
                return null;
            }
        }

        if (memberRepresentation.getId() != null)
            member.setId(new ObjectId(memberRepresentation.getId()));

        return member;
    }
}
