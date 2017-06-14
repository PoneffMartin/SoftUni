package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

/**
 * Created by mponev on 02.07.16.
 */
public class ChangeAbsolutePathCommand extends Command {
    public ChangeAbsolutePathCommand(String input, String[] data,
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
        String absolutePath = data[1];
        this.getIoManager().changeCurrentDirAbsolute(absolutePath);
    }
}
