package lt.markmerkk.jtrainer.entities

data class MenuHeader(
        val title: String = "",
        val link: String = ""
) {
    val linkWithHash: String
    get() = "#$link"
}