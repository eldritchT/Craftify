package tech.thatgravyboat.craftify.themes

import gg.essential.api.utils.GuiUtil
import gg.essential.universal.UDesktop
import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyData
import gg.essential.vigilance.data.PropertyType
import gg.essential.vigilance.data.SortingBehavior
import java.awt.Color
import java.io.File

@Suppress("unused")
object ThemeConfig : Vigilant(
    File("./config/craftify-theme.toml"),
    sortingBehavior = object : SortingBehavior() {
        override fun getSubcategoryComparator(): Comparator<in Map.Entry<String, List<PropertyData>>> {
            return Comparator { o1: Map.Entry<String, List<PropertyData>>, o2: Map.Entry<String, List<PropertyData>> ->
                if (o1.key == o2.key) return@Comparator 0
                return@Comparator if (o1.key == "Buttons") -1 else 1
            }
        }
    }
) {

    @Property(
        type = PropertyType.BUTTON,
        name = "Copy To Clipboard",
        placeholder = "Copy",
        subcategory = "Buttons",
        category = "Theme"
    )
    fun copy() {
        UDesktop.setClipboardString(Theme.fromConfig().getData())
    }

    @Property(
        type = PropertyType.BUTTON,
        name = "Set config from clipboard.",
        placeholder = "Load",
        subcategory = "Buttons",
        category = "Theme"
    )
    fun load() {
        try {
            Theme.fromJson(UDesktop.getClipboardString()).setConfig()
        } catch (e: Exception) {}
        ThemeConfig.gui()?.let { GuiUtil.open(it) }
    }

    @Property(
        type = PropertyType.BUTTON,
        name = "Reset config.",
        placeholder = "Reset",
        subcategory = "Buttons",
        category = "Theme"
    )
    fun reset() {
        Theme().setConfig()
        ThemeConfig.gui()?.let { GuiUtil.open(it) }
    }

    @Property(
        type = PropertyType.COLOR,
        name = "Border Color",
        category = "Theme"
    )
    var borderColor: Color = Color(1, 165, 82)

    @Property(
        type = PropertyType.COLOR,
        name = "Title Color",
        category = "Theme"
    )
    var titleColor: Color = Color.WHITE

    @Property(
        type = PropertyType.COLOR,
        name = "Artist Color",
        category = "Theme"
    )
    var artistColor: Color = Color.WHITE

    @Property(
        type = PropertyType.COLOR,
        name = "Background Color",
        category = "Theme"
    )
    var backgroundColor: Color = Color(0, 0, 0, 80)

    @Property(
        type = PropertyType.COLOR,
        name = "Background Color",
        category = "Theme",
        subcategory = "Progress Bar"
    )
    var progressBackgroundColor: Color = Color(50, 50, 50)

    @Property(
        type = PropertyType.COLOR,
        name = "Color",
        category = "Theme",
        subcategory = "Progress Bar"
    )
    var progressColor: Color = Color.WHITE

    @Property(
        type = PropertyType.COLOR,
        name = "Number Color",
        category = "Theme",
        subcategory = "Progress Bar"
    )
    var progressNumberColor: Color = Color.WHITE

    @Property(
        type = PropertyType.DECIMAL_SLIDER,
        name = "Radius",
        category = "Theme",
        subcategory = "Progress Bar",
        minF = 0f,
        maxF = 10f
    )
    var progressRadius: Float = 3f

    @Property(
        type = PropertyType.COLOR,
        name = "Color",
        category = "Theme",
        subcategory = "Controls"
    )
    var controlColor: Color = Color.WHITE

    @Property(
        type = PropertyType.COLOR,
        name = "Hover Color",
        category = "Theme",
        subcategory = "Controls"
    )
    var hoverControlColor: Color = Color(150, 150, 150)

    @Property(
        type = PropertyType.COLOR,
        name = "Selected Color",
        category = "Theme",
        subcategory = "Controls"
    )
    var selectedControlColor: Color = Color(1, 165, 82)

    @Property(
        type = PropertyType.COLOR,
        name = "Selected Hover Color",
        category = "Theme",
        subcategory = "Controls"
    )
    var selectedHoverControlColor: Color = Color(0, 212, 105)

    init {
        initialize()
    }
}
