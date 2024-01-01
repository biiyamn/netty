package weather;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.ByteToMessageDecoder;

public class DecryptionHandler extends ChannelInboundHandlerAdapter {
    EncryptionService service=new DefaultEncryptionService();
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(service.decrypt((byte[]) msg));
    }
}
