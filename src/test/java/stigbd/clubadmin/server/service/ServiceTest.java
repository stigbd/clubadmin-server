/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.service;

import org.junit.*;
import stigbd.clubadmin.server.domain.Member;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.listMembers();
        assertNotNull(result);
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
        Long expResult = (long) 1;
        Long result = instance.createMember(member);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveMember method, of class Service.
     */
    @Test
    public void testRetrieveMember() {
        System.out.println("retrieveMember");
        Long id = (long) 1;
        Service instance = new Service();
        Member result = instance.retrieveMember(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertTrue("Stig".equals(result.getFirstName()));
    }
    
}
