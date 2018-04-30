package lt.markmerkk.jtrainer.entities.responses

data class ResponseOutputCode(
        val uuid: String,
        val input: ResponseCodeInput,
        val output: ResponseCodeOutput
)

data class ResponseCodeInput(val source: String)
data class ResponseCodeOutput(val result: String)
