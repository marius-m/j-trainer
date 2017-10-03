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
class HtmlImageParserImplReplaceRelativeLinkSourceTest {
    lateinit var parser: HtmlRelativeLinkParserImpl
    var contextPath: String = "/context_path"
    val sourceTag = "src"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        parser = HtmlRelativeLinkParserImpl(contextPath)
    }

    @Test
    fun noImageSource() {
        // Assemble
        val inputString = "<img width=\"100\" />"

        // Act
        val out = parser.replaceSourcePathInTag(sourceTag, inputString)

        // Assert
        assertEquals("<img width=\"100\" />", out)
    }

    @Test
    fun valid() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\" />"

        // Act
        val out = parser.replaceSourcePathInTag(sourceTag, inputString)

        // Assert
        assertEquals("<img src=\"/context_path/imgs/boom.png\" />", out)
    }

    @Test
    fun valid_noStartingSlash() {
        // Assemble
        val inputString = "<img src=\"imgs/boom.png\" />"

        // Act
        val out = parser.replaceSourcePathInTag(sourceTag, inputString)

        // Assert
        assertEquals("<img src=\"/context_path/imgs/boom.png\" />", out)
    }

    @Test
    fun valid_absoluteContextPath() {
        // Assemble
        val absoluteContextPath = "/"
        val localParser = HtmlRelativeLinkParserImpl(absoluteContextPath)
        val inputString = "<img src=\"/imgs/boom.png\" />"

        // Act
        val out = localParser.replaceSourcePathInTag(sourceTag, inputString)

        // Assert
        assertEquals("<img src=\"/imgs/boom.png\" />", out)
    }

    @Test // replaces only first found source attribute
    fun valid_multiImage() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\"></img><img src=\"/imgs/heart.png\"></img>"

        // Act
        val out = parser.replaceSourcePathInTag(sourceTag, inputString)

        // Assert
        assertEquals("<img src=\"/context_path/imgs/boom.png\"></img><img src=\"/imgs/heart.png\"></img>", out)
    }

    @Test
    fun moreParams() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\" width=\"100\" />"

        // Act
        val out = parser.replaceSourcePathInTag(sourceTag, inputString)

        // Assert
        assertEquals("<img src=\"/context_path/imgs/boom.png\" width=\"100\" />", out)
    }

}