/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.service;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import stigbd.clubadmin.domain.Member;

/**
 *
 * @author sbd
 */
public class ServiceTest {
    
    public ServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listMembers method, of class Service.
     */
    @Test
    public void testListMembers() {
        System.out.println("listMembers");
        Service instance = new Service();
        HashMap<Long, Member> expResult = null;
        HashMap<Long, Member> result = instance.listMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMember method, of class Service.
     */
    @Test
    public void testCreateMember() {
        System.out.println("createMember");
        Member member = new Member();
        member.setFirstName("Stig");
        Service instance = new Service();
        Long expResult = null;
        Long result = instance.createMember(member);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveMember method, of class Service.
     */
    @Test
    public void testRetrieveMember() {
        System.out.println("retrieveMember");
        Long id = null;
        Service instance = new Service();
        Member expResult = null;
        Member result = instance.retrieveMember(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
