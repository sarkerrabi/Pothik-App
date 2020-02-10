package com.cse327.pothik.Setting;

/**
 * Created by Mahamud on 17-Dec-17.
 */

public class YoutubeVideo {

    String videoUrl;

    public YoutubeVideo() {

    }

    public YoutubeVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
