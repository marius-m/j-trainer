package lt.markmerkk.jtrainer.services

import com.nhaarman.mockito_kotlin.*
import com.vladsch.flexmark.ast.Document
import lt.markmerkk.jtrainer.entities.MenuHeader
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * @author mariusmerkevicius
 * *
 * @since 2017-09-29
 */
class MDToHtmlConverterImplTest {

    @Mock lateinit var interactor: MDInteractor
    lateinit var converter: MDToHtmlConverterImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        converter = MDToHtmlConverterImpl(interactor)
    }

    @Test
    fun validResponse() {
        // Assemble
        val validFilePath = "valid_file_path"
        val validFileDocument = createDocument()
        doReturn(true).whenever(interactor).mdFileExist(validFilePath)
        doReturn("valid_file").whenever(interactor).mdFileAsString(validFilePath)
        doReturn(validFileDocument).whenever(interactor).mdToDocument("valid_file")
        doReturn("valid_html").whenever(interactor).documentToHtml(validFileDocument)

        // Act
        val result = converter.toHtml(validFilePath)

        // Assert
        assertTrue(result.success)
        assertEquals("valid_html", result.html)
    }

    @Test
    fun validHeaders() {
        // Assemble
        val validFilePath = "valid_file_path"
        val validFileDocument = createDocument()
        val validHeaders = listOf<MenuHeader>(
                createMenuHeader(),
                createMenuHeader(),
                createMenuHeader()
        )
        doReturn(true).whenever(interactor).mdFileExist(validFilePath)
        doReturn("valid_file").whenever(interactor).mdFileAsString(validFilePath)
        doReturn(validFileDocument).whenever(interactor).mdToDocument("valid_file")
        doReturn("valid_html").whenever(interactor).documentToHtml(validFileDocument)
        doReturn(validHeaders).whenever(interactor).parseHeadersWithLevel(eq(validFileDocument), any())

        // Act
        val result = converter.toHtml(validFilePath)

        // Assert
        assertEquals(3, result.headers.size)
    }

    @Test
    fun invalid_emptyFile() {
        // Assemble
        val validFilePath = "valid_file_path"
        doReturn(true).whenever(interactor).mdFileExist(validFilePath)
        doReturn("").whenever(interactor).mdFileAsString(validFilePath)
        doReturn(createDocument()).whenever(interactor).mdToDocument("valid_file")
        doReturn("").whenever(interactor).documentToHtml(any())

        // Act
        val result = converter.toHtml(validFilePath)

        // Assert
        assertFalse(result.success)
        assertEquals("", result.html)
    }

    @Test
    fun invalid_invalidFilePath() {
        // Assemble
        val invalidFilePath = "invalid_file_path"
        doReturn(false).whenever(interactor).mdFileExist(invalidFilePath)
        doReturn("").whenever(interactor).mdFileAsString(invalidFilePath)

        // Act
        val result = converter.toHtml(invalidFilePath)

        // Assert
        assertFalse(result.success)
        assertEquals("", result.html)
    }

    //region Mocks

    fun createDocument(): Document {
        val document: Document = mock()
        return document
    }

    fun createMenuHeader(): MenuHeader {
        val menuHeader: MenuHeader = mock()
        return menuHeader
    }

    //endregion

}