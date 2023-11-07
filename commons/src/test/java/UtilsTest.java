import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/07 14:14
 **/
public class UtilsTest {
    @Test
    public void test1(){
        //获取当前路径
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
    }
}
