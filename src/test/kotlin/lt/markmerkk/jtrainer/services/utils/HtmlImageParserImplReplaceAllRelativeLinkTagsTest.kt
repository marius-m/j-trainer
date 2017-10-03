package lt.markmerkk.jtrainer.services.utils

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

/**
 * @author mariusmerkevicius
 * *
 * @since 2017-10-02
 */
class HtmlImageParserImplReplaceAllRelativeLinkTagsTest {

    lateinit var parser: HtmlRelativeLinkParserImpl
    var contextPath: String = "/context_path"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        parser = HtmlRelativeLinkParserImpl(contextPath)
    }

    @Test
    fun noImageTag() {
        // Assemble
        val html = "<p>Test test test</p>"

        // Act
        val resultHtml = parser.sanitizeImageSourcePaths(html)

        // Assert
        assertEquals("<p>Test test test</p>", resultHtml)
    }

    @Test
    fun noSource() {
        // Assemble
        val html = "<img />"

        // Act
        val resultHtml = parser.sanitizeImageSourcePaths(html)

        // Assert
        assertEquals("<img />", resultHtml)
    }

    @Test
    fun noSource2() {
        // Assemble
        val html = "<img></img>"

        // Act
        val resultHtml = parser.sanitizeImageSourcePaths(html)

        // Assert
        assertEquals("<img></img>", resultHtml)
    }

    @Test
    fun valid_withSource() {
        // Assemble
        val html = "<img src=\"/valid_source\"></img>"

        // Act
        val resultHtml = parser.sanitizeImageSourcePaths(html)

        // Assert
        assertEquals("<img src=\"/context_path/valid_source\"></img>", resultHtml)
    }

    @Test
    fun valid_multipleImg() {
        // Assemble
        val html = "<img src=\"/valid_source\"></img><img src=\"/valid_source\"></img>"

        // Act
        val resultHtml = parser.sanitizeImageSourcePaths(html)

        // Assert
        assertEquals("<img src=\"/context_path/valid_source\"></img><img src=\"/context_path/valid_source\"></img>", resultHtml)
    }

    @Test
    fun valid_wSource_otherAttributes() {
        // Assemble
        val html = "<img src=\"/valid_source\" width=\"100\" height=\"100\"></img>"

        // Act
        val resultHtml = parser.sanitizeImageSourcePaths(html)

        // Assert
        assertEquals("<img src=\"/context_path/valid_source\" width=\"100\" height=\"100\"></img>", resultHtml)
    }
}