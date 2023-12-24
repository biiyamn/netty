package weather;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class WeatherDataEncoder extends MessageToByteEncoder<WeatherDataPacket> {
    private WeatherEncoder weatherDataEncoder=new DefaultWeatherEncoder();
    @Override
    protected void encode(ChannelHandlerContext ctx, WeatherDataPacket msg, ByteBuf out) throws Exception {
        out.writeBytes(weatherDataEncoder.encode(msg));  // Use the previously defined encode method
    }
}
