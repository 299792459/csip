package com.csi.csi_demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/25 0025
 * @since 1.0.0
 */

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //配置内存中的 用户名、密码和角色
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("user").password("123456").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("123456").roles("ADMIN","USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/login").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/dept/**").hasRole("USER") //访问 /user这个接口，需要有USER角色
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated() //剩余的其他接口，登录之后就能访问
                .and();
                //.formLogin().defaultSuccessUrl("/loginmain");


    }
}
