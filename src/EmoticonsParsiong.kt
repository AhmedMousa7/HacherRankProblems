fun main() {
    val obj = EmoticonParser()
    print(obj.parseEmoticons(":):-)99)(:)-//:/ nooo! :-( and it works :)!"))
}


class EmoticonParser {

    fun parseEmoticons(text: String): List<InlinedEmoticon> {
        val supportedEmoticons = listOf<Emoticons>(
                Emoticons(1, ":)"),
                Emoticons(1, ":-)"),
                Emoticons(2, ":/"),
                Emoticons(3, ":("),
                Emoticons(3, ":-(")
        )

        val inlinedEmoticon = mutableListOf<InlinedEmoticon>()
        var lastPosition = 0
        supportedEmoticons.forEach { emoticon ->
            while(lastPosition != -1) {
                lastPosition = text.indexOf(emoticon.value, lastPosition)
                if (lastPosition != -1) {
                    inlinedEmoticon.add(InlinedEmoticon(emoticon.id, lastPosition, emoticon.value.length))
                    lastPosition += 1
                }else {
                    lastPosition = 0
                    break
                }
            }
        }

        return inlinedEmoticon
    }

    data class Emoticons(val id: Int, val value: String)
}

data class InlinedEmoticon(val emoticonId: Int, val position: Int, val length: Int)
