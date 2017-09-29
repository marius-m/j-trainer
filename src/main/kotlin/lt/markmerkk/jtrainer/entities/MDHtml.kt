package lt.markmerkk.jtrainer.entities

data class MDHtml(
        val success: Boolean = false,
        val html: String = "",
        val headers: List<MenuHeader> = emptyList()
)