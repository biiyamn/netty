package weather;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DefaultWeatherEncoder implements WeatherEncoder{
    @Override
    public byte[] encode(WeatherDataPacket packet) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(baos)) {

            dos.writeInt(packet.getVersion());
            dos.writeInt(packet.getLength());
            dos.write(packet.getDeviceId().getBytes(StandardCharsets.UTF_8));

            // Serialize the timestamp as a long (epoch milliseconds)
            dos.writeLong(packet.getTimestamp());

            dos.writeBoolean(packet.isEncrypted());
            dos.writeInt(packet.getChecksum());

            // Serialize weather data
            // Assuming you have getter methods to retrieve these values
            dos.writeLong(packet.getWeatherData().getTimestamp());
            dos.writeFloat(packet.getWeatherData().getTemperature());
            dos.writeInt(packet.getWeatherData().getHumidity());
            dos.writeInt(packet.getWeatherData().getWindSpeed());
            dos.writeInt(packet.getWeatherData().getPressure());

            dos.writeInt(packet.getBatteryLevel());
            dos.writeInt(packet.getSignalStrength());
            dos.write(packet.getDeviceStatus().getBytes(StandardCharsets.UTF_8));

            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
