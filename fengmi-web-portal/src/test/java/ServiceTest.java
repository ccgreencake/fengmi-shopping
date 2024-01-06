import com.ldb.FengmiWebPortalApplication;
import com.ldb.mapper.CategoryMapper;
import com.ldb.pojo.ResultData;
import com.ldb.pojo.Users;
import com.ldb.service.CategoryService;
import com.ldb.service.IndexImgService;
import com.ldb.service.ProductService;
import com.ldb.service.UsersService;
import com.ldb.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/11 21:40
 **/
@SpringBootTest(classes = FengmiWebPortalApplication.class)
public class ServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IndexImgService indexImgService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;
    @Test
    public void categoryTest() {
        ResultData resultData = categoryService.selectAll();
        System.out.println(resultData);
    }
    @Test
    public void indexImgTest(){
        ResultData indexImg = indexImgService.getIndexImg();
        System.out.println(indexImg);
    }
    @Test
    public void productDetailTest(){
        ResultData productDetail = productService.getDetail(3);
        System.out.println(productDetail);
    }
    @Test
    public void usersLoginTest(){
        Users users = new Users();
        users.setUsername("aaaa");
        users.setPassword("123123");
        ResultData resultData = usersService.login(users);
        System.out.println(resultData);
    }
    @Test
    public void JsonTest(){
        Users users = new Users();
        users.setUsername("aaaa");
        users.setPassword("123123");
        users.setToken("eyJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjoie1widXNlcklkXCI6bnVsbCxcInVzZXJuYW1lXCI6XCJhYWFhXCIsXCJwYXNzd29yZFwiOlwiXCIsXCJuaWNrbmFtZVwiOm51bGwsXCJyZWFsbmFtZVwiOm51bGwsXCJ1c2VySW1nXCI6bnVsbCxcInVzZXJNb2JpbGVcIjpudWxsLFwidXNlckVtYWlsXCI6bnVsbCxcInVzZXJTZXhcIjpudWxsLFwidXNlckJpcnRoXCI6bnVsbCxcInVzZXJSZWd0aW1lXCI6bnVsbCxcInVzZXJNb2R0aW1lXCI6bnVsbH0iLCJqdGkiOiJNVGt4TTJReVl6TXRaRGt5TlMwME1UZ3dMVGhsWVdJdFlXSTBZVFkwTnpVelpHSXgiLCJleHAiOjE3MDQyMTQ2OTV9.MhAN5jF0TcgB9ZSR6CESgK_hvhX2iKzhX1Fa2jyp_nGAtZqCpyvN5hDSk5lV3yaQ_-yiyAlN6MQUX8HnHxyqx9p6kqs0NTuNUgubZikGtFQC1ex2ZTpKLDOvsrMaBsCT-Smi1bvwWeUzkbhmaxUGlx_vGtjxcuGNnQCFJlrjmygXl1cU0nxXc0flosxr4atDIhZiMg18txKUlbEs2l9rJms2B6kZtY6AmgTu5D3ogqfBOzgBLlLOiIh3j--dRYmjRnoJyQaVo4PGGLr4-Db-EqyBi1woJWMOBA_bDx9bvwYeznzKayMXZsdwRpun9JIs95b4iQq9nVLH9Fm3KG36Vw");
        String s = JsonUtils.toString(users);
        System.out.println(s);
        Users users1 = JsonUtils.toBean(s, Users.class);
        System.out.println(users1);
    }

}
