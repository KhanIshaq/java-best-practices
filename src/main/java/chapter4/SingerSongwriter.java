package chapter4;

import java.applet.AudioClip;

public interface SingerSongwriter extends Singer, Songwriter {
       AudioClip strum();
       void actSensitive();
}