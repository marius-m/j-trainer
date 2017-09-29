package lt.markmerkk.jtrainer.services

import lt.markmerkk.jtrainer.entities.MDHtml

class MDToHtmlConverterImpl(
        private val interactor: MDInteractor
) : MDToHtmlConverter {

    override fun toHtml(mdFile: String): MDHtml {
        return MDHtml()
    }

}