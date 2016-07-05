package main.astraeus.content.dialogue.impl

import main.astraeus.content.dialogue.Dialogue
import main.astraeus.content.dialogue.DialogueFactory
import main.astraeus.content.dialogue.Expression

open class BankerDialogue(): Dialogue() {

    override fun sendDialogues(factory: DialogueFactory) {
        factory.sendNpcChat(Expression.HAPPY, "Good day. How may I help you?")
        .sendOption("I'd like to access my bank account, please.", Runnable {
            factory.sendPlayerChat("I'd like to access my bank account, please.")
            .onAction(Runnable {
                factory.player.bank.open()
            })
        }, "I'd like to check my PIN settings.", Runnable {
            factory.sendPlayerChat("I'd like to check my PIN settings.")
            .sendNpcChat("This feature is currently not available.")
        }, "I don't need anything.", Runnable {
            factory.sendPlayerChat("I don't need anything.")
        }).execute()
    }

}