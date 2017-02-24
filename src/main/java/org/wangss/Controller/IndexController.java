package org.wangss.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wangss on 2017/2/24.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        map.put("name", "FreeMarker");
        return "/index/index";
    }
}
