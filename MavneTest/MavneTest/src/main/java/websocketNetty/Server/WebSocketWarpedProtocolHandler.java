package websocketNetty.Server;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.AttributeKey;

import java.util.List;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import static io.netty.util.internal.ObjectUtil.checkNotNull;

public class WebSocketWarpedProtocolHandler  {
//    static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = 10000L;
//    /**
//     * Events that are fired to notify about handshake status
//     */
//    public enum ServerHandshakeStateEvent {
//        /**
//         * The Handshake was completed successfully and the channel was upgraded to websockets.
//         *
//         * @deprecated in favor of {@link WebSocketServerProtocolHandler.HandshakeComplete} class,
//         * it provides extra information about the handshake
//         */
//        @Deprecated
//        HANDSHAKE_COMPLETE,
//
//        /**
//         * The Handshake was timed out
//         */
//        HANDSHAKE_TIMEOUT
//    }
//
//    /**
//     * The Handshake was completed successfully and the channel was upgraded to websockets.
//     */
//    public static final class HandshakeComplete {
//        private final String requestUri;
//        private final HttpHeaders requestHeaders;
//        private final String selectedSubprotocol;
//
//        HandshakeComplete(String requestUri, HttpHeaders requestHeaders, String selectedSubprotocol) {
//            this.requestUri = requestUri;
//            this.requestHeaders = requestHeaders;
//            this.selectedSubprotocol = selectedSubprotocol;
//        }
//
//        public String requestUri() {
//            return requestUri;
//        }
//
//        public HttpHeaders requestHeaders() {
//            return requestHeaders;
//        }
//
//        public String selectedSubprotocol() {
//            return selectedSubprotocol;
//        }
//    }
//
//    private static final AttributeKey<WebSocketServerHandshaker> HANDSHAKER_ATTR_KEY =
//            AttributeKey.valueOf(WebSocketServerHandshaker.class, "HANDSHAKER");
//
//    private final WebSocketServerProtocolConfig serverConfig;
//
//    /**
//     * Base constructor
//     *
//     * @param serverConfig
//     *            Server protocol configuration.
//     */
//    public WebSocketWarpedProtocolHandler(WebSocketServerProtocolConfig serverConfig) {
//        super(WebSocketServerProtocolHandler(serverConfig));
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath) {
//        this(websocketPath, DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, long handshakeTimeoutMillis) {
//        this(websocketPath, false, handshakeTimeoutMillis);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, boolean checkStartsWith) {
//        this(websocketPath, checkStartsWith, DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, boolean checkStartsWith, long handshakeTimeoutMillis) {
//        this(websocketPath, null, false, 65536, false, checkStartsWith, handshakeTimeoutMillis);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols) {
//        this(websocketPath, subprotocols, DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols, long handshakeTimeoutMillis) {
//        this(websocketPath, subprotocols, false, handshakeTimeoutMillis);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols, boolean allowExtensions) {
//        this(websocketPath, subprotocols, allowExtensions, DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols, boolean allowExtensions,
//                                          long handshakeTimeoutMillis) {
//        this(websocketPath, subprotocols, allowExtensions, 65536, handshakeTimeoutMillis);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols,
//                                          boolean allowExtensions, int maxFrameSize) {
//        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols,
//                                          boolean allowExtensions, int maxFrameSize, long handshakeTimeoutMillis) {
//        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, false, handshakeTimeoutMillis);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols,
//                                          boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch) {
//        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, allowMaskMismatch,
//                DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols, boolean allowExtensions,
//                                          int maxFrameSize, boolean allowMaskMismatch, long handshakeTimeoutMillis) {
//        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, allowMaskMismatch, false,
//                handshakeTimeoutMillis);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols,
//                                          boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch, boolean checkStartsWith) {
//        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, allowMaskMismatch, checkStartsWith,
//                DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols,
//                                          boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch,
//                                          boolean checkStartsWith, long handshakeTimeoutMillis) {
//        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, allowMaskMismatch, checkStartsWith, true,
//                handshakeTimeoutMillis);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols,
//                                          boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch,
//                                          boolean checkStartsWith, boolean dropPongFrames) {
//        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, allowMaskMismatch, checkStartsWith,
//                dropPongFrames, DEFAULT_HANDSHAKE_TIMEOUT_MILLIS);
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols, boolean allowExtensions,
//                                          int maxFrameSize, boolean allowMaskMismatch, boolean checkStartsWith,
//                                          boolean dropPongFrames, long handshakeTimeoutMillis) {
//        this(websocketPath, subprotocols, checkStartsWith, dropPongFrames, handshakeTimeoutMillis,
//                WebSocketDecoderConfig.newBuilder()
//                        .maxFramePayloadLength(maxFrameSize)
//                        .allowMaskMismatch(allowMaskMismatch)
//                        .allowExtensions(allowExtensions)
//                        .build());
//    }
//
//    public WebSocketWarpedProtocolHandler(String websocketPath, String subprotocols, boolean checkStartsWith,
//                                          boolean dropPongFrames, long handshakeTimeoutMillis,
//                                          WebSocketDecoderConfig decoderConfig) {
//        this(WebSocketServerProtocolConfig.newBuilder()
//                .websocketPath(websocketPath)
//                .subprotocols(subprotocols)
//                .checkStartsWith(checkStartsWith)
//                .handshakeTimeoutMillis(handshakeTimeoutMillis)
//                .dropPongFrames(dropPongFrames)
//                .decoderConfig(decoderConfig)
//                .build());
//    }
//
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) {
//        ChannelPipeline cp = ctx.pipeline();
//        if (cp.get(WebSocketServerProtocolHandshakeHandler.class) == null) {
//            // Add the WebSocketHandshakeHandler before this one.
//            cp.addBefore(ctx.name(), WebSocketServerProtocolHandshakeHandler.class.getName(),
//                    new WebSocketServerProtocolHandshakeHandler(serverConfig));
//        }
//        if (serverConfig.decoderConfig().withUTF8Validator() && cp.get(Utf8FrameValidator.class) == null) {
//            // Add the UFT8 checking before this one.
//            cp.addBefore(ctx.name(), Utf8FrameValidator.class.getName(),
//                    new Utf8FrameValidator());
//        }
//    }

}
