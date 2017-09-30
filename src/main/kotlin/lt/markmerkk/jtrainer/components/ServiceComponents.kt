package lt.markmerkk.jtrainer.components

import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension
import com.vladsch.flexmark.ext.emoji.EmojiExtension
import com.vladsch.flexmark.ext.tables.TablesExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
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
        options.set(
                Parser.EXTENSIONS,
                listOf(
                        AnchorLinkExtension.create(),
                        TablesExtension.create(),
                        EmojiExtension.create()
                )
        )
        options.set(HtmlRenderer.GENERATE_HEADER_ID, true)
        options.set(AnchorLinkExtension.ANCHORLINKS_SET_ID, true)
        options.set(AnchorLinkExtension.ANCHORLINKS_SET_NAME, false)
        options.set(AnchorLinkExtension.ANCHORLINKS_WRAP_TEXT, true)
//        options.set(EmojiExtension.ROOT_IMAGE_PATH, "/imgs/")

        val parser = Parser.builder(options).build()
        val renderer = HtmlRenderer
                .builder(options)
                .build()
        return MDToHtmlConverterImpl(
                MDInteractorImpl(
                        parser,
                        renderer
                )
        )
    }

}