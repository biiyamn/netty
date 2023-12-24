package weather;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class WeatherDataDecoder extends ByteToMessageDecoder {
    private WeatherDecoder weatherDataDecoder=new DefaultWeatherDecoder();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // Adjust size as needed

        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);

        WeatherDataPacket packet = weatherDataDecoder.decode(bytes);
        out.add(packet);
    }
}
