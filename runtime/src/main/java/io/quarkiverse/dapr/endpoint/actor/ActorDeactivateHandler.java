package io.quarkiverse.dapr.endpoint.actor;

import io.dapr.actors.runtime.ActorRuntime;
import io.vertx.ext.web.RoutingContext;

/**
 * ActorDeactivateHandler
 */
public class ActorDeactivateHandler extends AbstractDaprActorHandler {
    @Override
    public String subRoute() {
        return ":type/:id";
    }

    /**
     * Handles API to deactivate an actor.
     *
     * @param event
     * @return Void.
     */
    @Override
    protected void delete(RoutingContext event) {
        String type = event.pathParam("type");
        String id = event.pathParam("id");
        ActorRuntime.getInstance().deactivate(type, id).block();
    }
}
