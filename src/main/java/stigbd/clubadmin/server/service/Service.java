/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.service;

import stigbd.clubadmin.server.domain.Member;
import stigbd.clubadmin.server.repository.Repository;

import java.util.ArrayList;

/**
 *
 * @author sbd
 */
public class Service {

    private static final Repository REPOSITORY = new Repository();

    public ArrayList<Member> listMembers() {
        return REPOSITORY.listMembers();
    }
    
    public Long createMember (Member member) {

        return REPOSITORY.createMember(member);
    }
    
    public Member retrieveMember(Long id) {

        return REPOSITORY.retrieveMember(id);
    }
    
}
