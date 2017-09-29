package lt.markmerkk.jtrainer.services

import com.vladsch.flexmark.ast.Document
import lt.markmerkk.jtrainer.entities.MenuHeader

/**
 * Helper interactor to help convert to html
 */
interface MDInteractor {

    /**
     * Checks if file exists
     */
    fun mdFileExist(filePath: String): Boolean

    /**
     * Will try to read an input file and return its contents
     * as [String].
     * If cannot find a file, will return an empty string.
     * To check if file exists use [mdFileExist]
     */
    fun mdFileAsString(filePath: String): String

    /**
     * Converts markdown file contents to [Document]
     */
    fun mdToDocument(mdAsString: String): Document

    /**
     * Converts [Document] to HTML
     */
    fun documentToHtml(document: Document): String

    /**
     * Parses all headers in a document and returns as a [MenuHeader].
     * Useful for mapping sections.
     */
    fun parseHeadersWithLevel(
            document: Document,
            headerLevel: Int
    ): List<MenuHeader>
}