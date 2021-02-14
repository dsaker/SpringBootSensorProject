package net.iwillwork4u.sensors.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Datasource datasource = new Datasource();

    public Datasource getDatasource() {
        return datasource;
    }

    public static class Datasource {

        private boolean cachePrepStmts = true;

        private int prepStmtCacheSize = 250;

        private int prepStmtCacheSqlLimit = 2048;

        private boolean useServerPrepStmts = true;

        public boolean isCachePrepStmts() {
            return cachePrepStmts;
        }

        public void setCachePrepStmts(boolean cachePrepStmts) {
            this.cachePrepStmts = cachePrepStmts;
        }

        public int getPrepStmtCacheSize() {
            return prepStmtCacheSize;
        }

        public void setPrepStmtCacheSize(int prepStmtCacheSize) {
            this.prepStmtCacheSize = prepStmtCacheSize;
        }

        public int getPrepStmtCacheSqlLimit() {
            return prepStmtCacheSqlLimit;
        }

        public void setPrepStmtCacheSqlLimit(int prepStmtCacheSqlLimit) {
            this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
        }

        public boolean isUseServerPrepStmts() {
            return useServerPrepStmts;
        }

        public void setUseServerPrepStmts(boolean useServerPrepStmts) {
            this.useServerPrepStmts = useServerPrepStmts;
        }
    }
}