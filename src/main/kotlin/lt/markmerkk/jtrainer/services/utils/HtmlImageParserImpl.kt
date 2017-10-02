package lt.markmerkk.jtrainer.services.utils

import java.util.regex.Pattern

class HtmlImageParserImpl : HtmlImageParser {

    override fun sanitizeImageSourcePaths(inputHtml: String): String {
        var outHtml = inputHtml
        val pattern = Pattern.compile("<img.*?>")
        val matcher = pattern.matcher(inputHtml)
        while (matcher.find()) {
            val imageTag = matcher.group()
            outHtml = outHtml
                    .replace(imageTag, replaceSourcePathInTag(imageTag))
        }
        return outHtml
    }

    fun replaceSourcePathInTag(inputString: String): String {
        val pattern = Pattern.compile("src=\".*?\"")
        val matcher = pattern.matcher(inputString)
        while (matcher.find()) {
            val foundSource = matcher.group()
            return inputString
                    .replace(
                            foundSource,
                            "th:src=\"@{${pullOnlyPath(inputString)}}\""
                    )
        }
        return inputString
    }

    fun pullOnlyPath(inputImageTag: String): String {
        val pattern = Pattern.compile("(?<=src=\").+?(?=\")")
        val matcher = pattern.matcher(inputImageTag)
        while (matcher.find()) {
            return matcher.group()
        }
        return ""
    }

}