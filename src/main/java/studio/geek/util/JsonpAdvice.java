package studio.geek.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @author 凌龙
 * @version 2017/3/9.
 */

@ControllerAdvice(basePackages ="studio.geek.action.home")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{
    public JsonpAdvice(){
        super("callback","jsonp");
    }
}
