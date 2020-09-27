package org.jointwork.filehub.core.filesystem

import org.jointwork.filehub.core.File

class FileSource(val fileSourceConfig : FileSourceConfig) : org.jointwork.filehub.core.FileSource {

    override fun getRootFile(): File {
//        val workingDirectory : String = fileSourceConfig.workingDirectory
//        return FileSystemFile(workingDirectory, "", null)
        TODO()
    }

    override fun getMountName(): String {
        return fileSourceConfig.mountName
    }
}