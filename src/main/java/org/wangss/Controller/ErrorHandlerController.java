package org.wangss.Controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangss on 2017/2/27.
 */
@Controller
@RequestMapping(value = "error")
public class ErrorHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/home/error";
    }

    @RequestMapping
    public String getErrPage(){
        return getErrorPath();
    }
}
