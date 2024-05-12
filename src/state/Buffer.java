package state;
import java.nio.file.Path;
public class Buffer {
    public Path path;
    public boolean dirty = false;

    public Buffer(String path) {
        this.path = Path.of(path);
    }
}
