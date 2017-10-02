package lt.markmerkk.jtrainer.services.utils

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

/**
 * @author mariusmerkevicius
 * *
 * @since 2017-10-03
 */
class HtmlImageParserImplPullOnlyPathTest {
    lateinit var parser: HtmlImageParserImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        parser = HtmlImageParserImpl()
    }

    @Test
    fun simple() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\" />"

        // Act
        val out = parser.pullOnlyPath(inputString)

        // Assert
        assertEquals("/imgs/boom.png", out)
    }

    @Test
    fun moreArguments() {
        // Assemble
        val inputString = "<img src=\"/imgs/boom.png\" width=\"100\"/>"

        // Act
        val out = parser.pullOnlyPath(inputString)

        // Assert
        assertEquals("/imgs/boom.png", out)
    }

    @Test
    fun noSourceArguments() {
        // Assemble
        val inputString = "<img width=\"100\"/>"

        // Act
        val out = parser.pullOnlyPath(inputString)

        // Assert
        assertEquals("", out)
    }

}