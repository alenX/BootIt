package org.wangss.Config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by wangss on 2017/2/27.
 */
public class HttpSessionInitializer extends AbstractHttpSessionApplicationInitializer {

     public HttpSessionInitializer(){
         super(RedisConfig.class);
     }
}
