package org.keycloak.config;

public enum OptionCategory {
    // ordered by name asc
    CACHE("Cache", 10, ConfigSupportLevel.SUPPORTED),
    DATABASE("Database", 20, ConfigSupportLevel.SUPPORTED),
    TRANSACTION("Transaction",30, ConfigSupportLevel.SUPPORTED),
    FEATURE("Feature", 40, ConfigSupportLevel.SUPPORTED),
    HOSTNAME("Hostname", 50, ConfigSupportLevel.SUPPORTED),
    HTTP("HTTP(S)", 60, ConfigSupportLevel.SUPPORTED),
    HEALTH("Health", 70, ConfigSupportLevel.SUPPORTED),
    CONFIG("Config", 75, ConfigSupportLevel.SUPPORTED),
    METRICS("Metrics", 80, ConfigSupportLevel.SUPPORTED),
    PROXY("Proxy", 90, ConfigSupportLevel.SUPPORTED),
    VAULT("Vault", 100, ConfigSupportLevel.SUPPORTED),
    LOGGING("Logging", 110, ConfigSupportLevel.SUPPORTED),
    TRUSTSTORE("Truststore", 115, ConfigSupportLevel.SUPPORTED),
    SECURITY("Security", 120, ConfigSupportLevel.SUPPORTED),
    EXPORT("Export", 130, ConfigSupportLevel.SUPPORTED),
    IMPORT("Import", 140, ConfigSupportLevel.SUPPORTED),
    OPENAPI("OpenAPI", 150, ConfigSupportLevel.SUPPORTED),
    GENERAL("General", 999, ConfigSupportLevel.SUPPORTED);

    private final String heading;
    //Categories with a lower number are shown before groups with a higher number
    private final int order;
    private final ConfigSupportLevel supportLevel;

    OptionCategory(String heading, int order, ConfigSupportLevel supportLevel) {
        this.order = order;
        this.supportLevel = supportLevel;
        this.heading = getHeadingBySupportLevel(heading);
    }

    public String getHeading() {
        return this.heading;
    }

    public int getOrder() {
        return this.order;
    }

    public ConfigSupportLevel getSupportLevel() {
        return this.supportLevel;
    }

    private String getHeadingBySupportLevel(String heading) {
        if (this.supportLevel.equals(ConfigSupportLevel.EXPERIMENTAL)){
            heading = heading + " (Experimental)";
        }

        if (this.supportLevel.equals(ConfigSupportLevel.PREVIEW)){
            heading = heading + " (Preview)";
        }

        return heading;
    }
}
