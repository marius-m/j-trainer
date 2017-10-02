package lt.markmerkk.jtrainer.services.utils

interface HtmlImageParser {
    fun sanitizeImageSourcePaths(inputHtml: String): String
}