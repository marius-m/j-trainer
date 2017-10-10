package lt.markmerkk.jtrainer.custom_compiler

import lt.markmerkk.jtrainer.entities.OutputCode

/**
 * Responsible for executing code dynamically
 */
interface DynamicExecutor {

    /**
     * Executes dynamically code and outputs result
     */
    fun execute(code: String): OutputCode
}