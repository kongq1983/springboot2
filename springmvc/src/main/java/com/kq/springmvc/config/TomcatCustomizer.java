package com.kq.springmvc.config;

/**
 * Created by qikong on 2020/12/15.
 */
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class TomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    private static final Logger logger = LogManager.getLogger(TomcatCustomizer.class);

//    private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> {
            //AbstractHttp11Protocol protocol = (AbstractHttp11Protocol) connector.getProtocolHandler();
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();



            Runnable runnable = ()->{

                logger.info("####################################################################################");
                logger.info("#");
                logger.info("# TomcatCustomizer");
                logger.info("#");

                logger.info("# MaxConnections {}", protocol.getMaxConnections());
                logger.info("# AcceptorThreadCount {}", protocol.getAcceptorThreadCount());
                logger.info("# AcceptCount {}", protocol.getAcceptCount());

                logger.info("#");
                logger.info("# MaxThread {}", protocol.getMaxThreads());
                logger.info("# MinSpareThreads {}", protocol.getMinSpareThreads());
                logger.info("#");

                logger.info("# ConnectionTimeout {}", protocol.getConnectionTimeout());
                logger.info("# KeepAliveTimeout {}", protocol.getKeepAliveTimeout());
                logger.info("# MaxKeepAliveRequests {}", protocol.getMaxKeepAliveRequests());
                logger.info("#");

                logger.info("# Executor: {} ", protocol.getExecutor());
                logger.info("# getConnectionCount: {} ", protocol.getConnectionCount());

                //ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)protocol.getUtilityExecutor();

                // logger.info("# Executor: {} ", scheduledThreadPoolExecutor);
                // logger.info("# getMaximumPoolSize: {} ", scheduledThreadPoolExecutor.getMaximumPoolSize());
                // logger.info("# getMaximumPoolSize: {} ", scheduledThreadPoolExecutor.getActiveCount());
                // logger.info("#");

                logger.info("####################################################################################");

            };

//            scheduledExecutorService.scheduleAtFixedRate(runnable,0,30, TimeUnit.SECONDS);
//            protocol.getUtilityExecutor().scheduleAtFixedRate(runnable,0,30, TimeUnit.SECONDS);
            protocol.getUtilityExecutor().scheduleAtFixedRate(runnable,0,30, TimeUnit.MINUTES);

        });
    }
}
