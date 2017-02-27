package org.wangss.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by wangss on 2017/2/27.
 */

@Configuration
@EnableRedisHttpSession
public class RedisConfig {

    @Bean
    public JedisConnectionFactory connectionFactory(){
        return new JedisConnectionFactory();
    }

    /*security*/
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
