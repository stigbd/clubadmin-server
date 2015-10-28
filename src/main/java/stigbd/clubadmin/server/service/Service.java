/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.service;

import stigbd.clubadmin.server.domain.Member;
import stigbd.clubadmin.server.repository.Repository;

import java.util.List;

/**
 *
 * @author sbd
 */
public class Service {

    private static Repository REPOSITORY;

    public static void setREPOSITORY(Repository r) {
        REPOSITORY = r;
    }


    public List<Member> listMembers() {
        return REPOSITORY.listMembers();
    }

    public String createMember(Member member) {

        return REPOSITORY.createMember(member);
    }

    public Member retrieveMember(String id) {

        return REPOSITORY.retrieveMemberById(id);
    }
    
}
