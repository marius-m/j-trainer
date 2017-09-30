package lt.markmerkk.jtrainer.services

import lt.markmerkk.jtrainer.entities.MDHtml

class MDToHtmlConverterImpl(
        private val interactor: MDInteractor
) : MDToHtmlConverter {

    override fun toHtml(mdFilePath: String): MDHtml {
        if (!interactor.mdFileExist(mdFilePath)) {
            return MDHtml(
                    success = false
            )
        }
        val fileAsString = interactor.mdFileAsString(mdFilePath)
        if (fileAsString.isEmpty()) {
            return MDHtml(
                    success = false
            )
        }
        val document = interactor.mdToDocument(fileAsString)
        return MDHtml(
                success = true,
                html = interactor.documentToHtml(document),
                headers = interactor.parseHeadersWithLevel(
                        document = document,
                        headerLevel = 2
                )
        )
    }

}