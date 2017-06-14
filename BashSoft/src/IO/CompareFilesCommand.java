package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

/**
 * Created by mponev on 02.07.16.
 */
public class CompareFilesCommand extends Command {
    public CompareFilesCommand(String input, String[] data,
                               Tester tester,
                               StudentsRepository repository,
                               DownloadManager downloadManager,
                               IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        if (data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }
        String firstPath = data[1];
        String secondPath = data[2];
        this.getTester().compareContent(firstPath, secondPath);
    }
}
