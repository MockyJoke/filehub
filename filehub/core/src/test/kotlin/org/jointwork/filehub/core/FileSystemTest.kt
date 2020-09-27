package org.jointwork.filehub.core

import io.mockk.*
import junit.framework.TestCase.assertEquals
import org.jointwork.filehub.core.filesystem.FileSystemFile
import org.junit.Test
import java.net.URI
import java.nio.file.*

class FileSystemTest {

    @Test
    fun listChildTest() {
        val fileName : String = "filename"
        val workingDirectory = "D:\\filehub_test\\apple"
//        val parentFile : File? = FileSystemFile("D:\\filehub_test", "D:", null)

        /***
         * //   given
                val service = mockk<TestableService>()
                every { service.getDataFromDb("Expected Param") } returns "Expected Output"

                // when
                val result = service.getDataFromDb("Expected Param")

                // then
                verify { service.getDataFromDb("Expected Param") }
                assertEquals("Expected Output", result)
         */
//        mockkStatic(Paths::class)
//        val mockPath = mockk<Path>()
//        every { Paths.get(workingDirectory) } returns mockPath
//        every { Files.list(mockPath) } returns
//        val parentFile = mockk<FileSystemFile>()
//        val fsf : FileSystemFile = FileSystemFile(workingDirectory, fileName, parentFile)
//        val children : List<File> = fsf.listChild()
//        assertEquals(children.isEmpty(), false)
//        for(child in children) {
//            assertEquals( expectedFileName, child.getName())
//        }

    }

    @Test
    fun createFileTest() {
        val fileName : String = "1.txt"
        val workingDirectory = "D:\\filehub_test\\apple"
        val path = workingDirectory + FileConstants.FILE_DELIMITER +fileName
//        mockkStatic(java.io.File::class)
        val mockFile = mockk<java.io.File>()
        mockkConstructor(java.io.File::class)

        every { anyConstructed<java.io.File>().isDirectory() } returns true
        every { anyConstructed<java.io.File>().createNewFile() } returns true
        val parentFile = mockk<FileSystemFile>()
        val fsf : FileSystemFile = FileSystemFile(workingDirectory, fileName, parentFile)

        val actual = fsf.createFile(fileName)
    }
}