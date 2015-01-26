/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.service;

import java.util.HashMap;
import stigbd.clubadmin.domain.Member;

/**
 *
 * @author sbd
 */
public class Service {
    
    public HashMap<Long, Member> listMembers() {
        return new HashMap<Long, Member> ();
    }
    
    public Long createMember (Member member) {
        return new Long(12);
    }
    
    public Member retrieveMember(Long id) {
        if (id == 12) {
            Member m = new Member();
        m.setFirstName("Stig B.");
        m.setLastName("Dørmænen");
            return m;
        }
        return null;
    }
    
}
