import com.ldb.FengmiWebPortalApplication;
import com.ldb.mapper.CategoryMapper;
import com.ldb.pojo.ResultData;
import com.ldb.service.CategoryService;
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
    @Test
    public void categoryTest() {
        ResultData resultData = categoryService.selectAll();
        System.out.println(resultData);
    }
}
