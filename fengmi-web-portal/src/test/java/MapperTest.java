import com.ldb.FengmiWebPortalApplication;
import com.ldb.mapper.CategoryMapper;
import com.ldb.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/09 16:24
 **/
@SpringBootTest(classes = FengmiWebPortalApplication.class)
public class MapperTest {
    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    public void categoryTest() {
        List<Category> categories = categoryMapper.selectAllCategory();
        System.out.println(categories);
    }
}
