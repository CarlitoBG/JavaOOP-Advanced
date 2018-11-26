package p02_stream_progress_info;

public class StreamProgressInfo {

    private Streamable file;

    private StreamProgressInfo(Streamable file) {
        this.file = file;
    }

    private int calculateCurrentPercent() {
        return (this.file.getBytesSent() * 100) / this.file.getLength();
    }

    public static void main(String[] args) {
        Streamable file = new File(10, 20);
        Streamable music = new Music(5, 2);

        StreamProgressInfo infoFile = new StreamProgressInfo(file);
        StreamProgressInfo infoMusic = new StreamProgressInfo(music);

        System.out.println(infoFile.calculateCurrentPercent());
        System.out.println(infoMusic.calculateCurrentPercent());
    }
}