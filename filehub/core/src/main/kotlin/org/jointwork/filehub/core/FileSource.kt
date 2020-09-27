package org.jointwork.filehub.core

interface FileSource {
    fun getRootFile() : File
    fun getMountName() : String
}