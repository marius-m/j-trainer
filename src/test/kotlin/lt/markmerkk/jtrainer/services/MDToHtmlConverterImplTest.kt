package lt.markmerkk.jtrainer.services

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
    fun valid() {
        // Assemble
        doReturn("valid_file")

        // Act
        val result = converter.toHtml("valid_file")

        // Assert
        assertTrue(result.success)
        assertEquals("valid_html", result.html)
        assertEquals(3, result.headers.size)
    }
}