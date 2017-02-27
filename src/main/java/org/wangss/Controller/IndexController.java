package org.wangss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangss.Daos.BootUserDao;
import org.wangss.Models.BootUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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

    @Autowired
    private BootUserDao bootUserDao;

    @ResponseBody
    @RequestMapping("/index/user/{id}")
    public BootUser getBootUser(@PathVariable Long id) {
        return bootUserDao.getBootUserByid(id);
    }


    @RequestMapping(value = "/index/register", method = RequestMethod.POST)
    public String register(String username, String password, Map<String, Object> map) {
        BootUser bootUser = new BootUser(username, password);
        bootUserDao.save(bootUser);
        map.put("name", bootUser.getName());
        return "/index/succ";
    }

    @RequestMapping("/index/login")
    public String login(String username, String password, HttpServletRequest httpRequest) {
        List<BootUser> bootUsers = bootUserDao.getBootUserByname(username);
        for (BootUser b : bootUsers) {
            if (b.isPassWord(password)) {
                httpRequest.getSession().setAttribute("name", b.getName());
                httpRequest.getSession().setAttribute("id", b.getId());
                System.out.println(b.getName());
                return "/index/";
            }
        }
        return "/index/error";
    }
}
