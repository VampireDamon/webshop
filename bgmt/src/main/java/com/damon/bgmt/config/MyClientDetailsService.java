package com.damon.bgmt.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

/**
 * 客户端程序扩展，支持自定义业务字段
 *
 * @author
 */
@Service("myClientDetailService")
public class MyClientDetailsService extends JdbcClientDetailsService {
    private static final Log logger = LogFactory.getLog(MyClientDetailsService.class);

    public MyClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        ClientDetails details;
        details = super.loadClientByClientId(clientId);
        logger.debug("客户端登录："+clientId);
        if(details!=null){
            logger.debug("客户端登录获取成功！");
        }else{
            logger.debug("客户端登录获取失败！");
        }
        return details;
    }

}
