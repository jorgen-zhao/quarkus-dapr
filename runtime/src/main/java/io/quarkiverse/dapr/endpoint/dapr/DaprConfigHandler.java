package io.quarkiverse.dapr.endpoint.dapr;

import java.io.IOException;

import io.dapr.actors.runtime.ActorRuntime;
import io.vertx.ext.web.RoutingContext;

/**
 * DaprConfigHandler
 */
public class DaprConfigHandler extends AbstractDaprHandler {

    @Override
    public String subRoute() {
        return "config";
    }

    /**
     * Returns Dapr's configuration for Actors.
     *
     * @return Actor's configuration.
     * @throws IOException If cannot generate configuration.
     */
    @Override
    protected void get(RoutingContext event) {
        event.json(ActorRuntime.getInstance().getConfig());
    }
}
