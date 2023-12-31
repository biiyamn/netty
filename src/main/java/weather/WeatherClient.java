package weather;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class WeatherClient {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        WeatherClientHandler weatherClientHanlder = new WeatherClientHandler();

        Bootstrap bootstrap=new Bootstrap().group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new WeatherDataEncoder());
            }
        });
        ChannelFuture sync = bootstrap.connect("127.0.0.1", 5050).sync();
        sync.channel().writeAndFlush(new WeatherDataPacket("WC_100",true,new WeatherDataPacket.WeatherData(0L, 10.0F,10,0,0),1,1,"OK"));
        sync.channel().closeFuture().sync();
    }
}
