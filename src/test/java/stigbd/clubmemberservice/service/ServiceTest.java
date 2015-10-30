/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubmemberservice.service;

import org.bson.types.ObjectId;
import org.junit.*;
import stigbd.clubmemberservice.domain.Member;
import stigbd.clubmemberservice.repository.Repository;
import stigbd.clubmemberservice.repository.RepositoryMock;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author sbd
 */
public class ServiceTest {
    static Repository repository;

    public ServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        repository = new RepositoryMock();
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
        Service.setREPOSITORY(repository);
        List<Member> expResult = null;
        List<Member> result = instance.listMembers();
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
        Service.setREPOSITORY(repository);
        String result = instance.createMember(member);
        assertNotNull(result);
    }

    /**
     * Test of retrieveMember method, of class Service.
     */
    @Test
    public void testRetrieveMember() {
        System.out.println("retrieveMember");
        Service instance = new Service();
        Service.setREPOSITORY(repository);
        Member m = testMember();
        instance.createMember(m);
        Member result = instance.retrieveMember(m.getId());
        assertNotNull(result);
        assertEquals(m.getId(), result.getId());
        assertTrue("Stig".equals(result.getFirstName()));
    }

    private static Member testMember() {
        Member m = new Member();
        m.setId(new ObjectId().toString());
        m.setFirstName("Stig");
        return m;
    }
}
