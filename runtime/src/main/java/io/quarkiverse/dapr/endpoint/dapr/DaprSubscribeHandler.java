package io.quarkiverse.dapr.endpoint.dapr;

import java.io.IOException;

import io.quarkiverse.dapr.core.DaprRuntime;
import io.vertx.ext.web.RoutingContext;

/**
 * DaprSubscribeHandler
 */
public class DaprSubscribeHandler extends AbstractDaprHandler {

    @Override
    public String subRoute() {
        return "subscribe";
    }

    /**
     * Returns the list of subscribed topics.
     *
     * @return List of subscribed topics.
     * @throws IOException If cannot generate list of topics.
     */
    @Override
    protected void get(RoutingContext event) {
        event.json(DaprRuntime.getInstance().listSubscribedTopics());
    }
}
