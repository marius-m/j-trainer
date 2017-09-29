package lt.markmerkk.jtrainer.services

import lt.markmerkk.jtrainer.entities.MDHtml

/**
 * Converts markdown files to HTML representation
 */
interface MDToHtmlConverter {
    /**
     * Converts input markdown file and packs it to [MDHtml]
     * Note that [MDHtml.success] will indicate if conversion was success
     */
    fun toHtml(mdFile: String): MDHtml
}