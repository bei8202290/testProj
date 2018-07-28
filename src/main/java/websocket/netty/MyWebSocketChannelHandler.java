package websocket.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * @author ZLB
 * @Description:初始化连接时的各个组件
 * @date 2018/7/27
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel c) throws Exception {
        c.pipeline().addLast("http-codec", new HttpServerCodec())
                .addLast("aggregator", new HttpObjectAggregator(64*2024))
                .addLast("http-chunked", new ChunkedWriteHandler())
                .addLast("handler", new MyWebSocketHandler());
    }
}
