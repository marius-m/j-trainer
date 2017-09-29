package lt.markmerkk.jtrainer.components

import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.parser.ParserEmulationProfile
import com.vladsch.flexmark.util.options.MutableDataSet
import lt.markmerkk.jtrainer.services.MDInteractorImpl
import lt.markmerkk.jtrainer.services.MDToHtmlConverter
import lt.markmerkk.jtrainer.services.MDToHtmlConverterImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class ServiceComponents {
    @Bean
    @Scope("singleton")
    fun htmlConverter(): MDToHtmlConverter {
        val options = MutableDataSet()
        options.setFrom(ParserEmulationProfile.GITHUB_DOC)
        options.set(
                Parser.EXTENSIONS,
                listOf(
                        AnchorLinkExtension.create()
                )
        )
        val parser = Parser.builder(options).build()
        val renderer = HtmlRenderer.builder(options).build()
        return MDToHtmlConverterImpl(
                MDInteractorImpl(
                        parser,
                        renderer
                )
        )
    }

}