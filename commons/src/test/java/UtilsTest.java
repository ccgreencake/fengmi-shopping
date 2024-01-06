import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ldb.utils.JsonUtils;
import com.ldb.utils.JwtUtils;
import com.ldb.utils.RsaUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;
import springfox.documentation.spring.web.json.Json;

import java.io.FileNotFoundException;
import java.security.PrivateKey;
import java.security.PublicKey;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    @Test
    public void testJwt() throws InterruptedException {
        //生成JWT令牌
        //创建Builder对象
        JWTCreator.Builder builder = JWT.create();
        //设置token生成的时间
        builder.withIssuedAt(new Date());
                //设置用户的角色权限信息。参数信息可以是map集合
        builder.withClaim("username","zhangsan");
        builder.withClaim("role","ROLE_user,ROLE_manager");
        //设置token的有效时间
        builder.withExpiresAt(new Date(System.currentTimeMillis()+5000));
        //生成token
        String token = builder.sign(Algorithm.HMAC256("qfjava"));
        System.out.println(token);
        //模拟token过期（休眠6000）
        //Thread.sleep(6000);
        //出现token过期异常TokenExpiredException
        //校验token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("qfjava")).build();
        DecodedJWT verify = jwtVerifier.verify(token);
        //获取token令牌中的信息
        System.out.println(verify.getClaim("username").asString());
        System.out.println(verify.getClaim("role").asString());

    }
    @Test
    public void testPublicKeyAndPrivateKey() throws Exception {
//使用工具类生成公钥和私钥（确保路径存在）
        String privateKeyFileName = "../commons/src/main/resources/rsa.pri";
        String publicKeyFileName = "../commons/src/main/resources/rsa.pub";
        RsaUtils.generateKey(publicKeyFileName,privateKeyFileName,"qfjava",2048);
    }
    @Test
    public void testValidatePublicKeyAndPrivateKey() throws Exception {
        //私钥加密，公钥解密
        //获取私钥文件路径
        String privateFile = ResourceUtils.getFile("classpath:key/rsa.pri").getPath();
        //获取私钥对象
        PrivateKey privateKey = RsaUtils.getPrivateKey(privateFile);
        //生成Token
        HashMap map = new HashMap();
        map.put("username","zhangsan");
        map.put("role","ROLE_admin,ROLE_user");
        String token = JwtUtils.generateTokenExpireInSeconds(map, privateKey, 10);
        //获取公钥文件路径
        String publicFile = ResourceUtils.getFile("classpath:key/rsa.pub").getPath();
        //获取公钥对象
        PublicKey publicKey = RsaUtils.getPublicKey(publicFile);
        Map infoFromToken = (Map) JwtUtils.getInfoFromToken(token, publicKey,
                Map.class);
        System.out.println(infoFromToken.get("username"));
        System.out.println(infoFromToken.get("role"));
    }
    @Test
    public void testMd5(){
        String s = DigestUtils.md5DigestAsHex("123123".getBytes());
        System.out.println(s);
    }
}
