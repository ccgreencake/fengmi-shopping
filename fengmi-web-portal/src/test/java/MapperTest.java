import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldb.FengmiWebPortalApplication;
import com.ldb.mapper.CategoryMapper;
import com.ldb.mapper.ProductMapper;
import com.ldb.pojo.Category;
import com.ldb.pojo.MyPage;
import com.ldb.pojo.Product;
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
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void categoryTest() {
        List<Category> categories = categoryMapper.selectAllCategory();
        System.out.println(categories);
    }
    @Test
    public void productTest(){
        System.out.println(productMapper.selectIntroduct(10));
    }
    @Test
    public void productTest2(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id", 22);
        System.out.println(productMapper.selectList(queryWrapper));
    }
    @Test
    public void productTest3(){
        int pageNum = 1;
        int pageSize = 5;
        Page page = new Page(pageNum, pageSize);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("sold_num");
        queryWrapper.eq("category_id", 46);
        List<Product> products = productMapper.selectByCategoryId(46, 0, 5);
        productMapper.selectPage(page,queryWrapper);
        System.out.println(page.getRecords());
        page.setRecords(products);
        System.out.println(page);
    }
    @Test
    public void productTest4(){
        List<Product> products = productMapper.selectByCategoryId(46, 0, 5);
        System.out.println(products);
        productMapper.selectCount(null);
    }
}
