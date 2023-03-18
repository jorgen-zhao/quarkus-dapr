package io.quarkiverse.dapr.endpoint.actor;

import io.dapr.actors.runtime.ActorRuntime;
import io.vertx.ext.web.RoutingContext;

/**
 * ActorInvokeMethodHandler
 */
public class ActorInvokeMethodHandler extends AbstractDaprActorHandler {
    @Override
    public String subRoute() {
        return ":type/:id/method/:method";
    }

    /**
     * Handles API to invoke an actor's method.
     *
     * @param event RoutingContext event.
     * @return Raw response body.
     */
    @Override
    protected void put(RoutingContext event) {
        String type = event.pathParam("type");
        String id = event.pathParam("id");
        String method = event.pathParam("method");
        byte[] body = event.getBody().getBytes();
        event.json(ActorRuntime.getInstance().invoke(type, id, method, body).block());
    }
}
