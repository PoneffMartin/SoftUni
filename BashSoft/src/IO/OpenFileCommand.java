package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;
import StaticData.SessionData;

import java.awt.*;
import java.io.File;

/**
 * Created by mponev on 02.07.16.
 */
public class OpenFileCommand extends Command {
    public OpenFileCommand(String input, String[] data,
                       Tester tester,
                       StudentsRepository repository,
                       DownloadManager downloadManager,
                       IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager );
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2){
            throw new InvalidInputException(this.getInput());
        }
        String fileName = data[1];
        String filePath = SessionData.currentPath + "//" + input;
        File newFile = new File(filePath);
        Desktop.getDesktop().open(newFile);
    }
}
