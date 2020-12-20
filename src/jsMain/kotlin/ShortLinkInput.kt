import react.*
import react.dom.*
import kotlinx.html.js.*
import kotlinx.html.InputType
import org.w3c.dom.events.Event
import org.w3c.dom.HTMLInputElement

external interface InputProps : RProps {
    var onSubmit: (String) -> Unit
}

val ShortLinkInput = functionalComponent<InputProps> { props ->
    val (text, setText) = useState("")

    val submitHandler: (Event) -> Unit = {
        it.preventDefault()
        setText("")
        props.onSubmit(text)
    }

    val changeHandler: (Event) -> Unit = {
        val value = (it.target as HTMLInputElement).value
        setText(value)
    }

    form {
        attrs.jsStyle["padding-left"] = "4em"
        attrs.jsStyle["padding-top"] = "1em"
        p("lead") {
            +"Enter or paste your link to generate an Ethereum managed short link."
        }
        attrs.onSubmitFunction = submitHandler
        input(InputType.url, classes = "form-control mr-md-2") {
            attrs.onChangeFunction = changeHandler
            attrs.value = text
        }
    }
}