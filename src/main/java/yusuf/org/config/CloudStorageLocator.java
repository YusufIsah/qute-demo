package yusuf.org.config;

import io.quarkus.qute.TemplateLocator;
import io.quarkus.qute.Variant;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class CloudStorageLocator implements TemplateLocator {

    private static final Logger log = Logger.getLogger(CloudStorageLocator.class);

    @Override
    public Optional<TemplateLocation> locate(String s) {

        try {
            Path found = Paths.get(s);
            final byte[] content = Files.readAllBytes(found);
            return Optional.of(new TemplateLocation() {
                public Reader read() {
                    return new StringReader(new String(content, StandardCharsets.UTF_8));
                }

                public Optional<Variant> getVariant() {
                    return Optional.empty();
                }
            });
        } catch (IOException var4) {
            log.warn("Unable to read the template from path: " + s, var4);
            return Optional.empty();
        }
    }

}
