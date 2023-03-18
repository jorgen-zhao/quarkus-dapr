package io.quarkiverse.dapr.endpoint.actor;

import io.dapr.actors.runtime.ActorRuntime;
import io.vertx.ext.web.RoutingContext;

/**
 * ActorInvokeReminderHandler
 */
public class ActorInvokeReminderHandler extends AbstractDaprActorHandler {
    @Override
    public String subRoute() {
        return ":type/:id/method/remind/:reminder";
    }

    /**
     * Handles API to trigger an actor's reminder.
     *
     * @param event RoutingContext event
     * @return Void.
     */
    @Override
    protected void put(RoutingContext event) {
        String type = event.pathParam("type");
        String id = event.pathParam("id");
        String reminder = event.pathParam("reminder");
        byte[] body = event.getBody().getBytes();
        ActorRuntime.getInstance().invokeReminder(type, id, reminder, body).block();
    }
}
