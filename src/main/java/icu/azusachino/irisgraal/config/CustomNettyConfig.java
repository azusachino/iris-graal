package icu.azusachino.irisgraal.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import icu.azusachino.irisgraal.handler.HeartbeatHandler;
import reactor.netty.ConnectionObserver;

/**
 * Custom Netty Customizer
 */
@Configuration
public class CustomNettyConfig implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory>, Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
        // add heartbeat obverserver
        factory.addServerCustomizers(httpServer -> httpServer.childObserve(
                (connection, state) -> {
                    if (state == ConnectionObserver.State.CONNECTED) {
                        connection.addHandlerFirst("heartbeat", new HeartbeatHandler());
                    }
                }));
    }

}
