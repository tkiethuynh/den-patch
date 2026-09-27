package app.tkiethuynh.patches.imou

import app.morphe.patcher.patch.resourcePatch
import app.tkiethuynh.patches.shared.Constants.COMPATIBILITY_IMOU
import org.w3c.dom.Element
import org.w3c.dom.Node

@Suppress("unused")
val removeImouSplitRequirementsPatch = resourcePatch(
    name = "Remove Imou split requirements",
    description = "Removes split requirements from AndroidManifest to allow standalone APK installation.",
    default = true
) {
    compatibleWith(COMPATIBILITY_IMOU)

    execute {
        document("AndroidManifest.xml").use { doc ->
            val manifest = doc.documentElement
            manifest.removeAttribute("android:requiredSplitTypes")
            manifest.removeAttribute("android:splitTypes")

            val app = manifest.getElementsByTagName("application").item(0) as? Element
            if (app != null) {
                val nodes = app.childNodes
                val toRemove = mutableListOf<Node>()
                for (i in 0 until nodes.length) {
                    val node = nodes.item(i)
                    if (node is Element && node.tagName == "meta-data") {
                        val name = node.getAttribute("android:name")
                        if (name == "com.android.vending.splits.required" || name == "com.android.vending.splits") {
                            toRemove.add(node)
                        }
                    }
                }
                toRemove.forEach { app.removeChild(it) }
            }
        }
    }
}
