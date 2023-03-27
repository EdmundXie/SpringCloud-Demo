package cn.itcast.feign.fallback;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Projectname: cloud-demo
 * @Filename: UserClientFallbackFactory
 * @Author: EdmundXie
 * @Data:2023/3/26 18:34
 * @Email: 609031809@qq.com
 * @Description:
 */
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
                log.error("查询用户异常",throwable);
                return new User();
            }
        };
    }
}
