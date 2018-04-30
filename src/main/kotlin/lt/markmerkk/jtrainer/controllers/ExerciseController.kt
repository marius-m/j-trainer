package lt.markmerkk.jtrainer.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@Controller
class ExerciseController {

    @RequestMapping(
            value = *arrayOf("/code_submit"),
            method = arrayOf(RequestMethod.GET)
    )
    fun codeSubmit(): String {
        return "code_submit"
    }

}