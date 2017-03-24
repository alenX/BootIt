package org.wangss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangss.Daos.IBootUserMapper;
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

    @RequestMapping("/register")
    public String register(Map<String, Object> map) {
        return "/index/register";
    }

    @Autowired
    private IBootUserMapper bootUser;

    @ResponseBody
    @RequestMapping("/index/user/{id}")
    public BootUser getBootUser(@PathVariable Long id) {
        return bootUser.getBootUserByid(id);
    }


    @RequestMapping(value = "/index/register", method = RequestMethod.POST)
    public String register(String username, String password, Map<String, Object> map) {
        BootUser bootUser = new BootUser(username, password);
//        IBootUserMapper.save(bootUser);
        map.put("name", bootUser.getName());
        return "/index/succ";
    }

    @ResponseBody
    @RequestMapping(value = "/index/register/check_user_name", method = RequestMethod.POST)
    public Object check_user_name(String username , Map<String, Object> map) {
        List<BootUser> bootUsers = bootUser.getBootUserByname(username);
        if (bootUsers.size()>0){
           map.put("succ",true);
        }else{
            map.put("succ",false);
        }
        return map;
    }

    @RequestMapping("/index/login")
    public String login(String username, String password, HttpServletRequest httpRequest) {
        List<BootUser> bootUsers = bootUser.getBootUserByname(username);
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

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
