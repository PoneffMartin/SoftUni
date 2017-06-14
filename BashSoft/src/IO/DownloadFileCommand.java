package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

import java.util.IllegalFormatCodePointException;

/**
 * Created by mponev on 02.07.16.
 */
public class DownloadFileCommand extends Command {
    public DownloadFileCommand(String input, String[] data,
                               Tester tester,
                               StudentsRepository repository,
                               DownloadManager downloadManager,
                               IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }
        String fileUrl = data[1];
        this.getDownloadManager().download(fileUrl);
    }
}
