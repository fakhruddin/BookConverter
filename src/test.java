import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.book.AuthorsType;


public class test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAuthorstype() {
		AuthorsType authr = new AuthorsType();
		List <String> at = new ArrayList<String>();
		at.add("asdf");
		at.add("asf");
		assertThat(at, authr.getAuthor());
		
	}

	private void assertThat(List<String> at, List<String> author) {
		// TODO Auto-generated method stub
		
		assertEquals(at, author);
		
	}

}
