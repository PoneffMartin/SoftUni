package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

/**
 * Created by mponev on 02.07.16.
 */
public class PrintOrderedStudentsCommand extends Command{
    public PrintOrderedStudentsCommand(String input, String[] data,
                                       Tester tester,
                                       StudentsRepository repository,
                                       DownloadManager downloadManager,
                                       IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        if (data.length != 3 && data.length != 4) {
            throw new InvalidInputException(this.getInput());
        }
        String course = data[1];
        String filter = data[2];
        if (data.length == 3) {
            this.getRepository().orderAndTake(course, filter);
            return;
        }
        Integer numberOfStudents = Integer.valueOf(data[3]);
        if (data.length == 4) {
            this.getRepository().orderAndTake(course, filter, numberOfStudents);
        }
    }
}
