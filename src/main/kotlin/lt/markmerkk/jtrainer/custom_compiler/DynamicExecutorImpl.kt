package lt.markmerkk.jtrainer.custom_compiler

import lt.markmerkk.jtrainer.entities.OutputCode
import net.openhft.compiler.CompilerUtils
import java.io.PrintWriter
import java.io.StringWriter

class DynamicExecutorImpl : DynamicExecutor {
    override fun execute(code: String): OutputCode {
        val stringWriter = StringWriter()
        val executableCode = codeTemplate(code)
        try {
            val aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(
                    object : ClassLoader() {},
                    executableCode.className,
                    executableCode.code,
                    PrintWriter(stringWriter)
            )
            val runner = aClass.newInstance() as Runnable
            runner.run()
            return OutputCode(executableCode.code, "Still no result, but executed!")
        } catch(e: Exception) {
            return OutputCode(executableCode.code, "Error executing! ${e.message}")
        }
    }

    fun codeTemplate(code: String): ExecutableCode {
        val className = "TestClass"
        val javaCode = "public class $className implements Runnable {\n" +
                "   public void run() {\n" +
                "       $code " +
                "   }\n" +
                "}\n"
        return ExecutableCode(className, javaCode)
    }

    data class ExecutableCode(
            val className: String,
            val code: String
    )

}