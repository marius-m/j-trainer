package lt.markmerkk.jtrainer.services.utils

import java.util.regex.Pattern

// todo: Needs a cleanup job and logic separation to reuse functionality
class HtmlRelativeLinkParserImpl(
        private val contextPath: String = ""
) : HtmlRelativeLinkParser {

    // todo: Check for absolute path

    override fun sanitizeImageSourcePaths(inputHtml: String): String {
        var outHtml = inputHtml
        val pattern = Pattern.compile("<img.*?>")
        val matcher = pattern.matcher(inputHtml)
        while (matcher.find()) {
            val imageTag = matcher.group()
            outHtml = outHtml
                    .replace(imageTag, replaceSourcePathInTag("src", imageTag))
        }
        return outHtml
    }

    // todo: Missing tests
    // todo: duplicate code
    override fun sanitizeHrefSourcePaths(inputHtml: String): String {
        var outHtml = inputHtml
        val pattern = Pattern.compile("<a.*?>")
        val matcher = pattern.matcher(inputHtml)
        while (matcher.find()) {
            val imageTag = matcher.group()
            outHtml = outHtml
                    .replace(imageTag, replaceSourcePathInTag("href", imageTag))
        }
        return outHtml
    }

    fun sanitizeContextPath(contextPath: String): String {
        if (contextPath == "/") {
            return ""
        }
        return contextPath
    }

    fun sanitizeAdjacentLink(inputLink: String): String {
        if (!inputLink.startsWith("/")) {
            return "/$inputLink"
        }
        return inputLink
    }

    // todo: Needs more extensive testing
    fun replaceSourcePathInTag(inputTag: String, inputString: String): String {
        val pattern = Pattern.compile("$inputTag=\".*?\"")
        val matcher = pattern.matcher(inputString)
        while (matcher.find()) {
            val foundSource = matcher.group()
            val inputLink = pullOnlyPath(inputTag, inputString)
            if (inputLink.startsWith("http") || inputLink.startsWith("https")) {
                // ignore absolute links
                continue
            }
            if (inputLink.startsWith("#")) {
                // ignoring hashlinks
                continue
            }
            val sourcePath = sanitizeAdjacentLink(inputLink)
            val contextPath = sanitizeContextPath(contextPath)
            return inputString
                    .replace(
                            foundSource,
                            "$inputTag=\"$contextPath$sourcePath\""
                    )
        }
        return inputString
    }

    fun pullOnlyPath(inputTag: String, inputImageTag: String): String {
        val pattern = Pattern.compile("(?<=$inputTag=\").+?(?=\")")
        val matcher = pattern.matcher(inputImageTag)
        while (matcher.find()) {
            return matcher.group()
        }
        return ""
    }

}