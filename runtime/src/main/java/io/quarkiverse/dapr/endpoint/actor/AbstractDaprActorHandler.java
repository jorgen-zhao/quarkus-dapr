package io.quarkiverse.dapr.endpoint.actor;

import io.quarkiverse.dapr.endpoint.dapr.AbstractDaprHandler;

/**
 * AbstractDaprActorHandler
 */
public abstract class AbstractDaprActorHandler extends AbstractDaprHandler {

    @Override
    public String baseRoute() {
        return "/actors";
    }

}
