package IO;

import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;

/**
 * Created by mponev on 02.07.16.
 */
public class ShowCourseCommand extends Command {
    public ShowCourseCommand(String input, String[] data,
                             Tester tester,
                             StudentsRepository repository,
                             DownloadManager downloadManager,
                             IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        if (data.length != 2 && data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }
        if (data.length == 2) {
            String courseName = data[1];
            this.getRepository().getStudentsByCourse(courseName);
        }
        if (data.length == 3){
            String courseName = data[1];
            String userName = data[2];
            this.getRepository().getStudentMarkInCourse(courseName, userName);
        }
    }
}
