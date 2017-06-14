package IO;

import Exceptions.InvalidFileNameException;
import Exceptions.InvalidInputException;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;
import StaticData.SessionData;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * Created by mponev on 30.05.16.
 */
public class CommandInterpreter {
    private Tester tester;
    private StudentsRepository repository;
    private DownloadManager downloadManager;
    private IOManager inputOutputManager;
    public CommandInterpreter(Tester tester,
                              StudentsRepository repository,
                              DownloadManager downloadManager,
                              IOManager inputOutputManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.inputOutputManager = inputOutputManager;
    }
    public void interpretCommand (String input) {
        String [] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Command command = parseCommand(input, data, commandName);
            command.execute();
        } catch (IllegalArgumentException iae) {
            OutputWriter.displayException(iae.getMessage());
        } catch (StringIndexOutOfBoundsException siobe) {
            OutputWriter.displayException(siobe.getMessage());
        } catch (Exceptions.InvalidPathException ioe) {
            OutputWriter.displayException(ioe.getMessage());
        } catch (Exceptions.InvalidFileNameException ifne) {
            OutputWriter.displayException(ifne.getMessage());
        } catch (IOException ioe) {
            OutputWriter.displayException(ioe.getMessage());
        } catch (Throwable t) {
            OutputWriter.displayException(t.getMessage());
        }
    }

    private Command parseCommand(String input, String[] data, String command) throws IOException{
        switch (command) {
            case "open":
                return new OpenFileCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "mkdir":
                return new MakeDirectoryCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "ls":
                return new TraverseFoldersCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "cmp":
                return new CompareFilesCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "changeDirRel":
                return new ChangeRelativePathCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "changeDirAbs":
                return new ChangeAbsolutePathCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "readDb":
                return new ReadDatabaseCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "filter":
                return new PrintFilteredStudentsCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "order":
                return new PrintOrderedStudentsCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "download":
                return new DownloadFileCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "downloadAsynch":
                return new DownloadFileAsynchCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "help":
                return new GetHelpCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "show":
                return new ShowCourseCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            case "dropdb":
                return new DropDatabaseCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.inputOutputManager);
            default:
                throw new InvalidInputException(input);
        }
    }
}
