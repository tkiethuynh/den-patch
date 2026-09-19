package app.tkiethuynh.patches.imou

import app.morphe.patcher.patch.resourcePatch
import app.tkiethuynh.patches.shared.Constants.COMPATIBILITY_IMOU
import org.w3c.dom.Element

private val layoutFiles = listOf(
    "res/layout/fragment_me_tab_new.xml",
    "res/layout-v22/fragment_me_tab_new.xml",
    "res/layout/server_imou_protect_dialog_layout.xml",
    "res/layout/pop_vas_info_layout.xml"
)

@Suppress("unused")
val removePromotionsPatch = resourcePatch(
    name = "Remove Imou promotions",
    description = "Removes native Imou Protect promotional banners and renewal dialogs.",
    default = true
) {
    compatibleWith(COMPATIBILITY_IMOU)

    execute {
        for (path in layoutFiles) {
            if (!get(path).exists()) continue

            document(path).use { document ->
                val root = document.documentElement
                if (path.endsWith("fragment_me_tab_new.xml")) {
                    root.findById("imou_protect_cl")?.setAttribute("android:visibility", "gone")
                } else {
                    root.setAttribute("android:visibility", "gone")
                }
            }
        }
    }
}

private fun Element.findById(name: String): Element? {
    if (getAttribute("android:id") == "@id/$name") return this
    val children = childNodes
    for (index in 0 until children.length) {
        val child = children.item(index)
        if (child is Element) {
            child.findById(name)?.let { return it }
        }
    }
    return null
}
