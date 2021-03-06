package com.kairlec.pusher.receiver.msg

import com.kairlec.pusher.receiver.reply.ReplyService
import org.w3c.dom.Element


class ReceiveVideoMsg private constructor(
        val thumbMediaId: String,
        val mediaID: String,
        replyService: ReplyService,
        baseReceiveMsg: ReceiveMsg
) : ReceiveMsg(replyService, baseReceiveMsg) {

    override fun contentToString(): String {
        return "[Video Data]"
    }

    companion object {
        fun parse(element: Element, replyService: ReplyService): ReceiveVideoMsg? {
            val baseReceiveMsg = ReceiveMsg.parse(element, replyService) ?: return null
            return parse(element, replyService, baseReceiveMsg)
        }

        fun parse(element: Element, replyService: ReplyService, baseReceiveMsg: ReceiveMsg): ReceiveVideoMsg? {
            val thumbMediaId = element["ThumbMediaId"] ?: return null
            val mediaID = element["MediaId"] ?: return null
            return ReceiveVideoMsg(thumbMediaId, mediaID, replyService, baseReceiveMsg)
        }
    }
}