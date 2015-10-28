package stigbd.clubadmin.server.repository;

import junit.framework.TestCase;

public class RepositoryDefaultTest extends TestCase {
    private static Repository repository;

    public void setUp() throws Exception {
        super.setUp();
        repository = new RepositoryDefault();
    }

    public void tearDown() throws Exception {

    }

    public void testListMembers() throws Exception {
        assertNotNull(repository.listMembers());
    }

    public void testCreateMember() throws Exception {

    }

    public void testRetrieveMemberById() throws Exception {

    }
}