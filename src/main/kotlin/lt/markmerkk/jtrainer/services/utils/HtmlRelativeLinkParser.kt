package lt.markmerkk.jtrainer.services.utils

interface HtmlRelativeLinkParser {
    fun sanitizeImageSourcePaths(inputHtml: String): String
    fun sanitizeHrefSourcePaths(inputHtml: String): String
}