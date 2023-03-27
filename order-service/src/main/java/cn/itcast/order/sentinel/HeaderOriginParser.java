package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Projectname: cloud-demo
 * @Filename: HeaderOriginParser
 * @Author: EdmundXie
 * @Data:2023/3/27 12:00
 * @Email: 609031809@qq.com
 * @Description:
 */
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        //1.获取请求头
        String header = httpServletRequest.getHeader("origin");
        if(StringUtils.isEmpty(header)){
            header = "blank";
        }
        return header;
    }
}
