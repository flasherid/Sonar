package com.lambdaworks.redis;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import io.netty.util.internal.ConcurrentSet;

/**
 * Close Events Facility. Can register/unregister CloseListener and fire a closed event to all registered listeners.
 * 
 * @author Mark Paluch
 * @since 3.0
 */
public class ConnectionEvents {
    private final Set<RedisConnectionStateListener> listeners = new ConcurrentSet<>();

    protected void fireEventRedisConnected(RedisChannelHandler<?, ?> connection) {
        for (RedisConnectionStateListener listener : listeners) {
            listener.onRedisConnected(connection);
        }
    }

    protected void fireEventRedisDisconnected(RedisChannelHandler<?, ?> connection) {
        for (RedisConnectionStateListener listener : listeners) {
            listener.onRedisDisconnected(connection);
        }
    }

    protected void fireEventRedisExceptionCaught(RedisChannelHandler<?, ?> connection, Throwable cause) {
        for (RedisConnectionStateListener listener : listeners) {
            listener.onRedisExceptionCaught(connection, cause);
        }
    }

    public void addListener(RedisConnectionStateListener listener) {
        listeners.add(listener);
    }

    public void removeListener(RedisConnectionStateListener listener) {
        listeners.remove(listener);
    }

    /**
     * Internal event before a channel is closed.
     */
    public static class PrepareClose {
        private CompletableFuture<Boolean> prepareCloseFuture = new CompletableFuture<>();

        public CompletableFuture<Boolean> getPrepareCloseFuture() {
            return prepareCloseFuture;
        }
    }

    /**
     * Internal event when a channel is closed.
     */
    public static class Close {
    }

    /**
     * Internal event when a channel is activated.
     */
    public static class Activated {
    }

}
