
//import static org.junit.Assert.*;

//import org.junit.Assert;
import org.junit.Before;
//import org.junit.Test;


import com.qa.persistence.repository.BlogDBRepository;

//import com.qa.util.JSONUtil;

public class AccountServiceTest {

//	private Blog service;
//	private JSONUtil util;
//	private BlogEndpoint endPoint;
	private BlogDBRepository blogDBRepo;

	@Before
	public void setup() {
		blogDBRepo = new BlogDBRepository();
		blogDBRepo.addAccount(
				"{\"id\":1,\"username\":\"gavinharris43\",\"firstName\":\"Gavin\",\"lastName\":\"Harris\",\"password\":\"password\",\"userLevel\":\"0\"}");
		blogDBRepo.addAccount(
				"{\"id\":2,\"username\":\"admin\",\"firstName\":\"Gavin\",\"lastName\":\"Harris\",\"password\":\"password\",\"userLevel\":\"1\"}");
		blogDBRepo.createBlog(
				"{\"id\":1,\"title\":\"Hello World\",\"username\":\"admin\",\"content\":\"Hello World TS\",\"date\":\"2019/01/01\",\"category\":\"TS\"}");
		blogDBRepo.createBlog(
				"{\"id\":2,\"title\":\"Hello World\",\"username\":\"admin\",\"content\":\"Hello World Guitar \",\"date\":\"2019/01/01\",\"category\":\"Guitar\"}");
	}

	// @Test
	// public void getAccounts() {
	// blogDBRepo.addAccount("{\"id\":1,\"username\":\"gavinharris43\",\"firstName\":\"Gavin\",\"lastName\":\"Harris\",\"password\":\"password\",\"userLevel\":\"0\"}");
	// assertEquals(blogDBRepo.getAllAccounts(),"[{\"id\":1,\"username\":\"gavinharris43\",\"firstName\":\"Gavin\",\"lastName\":\"Harris\",\"password\":\"password\",\"userLevel\":\"0\"},{\"id\":2,\"username\":\"admin\",\"firstName\":\"Gavin\",\"lastName\":\"Harris\",\"password\":\"password\",\"userLevel\":\"1\"}]");
	// }
	// @Test
	// public void getBlogs() {
	// assertEquals(blogDBRepo.getAllBlogs(),"[{\"id\":1,\"title\":\"Hello
	// World\",\"username\":\"admin\",\"content\":\"Hello World
	// TS\",\"date\":\"2019/01/01\",\"category\":\"TS\"},{\"id\":2,\"title\":\"Hello
	// World\",\"username\":\"admin\",\"content\":\"Hello World Guitar
	// \",\"date\":\"2019/01/01\",\"category\":\"Guitar\"}]");
	// }
}
