package IO;

import Exceptions.InvalidFileNameException;
import Exceptions.InvalidPathException;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by mponev on 5/18/16.
 */
public class IOManager {
    public void traverseDirectory(int depth){
        LinkedList<File> subFolders = new LinkedList<>();
        String path = SessionData.currentPath;
        int initialIndentation = path.split("////").length;
        File root = new File(path);
        subFolders.add(root);
        while (subFolders.size() != 0){
            File currentFile = subFolders.removeFirst();
            int currentIndentation = currentFile.toString().split("////").length - initialIndentation;
            if (depth - currentIndentation < 0) {
                break;
            }
            OutputWriter.writeMessageOnNewLine(currentFile.toString());
            File [] subFiles = currentFile.listFiles();
            if (subFiles != null){
                for (File subFile : subFiles) {
                    if (subFile.isDirectory()){
                        subFolders.add(subFile);
                    } else {
                        int indexOfLastSlash = subFile.toString().lastIndexOf("//");
                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }
                        OutputWriter.writeMessageOnNewLine(subFile.getName());
                    }
                }
            }
        }
    }
    public static void createDirectoryInCurrentFolder(String name) {
        String path = SessionData.currentPath + "\\" + name;
        File file = new File(path);
        boolean wasDirMade = file.mkdir();
        if (!wasDirMade) {
            throw new InvalidFileNameException();
        }
    }
    public String getCurrentDirectoryPath () {
        String currentPath = SessionData.currentPath;
        return currentPath;
    }
    public void changeCurrentDirRelativePath (String relativePath) {
        if (relativePath.equals("..")) {
            try {
                String currentPath = SessionData.currentPath;
                int indexOfLastSlash = currentPath.lastIndexOf("/");
                String newPath = currentPath.substring(0, indexOfLastSlash);
                SessionData.currentPath = newPath;
            } catch (StringIndexOutOfBoundsException siobe) {
                throw new InvalidPathException();
            }
        } else {
            String currentPath = SessionData.currentPath;
            currentPath += "//" + relativePath;
            changeCurrentDirAbsolute(currentPath);
    }
    }
    public void changeCurrentDirAbsolute (String absolutePath) {
        File file = new File(absolutePath);
        if (!file.exists()) {
            throw new InvalidPathException();
        }
        SessionData.currentPath = absolutePath;
    }

}
