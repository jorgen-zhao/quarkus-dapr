package io.quarkiverse.dapr.endpoint.actor;

import io.dapr.actors.runtime.ActorRuntime;
import io.vertx.ext.web.RoutingContext;

/**
 * ActorInvokeTimerHandler
 */
public class ActorInvokeTimerHandler extends AbstractDaprActorHandler {
    @Override
    public String subRoute() {
        return ":type/:id/method/timer/:timer";
    }

    /**
     * Handles API to trigger an actor's timer.
     *
     * @param event RoutingContext event
     * @return Void.
     */
    @Override
    protected void put(RoutingContext event) {
        String type = event.pathParam("type");
        String id = event.pathParam("id");
        String timer = event.pathParam("timer");
        byte[] body = event.getBody().getBytes();
        event.json(ActorRuntime.getInstance().invokeTimer(type, id, timer, body).block());
    }
}
