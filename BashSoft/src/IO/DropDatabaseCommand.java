package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

/**
 * Created by mponev on 02.07.16.
 */
public class DropDatabaseCommand extends Command {
    public DropDatabaseCommand(String input, String[] data,
                               Tester tester,
                               StudentsRepository repository,
                               DownloadManager downloadManager,
                               IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        if (data.length != 1) {
            throw new InvalidInputException(this.getInput());
        }
        this.getRepository().unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped!");
    }
}
