package lt.markmerkk.jtrainer.entities

data class MenuHeader(
        val title: String = "",
        val link: String = ""
) {
    val linkAsLocal: String
    get() = "#$link"
}