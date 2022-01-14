package tech.thatgravyboat.craftify

import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import gg.essential.api.utils.GuiUtil

object Command : Command("craftify") {

    @DefaultHandler
    fun handle() {
        Config.gui()?.let { GuiUtil.open(it) }
    }
}
