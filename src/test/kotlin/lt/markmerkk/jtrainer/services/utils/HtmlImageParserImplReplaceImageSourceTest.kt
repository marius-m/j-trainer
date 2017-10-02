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
class HtmlImageParserImplReplaceImageSourceTest {
    lateinit var parser: HtmlImageParserImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        parser = HtmlImageParserImpl()
    }

    @Test
    fun noImageSource() {
        // Assemble
        val inputString = "<img width=\"100\" />"

        // Act
        val out = parser.replaceSourcePathInTag(inputString)

        // Assert
        assertEquals("<img width=\"100\" />", out)
    }

    @Test
    fun valid() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\" />"

        // Act
        val out = parser.replaceSourcePathInTag(inputString)

        // Assert
        assertEquals("<img th:src=\"@{/imgs/boom.png}\" />", out)
    }

    @Test // replaces only first found source attribute
    fun valid_multiImage() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\"></img><img src=\"/imgs/heart.png\"></img>"

        // Act
        val out = parser.replaceSourcePathInTag(inputString)

        // Assert
        assertEquals("<img th:src=\"@{/imgs/boom.png}\"></img><img src=\"/imgs/heart.png\"></img>", out)
    }

    @Test
    fun moreParams() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\" width=\"100\" />"

        // Act
        val out = parser.replaceSourcePathInTag(inputString)

        // Assert
        assertEquals("<img th:src=\"@{/imgs/boom.png}\" width=\"100\" />", out)
    }

}