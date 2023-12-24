package weather;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DefaultWeatherDecoder implements WeatherDecoder {
    @Override
    public WeatherDataPacket decode(byte[] data) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             DataInputStream dis = new DataInputStream(bais)) {

            WeatherDataPacket packet = new WeatherDataPacket();

            packet.setVersion(dis.readInt());
            packet.setLength(dis.readInt());

            byte[] deviceIdBytes = new byte[6]; // Adjust size as needed
            dis.readFully(deviceIdBytes);
            packet.setDeviceId(new String(deviceIdBytes, StandardCharsets.UTF_8).trim());

            packet.setTimestamp(dis.readLong());

            packet.setEncrypted(dis.readBoolean());
            packet.setChecksum(dis.readInt());

            // Deserialize weather data
            WeatherDataPacket.WeatherData weatherData = new WeatherDataPacket.WeatherData();
            weatherData.setTimestamp(dis.readLong());
            weatherData.setTemperature(dis.readFloat());
            weatherData.setHumidity(dis.readInt());
            weatherData.setWindSpeed(dis.readInt());
            weatherData.setPressure(dis.readInt());

            packet.setWeatherData(weatherData);

            packet.setBatteryLevel(dis.readInt());
            packet.setSignalStrength(dis.readInt());

            byte[] statusBytes = new byte[2]; // Adjust size as needed
            dis.readFully(statusBytes);
            packet.setDeviceStatus(new String(statusBytes, StandardCharsets.UTF_8).trim());

            return packet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}