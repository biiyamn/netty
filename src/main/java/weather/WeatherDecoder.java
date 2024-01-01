package weather;

public interface WeatherDecoder {
    WeatherHeaderPacket decodeHeader(byte[] data);
    WeatherDataPacket decodeData(byte[] data);
}
