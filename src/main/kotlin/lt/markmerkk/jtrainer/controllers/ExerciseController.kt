package lt.markmerkk.jtrainer.controllers

import io.reactivex.Observable
import org.springframework.stereotype.Controller
import java.util.UUID
import lt.markmerkk.jtrainer.entities.ExecutorData
import lt.markmerkk.jtrainer.entities.responses.ResponseCodeInput
import lt.markmerkk.jtrainer.entities.responses.ResponseCodeOutput
import lt.markmerkk.jtrainer.entities.responses.ResponseOutputCode
import lt.markmerkk.jtrainer.services.ExecutorRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.concurrent.TimeUnit


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
        val result = executorRepository.findByUuid(uuid)
        if (result == null) {
            return ResponseOutputCode(
                    status = 404,
                    uuid = uuid
            )
        }
        if (result.output.isEmpty()) {
            return ResponseOutputCode(
                    status = 404,
                    uuid = uuid
            )
        }
        return ResponseOutputCode(
                status = 200,
                uuid = uuid,
                input = ResponseCodeInput(source = result.source),
                output = ResponseCodeOutput(result = result.output)
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
        // todo: Remove test executor updater
        Observable.interval(0, 1L, TimeUnit.SECONDS)
                .filter { it == 4L }
                .take(1)
                .subscribe({
                    val entityForUpdate = executorRepository.findByUuid(payload.uuid)
                    if (entityForUpdate != null) {
                        executorRepository.save(
                                ExecutorData(
                                        id = entityForUpdate.id,
                                        uuid = entityForUpdate.uuid,
                                        source = entityForUpdate.source,
                                        output = "Generated output"
                                )
                        )
                    }
                })
    }

    //endregion

    //region Convenience

    fun genUuid(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

    //endregion

}