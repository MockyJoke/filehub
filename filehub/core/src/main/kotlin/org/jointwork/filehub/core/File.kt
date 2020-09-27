package org.jointwork.filehub.core

interface File {
    // represent "ls" command
    fun listChild() : List<File>
    // /photo -> /dir1

    fun getName() : String
    fun getPath() : String
    fun getParent() : File

    fun getAccessor() : FileAccessor
    fun createFile(fileName : String) : File
    fun deleteFile(fileName : String)
    fun isDirectory() : Boolean
}