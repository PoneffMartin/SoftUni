package Network;

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import javax.swing.text.ChangedCharSetException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by mponev on 15.06.16.
 */
public class DownloadManager {
    public void downloadOnNewThread (String fileUrl) {
        Thread thread = new Thread(() -> download(fileUrl));
        OutputWriter.writeMessageOnNewLine(
                String.format("Worker thread %d started downloading..", thread.getId()));
        thread.setDaemon(false);
        thread.start();

    }
    public void download(String fileUrl) {
        URL url = null;
        ReadableByteChannel rbc = null;
        FileOutputStream fos = null;
        try {
            if (Thread.currentThread().getName().equals("main")) {
                OutputWriter.writeMessageOnNewLine("Started downloading..");
            }
            url = new URL(fileUrl);
            rbc = Channels.newChannel(url.openStream());
            String fileName = extractNameOfFile(url.toString());
            File file = new File(SessionData.currentPath + "/" + fileName);
            fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            if (Thread.currentThread().getName().equals("main")) {
                OutputWriter.writeMessageOnNewLine("Download complete.");
            } else {
                OutputWriter.writeMessageOnNewLine(
                        String.format("Worker thread %d downloading completed.", Thread.currentThread().getId()));
            }
        } catch (MalformedURLException e) {
            OutputWriter.displayException(e.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (rbc != null) {
                    rbc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String extractNameOfFile (String fileUrl) {
        int indexOfLastSlash = fileUrl.lastIndexOf('/');
        if (indexOfLastSlash == -1) {
            try {
                throw new MalformedURLException(ExceptionMessages.INVALID_PATH);
            } catch (MalformedURLException me) {
                me.printStackTrace();
            }

        }
        return fileUrl.substring(indexOfLastSlash + 1);
    }
}
