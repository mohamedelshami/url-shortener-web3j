import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.html.js.*
import kotlinx.coroutines.*

const val redirectBase = "http://localhost:8080"
private val scope = MainScope()

val App = functionalComponent<RProps> { _ ->
    val (links, setLinks) = useState(emptyList<ShortLinkDetails>())

    useEffect(dependencies = listOf()) {
        scope.launch {
            setLinks(getLinks())
        }
    }

    div("bg-light p-2 rounded") {
        h2("AKAP URL Shortner") {
            +"URL Shortener Web3J Demo"
        }
    }

    div("form-group row") {
        div("col-md-10") {
            child(
                ShortLinkInput,
                props = jsObject {
                    onSubmit = { input ->
                        val link = ShortLinkDetails("", input, "", "", 0)
                        scope.launch {
                            addShortLink(link)
                            setLinks(getLinks())
                        }
                    }
                }
            )
        }

        div {
            attrs.jsStyle["padding-left"] = "8em"
            attrs.jsStyle["padding-top"] = "1em"

            table("table table-dark") {
                thead("thead-dark") {
                    th(classes = "thead-dark") { +"Short Link" }
                    th(classes = "thead-dark") { +"Link" }
                    th(classes = "thead-dark") { +"Node ID" }
                }
                tbody() {
                    links.forEach {
                        val labelTxt = "$redirectBase#" + it.label
                        val url = it.url
                        val nodeId = it.nodeId
                        tr {
                            td {
                                +labelTxt
                            }
                            td {
                                a(href = "$url", classes = "alert-link") { +url.substring(0, 100) }
                            }
                            td {
                                a(href = "https://akap.me/browser/$nodeId") { +(nodeId.substring(0, 8) + "..") }
                            }
                        }
                    }
                }
            }
        }
    }
}