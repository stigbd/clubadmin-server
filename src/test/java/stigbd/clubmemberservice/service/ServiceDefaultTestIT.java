package stigbd.clubmemberservice.service;

import org.bson.types.ObjectId;
import org.junit.*;
import stigbd.clubmemberservice.domain.Member;
import stigbd.clubmemberservice.repository.Repository;
import stigbd.clubmemberservice.repository.RepositoryMock;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceDefaultTestIT {
    static Repository repository;

    public ServiceDefaultTestIT() {
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
     * Test of listMembers method, of class ServiceDefault.
     */
    @Test
    public void testListMembers() {
        System.out.println("listMembers");
        ServiceDefault instance = new ServiceDefault();
        List<Member> expResult = null;
        List<Member> result = instance.listMembers();
        assertNotNull(result);
    }

    /**
     * Test of createMember method, of class ServiceDefault.
     */
    @Test
    public void testCreateMember() {
        System.out.println("createMember");
        Member member = new Member();
        member.setFirstName("Stig");
        ServiceDefault instance = new ServiceDefault();
        String result = instance.createMember(member);
        assertNotNull(result);
    }

    /**
     * Test of retrieveMember method, of class ServiceDefault.
     */
    @Test
    public void testRetrieveMember() {
        System.out.println("retrieveMember");
        ServiceDefault instance = new ServiceDefault();
        Member m = testMember();
        instance.createMember(m);
        Member result = instance.retrieveMember(m.getId().toString());
        assertNotNull(result);
        assertEquals(m.getId(), result.getId());
        assertTrue("Stig".equals(result.getFirstName()));
    }

    private static Member testMember() {
        Member m = new Member();
        m.setId(new ObjectId());
        m.setFirstName("Stig");
        return m;
    }
}
