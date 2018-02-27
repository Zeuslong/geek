import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import studio.geek.util.JsonUtil;
import studio.geek.util.Result;

/**
 * @author 凌龙
 * @version 2017/2/22.
 */
public class RESTTest {



    @Test
    public void testGetForObject(){
        System.out.println("00000");
        RestTemplate rest = new RestTemplate();
        System.out.println("1111");
//        JsonUtil.prettyPrint(rest.getForObject("http://127.0.0.1/home/allProductions", Result.class));
        Result result = rest.getForObject("http://127.0.0.1/home/allProductions", Result.class);
        System.out.println("222");
        JsonUtil.prettyPrint(result);
    }

}
