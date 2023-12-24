package weather;

public interface WeatherDecoder {
    WeatherDataPacket decode(byte[] data);
}
