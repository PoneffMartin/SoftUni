package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

/**
 * Created by mponev on 02.07.16.
 */
public class TraverseFoldersCommand extends Command {
    public TraverseFoldersCommand(String input, String[] data,
                                  Tester tester,
                                  StudentsRepository repository,
                                  DownloadManager downloadManager,
                                  IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        if (data.length != 1 && data.length != 2){
            throw new InvalidInputException(this.getInput());
        }
        if (data.length == 1) {
            this.getIoManager().traverseDirectory(0);
        }
        if (data.length == 2) {
            int depth = Integer.parseInt(data[1]);
            this.getIoManager().traverseDirectory(depth);
        }
    }
}
