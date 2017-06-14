package IO;

import Exceptions.InvalidCommandException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

/**
 * Created by mponev on 02.07.16.
 */
public abstract class Command {
    public String input;
    public String[] data;
    private StudentsRepository repository;
    private Tester tester;
    private IOManager ioManager;
    private DownloadManager downloadManager;

    protected Command(String input, String[] data,
                      Tester tester,
                      StudentsRepository repository,
                      DownloadManager downloadManager,
                      IOManager ioManager) {
        this.setInput(input);
        this.setData(data);
        this.repository = repository;
        this.tester = tester;
        this.ioManager = ioManager;
        this.downloadManager = downloadManager;
    }

    protected String getInput() {
        return input;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidCommandException();
        }
        this.input = input;
    }

    protected String[] getData() {
        return data;
    }

    private void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidCommandException();
        }
        this.data = data;
    }

    protected StudentsRepository getRepository() {
        return repository;
    }

    protected Tester getTester() {
        return tester;
    }

    protected IOManager getIoManager() {
        return ioManager;
    }

    protected DownloadManager getDownloadManager() {
        return downloadManager;
    }
    public abstract void execute() throws Exception;
}
