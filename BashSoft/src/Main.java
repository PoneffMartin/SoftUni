import IO.*;
import Judge.Tester;
import Network.DownloadManager;
import Repository.RepositoryFilter;
import Repository.RepositorySorter;
import Repository.StudentsRepository;
import StaticData.ExceptionMessages;

import java.io.IOException;

/**
 * Created by mponev on 21.05.16.
 */
public class Main {
    public static void main(String[] args) {
        Tester tester = new Tester();
        DownloadManager downloadManager = new DownloadManager();
        IOManager ioManager = new IOManager();
        RepositorySorter sorter = new RepositorySorter();
        RepositoryFilter filter = new RepositoryFilter();
        StudentsRepository repository = new StudentsRepository(filter, sorter);
        CommandInterpreter currentInterpreter =
                new CommandInterpreter(tester, repository, downloadManager, ioManager);
        InputReader reader = new InputReader(currentInterpreter);
        try {
            reader.readCommands();
        } catch (IOException ioe) {
            OutputWriter.displayException(ioe.getMessage());
        }
    }
}
