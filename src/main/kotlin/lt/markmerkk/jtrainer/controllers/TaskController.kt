package lt.markmerkk.jtrainer.controllers

import net.openhft.compiler.CompilerUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.io.PrintWriter
import java.io.StringWriter


@RestController
class TaskController {

    @RequestMapping(
            value = *arrayOf("/api/check_result"),
            method = arrayOf(RequestMethod.GET)
    )
    fun index(): String {
        val result = executeDynamicCode("System.out.println(\"Hello world!\");")
        return result
    }

    fun executeDynamicCode(dynamicCode: String): String {
        val stringWriter = StringWriter()
        val className = "TestClass"
        val javaCode = "public class $className implements Runnable {" +
                "   public void run() {" +
                "       $dynamicCode " +
                "   }" +
                "}\n"
        try {
            val aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(
                    object : ClassLoader() {},
                    className,
                    javaCode,
                    PrintWriter(stringWriter)
            )
            val runner = aClass.newInstance() as Runnable
            runner.run()
            return stringWriter.toString()
        } catch(e: Exception) {
            return "[ERROR] Error executing code!"
        }
    }

}