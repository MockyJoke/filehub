package org.jointwork.filehub.core.filesystem

import org.jointwork.filehub.core.File
import org.jointwork.filehub.core.FileAccessor
import org.jointwork.filehub.core.FileConstants
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors

/**
 * class property:
 *      - workingDirectory: represents actual Windows/Linux filesystem path
 *      - parentFile:
 * */
class FileSystemFile(val workingDirectory : String, val filename : String, val parentFile : File) : File {

    override fun listChild(): List<File> {
        // Q: How "Paths.get()" works?
        // The Path is obtained by invoking the getPath method of the default FileSystem.
        val path = Paths.get(workingDirectory)

        val temp : List<FileSystemFile> =  Files.list(path)
                    .map { p -> FileSystemFile(p.fileName.toAbsolutePath().toString(), p.fileName.toString(), this) }
                    .collect(Collectors.toList())
        return temp
    }

    override fun getName(): String {
        return filename
    }

    // /root/photo/1.jpg
    override fun getPath(): String {
        return getParent().getPath() + FileConstants.FILE_DELIMITER +getName()
    }

    override fun getParent(): File {
        return parentFile
    }

    override fun getAccessor(): FileAccessor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createFile(fileName: String): File {

        // step :
        //      1. create new java File object -> File file = new FIle('1.jpg')
        //      2. Create new FileSystem File /photo/1.jpg
        //
        if(isDirectory()) {
            throw IllegalStateException("creating a file on a file is not allowed")
        }
        val path : String = workingDirectory + FileConstants.FILE_DELIMITER + fileName
        java.io.File(path).createNewFile()
        return FileSystemFile(path, fileName, this )
    }

    override fun deleteFile(fileName: String) {
        val path : String = workingDirectory + FileConstants.FILE_DELIMITER +fileName
        java.io.File(path).delete()
    }

    override fun isDirectory(): Boolean {
        return java.io.File(workingDirectory).isDirectory()
    }
}