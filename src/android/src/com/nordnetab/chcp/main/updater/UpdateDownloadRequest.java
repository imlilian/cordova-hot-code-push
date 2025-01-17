package com.nordnetab.chcp.main.updater;

import android.content.Context;

import com.nordnetab.chcp.main.model.PluginFilesStructure;

import java.util.Map;

/**
 * Created by Nikolay Demyankov on 01.06.16.
 * <p/>
 * Model for update request parameters.
 */
public class UpdateDownloadRequest {

    private String configURL;
    private String currentReleaseVersion;
    private String readyReleaseVersion;
    private PluginFilesStructure currentReleaseFS;
    private int currentNativeVersion;
    private Map<String, String> requestHeaders;

    /**
     * Constructor.
     *
     * @param context               application context
     * @param configURL             chcp.json url
     * @param currentReleaseVersion current web content version
     * @param readyReleaseVersion   ready web content version modify byLiLian@zilenet.com
     * @param currentNativeVersion  current native interface version
     * @param requestHeaders        additional request headers, which will be added
     *                              to all requests
     */
    public UpdateDownloadRequest(final Context context,
                                 final String configURL,
                                 final String currentReleaseVersion,
                                 final String readyReleaseVersion, // modify by LiLian@zilenet.com
                                 final int currentNativeVersion,
                                 final Map<String, String> requestHeaders) {
        this.configURL = configURL;
        this.currentNativeVersion = currentNativeVersion;
        this.requestHeaders = requestHeaders;
        this.currentReleaseVersion = currentReleaseVersion; // modify by LiLian@zilenet.com
        this.readyReleaseVersion = readyReleaseVersion; // modify by LiLian@zilenet.com
        this.currentReleaseFS = new PluginFilesStructure(context, currentReleaseVersion);
    }

    /**
     * Get class builder.
     *
     * @param context application context
     * @return builder
     */
    public static Builder builder(final Context context) {
        return new Builder(context);
    }

    /**
     * URL to chcp.json config on the server.
     *
     * @return url to config
     */
    public String getConfigURL() {
        return configURL;
    }

    /**
     * File structure of the current web release.
     *
     * @return file structure
     */
    public PluginFilesStructure getCurrentReleaseFileStructure() {
        return currentReleaseFS;
    }

    /**
     * Current native interface version.
     *
     * @return native interface version.
     */
    public int getCurrentNativeVersion() {
        return currentNativeVersion;
    }

    /**
     * Current release version. 
     * modify by LiLian@zilenet.com
     *
     * @return Current release version.
     */
    public String getCurrentReleaseVersion() {
        return currentReleaseVersion;
    }

    /**
     * Ready release version. 
     * modify by LiLian@zilenet.com
     * 
     * @return Ready release version.
     */
    public String getReadyReleaseVersion() {
        return readyReleaseVersion;
    }

    /**
     * Additional request headers.
     *
     * @return request headers
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    // region Builder pattern

    public static final class Builder {

        private Context mContext;
        private String configURL;
        private String currentReleaseVersion;
        private String readyReleaseVersion; // modify by LiLian@zilenet.com
        private int currentNativeVersion;
        private Map<String, String> requestHeaders;

        /**
         * Constructor.
         *
         * @param context application context
         */
        public Builder(final Context context) {
            mContext = context;
        }

        /**
         * Setter for config url.
         *
         * @param configURL chcp.json config url
         * @return builder
         */
        public Builder setConfigURL(final String configURL) {
            this.configURL = configURL;
            return this;
        }

        /**
         * Setter for current web release version.
         *
         * @param currentReleaseVersion version
         * @return builder
         */
        public Builder setCurrentReleaseVersion(final String currentReleaseVersion) {
            this.currentReleaseVersion = currentReleaseVersion;
            return this;
        }

        /**
         * Setter for ready web release version.
         * modify by LiLian@zilenet.com
         * 
         * @param readyReleaseVersion version
         * @return builder
         */
        public Builder setReadyReleaseVersion(final String readyReleaseVersion) {
            this.readyReleaseVersion = readyReleaseVersion;
            return this;
        }

        /**
         * Setter for additional request headers.
         *
         * @param requestHeaders request headers.
         * @return builder
         */
        public Builder setRequestHeaders(final Map<String, String> requestHeaders) {
            this.requestHeaders = requestHeaders;
            return this;
        }

        /**
         * Setter for current native interface version.
         *
         * @param currentNativeVersion native interface
         * @return builder
         */
        public Builder setCurrentNativeVersion(final int currentNativeVersion) {
            this.currentNativeVersion = currentNativeVersion;
            return this;
        }

        /**
         * Build the actual object.
         *
         * @return update request instance
         */
        public UpdateDownloadRequest build() {
            // modify by LiLian@zilenet.com
            return new UpdateDownloadRequest(mContext, configURL, currentReleaseVersion, readyReleaseVersion, currentNativeVersion, requestHeaders);
        }
    }

    // endregion
}
