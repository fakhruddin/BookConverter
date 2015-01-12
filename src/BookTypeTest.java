import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.book.AuthorsType;
import com.book.BookType;


public class BookTypeTest {

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
	public void test() {
		AuthorsType at = new AuthorsType();
		List<String> aufList = new ArrayList<String>();
		
		aufList.add("sdf");
		aufList.add("aasddd");
		at.setAuthorList(aufList);
		BookType btype = new BookType();
		btype.setAuthors(at);
		btype.setName("rio");
		btype.setPublisheddate("asd");
		assertEquals(aufList, btype.getAuthors().getAuthor());
	}

}
