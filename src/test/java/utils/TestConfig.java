package utils;

import io.github.cdimascio.dotenv.Dotenv;

public final class TestConfig {

    private static final Dotenv DOTENV = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private TestConfig() {
    }

    public static String get(String key) {
        String value = DOTENV.get(key, System.getenv(key));

        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required environment variable: " + key);
        }

        return value;
    }
}