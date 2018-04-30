package lt.markmerkk.jtrainer.controllers

import org.springframework.stereotype.Controller
import java.util.UUID
import lt.markmerkk.jtrainer.entities.ExecutorData
import lt.markmerkk.jtrainer.entities.responses.ResponseCodeInput
import lt.markmerkk.jtrainer.entities.responses.ResponseCodeOutput
import lt.markmerkk.jtrainer.entities.responses.ResponseOutputCode
import lt.markmerkk.jtrainer.services.ExecutorRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@Controller
class ExerciseController(
        val executorRepository: ExecutorRepository
) {

    @RequestMapping(
            value = *arrayOf("/code_submit"),
            method = arrayOf(RequestMethod.GET)
    )
    fun codeSubmit(): String {
        return "code_submit"
    }

    @RequestMapping(
            value = *arrayOf("/code_result"),
            method = arrayOf(RequestMethod.GET)
    )
    fun codeResult(
            @RequestParam(required = true) uuid: String
    ): String {
        return "code_result"
    }

    //region JSON

    @RequestMapping(
            value = *arrayOf("/api/code_issue_uuid"),
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf("application/json")
    )
    @ResponseBody fun apiCodeUuid(): String {
        val uuid = genUuid()
        return "{\"uuid\": \"$uuid\"}"
    }

    @RequestMapping(
            value = *arrayOf("/api/code_result"),
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf("application/json")
    )
    @ResponseBody fun apiCodeResult(
            @RequestParam(required = true) uuid: String
    ): ResponseOutputCode {
        return ResponseOutputCode(
                status = 200,
                uuid = uuid,
                input = ResponseCodeInput(source = "Basic input"),
                output = ResponseCodeOutput(result = "Some weird error")
        )
    }

    @RequestMapping(
            value = *arrayOf("/api/code_submit"),
            method = arrayOf(RequestMethod.POST)
    )
    @ResponseStatus(value = HttpStatus.OK)
    fun apiCodeSubmit(
            @RequestBody(required = true) payload: ExecutorData
    ) {
        executorRepository.save(
                ExecutorData(
                        uuid = payload.uuid,
                        source = payload.source
                )
        )
    }

    //endregion

    //region Convenience

    fun genUuid(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

    //endregion

}