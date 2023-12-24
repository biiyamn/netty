package weather;

public interface WeatherEncoder {
    byte[] encode(WeatherDataPacket weatherDataPacket);
}
